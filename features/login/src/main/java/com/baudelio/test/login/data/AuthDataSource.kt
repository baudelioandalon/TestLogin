package com.baudelio.test.login.data

import com.auth0.android.jwt.JWT
import com.baudelio.test.core.BuildConfig
import com.baudelio.test.core.domain.entity.AuthLoginEmailModel
import com.baudelio.test.core.domain.entity.AuthModel
import com.baudelio.test.core.domain.entity.ClaimsMapModel
import com.baudelio.test.core.domain.entity.ClaimsModel
import com.baudelio.test.core.utils.core.DataResponse
import com.baudelio.test.core.utils.core.InitServices
import com.baudelio.test.core.utils.core.StatusRequestEnum
import com.baudelio.test.core.utils.core.ValidResponse
import okhttp3.MultipartBody
import java.net.UnknownHostException


class AuthDataSource {

    companion object {

        fun getData(
            request: AuthLoginEmailModel
        ): DataResponse<Pair<AuthModel?, ClaimsModel?>> = try {

            val requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("email", request.email)
                .addFormDataPart("password", request.token)
                .build()
            val responseModel = ValidResponse().validationMethod(
                InitServices().postExecuteService(
                    requestBody,
                    BuildConfig.BASE_URL
                )
            )

            if (responseModel.statusRequest != StatusRequestEnum.SUCCESS) {
                DataResponse(
                    statusRequest = responseModel.statusRequest,
                    successData = Pair(null, null),
                    errorData = responseModel.errorData,
                    errorModel = responseModel.errorModel
                )
            } else {
                DataResponse(
                    statusRequest = responseModel.statusRequest,
                    successData = Pair(
                        responseModel.successData,
                        convertClaims(responseModel.successData?.token ?: "")
                    ),
                    errorData = responseModel.errorData,
                    errorModel = responseModel.errorModel
                )
            }
        } catch (exception: Exception) {
            if (exception is UnknownHostException) {
                DataResponse(
                    statusRequest = StatusRequestEnum.FAILURE,
                    null,
                    errorData = "Por favor, revisa tu conexion a internet"
                )
            } else {
                DataResponse(
                    statusRequest = StatusRequestEnum.FAILURE,
                    null,
                    errorData = "Por favor, verifique los datos."
                )
            }
        }

        private fun convertClaims(tokenReceived: String): ClaimsModel {
            val claims = JWT(tokenReceived).claims.toMap().toList()
                .associate { Pair(it.first ?: "", it.second.asString() ?: "") }
            return try {
                ClaimsModel(
                    titular = claims[ClaimsMapModel.TITULAR.minus] ?: "",
                    url = claims[ClaimsMapModel.URL.minus] ?: "",
                    email = claims[ClaimsMapModel.EMAIL.minus] ?: "",
                    solicitud = claims[ClaimsMapModel.REQUEST.minus] ?: ""
                )
            } catch (exception: Exception) {
                ClaimsModel(
                    titular = "",
                    url = "",
                    email = "",
                    solicitud = ""
                )
            }
        }
    }

}

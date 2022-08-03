package com.baudelio.test.core.utils.core

import com.baudelio.test.core.domain.entity.AuthModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call

class ValidResponse {
    fun validationMethod(result: Call<AuthModel>): DataResponse<AuthModel?> = try {
        val requestExecuted = result.execute()
        val gson = Gson()
        if (requestExecuted.isSuccessful && requestExecuted.code() == 200) {
            val jsonObject = gson.toJsonTree(requestExecuted.body())
            val myResponse =
                Gson().fromJson(jsonObject, AuthModel::class.java) as AuthModel
            if (myResponse.success) {
                DataResponse(
                    statusRequest = StatusRequestEnum.SUCCESS,
                    successData = myResponse
                )
            } else {
                DataResponse(
                    statusRequest = StatusRequestEnum.FAILURE,
                    errorData = "Hubo un error en las credenciales"
                )
            }

        } else {
            if (requestExecuted.errorBody() == null) {
                DataResponse(
                    statusRequest = StatusRequestEnum.FAILURE,
                    errorData = "Hay un error en el servicio, por favor, intente mas tarde."
                )
            } else {
                val type = object : TypeToken<ErrorModel>() {}.type
                val errorResult: ErrorModel? =
                    gson.fromJson(requestExecuted.errorBody()!!.charStream(), type)
                DataResponse(
                    statusRequest = StatusRequestEnum.FAILURE,
                    errorModel = errorResult
                )
            }

        }
    } catch (exception: Exception) {
        DataResponse(
            statusRequest = StatusRequestEnum.FAILURE,
            errorData = "Hay un error en el servicio, por favor, intente mas tarde."
        )
    }

}
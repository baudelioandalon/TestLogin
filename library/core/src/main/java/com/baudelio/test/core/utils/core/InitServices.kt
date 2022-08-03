package com.baudelio.test.core.utils.core

import com.baudelio.test.core.domain.entity.AuthModel
import com.baudelio.test.core.utils.retrofit.ApiServices
import com.baudelio.test.core.utils.retrofit.RetroClient
import okhttp3.RequestBody
import retrofit2.Call

class InitServices {

    fun postExecuteService(request: RequestBody, endPoint: String) =
        RetroClient.getRestEngine().create(ApiServices::class.java)
            .serviceResponsePostBody(
                body = request, url = endPoint
            ) as Call<AuthModel>
}

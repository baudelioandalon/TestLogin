package com.baudelio.test.core.utils.retrofit

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiServices {

    @POST
    fun serviceResponsePostBody(
        @Body body: RequestBody, @Url url: String = ""
    ): Call<Any>

}
package com.ucb.parcial2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApiAdapter {
    fun connectionApi(): IEndPointApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(ConstantsRestApi.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(IEndPointApi::class.java)
    }
}

package com.ucb.parcial2

import retrofit2.Call
import retrofit2.http.GET

interface IEndPointApi {
    @GET(ConstantsRestApi.POSTS)
    fun getAllPost(): Call<List<Post>>
}
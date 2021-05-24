package com.playlab.instaland

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {
    @GET("p/CPLiIoDF-S0/")
    fun getPostData(
        @Query("__a" ) j: Int
    ): Call<PostResponse?>?
}
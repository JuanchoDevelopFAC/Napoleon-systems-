package com.example.napoleonsystemsapp.network

import com.example.napoleonsystemsapp.home.data.PostModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("posts")
    fun fetchAllPosts(): Call<List<PostModel>>

    @POST("posts")
    fun createPost(@Body postModel: PostModel): Call<PostModel>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id:Int):Call<String>
}
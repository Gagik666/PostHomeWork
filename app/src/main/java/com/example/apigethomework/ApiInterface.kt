package com.example.apigethomework

import com.example.apigethomework.FirstTask.UserData
import com.example.apigethomework.SecondTask.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiInterface {
    @GET("marvel")
    fun getData(): Call<List<UserData>>


    @POST("posts")
    fun creatPost(@Body post: Post): Call<Post>




}
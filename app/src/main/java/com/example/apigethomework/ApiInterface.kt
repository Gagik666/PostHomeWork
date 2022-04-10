package com.example.apigethomework

import com.example.apigethomework.FirstTask.UserData
import com.example.apigethomework.SecondTask.Post
import com.example.apigethomework.ThirdTask.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiInterface {
    @GET("marvel")
    fun getData(): Call<List<UserData>>


    @POST("posts")
    fun creatPost(@Body post: Post): Call<Post>


    @GET("v2/everything?q=Apple&from=2022-04-10&sortBy=popularity&apiKey=cca11dd293d54b0b9973bc056d798907")
    fun getHeadKines(@Query("page") page: Int): Call<News>

    object NewService {
        val kinoInstance: ApiInterface
        init {
            val retrofitBulder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.simplifiedcoding.net/demos/")
                .build()
            kinoInstance =  retrofitBulder.create(ApiInterface::class.java)
        }

        val postInstance: ApiInterface
        init {
            val retrofitBulderPost = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()
                postInstance = retrofitBulderPost.create(ApiInterface::class.java)
        }

        val newInstance:ApiInterface
        init {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            newInstance = retrofit.create(ApiInterface::class.java)
        }
    }

}
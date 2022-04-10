package com.example.apigethomework.SecondTask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.apigethomework.ApiInterface
import com.example.apigethomework.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SecondTaskFragment : Fragment() {
  lateinit var tvCode: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCode = view.findViewById(R.id.tvCode)
        getMyPost()

    }
    private fun getMyPost() {
        val retrofitBulder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitPost = retrofitBulder.creatPost(Post(6,"new text", "new text"))
        retrofitPost.enqueue(object : Callback<Post?> {
            override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                tvCode.text = "response Code -> ${response.code()}"
            }

            override fun onFailure(call: Call<Post?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}



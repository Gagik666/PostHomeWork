package com.example.apigethomework.ThirdTask

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apigethomework.ApiInterface
import com.example.apigethomework.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdFragment : Fragment() {
    lateinit var adapter:NewsAdapter
    lateinit var rvNews: RecyclerView
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvNews = view.findViewById(R.id.rvNews)

        getNews()
    }

    private fun getNews() {
        val call = ApiInterface.NewService.newInstance.getHeadKines(1)
        call.enqueue(object : Callback<News?> {
            override fun onResponse(call: Call<News?>, response: Response<News?>) {
                val responseBody: News? = response.body()
                adapter = NewsAdapter(responseBody?.articles as MutableList<Article>) {
                    var intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.url))
                    startActivity(intent)
                }

                rvNews.adapter = adapter
                rvNews.layoutManager = LinearLayoutManager(context)
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


}
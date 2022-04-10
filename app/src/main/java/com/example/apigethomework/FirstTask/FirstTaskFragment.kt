package com.example.apigethomework.FirstTask

import android.os.Bundle
import android.util.Log
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
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FirstTaskFragment : Fragment() {
    lateinit var adapter: UserAdapter
    lateinit var rvUsers: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvUsers = view.findViewById(R.id.rvUsers)
        rvUsers.layoutManager = LinearLayoutManager(this.context)

        getMyData()
    }

    private fun getMyData() {
        val retrofitBulder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.simplifiedcoding.net/demos/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBulder.getData()
        retrofitData.enqueue(object : Callback<List<UserData>?> {
            override fun onResponse(
                call: Call<List<UserData>?>,
                response: Response<List<UserData>?>
            ) {
                val responseBody = response.body()!!

                adapter = UserAdapter(this@FirstTaskFragment, responseBody as MutableList<UserData>)
                adapter.notifyDataSetChanged()
                rvUsers.adapter = adapter
            }

            override fun onFailure(call: Call<List<UserData>?>, t: Throwable) {
                Log.d("MyLog", "ofFailure ${t.message}")
            }
        })
    }
}
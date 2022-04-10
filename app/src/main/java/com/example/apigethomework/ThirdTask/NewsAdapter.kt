package com.example.apigethomework.ThirdTask

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apigethomework.R
import com.squareup.picasso.Picasso
import java.net.URI

class NewsAdapter(
    private val list: MutableList<Article>,
    private val onItemClick: (article: Article) -> Unit
): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
   inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgNews = itemView.findViewById<ImageView>(R.id.imgNews)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDiscription = itemView.findViewById<TextView>(R.id.tvDiscription)
        fun bind(article: Article) {
            Picasso.get().load(article.urlToImage).into(imgNews)
                imgNews.setOnClickListener {
                   onItemClick.invoke(article)
                }
            tvTitle.text = article.title
                tvTitle.setOnClickListener() {
                    onItemClick.invoke(article)
                }
            tvDiscription.text = article.description
                tvDiscription.setOnClickListener() {
                    onItemClick.invoke(article)
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}
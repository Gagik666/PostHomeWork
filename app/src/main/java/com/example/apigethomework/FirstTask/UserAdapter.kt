package com.example.apigethomework.FirstTask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apigethomework.R
import com.squareup.picasso.Picasso

class UserAdapter(
    private val context: FirstTaskFragment,
    private val userList: MutableList<UserData>
    ): RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvTeam = itemView.findViewById<TextView>(R.id.tvTeam)
        val tvRealName = itemView.findViewById<TextView>(R.id.tvRealName)
        val img =itemView.findViewById<ImageView>(R.id.img)
        fun bind(myDataItem: UserData) {
            tvName.text = myDataItem.name
            tvTeam.text = myDataItem.team
            tvRealName.text = myDataItem.realname
            Picasso.get().load(myDataItem.imageurl).into(img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount() = userList.size

}
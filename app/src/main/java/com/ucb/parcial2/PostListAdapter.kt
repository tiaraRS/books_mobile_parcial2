package com.ucb.parcial2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostListAdapter(val list: ArrayList<Post>, val recyclerViewActivity: MainActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent,false)
        return UserListViewHolder(view)
    }

    class UserListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list.get(position)
        holder.itemView.findViewById<TextView>(R.id.tv_title).text = item.title
        holder.itemView.findViewById<TextView>(R.id.tv_body).text = item.body
    }


}
/*
class PostListAdapter(val items: ArrayList<Post>, val context: Context): RecyclerView.Adapter<PostListAdapter.PostListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        return PostListViewHolder(v)
    }
    override fun getItemCount(): Int {
        return items.count()
    }
    override fun onBindViewHolder(holder: PostListViewHolder, position: Int) {
        val item = items.get(position)
        holder.itemView.findViewById<TextView>(R.id.tv_title).text = item.title
        holder.itemView.findViewById<TextView>(R.id.tv_body).text = item.body

    }
    class PostListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}
*/
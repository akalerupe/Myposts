package com.example.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class postCommentsAdapter(var commentsList:List<Comments>):RecyclerView.Adapter<postCommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postCommentsViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.activity_comments,parent,false)
        return postCommentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: postCommentsViewHolder, position: Int) {
        var currentComments=commentsList.get(position)
        holder.tvname.text=currentComments.name
        holder.tvemail.text=currentComments.email
        holder.tvcommentsbody.text=currentComments.commentsbody
    }

    override fun getItemCount(): Int {
        return commentsList.count()
    }
}
class postCommentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvname=itemView.findViewById<TextView>(R.id.tvname)
    var tvemail=itemView.findViewById<TextView>(R.id.tvemail)
    var tvcommentsbody=itemView.findViewById<TextView>(R.id.tvcommentsbody)
//    var dvcomments=itemView.findViewById<>(R.id.dvcomments)
}
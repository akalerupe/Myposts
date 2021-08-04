package com.example.myposts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class postCommentsAdapter( var commentsList:List<Comments>):RecyclerView.Adapter<postCommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postCommentsViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.activity_view_uipackage,parent,false)
        return postCommentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: postCommentsViewHolder, position: Int) {
        var currentComments=commentsList.get(position)
        holder.tvposttitle.text=currentComments.posttitle
        holder.tvtextbody.text=currentComments.textbody
    }

    override fun getItemCount(): Int {
        return commentsList.count()
    }
}
class postCommentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvtextbody=itemView.findViewById<TextView>(R.id.tvtextbody)
    var tvposttitle=itemView.findViewById<TextView>(R.id.tvposttitle)

}
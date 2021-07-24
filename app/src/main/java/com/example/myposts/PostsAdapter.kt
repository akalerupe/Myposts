package com.example.myposts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostsAdapter(var postList:List<Post>):RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.post_list_item,parent,false)
        return PostsViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var currentPosts=postList.get(position)
        holder.tvuserid.text=currentPosts.userId.toString()
        holder.tvid.text=currentPosts.id.toString()
        holder.tvtitle.text=currentPosts.title
        holder.tvbody.text=currentPosts.body
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}
class PostsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvuserid=itemView.findViewById<TextView>(R.id.tvuserid)
    var tvid=itemView.findViewById<TextView>(R.id.tvid)
    var tvtitle=itemView.findViewById<TextView>(R.id.tvtitle)
    var tvbody=itemView.findViewById<TextView>(R.id.tvbody)



}
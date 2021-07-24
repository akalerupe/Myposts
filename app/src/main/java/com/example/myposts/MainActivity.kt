package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvposts:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchPosts()
    }
    fun fetchPosts(){
        rvposts=findViewById(R.id.rvposts)
        var retrofit=ApiClient.buildApiClient(Interface::class.java)
        var request=retrofit.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
               if (response.isSuccessful) {
                   var postList=response.body()!!
                   rvposts.layoutManager=LinearLayoutManager(baseContext)
                   var postsAdapter=PostsAdapter(postList)
                   rvposts.adapter=postsAdapter
                   Toast.makeText(baseContext, "${postList!!.size} posts", Toast.
                   LENGTH_LONG).show()
                   var postDetails= mutableListOf<Post>()
                   for (i in 1..postList.size){
                       postDetails.add(Post(7,76,"Details","These are your details"))
                   }
               }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }


        })
    }

}

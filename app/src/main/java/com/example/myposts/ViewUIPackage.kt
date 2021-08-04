package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewUIPackage : AppCompatActivity() {
    lateinit var rvcomments: RecyclerView
    lateinit var tvposttitle:TextView
    lateinit var tvtextbody:TextView

    var postId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_uipackage)
        postId=intent.getIntExtra("POST_ID",0)
        tvposttitle=findViewById(R.id.tvposttitle)
        tvtextbody=findViewById(R.id.tvtextbody)
        rvcomments=findViewById(R.id.rvcomments)
        fetchPostsById()
        fetchComments()

    }
    fun fetchPostsById(){
        var apiClient=ApiClient.buildApiClient(Interface::class.java)
        var request=apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    var post=response.body()
                    tvposttitle.text=post?.title
                    tvtextbody.text=post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
    fun fetchComments(){
        var apiClient=ApiClient.buildApiClient(Interface::class.java)
        var request=apiClient.getPostComments(postId)
        request.enqueue(object :Callback<List<Comments>>{
            override fun onResponse(call: Call<List<Comments>?>, response: Response<List<Comments>?>) {
                if (response.isSuccessful) {
                    var comment = response.body()!!
                    var commentsAdapter=postCommentsAdapter(comment)
                    rvcomments.adapter=commentsAdapter
                    rvcomments.layoutManager=LinearLayoutManager(baseContext)


                }
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        }
            )

        }
    }

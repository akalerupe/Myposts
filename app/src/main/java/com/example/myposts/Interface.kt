package com.example.myposts

import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Interface {
//    define diff endpoints choice to have the slash or not
//    make sure its only one slash to avoid concatenation
        @GET("posts")
        fun getPosts():Call<List<Post>>

        @GET("posts/{Id}")
        fun getPostById(@Path("Id")postId:Int):Call<Post>

        @GET("posts/{Id}/comments")
        fun getPostComments(@Path("Id")Id:Int):Call<List<Comments>>

        }

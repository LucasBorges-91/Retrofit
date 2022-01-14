package br.com.borges.lucas.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface PostService {

  @GET( "posts" )
  fun listPosts(): Call<List<PostModel>>
}
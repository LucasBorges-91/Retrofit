package br.com.borges.lucas.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton
class RetrofitClient private constructor() {

  companion object {

    private lateinit var retrofit: Retrofit
    private val baseUrl = "https://jsonplaceholder.typicode.com/"

    private fun getRetrofitInstance(): Retrofit {
      val httpClient = OkHttpClient.Builder()
      if ( !::retrofit.isInitialized ) {
        retrofit = Retrofit.Builder()
          .baseUrl( baseUrl )
          .client( httpClient.build() )
          .addConverterFactory( GsonConverterFactory.create() )
          .build()
      }
      return retrofit
    }

    fun <t> createService( serviceClass: Class<t>): t {
      return getRetrofitInstance().create( serviceClass )
    }
  }
}
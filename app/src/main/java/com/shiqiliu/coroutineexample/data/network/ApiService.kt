package com.shiqiliu.coroutineexample.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.shiqiliu.coroutineexample.data.model.NowPlayingResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/now_playing")
    suspend fun getPlayingMovie(
        @Query("api_key") api_key :String = API_KEY
    ): Response<NowPlayingResponse>

    companion object{
        const val API_KEY = "198564c5fabf8c62626e1fefed61dad8"

        operator fun invoke():ApiService{
            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}
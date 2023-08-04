package com.lunatictiol.retrofit22.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.lunatictiol.retrofit22.model.Movie
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("movielist.json")
    suspend fun getMovies() : List<Movie>


    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/apis/")

                    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}
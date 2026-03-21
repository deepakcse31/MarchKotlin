package com.example.marchkotlin

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("login/v2/getOtp")
    fun getOtp(@Body jsonObject: JsonObject?) : Call<OTPResponse>
    @GET("https://imdb.iamidiotareyoutoo.com/search?")
    fun getMovies(@Query("q") name: String): Call<MovieResponse>
}
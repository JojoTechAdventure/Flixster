package com.codepath.flixster

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed")
    fun getNowPlaying(): Call<MovieResponse>
}

package com.codepath.flixster

data class Movie(
    val title: String,
    val overview: String,
    val posterPath: String // this will be the partial URL I get from the API
)

package com.codepath.flixster

data class Movie(
    val title: String,
    val overview: String,
    val poster_path: String // this will be the partial URL I get from the API
)

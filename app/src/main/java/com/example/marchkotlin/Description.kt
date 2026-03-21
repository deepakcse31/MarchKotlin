package com.example.marchkotlin

import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("#ACTORS")val ACTORS: String,
    @SerializedName("#AKA") val AKA: String,
    @SerializedName("#IMDB_ID") val IMDB_ID: String,
    @SerializedName("#IMDB_IV") val IMDB_IV: String,
    @SerializedName("#IMDB_URL") val IMDB_URL: String,
    @SerializedName("#IMG_POSTER") val IMG_POSTER: String,
    @SerializedName("#RANK") val RANK: Int,
    @SerializedName("#TITLE") val TITLE: String,
    @SerializedName("#YEAR") val YEAR: Int,
    val photo_height: Int,
    val photo_width: Int
)
package com.example.marchkotlin

data class MovieResponse(
    val description: List<Description>,
    val error_code: Int,
    val ok: Boolean
)
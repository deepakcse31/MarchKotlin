package com.example.marchkotlin

data class OTPResponse(
    val error: Boolean,
    val message: String,
    val otp: Int
)
package com.example.marchkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActiviity : AppCompatActivity() {
    lateinit var edtMobile : EditText
    lateinit var btnLogin : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_activiity)
        edtMobile = findViewById(R.id.edtmobileno)
        btnLogin = findViewById(R.id.btnlogin)


        btnLogin.setOnClickListener {
            getOTP(edtMobile.text.toString())
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getOTP(phoneNo : String){

        val jsonObject= JsonObject()
        jsonObject.addProperty("phone_number",phoneNo)

        val call : Call<OTPResponse> = ApiClient.getClient()?.create(ApiService::class.java)!!.getOtp(jsonObject)

        call.enqueue(object : Callback<OTPResponse?>{
            override fun onResponse(call: Call<OTPResponse?>, response: Response<OTPResponse?>) {

                Log.e("response",response.body().toString())

            }
            override fun onFailure(call: Call<OTPResponse?>, t: Throwable) {

            }
        })


    }
}
package com.example.marchkotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PaymentActvity : AppCompatActivity() {

    lateinit var edtamount: EditText
    lateinit var btnpay: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment_actvity)
        edtamount = findViewById(R.id.edtamount)
        btnpay = findViewById(R.id.edtpay)

        btnpay.setOnClickListener {
            val amount = edtamount.text.toString()
            val intent = Intent(this, PaymentDetails::class.java)
            intent.putExtra("amount", amount)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
package com.example.marchkotlin.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.marchkotlin.R
import com.example.marchkotlin.viewModel.CounterViewModel

class CounterActivity : AppCompatActivity() {
    lateinit var texteView : TextView
    lateinit var btncounter : Button
    lateinit var counterViewModel : CounterViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_counter)
        texteView = findViewById(R.id.tvcounter)
        btncounter = findViewById(R.id.btncounter)
        counterViewModel= ViewModelProvider(this).get(CounterViewModel::class.java)
        counterViewModel.counter.observe(this){
            texteView.text = it.toString()
        }
        btncounter.setOnClickListener {
            counterViewModel.increment()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
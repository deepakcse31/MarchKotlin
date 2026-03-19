package com.example.marchkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecycleViewActvity : AppCompatActivity() {
    lateinit var rvlist: RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view_actvity)
        rvlist = findViewById(R.id.rvlist)

        val fruitlist = listOf(
            Fruit("Apple", R.drawable.home, "Red and juicy"),
            Fruit("Banana", R.drawable.home, "Yellow and sweet"),
            Fruit("Orange", R.drawable.home, "Citrus and tangy"),
            Fruit("Grapes", R.drawable.iv, "Purple and sweet"),
            Fruit("Mango", R.drawable.home, "Yellow and juicy"),
            Fruit("Pineapple", R.drawable.home, "Yellow and sweet"),
            Fruit("Watermelon", R.drawable.iv, "Green and juicy"),
            Fruit("Strawberry", R.drawable.iv, "Red and sweet"),

        )

        val adapter = RecycleAdapter(fruitlist)
        rvlist.setHasFixedSize(true)
        rvlist.layoutManager = LinearLayoutManager(this)
        rvlist.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
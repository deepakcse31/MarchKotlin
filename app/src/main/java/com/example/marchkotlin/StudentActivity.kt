package com.example.marchkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class StudentActivity : AppCompatActivity() {
    lateinit var edtName : EditText
    lateinit var edtenroll : EditText
    lateinit var edtbranch : EditText
    lateinit var edtsemester : EditText
    lateinit var btnSumit : Button

    val database= MyApp.database
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student)

        edtName = findViewById(R.id.edtname)
        edtenroll = findViewById(R.id.edtenroll)
        edtbranch = findViewById(R.id.edtbranch)
        edtsemester = findViewById(R.id.edtsem)
        btnSumit = findViewById(R.id.btnsubmit)

        btnSumit.setOnClickListener {

            val name = edtName.text.toString()
            val enroll = edtenroll.text.toString()
            val branch = edtbranch.text.toString()
            val semester = edtsemester.text.toString()
            GlobalScope.launch {
                database.studentDao().insert(StudentData(0,name,enroll,branch,semester))
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
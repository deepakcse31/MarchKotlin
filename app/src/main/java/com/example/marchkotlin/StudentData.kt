package com.example.marchkotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class StudentData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val enroll: String,
    val branch: String,
    val sem : String,
)

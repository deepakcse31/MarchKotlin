package com.example.marchkotlin

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface StudentDao {

    @Insert
    suspend fun insert(student: StudentData)
}
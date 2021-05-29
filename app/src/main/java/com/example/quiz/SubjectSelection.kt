package com.example.quiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz.Database.RuntimeData

class SubjectSelection : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_selection)
        val welcomeTest = findViewById<TextView>(R.id.welcomeUser)
        welcomeTest.text = "Welcome " + RuntimeData.userName.capitalize() + " Please Select Subject"
    }
}
package com.example.quiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz.Database.RuntimeData
import com.example.quiz.computer.Computer
import com.example.quiz.english.English
import com.example.quiz.math.MathQuestion
import com.example.quiz.physics.Physics
import java.util.*

class SubjectSelection : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_selection)
        val welcomeTest = findViewById<TextView>(R.id.welcomeUser)
        welcomeTest.text =
            "Welcome " + RuntimeData.userName.capitalize(Locale.ROOT) + " Please Select Subject"

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupSubject)
        val submitButton = findViewById<Button>(R.id.button)
        submitButton.setOnClickListener {

            RuntimeData.getRadioButton(radioGroup)
            for (currentRadioButton in RuntimeData.radioButtonArray) {
                if (currentRadioButton.isChecked) {
                    when (currentRadioButton.text.toString().toLowerCase(Locale.ROOT)) {
                        "math" -> {
                            startActivity(Intent(this, MathQuestion::class.java))
                        }
                        "computer" -> {
                            startActivity(Intent(this, Computer::class.java))
                        }
                        "english" -> {
                            startActivity(Intent(this, English::class.java))
                        }
                        "physics" -> {
                            startActivity(Intent(this, Physics::class.java))
                        }
                    }
                }
            }
        }


    }
}
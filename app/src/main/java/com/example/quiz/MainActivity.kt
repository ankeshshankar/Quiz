package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.quiz.Database.RuntimeData
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userName = findViewById<TextInputEditText>(R.id.nameEditText)
        val userEmail = findViewById<TextInputEditText>(R.id.emailEditText)
        val userMobile = findViewById<TextInputEditText>(R.id.mobileEditText)
        val submitBtn = findViewById<Button>(R.id.button)
        val constraintParent = findViewById<ConstraintLayout>(R.id.constraintParent)

        var notEmpty = true
        submitBtn.setOnClickListener {
            RuntimeData.getInputEditText(constraintParent)
            for (editText in RuntimeData.textInputEditTextArray) {
                notEmpty = if (RuntimeData.checkEditText(editText)) {
                    RuntimeData.showError(editText)
                    true
                } else {
                    false
                }
            }
            if (!notEmpty) {
                RuntimeData.userName = userName.text.toString()
                RuntimeData.userEmail = userEmail.text.toString()
                RuntimeData.userMobileNumber = userMobile.text.toString()
                startActivity(Intent(this, SubjectSelection::class.java))
            }
        }
        //Setting Data
        RuntimeData.hashMath["even number"] = "2"
    }
}
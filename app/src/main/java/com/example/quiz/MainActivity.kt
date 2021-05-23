package com.example.quiz

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userName = findViewById<TextInputEditText>(R.id.nameEditText)
        val userEmail = findViewById<TextInputEditText>(R.id.emailEditText)
        val userMobile = findViewById<TextInputEditText>(R.id.mobileEditText)
        val submitBtn = findViewById<Button>(R.id.button)

        submitBtn.setOnClickListener {
            val name = userName.text.toString()
            val email = userEmail.text.toString()
            val mobile = userMobile.text.toString()
            if (checkEditText(userEmail)) {
                Toast.makeText(this, email, Toast.LENGTH_LONG).show()
            } else {
                showError(userEmail)
            }
        }
    }

    private fun showError(inputEditText: TextInputEditText) {
        inputEditText.error = "Enter this field"
    }

    private fun checkEditText(inputEditText: TextInputEditText): Boolean {
        return inputEditText.text.toString().isNotEmpty() && inputEditText.text.toString()
            .isNotBlank()
    }
}
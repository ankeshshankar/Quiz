package com.example.quiz

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    var textInputEditTextArray = arrayListOf<TextInputEditText>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userName = findViewById<TextInputEditText>(R.id.nameEditText)
        val userEmail = findViewById<TextInputEditText>(R.id.emailEditText)
        val userMobile = findViewById<TextInputEditText>(R.id.mobileEditText)
        val submitBtn = findViewById<Button>(R.id.button)
        val constraintParent = findViewById<ConstraintLayout>(R.id.constraintParent)

        submitBtn.setOnClickListener {
            getInputEditText(constraintParent)
            for (editText in textInputEditTextArray) {
                if (checkEditText(editText)) {
                    showError(editText)
                } else {
                    Log.e("Test Data", editText.text.toString())

                }
            }


        }
    }

    fun getInputEditText(layout: ViewGroup) {
        for (i in 0 until layout.childCount) {
            if (layout.getChildAt(i) is ViewGroup) {
                getInputEditText(layout.getChildAt(i) as ViewGroup)
            } else {
                if (layout.getChildAt(i) is TextInputEditText) {
                    val tf = layout.getChildAt(i) as TextInputEditText
                    textInputEditTextArray.add(tf)
                }
            }
        }
    }

//    private fun getAllTextInputEditText(viewGroup: ViewGroup) {
//        for(i in 0..viewGroup.childCount){
//            if(viewGroup.getChildAt(i) is TextInputLayout){
//                val innerViewGroup = viewGroup.getChildAt(i) as ViewGroup
//                for (y in 0..innerViewGroup.childCount){
//                    if(innerViewGroup.getChildAt(y) is TextInputEditText){
//                        textInputEditTextArray.add(innerViewGroup.getChildAt(y) as TextInputEditText)
//                    }
//                }
//            }
//        }
//    }


    private fun showError(inputEditText: TextInputEditText) {
        inputEditText.error = "Enter this field"
    }

    private fun checkEditText(inputEditText: TextInputEditText): Boolean {
        return inputEditText.text.toString().isEmpty() && inputEditText.text.toString()
            .isBlank()
    }
}
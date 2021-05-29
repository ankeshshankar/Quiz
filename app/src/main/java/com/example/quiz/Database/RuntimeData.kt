package com.example.quiz.Database

import android.view.ViewGroup
import com.google.android.material.textfield.TextInputEditText

class RuntimeData {

    companion object {
        lateinit var userName: String
        lateinit var userEmail: String
        lateinit var userMobileNumber: String
        var textInputEditTextArray = arrayListOf<TextInputEditText>()

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


        fun showError(inputEditText: TextInputEditText) {
            inputEditText.error = "Enter this field"
        }

        fun checkEditText(inputEditText: TextInputEditText): Boolean {
            return inputEditText.text.toString().isEmpty() && inputEditText.text.toString()
                .isBlank()
        }

    }
}

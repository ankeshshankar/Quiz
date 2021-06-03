package com.example.quiz.Database

import android.view.ViewGroup
import com.google.android.material.radiobutton.MaterialRadioButton
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
                        textInputEditTextArray.add(layout.getChildAt(i) as TextInputEditText)
                    }
                }
            }
        }

        var radioButtonArray = arrayListOf<MaterialRadioButton>()
        fun getRadioButton(layout: ViewGroup) {
            for (i in 0 until layout.childCount) {
                if (layout.getChildAt(i) is ViewGroup) {
                    getRadioButton(layout.getChildAt(i) as ViewGroup)
                } else {
                    if (layout.getChildAt(i) is MaterialRadioButton) {
                        radioButtonArray.add(layout.getChildAt(i) as MaterialRadioButton)
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

        // Question Answers
        val hashMath: HashMap<String, String> = hashMapOf()
        val hashComp: HashMap<String, String> = hashMapOf()
        val hashPhy: HashMap<String, String> = hashMapOf()
        val hashEng: HashMap<String, String> = hashMapOf()
    }











}

package com.example.quiz.math

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.quiz.Database.RuntimeData
import com.example.quiz.R

class MathQuestionOne : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inti()


        return inflater.inflate(R.layout.fragment_math_question_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        inti()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun inti() {

        val radioGroup = view?.findViewById<RadioGroup>(R.id.mathQuestionOneRadio)
        val submitButton = view?.findViewById<Button>(R.id.button)
        RuntimeData.radioButtonArray.clear()
        RuntimeData.getRadioButton(radioGroup!!)
        submitButton?.setOnClickListener {
            for (currentRadioButton in RuntimeData.radioButtonArray) {
                if (currentRadioButton.isChecked) {
                    when (currentRadioButton.text.toString()) {
                        "2" -> {
                            Navigation.findNavController(requireView())
                                .navigate(R.id.action_mathQuestionOne_to_questionTwo)
                            break
                        }
                        "7" -> {
                            Toast.makeText(
                                this.requireContext(),
                                "Answer is wrong try again",
                                Toast.LENGTH_LONG
                            ).show()
                            break
                        }
                        "3" -> {
                            Toast.makeText(
                                this.requireContext(),
                                "Answer is wrong try again",
                                Toast.LENGTH_LONG
                            ).show()
                            break
                        }
                        "5" -> {
                            Toast.makeText(
                                this.requireContext(),
                                "Answer is wrong try again",
                                Toast.LENGTH_LONG
                            ).show()
                            break

                        }
                    }
                }
            }
        }


    }

}
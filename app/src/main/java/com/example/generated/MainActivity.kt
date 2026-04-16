package com.example.generated

import android.app.Activity
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var layout: LinearLayout
    private lateinit var resultTextView: TextView
    private lateinit var number1EditText: EditText
    private lateinit var number2EditText: EditText
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divideButton: Button

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)

        layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER

        resultTextView = TextView(this)
        resultTextView.text = "Result: "
        resultTextView.textSize = 24f
        resultTextView.gravity = Gravity.CENTER
        layout.addView(resultTextView, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))

        number1EditText = EditText(this)
        number1EditText.hint = "Number 1"
        number1EditText.gravity = Gravity.CENTER
        layout.addView(number1EditText, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))

        number2EditText = EditText(this)
        number2EditText.hint = "Number 2"
        number2EditText.gravity = Gravity.CENTER
        layout.addView(number2EditText, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))

        val buttonsLayout = LinearLayout(this)
        buttonsLayout.orientation = LinearLayout.HORIZONTAL
        layout.addView(buttonsLayout, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))

        addButton = Button(this)
        addButton.text = "+"
        addButton.setOnClickListener {
            calculate("+")
        }
        addButton.setBackgroundColor(Color.GREEN)
        buttonsLayout.addView(addButton, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))

        subtractButton = Button(this)
        subtractButton.text = "-"
        subtractButton.setOnClickListener {
            calculate("-")
        }
        subtractButton.setBackgroundColor(Color.RED)
        buttonsLayout.addView(subtractButton, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))

        multiplyButton = Button(this)
        multiplyButton.text = "*"
        multiplyButton.setOnClickListener {
            calculate("*")
        }
        multiplyButton.setBackgroundColor(Color.BLUE)
        buttonsLayout.addView(multiplyButton, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))

        divideButton = Button(this)
        divideButton.text = "/"
        divideButton.setOnClickListener {
            calculate("/")
        }
        divideButton.setBackgroundColor(Color.YELLOW)
        buttonsLayout.addView(divideButton, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))

        setContentView(layout)
    }

    private fun calculate(operation: String) {
        try {
            val number1 = number1EditText.text.toString().toDouble()
            val number2 = number2EditText.text.toString().toDouble()
            var result = 0.0

            when (operation) {
                "+" -> result = number1 + number2
                "-" -> result = number1 - number2
                "*" -> result = number1 * number2
                "/" -> {
                    if (number2 != 0.0) {
                        result = number1 / number2
                    } else {
                        resultTextView.text = "Error: Division by zero"
                        return
                    }
                }
            }

            resultTextView.text = "Result: $result"
        } catch (e: Exception) {
            resultTextView.text = "Error: Invalid input"
        }
    }
}
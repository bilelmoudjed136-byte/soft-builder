package com.example.generated

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : android.app.Activity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var resultTextView: TextView
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divideButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        resultTextView = findViewById(R.id.resultTextView)
        addButton = findViewById(R.id.addButton)
        subtractButton = findViewById(R.id.subtractButton)
        multiplyButton = findViewById(R.id.multiplyButton)
        divideButton = findViewById(R.id.divideButton)

        addButton.setOnClickListener {
            val num1 = editText1.text.toString().toDouble()
            val num2 = editText2.text.toString().toDouble()
            val result = num1 + num2
            resultTextView.text = "الناتج: $result"
        }

        subtractButton.setOnClickListener {
            val num1 = editText1.text.toString().toDouble()
            val num2 = editText2.text.toString().toDouble()
            val result = num1 - num2
            resultTextView.text = "الناتج: $result"
        }

        multiplyButton.setOnClickListener {
            val num1 = editText1.text.toString().toDouble()
            val num2 = editText2.text.toString().toDouble()
            val result = num1 * num2
            resultTextView.text = "الناتج: $result"
        }

        divideButton.setOnClickListener {
            val num1 = editText1.text.toString().toDouble()
            val num2 = editText2.text.toString().toDouble()
            if (num2 != 0.0) {
                val result = num1 / num2
                resultTextView.text = "الناتج: $result"
            } else {
                resultTextView.text = "خطأ: لا يمكن قسمة على الصفر"
            }
        }
    }
}
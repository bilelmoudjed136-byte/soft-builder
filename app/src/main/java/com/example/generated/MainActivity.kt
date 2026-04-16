package com.example.generated

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import android.widget.LinearLayout
import android.graphics.Color
import android.view.Gravity

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setBackgroundColor(Color.WHITE)
        val tv = TextView(this)
        tv.text = "Hello from Soft Builder!"
        tv.textSize = 24f
        tv.setTextColor(Color.BLACK)
        tv.gravity = Gravity.CENTER
        layout.addView(tv)
        setContentView(layout)
    }
}

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import kotlin.math.sqrt

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        val display = EditText(this)
        display.width = 300
        display.height = 100
        display.textSize = 24f
        display.isEnabled = false
        display.setBackgroundColor(resources.getColor(android.R.color.background_light))
        layout.addView(display)
        val buttons = arrayOf(
            arrayOf("7", "8", "9", "/"),
            arrayOf("4", "5", "6", "*"),
            arrayOf("1", "2", "3", "-"),
            arrayOf("0", ".", "=", "+")
        )
        for (row in buttons) {
            val rowLayout = LinearLayout(this)
            rowLayout.orientation = LinearLayout.HORIZONTAL
            for (text in row) {
                val button = Button(this)
                button.text = text
                button.width = 80
                button.height = 100
                button.setBackgroundColor(resources.getColor(android.R.color.background_light))
                button.setOnClickListener {
                    when (text) {
                        "=" -> {
                            try {
                                display.setText(eval(display.text.toString()).toString())
                            } catch (e: Exception) {
                                display.setText("Error")
                            }
                        }
                        else -> display.setText(display.text.toString() + text)
                    }
                }
                rowLayout.addView(button)
            }
            layout.addView(rowLayout)
        }
        layout.setBackgroundColor(resources.getColor(android.R.color.background_light))
        setContentView(layout)
    }
    fun eval(str: String): Double {
        return str.replace("^", "**").replace("sqrt", "Math.sqrt").replace("sin", "Math.sin").replace("cos", "Math.cos").replace("tan", "Math.tan").toDouble()
    }
}
package jp.techacademy.takumi.sakurai.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button1 -> sendValues("sum")
            R.id.button2 -> sendValues("difference")
            R.id.button3 -> sendValues("product")
            R.id.button4 -> sendValues("quotient")
        }
    }

    private fun sendValues(operator: String) {
        try{
            val x = value_X.text.toString().toDouble()
            val y = value_Y.text.toString().toDouble()
            var result: Double = 0.0

            if(operator == "quotient" && y == 0.0) {
                val rootLayout: View = findViewById(android.R.id.content)
                val snackbar = Snackbar.make(rootLayout , "０では割れません！", Snackbar.LENGTH_LONG)
                snackbar.show()
            } else {
                when (operator) {
                    "sum" -> result = x + y
                    "difference" -> result = x - y
                    "product" -> result = x * y
                    "quotient" -> result = x / y
                }
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("Result", result)
                startActivity (intent)
            }
        } catch (e : Exception){
            val rootLayout: View = findViewById(android.R.id.content)
            val snackbar = Snackbar.make(rootLayout , "「数値」を入力してください！", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
    }
}
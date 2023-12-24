package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var text: TextView
    lateinit var buttonIncrement: Button
    lateinit var buttonDecrement: Button

    lateinit var a: LinearLayout

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonIncrement = findViewById(R.id.incrementButton)
        buttonDecrement = findViewById(R.id.decrementButton)

        text = findViewById(R.id.countTextView)
        a = findViewById(R.id.rootLayout);

        buttonIncrement.setOnClickListener {
            text.text = (text.text.toString().toInt() + 2).toString()
            if (text.text.toString().toInt() >= 4){
                buttonIncrement.isEnabled = false
            }
            if(text.text.toString().toInt() != 0){
                buttonDecrement.isEnabled = true
            }
        }

        buttonDecrement.setOnClickListener {
            text.text = (text.text.toString().toInt() - 2).toString()

            if (text.text.toString().toInt() == 0){
                buttonDecrement.isEnabled = false
            }
            if(text.text.toString().toInt() != 0){
                buttonIncrement.isEnabled = true
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("key1",  text.text.toString())
        outState.putBoolean("key2", buttonIncrement.isEnabled)
        outState.putBoolean("key3", buttonDecrement.isEnabled)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        text.text = savedInstanceState.getString("key1")
        buttonIncrement.isEnabled = savedInstanceState.getBoolean("key2")
        buttonDecrement.isEnabled = savedInstanceState.getBoolean("key3")

    }
}
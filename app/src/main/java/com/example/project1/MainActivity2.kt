package com.example.project1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val textView = findViewById<TextView>(R.id.textView)

        val radioButtonValue = intent.getStringExtra("selectedRadioButton")
        val selectedCheckboxes = intent.getStringArrayListExtra("selectedCheckboxes")

        val message = "Major : $radioButtonValue\n" +
                "Languages : ${selectedCheckboxes?.joinToString(", ")}"

        textView.text = message
    }
}

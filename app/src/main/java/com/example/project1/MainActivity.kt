package com.example.project1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup = findViewById<RadioGroup>(R.id.rg)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            val selectedOption = radioButton.text.toString()
            showToast("You picked: $selectedOption")
        }

        val submitButton = findViewById<Button>(R.id.b) // Find the submit button by its ID

        submitButton.setOnClickListener {
            // Get the selected options inside the click listener
            val radioButton = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)

            // Get the selected options
            val selectedRadioButtonText = radioButton?.text.toString()
            val selectedCheckboxes = mutableListOf<String>()

            // Find checkboxes by their IDs
            val checkBox1 = findViewById<CheckBox>(R.id.c1)
            val checkBox2 = findViewById<CheckBox>(R.id.c2)
            val checkBox3 = findViewById<CheckBox>(R.id.c3)
            val checkBox4 = findViewById<CheckBox>(R.id.c4)
            val checkBox5 = findViewById<CheckBox>(R.id.c5)

            // Add selected checkboxes to the list
            if (checkBox1.isChecked) selectedCheckboxes.add(checkBox1.text.toString())
            if (checkBox2.isChecked) selectedCheckboxes.add(checkBox2.text.toString())
            if (checkBox3.isChecked) selectedCheckboxes.add(checkBox3.text.toString())
            if (checkBox4.isChecked) selectedCheckboxes.add(checkBox4.text.toString())
            if (checkBox5.isChecked) selectedCheckboxes.add(checkBox5.text.toString())

            // Create an intent to start the second activity
            val intent = Intent(this, MainActivity2::class.java)
            // Put the selected options as extras in the intent
            intent.putExtra("selectedRadioButton", selectedRadioButtonText)
            intent.putStringArrayListExtra("selectedCheckboxes", ArrayList(selectedCheckboxes))
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

package com.aleangelozi.sharedpreferences

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val buttonSave = findViewById<Button>(R.id.btnSave)
        val buttonLoad = findViewById<Button>(R.id.btnLoad)
        val buttonDelete = findViewById<Button>(R.id.btnDelete)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()


        buttonSave.setOnClickListener {
            val name = etName.text.toString()

            editor.apply {
                putString("name", name)
                apply()
            }
        }

        buttonLoad.setOnClickListener {
            val name = sharedPref.getString("name", null)

            etName.setText(name)
        }

        buttonDelete.setOnClickListener {

            editor.apply {
                remove("name")
                apply()
            }
        }


    }
}
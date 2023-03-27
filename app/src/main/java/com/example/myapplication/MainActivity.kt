package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent()
        intent.setClass(this@MainActivity, MainActivity2::class.java)


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val EditTextName = findViewById<EditText>(R.id.editTextName).text.toString()
            val EditTextSex = findViewById<EditText>(R.id.editTextSex).text.toString()
            val bundle = Bundle()
            bundle.putString("Name", EditTextName)
            bundle.putString("Sex", EditTextSex)
            //val intent = Intent(this, MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivityForResult(intent,1)

        }

    }
    @Deprecated("Deprecated in Java")
    @Suppress("DEPRECATION")
    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let {

            if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
                findViewById<TextView>(R.id.textView3).text =
                    "Size: ${it.getString("Size")}\n\n" +
                    "Color: ${it.getString("Color")}\n\n"

                }
            }
    }
}

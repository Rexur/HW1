package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //intent?.extras?.let {
        val bundle = this.getIntent().getExtras()
        val EditTextName = bundle?.getString("Name")
        val EditTextSex = bundle?.getString("Sex")


        //val bundle = Bundle()
        //bundle.putString("Key3","value")
        //bundle.putString("Key1","111")
        //val intent = Intent().putExtras(bundle)
        //setResult(Activity.RESULT_OK,intent.putExtras(bundle))
        //finish()
        //}

        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener{
            val bundle2 = Bundle()
            val EditTextSize = findViewById<TextView>(R.id.editTextSize).text.toString()
            val EditTextColor = findViewById<TextView>(R.id.editTextColor).text.toString()
            bundle2.putString("Size", EditTextSize)
            bundle2.putString("Color", EditTextColor)
            bundle2.putString("Name",EditTextName)
            bundle2.putString("Sex",EditTextSex)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtras(bundle2)
            setResult(Activity.RESULT_OK,intent.putExtras(bundle2))
            finish()

        }


    }
}
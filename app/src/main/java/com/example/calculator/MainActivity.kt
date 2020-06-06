package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun operationFunction(view: View){
        var editText: EditText = findViewById(R.id.edit_text)

        when(view.id){
            R.id.button_seven -> editText.setText("7")
            R.id.button_one -> editText.setText("1")
        }



    }
}



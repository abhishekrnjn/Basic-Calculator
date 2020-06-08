package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {

    var number :String = ""
    var numberOne : Float = 0.0F
    var numberTwo : Float = 0.0F
    var result : Float = 0.0F
    var isAddition :Boolean =false
    var isMultiply : Boolean =false
    var isMinus: Boolean = false
    var isdot : Boolean = false
    var isresult : Boolean =false
    var requiredReset: Boolean = true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun operationFunction(view: View){
        var editText: EditText? = findViewById(R.id.edit_text)

        when(view.id){
            R.id.button_multiply -> requiredReset=false
            R.id.button_plus -> requiredReset = false
            R.id.button_minus -> requiredReset = false

        }

        if(isresult && requiredReset){
            number =""
            isresult=false

        }
        requiredReset = true;

        when(view.id){



            R.id.button_one -> {
                number+="1"
                editText?.setText(number)
            }
            R.id.button_two ->{
                number+="2"
                editText?.setText(number)
            }
            R.id.button_three ->{
                number+="3"
                editText?.setText(number)
            }
            R.id.button_four ->{
                number+="4"
                editText?.setText(number)
            }
            R.id.button_five ->{
                number+="5"
                editText?.setText(number)
            }
            R.id.button_six ->{
                number+="6"
                editText?.setText(number)
            }
            R.id.button_seven ->{
                number+="7"
                editText?.setText(number)
            }
            R.id.button_eight ->{
                number+="8"
                editText?.setText(number)
            }
            R.id.button_nine ->{
                number+="9"
                editText?.setText(number)
            }
            R.id.button_zero ->{
                number+="0"
                editText?.setText(number)
            }
            R.id.button_clear ->{
                number =""
                editText?.setText(number)
                isdot=false
                isMultiply=false
                isAddition=false
                isMinus =false
            }
            R.id.button_dot ->{
                if(!isdot) {
                    number += "."
                    editText?.setText(number)
                    isdot =true
                }
            }
            R.id.button_plus ->{
                lastoperation()
                if(number.isNullOrBlank()){
                    return
                }
                else {
                    numberOne = number.toFloat()
                    editText?.setText("")
                    isAddition = true
                    number = ""
                }

            }
            R.id.button_multiply ->{
                lastoperation()
                if(number.isNullOrBlank()){
                    return
                }
                else {
                    numberOne = number.toFloat()
                    editText?.setText("")
                    isMultiply = true
                    number = ""
                }

            }
            R.id.button_minus->{
                lastoperation()
                if(number.isNullOrBlank()){
                    return
                }
                else {
                    numberOne = number.toFloat()
                    editText?.setText("")
                    isMinus = true;
                    isdot=false
                    number = ""
                }

            }

            R.id.button_equal ->{
                if(isAddition){
                    if(number.isNullOrBlank()){
                        editText?.setText("")
                    }
                    else {
                        numberTwo = number.toFloat()
                        result = numberOne + numberTwo
                        editText?.setText(result.toString())
                        number = result.toString()
                        isAddition = false;
                        isresult =true
                    }
                }
                if(isMultiply){
                    if(number.isNullOrBlank()){
                        editText?.setText("")
                    }
                    else {
                        numberTwo = number.toFloat()
                        result = numberOne * numberTwo
                        editText?.setText(result.toString())
                        number = result.toString()
                        isMultiply = false
                        isresult =true
                    }
                }
                if(isMinus){
                    if(number.isNullOrBlank()){
                        editText?.setText("")
                    }
                    else {
                        numberTwo = number.toFloat()
                        result = numberOne - numberTwo
                        editText?.setText(result.toString())
                        number = result.toString()
                        isMinus = false
                        isresult =true
                    }
                }

            }
        }



    }
     fun lastoperation(){
         isdot=false
         if(number.isNullOrBlank())
             return

        numberTwo = number.toFloat()
        if(isAddition){
            number= (numberOne+numberTwo).toString()
            isAddition = false
        }
        else if(isMinus){
            number = (numberOne+numberTwo).toString()
            isMinus =false
        }
        else if(isMultiply){
            number = (numberOne*numberTwo).toString()
            isMultiply=false
        }

    }
}



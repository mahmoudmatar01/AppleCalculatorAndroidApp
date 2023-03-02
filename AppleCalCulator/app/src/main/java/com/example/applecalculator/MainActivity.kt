package com.example.applecalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Clear Btn Method
        Clear.setOnClickListener(){
            InputData.text=""
            Result.text=""
        }



        number1.setOnClickListener(){
            InputData.text=addToinputText(number1.text.toString())
        }

        number2.setOnClickListener(){
            InputData.text=addToinputText(number2.text.toString())
        }

        number3.setOnClickListener(){
            InputData.text=addToinputText(number3.text.toString())
        }

        number4.setOnClickListener(){
            InputData.text=addToinputText(number4.text.toString())
        }

        number5.setOnClickListener(){
            InputData.text=addToinputText(number5.text.toString())
        }

        number6.setOnClickListener(){
            InputData.text=addToinputText(number6.text.toString())
        }

        number7.setOnClickListener(){
            InputData.text=addToinputText(number7.text.toString())
        }

        number8.setOnClickListener(){
            InputData.text=addToinputText(number8.text.toString())
        }

        number9.setOnClickListener(){
            InputData.text=addToinputText(number9.text.toString())
        }

        zerobtn.setOnClickListener(){
            InputData.text=addToinputText(zerobtn.text.toString())
        }

        dotbtn.setOnClickListener(){
            InputData.text=addToinputText("0.")
        }

        plus.setOnClickListener(){
            InputData.text=addToinputText(plus.text.toString())
        }

        minus.setOnClickListener(){
            InputData.text=addToinputText(minus.text.toString())
        }

        Multi.setOnClickListener(){
            InputData.text=addToinputText(Multi.text.toString())
        }

        Div.setOnClickListener(){
            InputData.text=addToinputText(Div.text.toString())
        }

        Closebracket.setOnClickListener(){
            InputData.text=addToinputText(Closebracket.text.toString())
        }

        equalbtn.setOnClickListener(){
            ShowResult()
            if(ShowResult()=="Error"){
                InputData.text=InputData.text
            }
            else{
                InputData.text=ShowResult()
            }
        }

        openbracket.setOnClickListener(){
            InputData.text=addToinputText(openbracket.text.toString())
        }

        BackSpace.setOnClickListener(){
            if(InputData.text.length>1){
                InputData.text=InputData.text.subSequence(0,InputData.text.length-1)
            }
            else{
                InputData.text=""
            }
        }

    }


    private fun addToinputText(buttonText:String):String{
        if(InputData.text.length>15){
            return "${InputData.text}"
        }
        return "${InputData.text}$buttonText"
    }


    @SuppressLint("SetTextI18n")
    private fun ShowResult():String{

        try{

            val expression=InputData.text.toString()
            val result=Expression(expression).calculate()
            if(result.isNaN()){
                Result.text="Error"
                Result.setTextColor(ContextCompat.getColor(this, R.color.design_default_color_error))
            }
            else{
                Result.text=DecimalFormat("0.#######").format(result).toString()
                Result.setTextColor(ContextCompat.getColor(this, R.color.green))

            }


        }
        catch (e:java.lang.Exception){
            Result.text="Error"
        Result.setTextColor(ContextCompat.getColor(this, R.color.design_default_color_error))
    }
    return Result.text.toString()
    }


}
package com.project.morsetotext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ReceiveCode : AppCompatActivity() {
    private val TAG = "rec"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_code)
        val morse_text = findViewById<TextView>(R.id.mt)

        val dot = findViewById<Button>(R.id.dot)
        val dash = findViewById<Button>(R.id.dash)
        val space = findViewById<Button>(R.id.space)

        dot.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var temp = morse_text.text.toString()
                temp+='.'

                morse_text.text = temp
            }
        })

        dash.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var temp = morse_text.text.toString()
                temp+='-'

                morse_text.text = temp
            }
        })

        space.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var temp = morse_text.text.toString()
                temp+=' '

                morse_text.text = temp
            }
        })


        val translate = findViewById<Button>(R.id.translate)
        translate.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {

                var str:String = morse_text.text.toString()
                morse_text.text=""
                str+=' '
                var finaltext:String = ""
                var temp:String = ""
                for(i in str){


                    if(i==' ')
                    {
                        Log.d(TAG, temp.length.toString())
                        finaltext+=Convert(temp)
                        temp=""
                    }
                    else
                    {
                        temp+=i
                    }
                }
                val show_code = findViewById<TextView>(R.id.show_code)

                show_code.text = finaltext
            }
        })

    }

    private fun Convert(temp: String): String {

        if(temp==".-")
            return "A"
        else if(temp=="-...")
            return "B"
        else if(temp=="-.-.")
            return "C"
        else if(temp=="-..")
            return "D"
        else if(temp==".")
            return "E"
        else if(temp=="..-.")
            return "F"
        else if(temp=="--.")
            return "G"
        else if(temp=="....")
            return "H"
        else if(temp=="..")
            return "I"
        else if(temp==".---")
            return "J"
        else if(temp=="-.-")
            return "K"
        else if(temp==".-..")
            return "L"
        else if(temp=="--")
            return "M"
        else if(temp=="-.")
            return "N"
        else if(temp=="---")
            return "O"
        else if(temp==".--.")
            return "P"
        else if(temp=="--.-")
            return "Q"
        else if(temp==".-.")
            return "R"
        else if(temp=="...")
            return "S"
        else if(temp=="-")
            return "T"
        else if(temp=="..-")
            return "U"
        else if(temp=="...-")
            return "V"
        else if(temp==".--")
            return "W"
        else if(temp=="-..-")
            return "X"
        else if(temp=="-.--")
            return "Y"
        else if(temp=="--..")
            return "Z"
        else if(temp==".----")
            return "1"
        else if(temp=="..---")
            return "2"
        else if(temp=="...--")
            return "3"
        else if(temp=="....-")
            return "4"
        else if(temp==".....")
            return "5"
        else if(temp=="-....")
            return "6"
        else if(temp=="--...")
            return "7"
        else if(temp=="---..")
            return "8"
        else if(temp=="----.")
            return "9"
        else if(temp=="-----")
            return "0"
        else if(temp==".-.-.-")
            return "."
        else if(temp=="--..--")
            return ","
        else if(temp=="..--..")
            return "?"
        return "#"

    }
}
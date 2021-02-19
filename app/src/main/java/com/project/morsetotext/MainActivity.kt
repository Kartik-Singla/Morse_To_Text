package com.project.morsetotext

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Camera
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val TAG:String = "main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_code)

        val send = findViewById<Button>(R.id.send)
        val receive = findViewById<Button>(R.id.receive)

        send.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View?) {
                val i:Intent = Intent(this@MainActivity,SendCode::class.java)
                startActivity(i)
            }
        })

        receive.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View?) {
                val i:Intent = Intent(this@MainActivity,ReceiveCode::class.java)
                startActivity(i)
            }
        })


    }



}
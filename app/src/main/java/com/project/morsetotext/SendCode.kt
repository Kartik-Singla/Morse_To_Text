package com.project.morsetotext

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SendCode : AppCompatActivity() {
    private lateinit var mCameraManager: CameraManager
    private lateinit var mCameraId:String
    private val TAG:String = "main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isFlash:Boolean = applicationContext.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)//variable to check if device has working flash

        if(!isFlash) {
            Toast.makeText(this,"No Flash detected", Toast.LENGTH_SHORT).show()
        }

        mCameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager//getting camera service

        try {
            mCameraId = mCameraManager.cameraIdList[0]
        }
        catch (e: CameraAccessException){
            e.stackTrace
        }
        val morsetext = findViewById<EditText>(R.id.mt)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {

                val text:String = morsetext.text.toString()

                var binary:String = ""

                for(i in text){
                    if(i=='A' || i=='a')
                        binary += ".-"
                    else if (i=='Z' || i=='z')
                        binary+="--.."
                    else if (i=='B' || i=='b')
                        binary+="-..."
                    else if (i=='C' || i=='c')
                        binary+="-.-."
                    else if (i=='D' || i=='d')
                        binary+="-.."
                    else if (i=='E' || i=='e')
                        binary+="."
                    else if (i=='F' || i=='f')
                        binary+="..-."
                    else if (i=='G' || i=='g')
                        binary+="--."
                    else if (i=='H' || i=='h')
                        binary+="...."
                    else if (i=='I' || i=='i')
                        binary+=".."
                    else if (i=='J' || i=='j')
                        binary+=".---"
                    else if (i=='K' || i=='k')
                        binary+="-.-"
                    else if (i=='L' || i=='l')
                        binary+=".-.."
                    else if (i=='M' || i=='m')
                        binary+="--"
                    else if (i=='N' || i=='n')
                        binary+="-."
                    else if (i=='O' || i=='o')
                        binary+="---"
                    else if (i=='P' || i=='p')
                        binary+=".--."
                    else if (i=='Q' || i=='q')
                        binary+="--.-"
                    else if (i=='R' || i=='r')
                        binary+=".-."
                    else if (i=='S' || i=='s')
                        binary+="..."
                    else if (i=='T' || i=='t')
                        binary+="-"
                    else if (i=='U' || i=='u')
                        binary+="..-"
                    else if (i=='V' || i=='v')
                        binary+="...-"
                    else if (i=='W' || i=='w')
                        binary+=".--"
                    else if (i=='X' || i=='x')
                        binary+="-..-"
                    else if (i=='Y' || i=='y')
                        binary+="-.--"
                    else if(i=='1')
                        binary+=".----"
                    else if(i=='2')
                        binary+="..---"
                    else if(i=='3')
                        binary+="...--"
                    else if(i=='4')
                        binary+="....-"
                    else if(i=='5')
                        binary+="....."
                    else if(i=='6')
                        binary+="-...."
                    else if(i=='7')
                        binary+="--..."
                    else if(i=='8')
                        binary+="---.."
                    else if(i=='9')
                        binary+="----."
                    else if(i=='0')
                        binary+="-----"
                    else if(i=='.')
                        binary+=".-.-.-"
                    else if(i==',')
                        binary+="--..--"
                    else if(i=='?')
                        binary+="..--.."


                    binary+="#"
                }
                BlinkFlash(binary)
            }
        })

    }

    private fun BlinkFlash(mystring:String) {


        val blinkDelay:Long = 50

        for (item in mystring){
            if(item == '-')
            {
                try{
                    mCameraManager.setTorchMode(mCameraId,true)
                }catch(e: CameraAccessException){
                    e.stackTrace
                }
                try{
                    Thread.sleep(1000)
                    mCameraManager.setTorchMode(mCameraId,false)
                    Thread.sleep(100)
                }
                catch (e:InterruptedException){
                    e.stackTrace
                }
            }
            else if(item=='.')
            {
                try{
                    mCameraManager.setTorchMode(mCameraId,true)
                }catch(e: CameraAccessException){
                    e.stackTrace
                }
                try{
                    Thread.sleep(200)
                    mCameraManager.setTorchMode(mCameraId,false)
                    Thread.sleep(100)
                }
                catch (e:InterruptedException){
                    e.stackTrace
                }
            }
            else if(item=='#') {
                mCameraManager.setTorchMode(mCameraId, false)
                Thread.sleep(2000)
            }

        }

    }




}
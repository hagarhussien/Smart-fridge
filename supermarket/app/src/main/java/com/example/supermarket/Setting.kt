package com.example.supermarket

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.button.MaterialButton
import com.google.firebase.Firebase
import com.google.firebase.database.database

class Setting : AppCompatActivity(), View.OnClickListener {
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var mode: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val logptn: MaterialButton = findViewById(R.id.logptn)

        logptn.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        btn1 = findViewById<Button>(R.id.on)
        btn2 = findViewById<Button>(R.id.off)
        mode = findViewById<Button>(R.id.mode)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        mode.setOnClickListener(this)

//        val switch:SwitchCompat=findViewById<SwitchCompat>(R.id.switch1)

        val sharedPreferences=getSharedPreferences("Mode", Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        val nightMode=sharedPreferences.getBoolean("night",false)
        if(nightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }


//                editor.putBoolean("night",false)
//                editor.commit()}



    }


    override fun onClick(v: View?) {
        if (v == btn1) {
            val database = Firebase.database
            val myRef = database.getReference("Control")
            myRef.setValue("true")

        }
        else if(v==btn2)
        {
            val database = Firebase.database
            val myRef = database.getReference("Control")
            myRef.setValue("false")
        }
        else {
            val sharedPreferences = getSharedPreferences("Mode", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val currentMode = AppCompatDelegate.getDefaultNightMode()
            if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean("night", false)
                editor.commit()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean("night", true)
                editor.commit()
            }

        }

        }
    }




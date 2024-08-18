package com.example.app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.Firebase
import com.google.firebase.database.database

class SendData : AppCompatActivity(),OnClickListener {
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var txt:EditText
    //val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_data)
        btn1=findViewById<Button>(R.id.man)
        btn2=findViewById<Button>(R.id.atu)
        txt=findViewById<EditText>(R.id.editBtn)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)

        val logptn: MaterialButton = findViewById(R.id.logptn)

        logptn.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

    }

    override fun onClick(v: View?) {
        if (v == btn1)
        {
            val database = Firebase.database



            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val getUserName: String?=sharedPreferences.getString("ُUserName","Ahmed")
            val myRef = database.getReference("qty").child("sty")
            myRef.setValue(getUserName)
            val nameRef = database.getReference("order").child("Name")
           nameRef.setValue(getUserName)
            val getAddress: String?=sharedPreferences.getString("Address","No")
            val addressRef = database.getReference("order").child("Address")
            addressRef.setValue(getAddress)
            val getPhone: String?=sharedPreferences.getString("Phone","No")
            val phoneRef = database.getReference("order").child("Phone")
          phoneRef.setValue(getPhone)
            val myQ = database.getReference("order").child("Quantaty")
            myQ.setValue(txt.text.toString())

        }
        else if(v==btn2)
        {
            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val getEmail: String?=sharedPreferences.getString("Edit","No")
            val database = Firebase.database

          //  val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val getUserName: String?=sharedPreferences.getString("ُUserName","Ahmed")
            val myRef = database.getReference("qty").child("sty")
            myRef.setValue(getUserName)
            val nameRef = database.getReference("order").child("Name")
            nameRef.setValue(getUserName)
            val getAddress: String?=sharedPreferences.getString("Address","No")
            val addressRef = database.getReference("order").child("Address")
            addressRef.setValue(getAddress)
            val getPhone: String?=sharedPreferences.getString("Phone","No")
            val phoneRef = database.getReference("order").child("Phone")
            phoneRef.setValue(getPhone)
            val mm: String?=sharedPreferences.getString("Edit","No")

            val myQ = database.getReference("order").child("Quantaty")
            myQ.setValue(mm)
        }
    }

}
package com.example.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class OTP2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp2)

        val phone: EditText = findViewById<EditText>(R.id.txtptn)
        val Confirm: Button = findViewById<Button>(R.id.conptn)




        Confirm.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

            val getMobile: String?=sharedPreferences.getString("Phone","0125")

            val phoneNum = phone.text.toString().trim()
            if (phoneNum.isEmpty()) {
                phone.error = "Please Enter Your Phone"
            } else {
                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
            }
            if(phoneNum.isNotEmpty() && phoneNum==getMobile){
                val intent = Intent(this,MakeSelection::class.java)
                startActivity(intent)
            }
        }

           /* Confirm.setOnClickListener {
                // تنفيذ العمليات عند الضغط على زر التأكيد
                val phoneNumber = phone.text.toString()

                // قم بتنفيذ إجراءات إرسال رمز التحقق إلى رقم الهاتف
                // يمكنك استخدام مكتبات إرسال رسائل التحقق مثل Firebase Authentication
            }*/

    }
}
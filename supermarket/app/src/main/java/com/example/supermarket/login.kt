package com.example.supermarket

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.supermarket.R

class login : AppCompatActivity() {

    private var passwordVisible = false
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

//        val sharedPreferences = getSharedPreferences("USER_CREDENTIALS", Context.MODE_PRIVATE)


        val emailET: EditText = findViewById<EditText>(R.id.emailET);
        val passwordET: EditText = findViewById<EditText>(R.id.passwordET);
        val passwordIcon: ImageView = findViewById<ImageView>(R.id.passwordIcon);
        val signUpBtn: TextView = findViewById<TextView>(R.id.signUpBtn);
        val signIn: AppCompatButton = findViewById<AppCompatButton>(R.id.signInBtn)

        val forgetPassword:TextView=findViewById<TextView>(R.id.forgetPasswordBtn)
        passwordIcon.setOnClickListener {
            val passwordText = passwordET.text.toString()
            Toast.makeText(this, passwordText, Toast.LENGTH_SHORT).show()
        }

        //passwordhiden
        passwordIcon.setOnClickListener {
            passwordVisible = !passwordVisible
            val transformationMethod =
                if (passwordVisible) null else PasswordTransformationMethod.getInstance()
            passwordET.transformationMethod = transformationMethod

            // تغيير أيقونة العين
            val iconRes =
                if (passwordVisible) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24
            passwordIcon.setImageDrawable(ContextCompat.getDrawable(this, iconRes))

            // تحديث المؤشر إلى نهاية النص
            passwordET.setSelection(passwordET.length())
        }

        signUpBtn.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }


        forgetPassword.setOnClickListener {
            val intent = Intent(this, OTP2::class.java);
            startActivity(intent)
        }

        signIn.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


            val storedEmail:String? = sharedPreferences.getString("Email", "")
            val Email = emailET.text.toString().trim()
//            if(username==storedUsername) {
            if (Email.isEmpty()) {
                emailET.error = "Please Enter Your Email"
            } else {
                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
            }
//            }
//            else{
//                usernameET.error = "Please Enter Your Correct Name"
//            }
            val storedPassword:String? = sharedPreferences.getString("Password", "")
            val Pass = passwordET.text.toString().trim()

            if (Pass.isEmpty()) {
                passwordET.error = "Please Enter Your Correct Password "
            } else {
                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
            }

            if (Email.isNotEmpty() && Pass.isNotEmpty()&& Email == storedEmail && Pass == storedPassword)
            {

                val intent = Intent(this, Notification::class.java)
                startActivity(intent)
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()

            }
            else{
                Toast.makeText(this, "Incorrect email or phone number?", Toast.LENGTH_SHORT).show()
            }

        }

//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//
//            Toast.makeText(baseContext, "welcome back   ",Toast.LENGTH_SHORT).show()
//            val intent = Intent(this, mainPage::class.java)
//            startActivity(intent)


    }

}

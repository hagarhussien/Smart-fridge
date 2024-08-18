package com.example.supermarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class New_Password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_password)

        val password: EditText = findViewById<EditText>(R.id.newptn);
        val conPassword: EditText = findViewById<EditText>(R.id.conptn);
        val submit: Button = findViewById<Button>(R.id.subptn)


        fun checkPasswordStrength(password: String): Boolean {
            // Check the length
            if (password.length <8) {
                return false
            }

            // Check for at least one letter
            if (!password.any { it.isLetter() }) {
                return false
            }

            // Check for at least one digit
            if (!password.any { it.isDigit() }) {
                return false
            }

            // Check for at least one special character
            if (!password.any { it.isLetterOrDigit() && !it.isDigit() }) {
                return false
            }

            return true
        }

        fun main() {
            val password = "WeakPassword"
            if (!checkPasswordStrength(password)) {
                println("كلمة المرور ضعيفة. من فضلك، أدخل كلمة مرور قوية.")
            }
        }


        submit.setOnClickListener {
            val pass = password.text.toString().trim()
            if (!checkPasswordStrength(pass)) {
                Toast.makeText(this, "The password is weak. Please, enter a strong password.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pass.isEmpty()) {
                password.error = "Please Enter Your Password"
            } else {
                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
            }

            val conPass = conPassword.text.toString().trim()
            if (conPass.isEmpty()) {
                conPassword.error = "Please Enter Your Confirm Password"
            } else {
                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
            }
            if (pass.isNotEmpty() && conPass.isNotEmpty() && checkPasswordStrength(pass) && conPassword.text.toString().equals(password.text.toString())) {
                    val intent = Intent(this, login::class.java)
                    startActivity(intent)
                }
        }


        }
}
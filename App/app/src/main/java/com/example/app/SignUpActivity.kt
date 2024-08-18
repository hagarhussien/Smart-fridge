package com.example.app

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class SignUpActivity : AppCompatActivity() {
    private fun isEmailFormal(email: String): Boolean {
        val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        return email.matches(emailRegex)
    }

    fun checkPasswordStrength(password: String): Boolean {
        // Check the length
        if (password.length < 8) {
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

    private var passwordShowing = false;
    private var conPasswordShowing = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
//        var editor = sharedPreference.edit()
//        editor.putString("username","Anupam")
//        editor.putString("ُEmail","Anupam")
//        editor.commit()


        setContentView(R.layout.activity_sign_up)
        val username: EditText = findViewById<EditText>(R.id.SingInName)

        val email: EditText = findViewById<EditText>(R.id.SingInEmail);
        val phone: EditText = findViewById<EditText>(R.id.SingInPhone);
        val password: EditText = findViewById<EditText>(R.id.passwordET);
        val conpassword: EditText = findViewById<EditText>(R.id.conPasswordET);
        val passwordIcon: ImageView = findViewById<ImageView>(R.id.passwordIcon);
        val conPasswordIcon: ImageView = findViewById<ImageView>(R.id.conPasswordIcon);
        val age: EditText = findViewById<EditText>(R.id.SingInAge);
        val address: EditText = findViewById<EditText>(R.id.SingInAddress);
        val SignUpBtn: AppCompatButton = findViewById<AppCompatButton>(R.id.signUpInBtn);
        val signwithgoogle: TextView = findViewById<TextView>(R.id.signgoogle);

        //checking if password is showing or not
        passwordIcon.setOnClickListener {
            if (passwordShowing) {
                passwordShowing = false;
                password.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD);
                passwordIcon.setImageResource(com.google.android.material.R.drawable.avd_show_password);

            } else {
                passwordShowing = true;
                password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                passwordIcon.setImageResource(com.google.android.material.R.drawable.avd_hide_password);

            }
            password.setSelection(password.length());
        }


        /*556*/ conPasswordIcon.setOnClickListener {

            if (conPasswordShowing) {
                conPasswordShowing = false;
                conpassword.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD);
                conPasswordIcon.setImageResource(com.google.android.material.R.drawable.avd_show_password);

            } else {
                conPasswordShowing = true;
                conpassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                passwordIcon.setImageResource(com.google.android.material.R.drawable.avd_hide_password);

            }
            conpassword.setSelection(conpassword.length());
        }

        /*
        SignUpBtn.setOnClickListener{
            val getPhoneTxt:String=phone.getText().toString()
            val getEmailTxt:String=email.getText().toString()
                val intent=Intent(this,OTPVerifiction::class.java)
            intent.putExtra("phone",getPhoneTxt)
            intent.putExtra("Email",getEmailTxt)
            startActivity(intent)
        }*/

        SignUpBtn.setOnClickListener {
            finish()
        }

        SignUpBtn.setOnClickListener {

            val userEmail = email.text.toString()
            if (isEmailFormal(userEmail)) {
                // البريد الإلكتروني صحيح، يمكنك تنفيذ الإجراءات اللازمة لعملية Sign up
                Toast.makeText(this, "successfully registered", Toast.LENGTH_SHORT).show()

            } else {
                // البريد الإلكتروني غير صحيح
                Toast.makeText(this, "please enter a working email address", Toast.LENGTH_SHORT)
                    .show()
            }
//val password=password.text.toString().trim()
            val passwprd = password.text.toString().trim()
            if (!checkPasswordStrength(passwprd)) {
                Toast.makeText(
                    this,
                    "The password is weak. Please, enter a strong password.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val Username = username.text.toString().trim()
            if (Username.isEmpty()) {
                username.error = "Please Enter Your Name"
            } else {
                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
            }

            val Email = email.text.toString().trim()
            if (Email.isEmpty()) {
                email.error = "Please Enter Your ُEmail"
            } else {
                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
            }

            val Phone = phone.text.toString().trim()
            if (Phone.isEmpty()) {
                phone.error = "Please Enter Your Phone Number"
            } else {
                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
            }


            val Passwprd = password.text.toString().trim()
            if (Passwprd.isEmpty()) {
                password.error = "Please Enter Your Password"
            } else {
                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
            }


            val ConPassword = conpassword.text.toString().trim()
            if (ConPassword.isEmpty()) {
                conpassword.error = "Please Enter Your Confirm Password"
            } else {
                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
            }


            val Age = age.text.toString().trim()
            if (Age.isEmpty()) {
                age.error = "Please Enter Your Age"
            } else {
                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
            }


            val Address = address.text.toString().trim()
            if (Address.isEmpty()) {
                address.error = "Please Enter Your Address"
            } else {
                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
            }

            if (Address.isNotEmpty() and Age.isNotEmpty() and checkPasswordStrength(passwprd) and isEmailFormal(
                    userEmail
                ) and ConPassword.isNotEmpty() and Passwprd.isNotEmpty() and Phone.isNotEmpty() and Email.isNotEmpty() and Username.isNotEmpty() and conpassword.text.toString()
                    .equals(password.text.toString())
            ) {
                val getPhoneTxt: String = phone.getText().toString()
                val getEmailTxt: String = email.getText().toString()
                val getUserNameTxt: String = username.getText().toString()
                val getPasswordTxt: String = password.getText().toString()
                val getAddressTxt:String=address.getText().toString()
                val intent = Intent(this, OTPVerifiction::class.java)
//                intent.putExtra("phone",getPhoneTxt)
//                intent.putExtra("Email",getEmailTxt)
                val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
                var editor = sharedPreferences.edit()
                editor.putString("Phone", getPhoneTxt)

                editor.putString("Email", getEmailTxt)

                editor.putString("ُUserName", getUserNameTxt)

editor.putString("Address",getAddressTxt)
                editor.putString("Password", getPasswordTxt)
                editor.commit()
                editor.apply()
                startActivity(intent)
            }


        }


    }

}








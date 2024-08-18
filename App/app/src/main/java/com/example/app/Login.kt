package com.example.app

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
import com.google.firebase.FirebaseApp

class Login : AppCompatActivity() {
    private val googleSignInRequestCode = 234
    private var passwordVisible = false


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this)
        setContentView(R.layout.activity_login);


//        val sharedPreferences = getSharedPreferences("USER_CREDENTIALS", Context.MODE_PRIVATE)


        val emailET: EditText = findViewById<EditText>(R.id.emailET);
        val passwordET: EditText = findViewById<EditText>(R.id.passwordET);
        val passwordIcon: ImageView = findViewById<ImageView>(R.id.passwordIcon);
        val signUpBtn: TextView = findViewById<TextView>(R.id.signUpBtn);
        val signIn: AppCompatButton = findViewById<AppCompatButton>(R.id.signInBtn)

        val forgetPassword: TextView = findViewById<TextView>(R.id.forgetPasswordBtn)
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
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }


        forgetPassword.setOnClickListener {
            val intent = Intent(this, OTP2::class.java);
            startActivity(intent)
        }

        signIn.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


            val storedEmail: String? = sharedPreferences.getString("Email", "")
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
            val storedPassword: String? = sharedPreferences.getString("Password", "")
            val Pass = passwordET.text.toString().trim()

            if (Pass.isEmpty()) {
                passwordET.error = "Please Enter Your Correct Password "
            } else {
                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
            }

            if (Email.isNotEmpty() && Pass.isNotEmpty() && Email == storedEmail && Pass == storedPassword) {

                val intent = Intent(this, mainPage::class.java)
                startActivity(intent)
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Incorrect email or phone number?", Toast.LENGTH_SHORT).show()
            }

        }
    }}

//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//
//            Toast.makeText(baseContext, "welcome back   ",Toast.LENGTH_SHORT).show()
//            val intent = Intent(this, mainPage::class.java)
//            startActivity(intent)

//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//
//        val googleSignInClient = GoogleSignIn.getClient(this, gso)
//
//
//        val googleSignInBtn: RelativeLayout = findViewById<RelativeLayout>(R.id.signInwithGoogle)
//        googleSignInBtn.setOnClickListener {
//
//            if (isConnected(this)) {
//                val signInIntent = googleSignInClient.signInIntent
//                startActivityForResult(signInIntent, googleSignInRequestCode)
//            } else {
//                longToastShow("No Internet Connection!")
//            }
//
//
//        }
//    }
//
//
//    fun isConnected(context: Context): Boolean {
//            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//            val activeNetwork = connectivityManager.activeNetworkInfo
//            return activeNetwork?.isConnected == true
//        }
//
//        // Method to show a long toast message
//        fun Context.longToastShow(message: CharSequence) {
//            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
//        }
//
//        // Handling the result in onActivityResult
//        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//            super.onActivityResult(requestCode, resultCode, data)
//
//            when (requestCode){
//                googleSignInRequestCode -> {
//                    try {
//                        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//                        val account = task.getResult(ApiException::class.java)
//                        firebaseAuthWithGoogle(account)
//
//                    }catch (e:ApiException){
//                        e.printStackTrace()
//                        e.message?.let { longToastShow(it) }
//                    }
//                }
//            }
//        }
//
//    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
//        val credential = GoogleAuthProvider.getCredential(account.idToken,null)
//        FirebaseAuth.getInstance().signInWithCredential(credential)
//            .addOnSuccessListener {
//                longToastShow("Login Successful")
//                val mainIntent = Intent(this,Login::class.java)
//                mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                startActivity(mainIntent)
//                finish()
//            }
//            .addOnFailureListener {
//                it.printStackTrace()
//                it.message?.let { it1 -> longToastShow(it1) }
//            }
//    }







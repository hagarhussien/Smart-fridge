package com.example.supermarket

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class Profile : AppCompatActivity() {
    var btn:Button?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val e=sharedPreferences.edit()
        val profileImage: ImageView = findViewById<ImageView>(R.id.profileImage)
        Log.d("mytag","ok")
        val s=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode==Activity.RESULT_OK&&it.data!=null)
            {
                val uri=it.data!!.data
                profileImage.setImageURI(uri!!)
                e.putString("image",uri.toString())
                e.commit()
            }
        }
//Mohammed
        // تفاعل مع العناصر في ملف التخطيط
        val btn:Button= findViewById<Button>(R.id.button)
        btn.setOnClickListener(View.OnClickListener {
            var intent=Intent()
            intent.action=Intent.ACTION_GET_CONTENT
            intent.type="image/*"
            s.launch(intent)
        })
        Log.d("mytag","ok2")
        val usernameTextView: TextView = findViewById<TextView>(R.id.useptn)
        val emailTextView: TextView = findViewById<TextView>(R.id.Emaptn)
       // val viewEmailButton: Button = findViewById(R.id.viewEmailButton)
        val settingsButton: TextView = findViewById(R.id.settptn)
        val helpButton: TextView = findViewById(R.id.helpptn)
        val logoutButton: TextView = findViewById(R.id.outptn)

        val User_Name: TextView = findViewById<TextView>(R.id.useptn)
        val Email: TextView = findViewById<TextView>(R.id.Emaptn)
        val Address:TextView=findViewById<TextView>(R.id.homptn)
        Log.d("mytag","ok3")

        val getEmail: String?=sharedPreferences.getString("Email","No")
        val getUserName: String?=sharedPreferences.getString("ُUserName","Ahmed")
        val getImage: String?=sharedPreferences.getString("image","nothing")
        val getAddress:String?=sharedPreferences.getString("Address","Assuit")
        Log.d("mytag","ok4")
        if(!getImage.equals("nothing")) {
            Log.d("Mostafa",getImage!!)
            Log.d("mytag","ok44444444")
            val u = Uri.parse(getImage)
            Log.d("Mostafa","uri: $u")
         //   profileImage.setImageURI(u!!)
        }
        Email.setText(getEmail);
      User_Name.setText(getUserName);
        Address.setText(getAddress)
        Log.d("mytag","ok5")

        //Log.d("Profile",getUser_Name!!)

        // قم بتعيين صورة الملف الشخصي وبيانات المستخدم
        // يمكنك استخدام مكتبة لاختيار الصورة مثل Intent.ACTION_PICK لاختيار صورة من الجهاز
        // عند النقر على الأزرار، يمكنك تنفيذ الإجراءات المناسبة مثل فتح صفحة البريد الإلكتروني
    //    viewEmailButton.setOnClickListener {
            // قم بتنفيذ الإجراء عند النقر على زر البريد الإلكتروني
      //  }

        settingsButton.setOnClickListener {
            // قم بتنفيذ الإجراء عند النقر على زر الإعدادات
            val intent= Intent(this,Setting::class.java)

            startActivity(intent)
        }



        logoutButton.setOnClickListener {
            Log.d("mytag","ok6")
            val intent= Intent(this,login::class.java)

            startActivity(intent)
            // قم بتنفيذ الإجراء عند النقر على زر تسجيل الخروج
        }

        val help:TextView=findViewById<TextView>(R.id.helpptn)


       help.setOnClickListener {

            val intent= Intent(this,Help::class.java)

            startActivity(intent)
            // قم بتنفيذ الإجراء عند النقر على زر تسجيل الخروج
        }
        val logptn: MaterialButton = findViewById(R.id.logptn)

        logptn.setOnClickListener {
            val intent = Intent(this,Notification::class.java)
            startActivity(intent)
        }

    }
}
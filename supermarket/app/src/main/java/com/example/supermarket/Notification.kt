package com.example.supermarket

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class Notification : AppCompatActivity() {
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        val database = Firebase.database
        val myRef = database.getReference("qty")
        var list = findViewById<ListView>(R.id.list1)
        var mylist = ArrayList<String>()
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                mylist = ArrayList<String>()
                val mylist = mutableListOf<String>()

                val list: ListView = findViewById<ListView>(R.id.list1)
                // list.setTextColor(getResources().getColor(R.color.move));
                for (child in snapshot.children) {


                    val value = child.value.toString() // عرض الوزن على TextView

                    val weightText = value
                    // تحويل الوزن إلى جرام


                    val message = " A message from ${weightText}"
                    // Toast.makeText(this@Notification, message, Toast.LENGTH_SHORT).show()

                    mylist.add(message)

                }


                val adapter =
                    ArrayAdapter(this@Notification, android.R.layout.simple_list_item_1, mylist)
                list.adapter = adapter
                list.setOnItemClickListener { parent, view, position, id ->
                    if (position == 0) {
                        val intent = Intent(this@Notification, Details2::class.java)
                        startActivity(intent)
                    }
                }}

                    override fun onCancelled(error: DatabaseError) {
                        Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
                    }
                })
//Mohammed
                    val backButton: MaterialButton = findViewById<MaterialButton>(R.id.logptn)




                    backButton.setOnClickListener {
                        // تنفيذ العمليات عند النقر على زر العودة
                        val intent = Intent(this, login::class.java)
                        startActivity(intent) // لإغلاق هذا النشاط والرجوع إلى النشاط السابق
                    }

                    val mn: ImageView = findViewById<ImageView>(R.id.prof)

                    mn.setOnClickListener {
                        val intent = Intent(this, Profile::class.java)

                        startActivity(intent)
                    }
                }
            }

//        Log.d("Notification", "Received data: superMarketPhone: $superMarketPhone, userEmail: $userEmail, " +
//                "userPhone: $userPhone, orderNumber: $orderNumber, quantity: $quantity")

//        nextButton.setOnClickListener {
//            // تنفيذ العمليات عند النقر على زر التالي
//            // يمكنك هنا تنفيذ الإجراءات الخاصة بالانتقال إلى الصفحة التالية
//            val intent = Intent(this, Request_Page::class.java)
//            startActivity(intent)
//        }


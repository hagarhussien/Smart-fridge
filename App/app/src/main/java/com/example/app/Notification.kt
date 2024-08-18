package com.example.app

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database


class Notification : AppCompatActivity() {
    var btn : Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        val database = Firebase.database
        val myRef = database.getReference("esp8266")
        var list=findViewById<ListView>(R.id.list1)
        var mylist = ArrayList<String>()
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                mylist = ArrayList<String>()

//                for (child in snapshot.children) {
//
//
//
//                    val value = child.value.toString() // عرض الوزن على TextView
//
//                    val weightText = value
//                    val weightInGrams = convertToGrams(weightText) // تحويل الوزن إلى جرام
//
//
//                    if (weightInGrams < 1000) {
//                        Toast.makeText(this@Notification,weightInGrams.toString(),Toast.LENGTH_SHORT).show()
//                        mylist.add(weightInGrams.toString())
//                        val adapter = ArrayAdapter(this@Notification, android.R.layout.simple_list_item_1, mylist)
//                        list.adapter = adapter
//
//
//                    }
//                    else{
//                        // sendMessage("No")
//                    }


//                }


                val mylist = mutableListOf<String>()

                val list:ListView=findViewById<ListView>(R.id.list1)
               // list.setTextColor(getResources().getColor(R.color.move));
                for (child in snapshot.children) {


                    val value = child.value.toString() // عرض الوزن على TextView

                    val weightText = value
                    val weightInGrams = convertToGrams(weightText) // تحويل الوزن إلى جرام

                    if (weightInGrams < 1000) {
                        val message = " ${child.key} now weighs ${weightInGrams}g"
                       // Toast.makeText(this@Notification, message, Toast.LENGTH_SHORT).show()

                        mylist.add(message)

                    }
                }

                val adapter = ArrayAdapter(this@Notification, android.R.layout.simple_list_item_1, mylist)
                list.adapter = adapter
                list.setOnItemClickListener { parent, view, position, id ->
                    if(position==0)
                    {
                        val intent = Intent(this@Notification, SendData::class.java)
                        startActivity(intent)
                    }
                }


            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })

        // التحقق من وجود الرسالة


//
//            // إنشاء محول (Adapter) لعرض الرسائل في ListView
//            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, messageList)
//
//            // ربط المحول بـ ListView
//            val listView: ListView = findViewById(R.id.list1)
//            listView.adapter = adapter
//        } else {
//            // إذا كانت الرسالة غير موجودة، يمكنك إظهار رسالة خطأ أو إجراء إجراء بديل
//            Toast.makeText(this, "No message received", Toast.LENGTH_SHORT).show()
//        }
//
//
        val backButton: MaterialButton = findViewById<MaterialButton>(R.id.logptn)

        backButton.setOnClickListener {
            // تنفيذ العمليات عند النقر على زر العودة
            val intent = Intent(this, mainPage::class.java)
            startActivity(intent) // لإغلاق هذا النشاط والرجوع إلى النشاط السابق
        }


    }





    // تحويل الوزن إلى جرام
    private fun convertToGrams(weight: String): Double {

        val parts = weight.split(",")

        var totalGrams = 0.0

        if (parts.size > 1) {
            val kk=parts[1].removeRange(0,4)
            val kg=kk.removeRange(kk.length-1,kk.length)
            Log.d("Hha",kg.toString())
            val kilograms = kg.toDoubleOrNull() ?: 0.0
            totalGrams += kilograms * 1000
            val grams = parts[0].removeRange(0,3).toDoubleOrNull() ?: 0.0
            totalGrams+=grams
        } else {
            totalGrams += weight.toDoubleOrNull() ?: 0.0
        }

        return totalGrams
    }




}
package com.example.app

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database


//class mainPage : AppCompatActivity() {
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main_page)
//        val table=findViewById<TableLayout>(R.id.tableLayout)
//        val database = Firebase.database
//        val myRef = database.getReference("esp8266")
//        val textview = TextView(this@mainPage)
//        val textview2 = TextView(this@mainPage)
//        myRef.addValueEventListener(object: ValueEventListener {
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                // whenever data at this location is updated.
//                //   val count = snapshot.childrenCount
//                val firstRow = table.getChildAt(0)
//                table.removeAllViews()
//
//                if (firstRow != null) {
//                    table.addView(firstRow)
//                }
//                for (child in snapshot.children) {
//
//                    Log.d("Mostafa", child.key.toString())
//                    val row = TableRow(this@mainPage)
//
//                    row.layoutParams = TableLayout.LayoutParams(
//                        TableLayout.LayoutParams.MATCH_PARENT,
//                        TableLayout.LayoutParams.WRAP_CONTENT
//                    )
////                    val textview = TextView(this@mainPage)
////                    val textview2 = TextView(this@mainPage)
//                    textview2.layoutParams = TableRow.LayoutParams(
//                        TableRow.LayoutParams.WRAP_CONTENT,
//                        TableRow.LayoutParams.WRAP_CONTENT
//                    )
//
//                    textview.layoutParams = TableRow.LayoutParams(
//                        TableRow.LayoutParams.WRAP_CONTENT,
//                        TableRow.LayoutParams.WRAP_CONTENT
//                    )
//                    textview2.setText(child.value.toString())
//                    textview.setText(child.key.toString())
//
//
//                    textview2.setPadding(5, 20, 5, 20)
//
//                    textview.setPadding(5, 20, 5, 20)
//                    textview.gravity = Gravity.CENTER
//                    textview2.gravity = Gravity.CENTER
//
//                    // تعيين لون خلفية الجدول
//                    table.setBackgroundColor(getResources().getColor(R.color.gray))
//
//                    textview.setTextColor(getResources().getColor(R.color.move));
//                    textview2.setTextColor(getResources().getColor(R.color.move));
//                    row.addView(textview2)
//
//                    row.addView(textview)
//                    table.addView(row)
//
//                }}
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//        })
//
//        val ProfileBtn: ImageView=findViewById<ImageView>(R.id.profBtn)
//        val notification: ImageView=findViewById<ImageView>(R.id.notifiBtn)
//        ProfileBtn.setOnClickListener {
//            val intent = Intent(this, Profile::class.java)
//
//            startActivity(intent)
//        }
//
//       notification.setOnClickListener {
//            val intent = Intent(this, Notification::class.java)
//            startActivity(intent)
//        }
//
//
//
//
//    }
//}


class mainPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        val table = findViewById<TableLayout>(R.id.tableLayout)
        val database = Firebase.database
        val myRef = database.getReference("esp8266")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                // This method is called once with the initial value and again
                //whenever data at this location is updated.
                //whenever data at this location is updated.
                // val count = snapshot.childrenCount
                // val firstRow = table.getChildAt(0)
                table.removeAllViews()

//                if (firstRow != null) {
//                    table.addView(firstRow)
//                }

                for (child in snapshot.children) {
                    val textview = TextView(this@mainPage)
                    val textview2 = TextView(this@mainPage)

                    val row = TableRow(this@mainPage)
                    row.layoutParams = TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT
                    )

                    textview2.layoutParams = TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                    )

                    textview.layoutParams = TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                    )

                    textview2.text = child.value.toString() // عرض الوزن على TextView
                    textview.text = child.key.toString()

                    textview2.setPadding(5, 20, 5, 20)
                    textview.setPadding(5, 20, 5, 20)
                    textview.gravity = Gravity.CENTER
                    textview2.gravity = Gravity.CENTER

                    table.setBackgroundColor(getResources().getColor(R.color.gray))

                    textview.setTextColor(getResources().getColor(R.color.move));
                    textview2.setTextColor(getResources().getColor(R.color.move));
                    row.addView(textview2)
                    row.addView(textview)
                    table.addView(row)

                    val weightText = textview2.text.toString()
                    val weightInGrams = convertToGrams(weightText) // تحويل الوزن إلى جرام

                    if (weightInGrams < 1000) {
                        // إذا كان الوزن أقل من كيلوجرام واحد
                        // sendMessage("Hello, ReceiverActivity!")
                    }
                    else{
                        // sendMessage("No")
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        val mn: ImageView = findViewById<ImageView>(R.id.prof)
        val notification: ImageView = findViewById<ImageView>(R.id.notifiBtn)
        val default:Button=findViewById<Button>(R.id.de)
        mn.setOnClickListener {
            val intent = Intent(this@mainPage, Profile::class.java)

            startActivity(intent)
        }


        notification.setOnClickListener {
            val intent = Intent(this@mainPage, Notification::class.java)
            startActivity(intent)
        }
        default.setOnClickListener {
            val intent = Intent(this@mainPage, Default::class.java)

            startActivity(intent)
        }
    }

    private fun sendMessage(message: String) {
        val intent = Intent(this, Notification::class.java)
        intent.putExtra("key_message", message)
        startActivity(intent)
    }

    // تحويل الوزن إلى جرام
    private fun convertToGrams(weight: String): Double {
        val parts = weight.split(" ")
        var totalGrams = 0.0

        if (parts.size > 1 && parts[1].toLowerCase() == "kg") {
            val kilograms = parts[0].toDoubleOrNull() ?: 0.0
            totalGrams += kilograms * 1000
        } else {
            totalGrams += weight.toDoubleOrNull() ?: 0.0
        }

        return totalGrams
    }
}

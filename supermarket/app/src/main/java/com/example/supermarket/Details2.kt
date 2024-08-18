package com.example.supermarket

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Details2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details2)
        val backButton:MaterialButton=findViewById<MaterialButton>(R.id.backptn)
        val table = findViewById<TableLayout>(R.id.tableLayout)
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("order")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                table.removeAllViews()

                for (child in snapshot.children) {
                    val textview = TextView(this@Details2)
                    val textview2 = TextView(this@Details2)

                    val row = TableRow(this@Details2)
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

                    textview2.text = child.value.toString() // Display value in TextView
                    textview.text = child.key.toString()   // Display key in TextView

                    textview2.setPadding(5, 20, 5, 20)
                    textview.setPadding(5, 20, 5, 20)
                    textview.gravity = Gravity.CENTER
                    textview2.gravity = Gravity.CENTER

                    textview.setTextColor(resources.getColor(R.color.move, null))
                    textview2.setTextColor(resources.getColor(R.color.move, null))
                    row.addView(textview2)
                    row.addView(textview)
                    table.addView(row)


                }


            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        backButton.setOnClickListener{
            val intent= Intent(this,Notification::class.java)
            startActivity(intent)
        }
    }
}

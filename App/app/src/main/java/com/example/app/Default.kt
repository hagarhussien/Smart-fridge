package com.example.app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class Default : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_default)
        var actualId=1

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.putString("Edit", "")
     //  val edit: EditText =findViewById<EditText>(R.id.editBtn)
        val edit:EditText=findViewById<EditText>(R.id.editBtn)
        val backButton: MaterialButton = findViewById<MaterialButton>(R.id.logptn)
        //val nextButton: MaterialButton = findViewById<MaterialButton>(R.id.nextptn)

        val tableLayout = findViewById<TableLayout>(R.id.table)
        for (i in 1..5) {
            val tableRow = TableRow(this)

            // Column 1
           val editText2 = EditText(this)
            editText2.id= View.generateViewId()
            if(i==1)
                actualId=editText2.id
            val getEmail: String?=sharedPreferences.getString("Edit","No")

            if(i==1)
                editText2.setText(getEmail)
            editText2.setPadding(8, 8, 8, 8)
            tableRow.addView(editText2)

            val textView1 = TextView(this)
            textView1.text = "         item $i"
            textView1.setPadding(8, 8, 8, 8)

            tableRow.addView(textView1)
            tableRow.setBackgroundColor(getResources().getColor(R.color.gray))
            textView1.setTextColor(getResources().getColor(R.color.move));
            editText2.setTextColor(getResources().getColor(R.color.move));
            // Column 2

            // Add the TableRow to the TableLayout
            tableLayout.addView(tableRow)
        }



        backButton.setOnClickListener {
            // تنفيذ العمليات عند النقر على زر العودة
            val intent = Intent(this, mainPage::class.java)
            startActivity(intent) // لإغلاق هذا النشاط والرجوع إلى النشاط السابق
        }

        val save: Button =findViewById<Button>(R.id.save)
      save.setOnClickListener{
           val editTxt=findViewById<EditText>(actualId)

            if(editTxt.text.toString().trim().length>0){
                val editor = sharedPreferences.edit()
                editor.putString("Edit", editTxt.text.toString())
                editor.apply()
        }}
//        val getEmail: String?=sharedPreferences.getString("Edit","No")
//
//        edit.setText(getEmail);
    }
}
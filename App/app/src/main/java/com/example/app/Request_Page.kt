//package com.example.app
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import androidx.appcompat.app.AppCompatActivity
//import com.google.android.material.button.MaterialButton
//
//
//class Request_Page : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_request_page)
//        val logptn: MaterialButton = findViewById(R.id.logptn)
//        val superMarketPhone: EditText = findViewById<EditText>(R.id.superptn)
//        val userEmail: EditText = findViewById<EditText>(R.id.userEmptn)
//
//        val userPhone: EditText = findViewById<EditText>(R.id.phoneNuptn)
//
//        val orderNum: EditText = findViewById<EditText>(R.id.orderNaptn)
//
//        val quantity: EditText = findViewById<EditText>(R.id.quantptn)
//        val submit: Button = findViewById<Button>(R.id.submitptn)
//
//        logptn.setOnClickListener() {
//            val intent = Intent(this, Notification::class.java);
//            startActivity(intent)
//
//        }
//
//               submit.setOnClickListener {
//            val superNumber = superMarketPhone.text.toString().trim()
//            if (superNumber.isEmpty()) {
//              superMarketPhone.error = "Please Enter The SuperMarket Phone"
//            } else {
//                // إرسال البيانات إذا كان اسم المستخدم غير فارغ
//            }
//
//
//           val userNumber = userPhone.text.toString().trim()
//           if (userNumber.isEmpty()) {
//              userPhone.error = "Please Enter The Your Phone Number"
//           } else {
//               // إرسال البيانات إذا كان اسم المستخدم غير فارغ
//           }
//
//
//
//           val userMail = userEmail.text.toString().trim()
//           if (userMail.isEmpty()) {
//            userEmail.error = "Please Enter The SuperMarket Phone"
//           } else {
//               // إرسال البيانات إذا كان اسم المستخدم غير فارغ
//           }
//
//
//
//           val Quantity = quantity.text.toString().trim()
//           if (Quantity.isEmpty()) {
//             quantity.error = "Please Enter The SuperMarket Phone"
//           } else {
//               // إرسال البيانات إذا كان اسم المستخدم غير فارغ
//           }
//
//
//
//           val orderNumber = orderNum.text.toString().trim()
//           if (orderNumber.isEmpty()) {
//            orderNum.error = "Please Enter The SuperMarket Phone"
//           } else {
//               // إرسال البيانات إذا كان اسم المستخدم غير فارغ
//           }
//
//
//
//
//       if( superNumber.isNotEmpty() and orderNumber.isNotEmpty() and userNumber.isNotEmpty() and  userMail.isNotEmpty() and Quantity.isNotEmpty()){
//            val intent = Intent(this, mainPage::class.java);
//            startActivity(intent)
//        }
//    }
//
//
//     /*   submit.setOnClickListener {
//            val superNumber = superMarketPhone.text.toString().trim()
//            val userNumber = userPhone.text.toString().trim()
//            val userMail = userEmail.text.toString().trim()
//            val Quantity = quantity.text.toString().trim()
//            val orderNumber = orderNum.text.toString().trim()
//
//            var valid = true
//
//            if (superNumber.isEmpty()) {
//                superMarketPhone.error = "Please Enter The SuperMarket Phone"
//                valid = false
//            }
//
//            if (userNumber.isEmpty()) {
//                userPhone.error = "Please Enter Your Phone Number"
//                valid = false
//            }
//
//            if (userMail.isEmpty()) {
//                userEmail.error = "Please Enter Your Email"
//                valid = false
//            }
//
//            if (Quantity.isEmpty()) {
//                quantity.error = "Please Enter The Quantity"
//                valid = false
//            }
//
//            if (orderNumber.isEmpty()) {
//                orderNum.error = "Please Enter The Order Number"
//                valid = false
//            }
//
//            if (valid) {
//                val intent = Intent()
//                intent.action = "com.example.otherapp.RECEIVE_DATA"
//                intent.putExtra("superMarketPhone", superNumber)
//                intent.putExtra("userEmail", userMail)
//                intent.putExtra("userPhone", userNumber)
//                intent.putExtra("orderNumber", orderNumber)
//                intent.putExtra("quantity", Quantity)
//                intent.type = "text/plain"
//
//                if (intent.resolveActivity(packageManager) != null) {
//                    startActivity(intent)
//                }
//            }
//        }*/
//    }
//}



package com.example.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class Request_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_request_page)
        val superMarketPhone: EditText = findViewById<EditText>(R.id.superptn)
        val userEmail: EditText = findViewById<EditText>(R.id.userEmptn)
        val userPhone: EditText = findViewById<EditText>(R.id.phoneNuptn)
        val orderNum: EditText = findViewById<EditText>(R.id.orderNaptn)
        val quantity: EditText = findViewById<EditText>(R.id.quantptn)
        val submit: Button = findViewById<Button>(R.id.submitptn)
        val logptn: MaterialButton = findViewById(R.id.logptn)

        logptn.setOnClickListener {
            val intent = Intent(this, Notification::class.java)
            startActivity(intent)
        }

        submit.setOnClickListener {
            val superNumber = superMarketPhone.text.toString().trim()
            val userNumber = userPhone.text.toString().trim()
            val userMail = userEmail.text.toString().trim()
            val orderNumber = orderNum.text.toString().trim()
            val Quantity = quantity.text.toString().trim()
            Log.d("Request_Page", "superNumber: $superNumber")
            Log.d("Request_Page", "userNumber: $userNumber")
            Log.d("Request_Page", "userMail: $userMail")
            Log.d("Request_Page", "orderNumber: $orderNumber")
            Log.d("Request_Page", "quantityText: $quantity")

            var valid = true

            if (superNumber.isEmpty()) {
                superMarketPhone.error = "Please Enter The SuperMarket Phone"
                valid = false
            }
            if (userNumber.isEmpty()) {
                userPhone.error = "Please Enter Your Phone Number"
                valid = false
            }
            if (userMail.isEmpty()) {
                userEmail.error = "Please Enter Your Email"
                valid = false
            }
            if (Quantity.isEmpty()) {
                quantity.error = "Please Enter The Quantity"
                valid = false
            }
            if (orderNumber.isEmpty()) {
                orderNum.error = "Please Enter The Order Number"
                valid = false
            }

            if (valid) {
                val intent = Intent().apply {
                    action = "com.example.RECEIVE_DATA"
                    putExtra("superMarketPhone", superNumber)
                    putExtra("userEmail", userMail)
                    putExtra("userPhone", userNumber)
                    putExtra("orderNumber", orderNumber)
                    putExtra("quantity", Quantity)
                    Log.d("mytag2",superNumber)
                }
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
        }
    }
}

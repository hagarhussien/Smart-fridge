package com.example.app


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class MakeSelection : AppCompatActivity() {
    private var otpEt1: EditText? = null
    private var otpEt2: EditText? = null
    private var otpEt3: EditText? = null
    private var otpEt4: EditText? = null
    private var otpEt5: EditText? = null
    private var otpEt6: EditText? = null

    private var resendBtn: TextView? = null

    //true after every 60 second
    private var resendEnabled = false

    //resend time in seconds
    private var resendTime: Int = 60;

    private var selectedEtPosition: Int = 0;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_selection)

        otpEt1 = findViewById(R.id.otpET1);
        otpEt2 = findViewById(R.id.otpET2);
        otpEt3 = findViewById(R.id.otpET3);
        otpEt4 = findViewById(R.id.otpET4);
        otpEt5 = findViewById(R.id.otpET5);
        otpEt6 = findViewById(R.id.otpET6);

        resendBtn = findViewById(R.id.resendBtn);

        val verifyBtn: AppCompatButton = findViewById<AppCompatButton>(R.id.verifyBtn)

        val otpEmail: TextView = findViewById<TextView>(R.id.otpEmail)
        val otpMobile: TextView = findViewById<TextView>(R.id.otpMobile)

        //getting email and mobile from Register activity through intent
//        val getEmail: String? = getIntent().getStringExtra("email")
//        val getMobile: String? = getIntent().getStringExtra("mobile")
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val getEmail: String?=sharedPreferences.getString("Email","No")
        val getMobile: String?=sharedPreferences.getString("Phone","0125")
        //setting email and mobile to TextView
        otpEmail.setText(getEmail);
        otpMobile.setText(getMobile);

        (otpEt1 as EditText).addTextChangedListener(textWatcher)
        (otpEt2 as EditText).addTextChangedListener(textWatcher)
        (otpEt3 as EditText).addTextChangedListener(textWatcher)
        (otpEt4 as EditText).addTextChangedListener(textWatcher)
        (otpEt5 as EditText).addTextChangedListener(textWatcher)
        (otpEt6 as EditText).addTextChangedListener(textWatcher)


        verifyBtn.setOnClickListener()
        {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        //by default open keyboard at otpEt1
        showKeyboard(otpEt1 as EditText)

//start Resend count down timer
        startCountDownTimer();

        resendBtn?.setOnClickListener {
            if (resendEnabled) {
                //handle your resend code here
                //start new resend count down timer
                startCountDownTimer()
            }
        }

        verifyBtn.setOnClickListener {
            val generatOtp: String? =
                otpEt1?.getText().toString() + otpEt2?.getText().toString() + otpEt3?.getText()
                    .toString() + otpEt4?.getText().toString()+ otpEt5?.getText().toString()+ otpEt6?.getText().toString();
            if (generatOtp?.length == 6) {
                // الشفرة هنا للقيام بما تريد عندما يكون طول generatOtp هو 4
                //handle your otp verification here
                val intent = Intent(this,New_Password::class.java)
                startActivity(intent)
            }

        }


    }

    private fun showKeyboard(otpEt: EditText) {
        otpEt.requestFocus() // تأكد من طلب التركيز على otpEt1 بدلاً من otpEt
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(
            otpEt,
            InputMethodManager.SHOW_IMPLICIT
        ) // لعرض لوحة المفاتيح
    }

    private fun startCountDownTimer() {
        resendEnabled = false
        resendBtn?.setTextColor(Color.parseColor("#99000000"))
        object : CountDownTimer((resendTime * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // تنفيذ السلوك المطلوب عند كل تحديث للعداد
                resendBtn?.setText("Resend code(" + (millisUntilFinished / 1000) + ")");
            }

            override fun onFinish() {
                // تنفيذ السلوك المطلوب عند الانتهاء من العد التنازلي
                resendEnabled = true;
                resendBtn?.setText("Resend Code");
                resendBtn?.setTextColor(getResources().getColor(R.color.primary));
            }
        }.start()
    }


    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // يمكنك إضافة السلوك الذي تحتاجه هنا
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // يمكنك إضافة السلوك الذي تحتاجه هنا
        }

//        override fun afterTextChanged(s: Editable?) {
//            // يمكنك إضافة السلوك الذي تحتاجه هنا
//            if (s?.length ?: 0 > 0) {
//                // إجراءات عندما يكون طول النص أكبر من صفر
//                if (selectedEtPosition == 0) {
//                    selectedEtPosition = 1
//                    otpEt2?.let { showKeyboard(it) }
//
//                } else if (selectedEtPosition == 1) {
//                    selectedEtPosition = 2
//                    otpEt3?.let { showKeyboard(it) }
//                } else if (selectedEtPosition == 2) {
//                    selectedEtPosition = 3
//                    otpEt4?.let { showKeyboard(it) }
//                }} else if (selectedEtPosition == 3) {
//                    selectedEtPosition = 4
//                    otpEt5?.let { showKeyboard(it) }
//                } else if (selectedEtPosition == 4) {
//                    selectedEtPosition = 5
//                    otpEt6?.let { showKeyboard(it)
//                }
//
//            }
//
//        }
override fun afterTextChanged(s: Editable?) {
    s?.let {
        if (it.length == 1) {
            // Perform actions when the text length is exactly 1
            when (selectedEtPosition) {
                0 -> {
                    selectedEtPosition = 1
                    otpEt2?.let { showKeyboard(it) }
                }
                1 -> {
                    selectedEtPosition = 2
                    otpEt3?.let { showKeyboard(it) }
                }
                2 -> {
                    selectedEtPosition = 3
                    otpEt4?.let { showKeyboard(it) }
                }
                3 -> {
                    selectedEtPosition = 4
                    otpEt5?.let { showKeyboard(it) }
                }
                4 -> {
                    selectedEtPosition = 5
                    otpEt6?.let { showKeyboard(it) }
                }
                // Add more cases if needed
                else -> {}
            }
        } else if (it.length == 0) {
            // Perform actions when the text length is 0 (e.g., backspace pressed)
            when (selectedEtPosition) {
                1 -> {
                    selectedEtPosition = 0
                    otpEt1?.let { showKeyboard(it) }
                }
                2 -> {
                    selectedEtPosition = 1
                    otpEt2?.let { showKeyboard(it) }
                }
                3 -> {
                    selectedEtPosition = 2
                    otpEt3?.let { showKeyboard(it) }
                }
                4 -> {
                    selectedEtPosition = 3
                    otpEt4?.let { showKeyboard(it) }
                }
                5 -> {
                    selectedEtPosition = 4
                    otpEt5?.let { showKeyboard(it) }
                }
                // Add more cases if needed
                else -> {}
            }
        } else {

        }
    }
}

    };

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_DEL) {
            when (selectedEtPosition) {
                5-> {
                    selectedEtPosition = 4
                    otpEt5?.let { showKeyboard(it) }
                } 4 -> {
                    selectedEtPosition = 3
                    otpEt4?.let { showKeyboard(it) }
                } 3 -> {
                    selectedEtPosition = 2
                    otpEt3?.let { showKeyboard(it) }
                }

                2 -> {
                    selectedEtPosition = 1
                    otpEt2?.let { showKeyboard(it) }
                }

                1 -> {
                    selectedEtPosition = 0
                    otpEt1?.let { showKeyboard(it) }
                }
            }
            return true
        } else {
            return super.onKeyUp(keyCode, event)
        }


    }


}



package com.example.grade

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var etccs1030: EditText
    private lateinit var etccs3040: EditText
    private lateinit var etccs3060: EditText
    private lateinit var etccs3080: EditText
    private lateinit var etccs4050: EditText

    private lateinit var tvGradeCcs1030: TextView
    private lateinit var tvGradeCcs3040: TextView
    private lateinit var tvGradeCcs3060: TextView
    private lateinit var tvGradeCcs3080: TextView
    private lateinit var tvGradeCcs4050: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etccs1030 = findViewById(R.id.etccs1030)
        etccs3040 = findViewById(R.id.etccs3040)
        etccs3060 = findViewById(R.id.etccs3060)
        etccs3080 = findViewById(R.id.etccs3080)
        etccs4050 = findViewById(R.id.etccs4050)

        tvGradeCcs1030 = findViewById(R.id.tvGradeCcs1030)
        tvGradeCcs3040 = findViewById(R.id.tvGradeCcs3040)
        tvGradeCcs3060 = findViewById(R.id.tvGradeCcs3060)
        tvGradeCcs3080 = findViewById(R.id.tvGradeCcs3080)
        tvGradeCcs4050 = findViewById(R.id.tvGradeCcs4050)

        etccs1030.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG, "afterTextChanged $s")
                computeGrade()
            }
        })
        etccs3040.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG, "afterTextChanged $s")
                computeGrade()
            }
        })
        etccs3060.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG, "afterTextChanged $s")
                computeGrade()
            }
        })
        etccs3080.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG, "afterTextChanged $s")
                computeGrade()
            }
        })
        etccs4050.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG, "afterTextChanged $s")
                computeGrade()
            }
        })

    }
    private fun computeGrade() {
        // get the grade values... use toIntorNull which safely returns null if the string is not
        // a valid number
        // the elvis operator ?: will then providea default value of 0
        val ccs1030 = etccs1030.text.toString().toIntOrNull() ?: 0
        val ccs3040 = etccs3040.text.toString().toIntOrNull() ?: 0
        val ccs3060 = etccs3060.text.toString().toIntOrNull() ?: 0
        val ccs3080 = etccs3080.text.toString().toIntOrNull() ?: 0
        val ccs4050 = etccs4050.text.toString().toIntOrNull() ?: 0

        // pair the grade and its corresponding textView
        val gradeViews = listOf(
            ccs1030 to tvGradeCcs1030,
            ccs3040 to tvGradeCcs3040,
            ccs3060 to tvGradeCcs3060,
            ccs3080 to tvGradeCcs3080,
            ccs4050 to tvGradeCcs4050
        )

        for ((grade, textView) in gradeViews) {
            val gradeLabel = when (grade) {
                in 0..39 -> "F"
                in 40..49 -> "D"
                in 50..59 -> "C"
                in 60..69 -> "B"
                in 70..100 -> "A"
                else -> "Invalid"
            }
            textView.text = gradeLabel
        }
    }
}
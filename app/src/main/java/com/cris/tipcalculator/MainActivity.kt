package com.cris.tipcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private val currencyFormat = NumberFormat.getCurrencyInstance()
    private val percentFormat = NumberFormat.getPercentInstance()

    private var billAmount = 0.0
    private var percent = 0.15
    private var amountTextView: TextView? = null
    private var percentTextView: TextView? = null
    private var tipTextView: TextView? = null
    private var totalTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}

package com.cris.tipcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity(), TextWatcher, SeekBar.OnSeekBarChangeListener {

    private val currencyFormat = NumberFormat.getCurrencyInstance()
    private val percentFormat = NumberFormat.getPercentInstance()

    private var billAmount = 0.0
    private var percent = 0.15
    //private var tip = 0.0
    //private var total = 0.0
    private var amountTextView: TextView? = null
    private var percentTextView: TextView? = null
    private var tipTextView: TextView? = null
    private var totalTextView: TextView? = null
    //private var amountEditText: EditText? = null
    //private var percentSeekBar: SeekBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        amountTextView = findViewById(R.id.amountTextView)
        percentTextView = findViewById(R.id.percentTextView)
        tipTextView = findViewById(R.id.tipTextView)
        totalTextView = findViewById(R.id.totalTextView)
        //amountEditText = findViewById(R.id.amountEditText)
        //percentTextView = findViewById(R.id.percentTextView)
        tipTextView?.text = currencyFormat.format(0)
        totalTextView?.text = currencyFormat.format(0)

        val amountEditText : EditText = findViewById(R.id.amountEditText)
        amountEditText.addTextChangedListener(this)
        val percentSeekBar : SeekBar = findViewById(R.id.percentSeekBar)
        percentSeekBar.setOnSeekBarChangeListener(this)

    }
    private fun calculate(){
        percentTextView?.text = percentFormat.format(percent)
        var tip: Double = billAmount * percent
        var total: Double = billAmount + tip

        tipTextView?.text = currencyFormat.format(tip)
        totalTextView?.text = currencyFormat.format(total)
    }
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        try{
            billAmount = java.lang.Double.parseDouble(s.toString())/100.0
            amountTextView?.text = currencyFormat.format(billAmount)
        }
        catch(e: NumberFormatException){
            amountTextView?.text = ""
            billAmount = 0.0
        }
        calculate()
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        percent = progress/100.0
        calculate()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }
}

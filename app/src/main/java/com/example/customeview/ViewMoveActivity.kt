package com.example.customeview

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ViewMoveActivity : AppCompatActivity() ,View.OnTouchListener{
    private var mainLayout: ViewGroup? = null
    private lateinit var custom: MyCustom
    private lateinit var button:Button
    private var _xDelta = 0
    private var _yDelta = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_move)
        mainLayout = findViewById(R.id.constraintLayoutID)
        custom = findViewById(R.id.customCircleID)
        button=findViewById(R.id.buttonID)
        custom.setOnTouchListener(this)
        button.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        val X = event!!.rawX.toInt()
        val Y = event.rawY.toInt()
        when (event.action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_DOWN -> {
                val lParams = v!!.layoutParams as RelativeLayout.LayoutParams
                _xDelta = X - lParams.leftMargin
                _yDelta = Y - lParams.topMargin
            }
            MotionEvent.ACTION_UP -> {
                Toast.makeText(this,
                    "I'm here!", Toast.LENGTH_SHORT)
                    .show();
            }
            MotionEvent.ACTION_POINTER_DOWN -> {
            }
            MotionEvent.ACTION_POINTER_UP -> {
            }
            MotionEvent.ACTION_MOVE -> {
                val layoutParams = v!!.layoutParams as RelativeLayout.LayoutParams
                layoutParams.leftMargin = X - _xDelta
                layoutParams.topMargin = Y - _yDelta
                layoutParams.rightMargin = 0
                layoutParams.bottomMargin = 0
                v.layoutParams = layoutParams
            }
        }
        mainLayout!!.invalidate()
        return true
    }
}
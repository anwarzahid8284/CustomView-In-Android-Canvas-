package com.example.customeview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class CustomView(context: Context): View(context) {
    val paint:Paint
    var circleX:Float
    var circleY:Float
    init {
        paint= Paint()
        paint.isFilterBitmap=true
        paint.isAntiAlias=true
        paint.color= Color.BLUE
        circleX=100f
        circleY=100f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawCircle(circleX,circleY,70f,paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        circleX=event!!.rawX
        circleY= event.rawY
        invalidate()
        return true
    }
}
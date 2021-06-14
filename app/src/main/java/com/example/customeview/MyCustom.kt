package com.example.customeview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyCustom(context: Context,attributes: AttributeSet):View(context,attributes) {
    private val paint: Paint = Paint()
    var circleX:Float
    var circleY:Float
    init {
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
}
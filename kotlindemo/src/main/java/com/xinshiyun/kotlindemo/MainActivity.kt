package com.xinshiyun.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTest.text = "kotlin扩展方法"
        btnTest.text = btnTest.autoAddStr()

        btnTest.setOnClickListener(View.OnClickListener {  })

        val width = 20f.dp
        Log.e("width","width = $width")
    }

    fun TextView.autoAddStr():String{
        return "${this.text}[试用版]"
    }
}
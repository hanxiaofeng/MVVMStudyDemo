package com.xinshiyun.mvvmstudydemo

import android.util.Log
import android.view.View
import android.widget.Toast

interface BtnClickListener {

    fun onClick(view:View)

    fun show()= println("------调用了show方法")
}
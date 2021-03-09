package com.xinshiyun.mvvmstudydemo

import android.util.Log
import android.view.View

class CommonListener: BtnClickListener {
    override fun onClick(view: View) {

    }

    override fun show(){
        super.show()
        println("  --- 接口实现类： 调用了show方法show")
    }
}


fun main() {
    val commonListener = CommonListener()
    commonListener.show()
}

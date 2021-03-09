package com.xinshiyun.mvvmblog

import android.util.Log
import android.view.View
import androidx.databinding.BindingConversion
import androidx.lifecycle.ViewModel

class MyMainModel : ViewModel() {


    var userName = "张三"

    var paddingLeft = 10

    val clickMe = View.OnClickListener {
        Log.e("click", "click me -- 变量")
    }

    fun clickMe(){
        Log.e("click","click me -- 方法")
    }

    fun click(view: View){
        Log.e("click","click me: $view, 使用::调用，需要与接口参数一致")
    }
}
package com.xinshiyun.mvvmstudydemo.ui.main

import android.util.Log
import android.view.View
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(var fragmentName:String) : ViewModel() {

    constructor():this("myFragment"){

    }

    var address = MutableLiveData<String>()


    val onMyClick = View.OnClickListener {
        Log.e("FragmentViewModel", "commonLog - onClick: 变量")
    }

    fun onClick(v: View) {
        Log.e("FragmentViewModel", "commonLog - onClick: 方法")
    }

    fun onNoParamClick() {
        Log.e("FragmentViewModel", "commonLog - onClick: 没有参数，或者有参数也行，但是 xml 中也必须给它传对应的值")
    }

    /*fun show(): MutableLiveData<String>? {
        return MutableLiveData("${fragmentName.value},哈哈哈")
    }*/

}
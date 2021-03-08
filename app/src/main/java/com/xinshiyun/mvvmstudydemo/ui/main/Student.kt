package com.xinshiyun.mvvmstudydemo.ui.main

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.xinshiyun.mvvmstudydemo.BR

class Student : BaseObservable() {

    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR._all)
        }

    var age: Int = 0
        set(value) {
            field = value
            notifyChange()
        }

    fun changeName2(newName:String){
        name = newName
    }
}
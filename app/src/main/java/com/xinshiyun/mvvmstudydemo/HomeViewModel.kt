package com.xinshiyun.mvvmstudydemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class HomeViewModel : ViewModel() {

    var name: String = "name"

    private val userName = MutableLiveData<String>()

    private var userNameList: MutableLiveData<List<String>>? = null

    fun getCurrentName(): MutableLiveData<String> {
        return userName
    }

    fun getUserNameList(): MutableLiveData<List<String>> {

        if (userNameList == null) {
            userNameList = MutableLiveData<List<String>>()
//            val listName: List<String> = listOf("张三", "李四", "王五")
//            userNameList!!.value = listName
        }

        return userNameList as MutableLiveData<List<String>>
    }
}
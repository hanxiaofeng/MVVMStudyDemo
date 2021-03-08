package com.xinshiyun.focusdemo.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class HomeViewModel : ViewModel() {

    var titleList = MutableLiveData<ArrayList<TitleModel>>()

}
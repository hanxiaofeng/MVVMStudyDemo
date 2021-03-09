package com.xinshiyun.mvvmstudydemo.model

import androidx.databinding.BaseObservable
import com.xinshiyun.mvvmstudydemo.R
import com.xinshiyun.mvvmstudydemo.inner.IBaseBindingAdapterItem


data class TextItem(val name: String) : IBaseBindingAdapterItem {
    override fun getItemViewType(): Int {
        return R.layout.item_text
    }
}

data class FruitItem(var url: String, val name: String) : IBaseBindingAdapterItem ,
    BaseObservable() {

    override fun getItemViewType(): Int {
        return R.layout.item_fruit
    }
}
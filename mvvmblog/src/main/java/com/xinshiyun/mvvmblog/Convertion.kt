package com.xinshiyun.mvvmblog

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods


object ConvertionTest {

    @JvmStatic
    @BindingConversion
    fun convert(value: String?) = "${value}(试用版)"


    @JvmStatic
    @BindingAdapter("android:paddingLeft")
    fun setPaddingLeft(view: View, oldPadding: Int, newPadding: Int) {
        Log.e("padding", "oldPadding = $oldPadding, newPadding = $newPadding")
    }


    @JvmStatic
    @BindingAdapter("android:myText")
    fun myText(view: View, oldText: String, newText: String) {
        Log.e("mytext", "oldText = $oldText, newText = $newText")
        if (view is MyTextView) {
            view.text = newText
        }
    }



}
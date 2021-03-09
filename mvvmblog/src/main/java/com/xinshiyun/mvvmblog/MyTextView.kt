package com.xinshiyun.mvvmblog

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods

@BindingMethods(
    value = [
        BindingMethod(
            type = TextView::class,
            attribute = "showToast",
            method = "show"
        )]
)
class MyTextView(context: Context?, attrs: AttributeSet?) :
    AppCompatTextView(context!!, attrs) {

    fun show(toastStr: String) {
        Toast.makeText(context, "哈哈哈,$toastStr", Toast.LENGTH_LONG).show()
    }
}

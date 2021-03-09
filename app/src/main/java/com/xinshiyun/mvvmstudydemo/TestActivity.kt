package com.xinshiyun.mvvmstudydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    @VMScope("home")
    private lateinit var model: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        injectViewModel()

//        model = ViewModelProvider(this).get("home",HomeViewModel::class.java)
        Log.e("mvvm", "test model = $model")


        tv_btn.setOnClickListener {

            /**
             * 在此处修改livedata的值，main不会更新，应为处于noactive状态，返回到Main后，数据更新刷新页面
             */

            model.getCurrentName().value = "当前的值改变了,哈哈，我在test！"

            val listName: List<String> = listOf("张三2", "李四2", "王五2")
            model.getUserNameList().value = listName
        }
    }
}
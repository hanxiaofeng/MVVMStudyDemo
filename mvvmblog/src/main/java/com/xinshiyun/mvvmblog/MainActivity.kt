package com.xinshiyun.mvvmblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.xinshiyun.mvvmblog.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var myMainModel: MyMainModel

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        myMainModel = ViewModelProvider(this).get(MyMainModel::class.java)
        activityMainBinding.viewModel = myMainModel

        initView()
    }

    private fun initView() {

        findViewById<Button>(R.id.btnChange).setOnClickListener {

            myMainModel.userName = "我是改变后的值：李四"
            myMainModel.paddingLeft = 20
            activityMainBinding.viewModel = myMainModel
        }

        editText.addTextChangedListener {
            Log.e("userName","new userName = ${activityMainBinding.viewModel!!.userName}")

//            activityMainBinding.viewModel = myMainModel
        }
    }
}
package com.xinshiyun.mvvmblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.xinshiyun.mvvmblog.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    private lateinit var myMainModel: MyMainModel

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.lifecycleOwner = this
        myMainModel = ViewModelProvider(this).get(MyMainModel::class.java)
        activityMainBinding.viewModel = myMainModel

        myMainModel.studentLiveData.observe(this, Observer {
            //数据有更新/变化
//            myMainModel.userName = it.name
//            activityMainBinding.viewModel = myMainModel
        })

        initView()

    }

    private fun loadData() {

        launch {
            withContext(Dispatchers.IO) {
                delay(2000)
            }

            val student = Student("我是新来的学生")
            myMainModel.studentLiveData.postValue(student)
        }
    }

    private fun initView() {

        findViewById<Button>(R.id.btnChange).setOnClickListener {

            loadData()

//            myMainModel.userName = "我是改变后的值：李四"
//            myMainModel.paddingLeft = 20
//            activityMainBinding.viewModel = myMainModel
        }

        editText.addTextChangedListener {
            Log.e("userName", "new userName = ${activityMainBinding.viewModel!!.userName}")

//            activityMainBinding.viewModel = myMainModel
        }
    }
}
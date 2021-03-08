package com.xinshiyun.mvvmstudydemo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.xinshiyun.mvvmstudydemo.databinding.MainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() ,CoroutineScope by MainScope() {

    @VMScope("home")
    private lateinit var model: HomeViewModel


    private lateinit var activityMainBinding: MainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectViewModel()

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        model = ViewModelProvider(this).get(HomeViewModel::class.java)

        Log.e("mvvm", "main model = $model")

        val nameObserver = Observer<String> { newName ->
            findViewById<TextView>(R.id.tvName).text = newName
        }

        tvName.setTextColor(Color.RED)

        model.getCurrentName().observe(this, nameObserver)

        model.getUserNameList().observe(this, Observer {
            for (name in it) {
                Log.e("mvvm", "name = $name")
            }
        })

        findViewById<Button>(R.id.btn_start).setOnClickListener {
            model.getCurrentName().value = "当前的值改变了"

            val listName: List<String> = listOf("张三1", "李四1", "王五1")
            model.getUserNameList().value = listName

            model.name = "change name value"
            activityMainBinding.vm = model


            activityMainBinding.tvName.text = "我是新得值"
        }

        btn_jump.setOnClickListener {
//            activityMainBinding.tvName.text = "我是新得值"
            startActivity(Intent(this@MainActivity, FragmentActivity::class.java))
        }

        btnJumpRecycler.setOnClickListener {
            startActivity(Intent(this@MainActivity, RecyclerActivity::class.java))
        }

        testCoroutine();

        launch {
            Log.e("launch","--------------start,thread:${Thread.currentThread().name}")
            withContext(Dispatchers.IO){
                Log.e("launch","--------------delay start,thread:${Thread.currentThread().name}")
                delay(3000)
                Log.e("launch","--------------delay end,thread:${Thread.currentThread().name}")
            }
            Log.e("launch","--------------3s之后,thread:${Thread.currentThread().name}")
        }
    }

    private fun testCoroutine() {

        val coroutineTest = CoroutineTest(CoroutineScope(Dispatchers.Main).coroutineContext)
        coroutineTest.test2()
    }
}
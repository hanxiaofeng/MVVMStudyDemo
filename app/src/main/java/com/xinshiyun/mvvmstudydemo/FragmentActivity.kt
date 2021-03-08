package com.xinshiyun.mvvmstudydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xinshiyun.mvvmstudydemo.ui.main.MyFragment

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MyFragment.newInstance())
                .commitNow()
        }
    }
}
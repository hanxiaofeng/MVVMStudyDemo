package com.xinshiyun.mvvmstudydemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.xinshiyun.mvvmstudydemo.BR
import com.xinshiyun.mvvmstudydemo.R
import com.xinshiyun.mvvmstudydemo.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.*

class MyFragment : Fragment() {

    companion object {
        fun newInstance() = MyFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var fragmentBinding: MainFragmentBinding

    private lateinit var student: Student

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        return fragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        student = Student()

        fragmentBinding.student = student
        fragmentBinding.listener = Listener()

        fragmentBinding.setVariable(BR.fragmentVModel,viewModel)

        viewModel.address.observe(viewLifecycleOwner, Observer {

            fragmentBinding.fragmentVModel = viewModel

        })

        tv_start.setOnClickListener {

//            viewModel.fragmentName = "我是新值啊"
            viewModel.address.postValue("我是新地址address啊")
        }
    }

    inner class Listener{

        fun changeName(){
            student.name = "可可"
        }

        fun changeAllInfo(){
            student.changeName2("--------------可可")
            student.age +=1
        }

    }

}
package com.xinshiyun.mvvmstudydemo.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.xinshiyun.mvvmstudydemo.BR
import com.xinshiyun.mvvmstudydemo.inner.IBaseBindingAdapterItem


abstract class BaseBindRecyclerViewAdapter<T>(
    context: Context,
    //数据源
    var mList: List<T>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return onCreateMyViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindMyViewHolder(holder, position)
    }

    //获取Item布局
    abstract fun onCreateMyViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    //绑定数据
    abstract fun onBindMyViewHolder(holder: RecyclerView.ViewHolder?, position: Int)

}


/**
 * @param binding 可以看作是这个holder代表的布局的马甲，getRoot()方法会返回整个holder的最顶层的view
 */
class BaseBindingViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    /**
     * 绑定数据
     *
     * @param item
     */
    fun bindData(item: IBaseBindingAdapterItem?) {
        binding.setVariable(BR.item, item)
    }

}
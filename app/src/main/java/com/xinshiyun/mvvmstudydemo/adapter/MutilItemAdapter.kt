package com.xinshiyun.mvvmstudydemo.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.xinshiyun.mvvmstudydemo.R
import com.xinshiyun.mvvmstudydemo.base.BaseBindRecyclerViewAdapter
import com.xinshiyun.mvvmstudydemo.databinding.ItemFruitBinding
import com.xinshiyun.mvvmstudydemo.databinding.ItemTextBinding
import com.xinshiyun.mvvmstudydemo.inner.IBaseBindingAdapterItem
import com.xinshiyun.mvvmstudydemo.model.FruitItem
import com.xinshiyun.mvvmstudydemo.model.TextItem
import org.w3c.dom.Text

class MutilItemAdapter(
    private val context: Context,
    private val list: MutableList<IBaseBindingAdapterItem>
) : BaseBindRecyclerViewAdapter<IBaseBindingAdapterItem>(context, list) {

    override fun getItemViewType(position: Int): Int {
        return list[position].getItemViewType()
    }

    override fun onCreateMyViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            R.layout.item_fruit -> {
                val itemFruitBinding =
                    DataBindingUtil.inflate<ItemFruitBinding>(
                        inflater,
                        R.layout.item_fruit,
                        parent,
                        false
                    )
                return FruitViewHolder(itemFruitBinding)
            }

            R.layout.item_text -> {
                val itemTextBinding =
                    DataBindingUtil.inflate<ItemTextBinding>(
                        inflater,
                        R.layout.item_text,
                        parent,
                        false
                    )
                return TextViewHolder(itemTextBinding)
            }

            else -> {
                val itemTextBinding =
                    DataBindingUtil.inflate<ItemTextBinding>(
                        inflater,
                        R.layout.item_text,
                        parent,
                        false
                    )
                return TextViewHolder(itemTextBinding)
            }
        }
    }

    override fun onBindMyViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        if (holder is FruitViewHolder) {
            val fruitBean = mList[position] as FruitItem
            (holder as FruitViewHolder).getBinding().fruit = fruitBean
            (holder as FruitViewHolder).getBinding().executePendingBindings()
        } else if (holder is TextViewHolder) {
            val textBean = mList[position] as TextItem
            (holder as TextViewHolder).getBinding().item = textBean
            (holder as TextViewHolder).getBinding().executePendingBindings()
        }
    }


    internal class FruitViewHolder(private val binding: ItemFruitBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun getBinding(): ItemFruitBinding {
            return binding
        }

    }

    internal class TextViewHolder(private val binding: ItemTextBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun getBinding(): ItemTextBinding {
            return binding
        }
    }

}
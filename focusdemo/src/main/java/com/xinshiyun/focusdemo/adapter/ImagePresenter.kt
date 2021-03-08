package com.xinshiyun.focusdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import com.xinshiyun.focusdemo.R
import com.xinshiyun.focusdemo.model.ImageModel
import com.xinshiyun.focusdemo.model.TitleModel

class ImagePresenter(private val context: Context) : Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val view: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.item_image, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder?, item: Any?) {
        if (item is ImageModel) {
            Glide.with(context)
                .load(item.url)
                .centerCrop()
                .into((viewHolder as ViewHolder).ivImage)
        }
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder?) {

    }


    inner class ViewHolder(view: View?) : Presenter.ViewHolder(view) {
        var ivImage: ImageView = view!!.findViewById<ImageView>(R.id.iv_image)

    }
}
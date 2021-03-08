package com.xinshiyun.focusdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.leanback.widget.Presenter
import com.xinshiyun.focusdemo.R
import com.xinshiyun.focusdemo.model.TitleModel

class TitlePresenter : Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val view: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.item_main_title, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder?, item: Any?) {
        if (item is TitleModel) {
            (viewHolder as ViewHolder).mainTitle.text = item.name
        }
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder?) {

    }


    inner class ViewHolder(view: View?) : Presenter.ViewHolder(view) {
        var mainTitle: TextView = view!!.findViewById<TextView>(R.id.tv_main_title)

    }
}
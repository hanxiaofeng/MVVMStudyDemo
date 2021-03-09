package com.xinshiyun.mvvmstudydemo.attr

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.xinshiyun.mvvmstudydemo.R


object ImageAttrAdapter {

    @JvmStatic
    @BindingAdapter("android:src")
    fun setSrc(view: ImageView, imageId: Int) {
        view.setImageResource(imageId)
    }

    /**
     * 1.加载图片,无需手动调用此方法
     * 2.使用@BindingAdapter注解设置自定义属性的名称，imageUrl就是属性的名称，
     * 当ImageView中使用imageUrl属性时，会自动调用loadImage方法，
     *
     * @param imageView ImageView
     * @param url       图片地址
     */
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, url: String?) {

        val options = RequestOptions()
            .placeholder(R.drawable.apple)
            .error(R.mipmap.apple)
            .priority(Priority.HIGH)
            .diskCacheStrategy(DiskCacheStrategy.NONE)

        Glide.with(imageView.context).load(url)
            .apply(options)
            .into(imageView)
    }


}
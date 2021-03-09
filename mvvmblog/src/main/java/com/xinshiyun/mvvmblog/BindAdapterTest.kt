package com.xinshiyun.mvvmblog

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class ImageLoader {

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl", "placeholder", "error",requireAll = false)
        fun loadImageView(
            imageView: ImageView,
            url: String?,
            drawHolder: Drawable?,
            error: Drawable?
        ) {
            Glide.with(imageView).load(url).into(imageView)
        }
    }


}
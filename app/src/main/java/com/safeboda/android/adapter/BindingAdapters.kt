package com.safeboda.android.adapter

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("loadAvatar")
    fun loadAvatar(imageView: ShapeableImageView, url: String?){

        url?.let {
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }
}
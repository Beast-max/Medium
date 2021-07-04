package com.example.conduit.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.loadImage(uri:String,crop:Boolean = false){
    if(crop) {
        Glide.with(this).load(uri).circleCrop().into(this)
    }
    else
    {
        Glide.with(this).load(uri).into(this)
    }

}
package com.kuzyava.vkmobiledonations.binding

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("bindImage")
fun bindLoadImage(view: ImageView, uri: Uri) {
    view.setImageURI(uri)
}

@BindingAdapter("bindHeading")
fun bindHeading(view: TextView, text: String) {
    view.text = text.split(" ")[0]
}

@BindingAdapter("bindInfoA", "bindInfoD")
fun bindInfo(view: TextView, author: String, date: String) {
    view.text = "$author • Закончится $date"
}
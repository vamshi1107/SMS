package com.project.sms

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

open class smsViewHolder : RecyclerView.ViewHolder {
    var text: TextView
    constructor(view:View) : super(view) {
       text =view.findViewById(R.id.text)
    }

}
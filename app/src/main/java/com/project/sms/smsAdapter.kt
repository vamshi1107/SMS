package com.project.sms

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class smsAdapter(
    var context: Context,
    var list: ArrayList<SMS>,
    var sheet: BottomSheetBehavior<LinearLayout>,
    var msgcon:TextView
) : RecyclerView.Adapter<smsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): smsViewHolder {
        var v: View= LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        var viewHolder = smsViewHolder(v)
        return viewHolder
    }

    override fun onBindViewHolder(holder: smsViewHolder, position: Int) {
        holder.text.text=list.get(position).rs
        if(list.get(position).add){
            holder.itemView.findViewById<CardView>(R.id.Item).background=ContextCompat.getDrawable(context,R.drawable.green)
        }
        else{
            holder.itemView.findViewById<CardView>(R.id.Item).background=ContextCompat.getDrawable(context,R.drawable.red)

        }
        holder.itemView.setOnClickListener(View.OnClickListener {
            sheet.state=BottomSheetBehavior.STATE_EXPANDED
            msgcon.text=list.get(position).content

        })
    }

    override fun getItemCount(): Int {
        return  list.size
    }

}

package com.project.sms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    lateinit var list:RecyclerView;
    lateinit var layout:LinearLayout
    lateinit var sheet:BottomSheetBehavior<LinearLayout>;
    lateinit var msgcon:TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initSheet()
        ContextCompact.
        list.adapter=smsAdapter(applicationContext,smsRepo.getSMS(applicationContext),sheet,msgcon)
        list.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)

    }

    fun initViews(){
        list=findViewById(R.id.list)
        layout=findViewById(R.id.sheet)
        msgcon=findViewById(R.id.msgcon)
    }
    fun initSheet(){
        sheet= BottomSheetBehavior.from(layout)
        sheet .apply {
            peekHeight=0
            state=BottomSheetBehavior.STATE_COLLAPSED
        }
    }

}

package com.project.sms

import android.content.Context
import android.database.Cursor
import android.net.Uri

class smsRepo {

    companion object{

        fun getSMS(context: Context) : ArrayList<SMS>{
            var cur: Cursor= context.contentResolver.query(Uri.parse("content://sms"),null,null,null,null)!!
            val array=ArrayList<SMS>()
            var get=false
            cur.moveToFirst()
            do{
                var str=cur.getString(13)
                if(str.toLowerCase().contains("debited") ){
                    var k=""
                    var j=0
                    var stop=false
                    str.split(" ").forEach{e->
                        if(e.toLowerCase().contains("rs") and (e.length > "rs:".length) and !stop){
                            array.add((SMS("- "+e,cur.getString(13),false)))
                            stop=true
                        }
                        else if(e.toLowerCase().contains("rs")){
                            get=e.toLowerCase().contains("rs")
                        }
                        else if(get ){
                            get=false
                            k+=e
                            j++
                            if((j==2) and  !stop){
                                array.add((SMS("- "+k,cur.getString(13),false)))
                                stop=true
                                k=""
                                j=0

                            }
                        }
                    }

                }
                if( str.toLowerCase().contains("credited") ){
                    var stop=false
                    str.split(" ").forEach{e->
                        if(e.toLowerCase().contains("rs") and !stop){
                            array.add((SMS("+ "+e,cur.getString(13),true)))
                            stop=true
                        }
                    }}
            }while (cur.moveToNext())
          return array
        }
    }
}
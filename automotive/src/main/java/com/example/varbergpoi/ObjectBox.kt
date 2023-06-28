package com.example.varbergpoi

import android.content.Context
import com.example.varbergpoi.dummydata.MyObjectBox
import io.objectbox.BoxStore

class ObjectBox {
    companion object{
        private lateinit var boxStore:BoxStore
        fun init(context:Context){
            boxStore = MyObjectBox.builder().androidContext(context.applicationContext).build()
        }

        fun getBoxStore(): BoxStore {
            return boxStore
        }
    }
}
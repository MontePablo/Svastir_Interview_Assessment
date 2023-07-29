package com.example.svastirinterview

import com.example.svastirinterview.adapters.itemFunctions

object KeepObjectOfItemFunctions {
    private lateinit var listener:itemFunctions

    fun setListener(listener:itemFunctions){
        this.listener=listener
    }
    fun getListener():itemFunctions{
        return listener
    }
}
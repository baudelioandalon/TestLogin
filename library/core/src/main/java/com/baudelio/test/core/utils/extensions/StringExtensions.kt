package com.baudelio.test.core.utils.extensions

import android.util.Log

fun String.log(key: String, error: Boolean = true){
    if(!error){
        Log.i(key,this)
    }else{
        Log.e(key,this)
    }
}
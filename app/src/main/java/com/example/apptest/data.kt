package com.example.apptest

import androidx.lifecycle.MutableLiveData

object data {
    val data = MutableLiveData<MutableList<String>>()
    var mapSize = mutableMapOf<String,Int>()
}
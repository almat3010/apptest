package com.example.apptest

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import java.io.IOException

class Parse :ViewModel(){
    private val pic = MutableLiveData<MutableList<String>>()
    private val msg = MutableLiveData<String>()

    private suspend fun getImg (url: String) {
        try {
            val elem = mutableListOf<String>()
            val doc = Jsoup.connect(url).get()
            doc.getElementsByTag("img").forEach {
                elem.add(it.attr("abs:src"))
            }
            pic.postValue(elem)
        }catch (e:IOException){msg.postValue("incorrect link")}
    }

    fun getPics() : LiveData<MutableList<String>>{
        return pic
    }

    fun checkUrl():LiveData<String>{
        return msg
    }

    fun kek (url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getImg(url)
        }
    }
}
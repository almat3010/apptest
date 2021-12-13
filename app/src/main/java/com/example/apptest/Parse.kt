package com.example.apptest

import android.util.Log
import androidx.lifecycle.*
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import java.io.IOException

class Parse : ViewModel(){
    private val msg = MutableLiveData<String>()

    suspend fun getImg (pict : MutableLiveData<MutableList<String>>, url: String) {
        try {
            val elem = mutableListOf<String>()
            val doc = Jsoup.connect(url).get()
            doc.getElementsByTag("img").forEach {
                if (!it.attr("abs:src").contains(".gif") && it.attr("abs:src")!=""){
                    elem.add(it.attr("abs:src"))
                }
            }
            pict.postValue(elem)
        }catch (e:IOException){msg.postValue("incorrect link")}
    }

    fun checkUrl():LiveData<String>{
        return msg
    }

    fun parse (pict : MutableLiveData<MutableList<String>>, url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getImg(pict, url)
        }
    }

    suspend fun picassoSize (tags: List<String>) {
        tags.forEach{ url ->
            if (url.contains("https")) {
                val picasso = Picasso.get().load(url).get()
                data.mapSize.put(url, picasso.byteCount/1000)
            }
            else{
                val picasso = Picasso.get().load(url.replace("http","https")).get()
                data.mapSize.put(url, picasso.byteCount/1000)
            }
        }
    }
    fun getSize (url: List<String>) {
        viewModelScope.launch(Dispatchers.IO) {
               picassoSize(url)
        }
    }
}

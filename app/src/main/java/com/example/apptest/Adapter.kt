package com.example.apptest

import android.icu.number.NumberFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adapter(private val tags: List<String>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var text: TextView = view.findViewById<View>(R.id.textView1) as TextView
        var img: ImageView = view.findViewById<View>(R.id.imageView1) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tag = tags[position]
        if (tag.contains("https")){
            Picasso.get().load(tag).placeholder(R.drawable.abc_vector_test).into(holder.img)
        }
        else{
            Picasso.get().load(tag.replace("http","https")).placeholder(R.drawable.abc_vector_test).into(holder.img)
        }
        val size = data.mapSize[tag]
        holder.text.text = "url -$tag, size - $size kb"
    }

    override fun getItemCount(): Int {
        return tags.size
    }
}
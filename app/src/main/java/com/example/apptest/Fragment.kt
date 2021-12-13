package com.example.apptest

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val input = view.findViewById<TextView>(R.id.editText2)
        val click = view.findViewById<Button>(R.id.button3)

        click.setOnClickListener{
            val network = Parse()
            network.parse(data.data, input.text.toString())
            network.checkUrl().observeForever(Observer {
                Toast.makeText(this.context,it,Toast.LENGTH_SHORT).show()
            })
            if(data.data.value != null) {
                network.getSize(data.data.value!!)
                    findNavController().navigate(R.id.fragmentTwo)
            }
            else{
                Toast.makeText(this.context,"Wait...",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
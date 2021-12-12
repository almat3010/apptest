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

        val bundle = Bundle()

        click.setOnClickListener{
            val network = Parse()

            val arr : ArrayList<String> = arrayListOf("https://files.betamax.raywenderlich.com/attachments/collections/232/22bf4a70-00e1-4b67-9197-0b345ba14d77.png",
                "https://s3.us-east-2.wasabisys.com/artcdn.artradarjournal.com/how-to-use-picasso-android-studio-.jpg")

            network.kek(input.text.toString())
            val observImg = Observer<MutableList<String>> { elem ->
                elem.forEach {
                    arr.add(it)
                }
                Log.i("SSS", arr.toString())
                bundle.putString("myArg", arr.toString())
               // val kek = FragmentTwo()
                //kek.arguments = bundle
            }
            network.getPics().observeForever(observImg)

            findNavController().navigate(R.id.fragmentTwo,bundle)
        }
    }
}

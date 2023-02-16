package com.example.classdemoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.classdemoapp.R

class CharacterDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_character_detail, container, false)

        if (arguments != null){
            val name = requireArguments().getString("name")
            val age = requireArguments().getInt("age")
            val position = requireArguments().getString("position")
            val club = requireArguments().getString("club")
            val nation = requireArguments().getString("nation")
            val image = requireArguments().getString("image")

            view.findViewById<TextView>(R.id.player_name).text = name
            view.findViewById<TextView>(R.id.player_club).text = club
            view.findViewById<TextView>(R.id.player_nation).text = nation
            view.findViewById<TextView>(R.id.player_position).text = position
            view.findViewById<TextView>(R.id.player_age).text = age.toString()
            val imageView = view.findViewById<ImageView>(R.id.player_image)

            Glide.with(this)
                .load(image)
                .into(imageView)

        }

        return view
    }
}
package com.example.classdemoapp

import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class CharacterAdapter(private val characters: List<Character>):RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_card_view,parent,false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.characterImage.setImageResource(character.image)
        holder.charactername.text= character.name
        holder.characterAge.text = character.age.toString()
        holder.characterClub.text = character.club
        holder.characterNation.text = character.nation
    }

    class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val characterImage: ImageView = itemView.findViewById(R.id.character_image)
        val charactername: TextView = itemView.findViewById(R.id.character_name)
        val characterAge: TextView = itemView.findViewById(R.id.character_age)
        val characterClub: TextView = itemView.findViewById(R.id.character_club)
        val characterNation: TextView = itemView.findViewById(R.id.character_nation)

    }

}
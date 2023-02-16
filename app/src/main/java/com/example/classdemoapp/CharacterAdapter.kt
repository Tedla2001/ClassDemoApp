package com.example.classdemoapp

import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classdemoapp.ui.CharacterDetailFragment
import org.w3c.dom.Text

class CharacterAdapter(private val characters: List<Character>):RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_card_view,parent,false)
        return CharacterViewHolder(view) {position ->
            val character = characters[position]

            val bundle = bundleOf(
                "name" to character.name,
                "age" to character.age,
                "image" to character.image,
                "club" to character.club ,
                "nation" to character.nation,
                "position" to character.position
            )

            val detailFragment = CharacterDetailFragment()
            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        Glide.with(holder.itemView.context).load(character.image).error(R.drawable.partey).into(holder.characterImage)
        holder.characterName.text= character.name
        holder.characterClub.text = character.club
        holder.characterNation.text = character.nation
//        holder.characterAge.text = character.age.toString()
//        holder.characterPosition.text = character.position
    }

    inner class CharacterViewHolder(itemView: View,
                                    private val onItemClick:(adapterPosition:Int) -> Unit
                                    ): RecyclerView.ViewHolder(itemView){
        val characterImage: ImageView = itemView.findViewById(R.id.character_image)
        val characterName: TextView = itemView.findViewById(R.id.character_name)
        val characterClub: TextView = itemView.findViewById(R.id.character_club)
        val characterNation: TextView = itemView.findViewById(R.id.character_nation)
//        val characterAge: TextView = itemView.findViewById(R.id.player_age)
//        val characterPosition: TextView = itemView.findViewById(R.id.player_position)

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

    }

}
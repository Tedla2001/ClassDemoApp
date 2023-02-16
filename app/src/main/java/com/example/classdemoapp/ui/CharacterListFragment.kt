package com.example.classdemoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classdemoapp.Character
import com.example.classdemoapp.CharacterAdapter
import com.example.classdemoapp.R

class CharacterListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_character_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.character_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val characters = createListOfCharacter()

//        for(i in 0..30){
//            characters.add(createCharacters())
//        }

        val adapter = CharacterAdapter(characters)

        recyclerView.adapter = adapter

        return view
    }

    private fun createCharacters() = Character(
        name = "Partey",
        age = 30,
        image = "https://rickandmortyapi.com/api/character/avatar/473.jpeg",
        club = "Arsenal",
        nation = "Ghana",
        position = "CDM",
        id = 0
    )

    fun createListOfCharacter(): MutableList<Character> {
        val characters = mutableListOf(
            Character(
                name = "Partey",
                age = 30,
                image = "https://resources.premierleague.com/premierleague/photos/players/250x250/p167199.png",
                club = "Arsenal",
                nation = "Ghana",
                position = "Midfielder",
                id = 0
            ),
            Character(
                name = "Haaland",
                age = 22,
                image = "https://resources.premierleague.com/premierleague/photos/players/250x250/p223094.png",
                club = "Man City",
                nation = "Norway",
                position = "Forward",
                id = 1
            ),
            Character(
                name = "Kane",
                age = 30,
                image = "https://resources.premierleague.com/premierleague/photos/players/250x250/p78830.png",
                club = "Tottenham",
                nation = "England",
                position = "Forward",
                id = 2
            ),
            Character(
                name = "Rashford",
                age = 25,
                image = "https://resources.premierleague.com/premierleague/photos/players/250x250/p176297.png",
                club = "Man Utd",
                nation = "England",
                position = "Forward",
                id = 3
            ),
            Character(
                name = "Saka",
                age = 21,
                image = "https://resources.premierleague.com/premierleague/photos/players/250x250/p223340.png",
                club = "Arsenal",
                nation = "England",
                position = "Forward",
                id = 4
            ),
            Character(
                name = "Pope",
                age = 30,
                image = "https://resources.premierleague.com/premierleague/photos/players/250x250/p98747.png",
                club = "Newcastle",
                nation = "England",
                position = "Goalkeeper",
                id = 5
            ),
            Character(
                name = "Tiago Silva",
                age = 38,
                image = "https://resources.premierleague.com/premierleague/photos/players/250x250/p51090.png",
                club = "Chelsea",
                nation = "Brazil",
                position = "Defender",
                id = 6
            ),
            Character(
                name = "Salah",
                age = 30,
                image = "https://resources.premierleague.com/premierleague/photos/players/250x250/p118748.png",
                club = "Liverpool",
                nation = "Egypt",
                position = "Forward",
                id = 7
            )
        )
        return characters
    }

}
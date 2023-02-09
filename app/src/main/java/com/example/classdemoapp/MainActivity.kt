package com.example.classdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.character_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val characters = createListOfCharacter()

//        for(i in 0..30){
//            characters.add(createCharacters())
//        }

        val adapter = CharacterAdapter(characters)

        recyclerView.adapter = adapter
    }

    private fun createCharacters() = Character(
        name = "Partey",
        age = 30,
        image = R.drawable.cat,
        club = "Arsenal",
        nation = "Ghana",
        id = 0
    )

    fun createListOfCharacter(): MutableList<Character> {
        val characters = mutableListOf(
            Character(name = "Partey", age = 30, image = R.drawable.partey, club = "Arsenal", nation = "Ghana", id = 0),
            Character(name = "Haaland", age = 22, image = R.drawable.haaland, club = "Man City", nation = "Norway", id = 1),
            Character(name = "Kane", age = 30, image = R.drawable.kane, club = "Tottenham", nation = "England", id = 2),
            Character(name = "Rashford", age = 25, image = R.drawable.rashford, club = "Man Utd", nation = "England", id = 3),
            Character(name = "Saka", age = 25, image = R.drawable.saka, club = "Arsenal", nation = "England", id = 3),
            Character(name = "Salah", age = 25, image = R.drawable.salah, club = "Liverpool", nation = "Egypt", id = 3)
        )
        return characters
    }

}
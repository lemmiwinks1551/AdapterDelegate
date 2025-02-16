package com.example.adapterdelegatestest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapterdelegatestest.entity.Automobile
import com.example.adapterdelegatestest.entity.Driver
import com.example.adapterdelegatestest.entity.ListItem
import com.example.adapterdelegatestest.ui.MainAdapter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        inflateRecyclerView()
    }

    private fun inflateRecyclerView() {
        // Создаём список items с разными типами данных (Automobile и Driver).
        val items: List<ListItem> = listOf(
            Automobile("BMW", "Black"),
            Driver("John", 20),
            Automobile("Ferrari", "Red"),
            Driver("Bob", 30),
            Automobile("Toyota", "Blue"),
            Driver("Mike", 25),
            Automobile("Toyota", "Blue"),
            Driver("Mike", 25),
            Automobile("Toyota", "Blue"),
            Driver("Mike", 25),
            Automobile("Toyota", "Blue"),
            Driver("Mike", 25),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = MainAdapter() // уже содержит делегаты

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.items = items
    }
}
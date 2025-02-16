package com.example.adapterdelegatestest.entity

data class Automobile(
    val brand: String,
    val color: String
) : ListItem

data class Driver(
    val name: String,
    val age: Int
) : ListItem

// оба класса реализуют интерфейс ListItem,
// это позволяет работать с ними как с единым списком элементов разных типов.
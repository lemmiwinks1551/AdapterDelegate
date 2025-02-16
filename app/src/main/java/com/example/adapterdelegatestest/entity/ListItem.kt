package com.example.adapterdelegatestest.entity


interface ListItem


/*
интерфейс позволяет создать общий тип данных для списка RecyclerView.
Так как RecyclerView.Adapter работает с одним List<T> нужно, чтобы все элементы списка
(Automobile и Driver) были одного типа.
Этот интерфейс даёт возможность использовать Adapter Delegates, которые сами понимают,
какой тип данных обрабатывать.*/

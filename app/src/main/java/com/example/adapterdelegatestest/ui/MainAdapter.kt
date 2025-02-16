package com.example.adapterdelegatestest.ui

import com.example.adapterdelegatestest.databinding.ItemAutomobileBinding
import com.example.adapterdelegatestest.databinding.ItemDriverBinding
import com.example.adapterdelegatestest.entity.Automobile
import com.example.adapterdelegatestest.entity.Driver
import com.example.adapterdelegatestest.entity.ListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

// адаптер с делегатами
// сам выбирает, каким делегатом обрабатывать элементы.
class MainAdapter : ListDelegationAdapter<List<ListItem>>() {
    init {
        // регистрируем делегаты (automobileDelegate() и driverDelegate())
        // Делегаты определяют, какие ViewHolder'ы использовать для разных типов данных
        delegatesManager.addDelegate(automobileDelegate())
            .addDelegate(driverDelegate())
    }
}

// делегат для Automobile
private fun automobileDelegate() =
    adapterDelegateViewBinding<Automobile, ListItem, ItemAutomobileBinding>(
        // Указываем, что этот делегат работает с Automobile
        // ListItem — базовый интерфейс, чтобы адаптер понимал, что это часть общего списка.
        // ItemAutomobileBinding — ViewBinding для макета автомобиля.
        // Создаём ViewBinding, который будет использоваться для этого типа данных.
        { inflater, parent -> ItemAutomobileBinding.inflate(inflater, parent, false) }
    ) {
        bind {// вместо onBindViewHolder()
            // Когда RecyclerView привязывает данные, мы просто заполняем TextView нужными значениями.
            binding.tvBrand.text = item.brand
            binding.tvColor.text = item.color
        }
    }
// Аналогично automobileDelegate().
private fun driverDelegate() = adapterDelegateViewBinding<Driver, ListItem, ItemDriverBinding>(
    { inflater, parent -> ItemDriverBinding.inflate(inflater, parent, false) }
) {
    bind {
        binding.tvName.text = item.name
        binding.tvAge.text = item.age.toString()
    }
}


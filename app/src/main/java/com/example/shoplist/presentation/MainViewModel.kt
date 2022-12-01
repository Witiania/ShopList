package com.example.shoplist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoplist.data.ShopListRepositoryImpl // как указывал ниже, дата слой попадать сюда нге должен!!!
import com.example.shoplist.domain.DeleteShopItemeUseCase
import com.example.shoplist.domain.EditShopItemUseCase
import com.example.shoplist.domain.GetShopListUseCase
import com.example.shoplist.domain.ShopItem

class MainViewModel:ViewModel() {

    private val repository = ShopListRepositoryImpl // Так делать нельзя, презенташион не должен зависеть от Дата слоя.
    //Может зависеть только от Домэйн слоя, так же как и дата слой, только от Домэйн слоя

    private val getShopListUseCase = GetShopListUseCase(repository) // Почему берем в конструктор а не наследуем?!?!?!?!?
    private val deleteShopItemUseCase = DeleteShopItemeUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()  // чтобы сохранялись данные при уничтожении View, например при перевороте экрана (MutableLiveData)

//    fun getShopList(){
//       val list =getShopListUseCase.getShopList()
//        shopList.value = list
//    }
    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
//        getShopList()
    }

    fun changeEnabledState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled =!shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
//        getShopList()
    }
}
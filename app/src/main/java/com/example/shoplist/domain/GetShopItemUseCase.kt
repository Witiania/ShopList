package com.example.shoplist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItemUseCase(shopItemId:ShopItem){
        shopListRepository.getShopItemUseCase(shopItemId)
    }
}
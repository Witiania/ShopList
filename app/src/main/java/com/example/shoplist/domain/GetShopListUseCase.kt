package com.example.shoplist.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList():LiveData<List<ShopItem>>{     // ранее был типо List<ShopItem> - меняем на LiveData чтобы список обновлялся автоматически
            return shopListRepository.getShopList()
    }
}
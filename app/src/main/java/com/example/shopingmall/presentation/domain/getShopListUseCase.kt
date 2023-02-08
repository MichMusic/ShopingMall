package com.example.shopingmall.presentation.domain

import androidx.lifecycle.LiveData

class getShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}
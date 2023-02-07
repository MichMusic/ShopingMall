package com.example.shopingmall.presentation.domain

class getAddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addingItem(shopItem: ShopItem) {
        shopListRepository.addingItem(shopItem)
    }
}
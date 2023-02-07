package com.example.shopingmall.presentation.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editingShopItem(shopItem: ShopItem) {
        shopListRepository.editingShopItem(shopItem)
    }
}
package com.example.shopingmall.presentation.domain

class deleteIShoptemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleting(shopItem: ShopItem) {
        shopListRepository.deleting(shopItem)
    }
}
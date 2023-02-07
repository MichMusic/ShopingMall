package com.example.shopingmall.presentation.domain

interface ShopListRepository {
    fun addingItem(shopItem: ShopItem)

    fun editingShopItem(shopItem: ShopItem)

    fun deleting(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int) : ShopItem

    fun getShopList(): List<ShopItem>
}
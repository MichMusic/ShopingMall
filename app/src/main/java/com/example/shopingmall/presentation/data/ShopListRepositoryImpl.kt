package com.example.shopingmall.presentation.data

import com.example.shopingmall.presentation.domain.ShopItem
import com.example.shopingmall.presentation.domain.ShopListRepository

object ShopListRepositoryImpl:  ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

    override fun addingItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.undefinedId) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun editingShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun deleting(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addingItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw java.lang.RuntimeException("Элемент с id $shopItemId не был найден")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}
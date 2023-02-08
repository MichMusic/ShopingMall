package com.example.shopingmall.presentation.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopingmall.presentation.domain.ShopItem
import com.example.shopingmall.presentation.domain.ShopListRepository

object ShopListRepositoryImpl:  ShopListRepository {

    private val shopListLd = MutableLiveData<List<ShopItem>>()

    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

    init {
        for(i in 0 until 10) {
            val item = ShopItem("Irina $i",i,true)
            addingItem(item)
        }
    }

    override fun addingItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.undefinedId) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun editingShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun deleting(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addingItem(shopItem)
        updateList()
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw java.lang.RuntimeException("Элемент с id $shopItemId не был найден")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLd
    }

    private fun updateList() {
        shopListLd.value = shopList.toList()
    }
}
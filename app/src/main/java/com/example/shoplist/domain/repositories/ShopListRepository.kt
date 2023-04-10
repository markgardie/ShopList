package com.example.shoplist.domain.repositories

import com.example.shoplist.domain.models.ShopItem

interface ShopListRepository {

    fun getShopList(): List<ShopItem>

    fun getShopItem(shopItemId: Int): ShopItem

    fun editShopItem(shopItem: ShopItem)

    fun deleteShopItem (shopItem: ShopItem)

    fun addShopItem(shopItem: ShopItem)
}
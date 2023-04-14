package com.example.shoplist.domain.repositories

import androidx.lifecycle.LiveData
import com.example.shoplist.domain.models.ShopItem

interface ShopListRepository {

    fun getShopList(): LiveData<List<ShopItem>>

    fun getShopItem(shopItemId: Int): ShopItem

    fun editShopItem(shopItem: ShopItem)

    fun deleteShopItem (shopItem: ShopItem)

    fun addShopItem(shopItem: ShopItem)
}
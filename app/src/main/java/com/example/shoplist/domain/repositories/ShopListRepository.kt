package com.example.shoplist.domain.repositories

import androidx.lifecycle.LiveData
import com.example.shoplist.domain.models.ShopItem

interface ShopListRepository {

   fun getShopList(): LiveData<List<ShopItem>>

   suspend fun getShopItem(shopItemId: Int): ShopItem

   suspend fun editShopItem(shopItem: ShopItem)

   suspend fun deleteShopItem (shopItem: ShopItem)

   suspend fun addShopItem(shopItem: ShopItem)
}
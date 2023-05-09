package com.example.shoplist.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoplist.domain.models.ShopItem

@Dao
interface ShopListDao {

    @Query("select * from shop_items")
    fun getShopList(): LiveData<List<ShopItem>>

    @Query("select * from shop_items where id = :shopItemId limit 1")
    fun getShopItem(shopItemId: Int): ShopItem

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun editShopItem(shopItem: ShopItem)

    @Query("delete from shop_items where id = :shopItem")
    fun deleteShopItem (shopItem: ShopItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addShopItem(shopItem: ShopItem)
}
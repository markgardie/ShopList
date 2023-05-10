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
    fun getShopList(): LiveData<List<ShopItemDbModel>>

    @Query("select * from shop_items where id = :shopItemId limit 1")
    suspend fun getShopItem(shopItemId: Int): ShopItemDbModel

    @Query("delete from shop_items where id = :shopItemId")
    suspend fun deleteShopItem (shopItemId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShopItem(shopItem: ShopItemDbModel)
}
package com.example.shoplist.domain.use_cases

import androidx.lifecycle.LiveData
import com.example.shoplist.domain.models.ShopItem
import com.example.shoplist.domain.repositories.ShopListRepository

class GetShopListUseCase(
    private val shopListRepository: ShopListRepository
) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return  shopListRepository.getShopList()
    }
}
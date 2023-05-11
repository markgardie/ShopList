package com.example.shoplist.data.mappers

import androidx.lifecycle.LiveData
import com.example.shoplist.data.database.ShopItemDbModel
import com.example.shoplist.domain.models.ShopItem

class ShopListMapper {

    fun mapDbModelToEntity(dbModel: ShopItemDbModel) = ShopItem(
            id = dbModel.id,
            name = dbModel.name,
            count = dbModel.count,
            enabled = dbModel.enabled
    )

    fun mapEntityToDbModel(entity: ShopItem) = ShopItemDbModel(
            id = entity.id,
            name = entity.name,
            count = entity.count,
            enabled = entity.enabled
        )

    fun mapListDbModelToListEntity(list: List<ShopItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

}
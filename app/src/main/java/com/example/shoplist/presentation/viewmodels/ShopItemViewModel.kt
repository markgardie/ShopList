package com.example.shoplist.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoplist.data.repositories.ShopListRepositoryImpl
import com.example.shoplist.domain.models.ShopItem
import com.example.shoplist.domain.use_cases.AddShopItemUseCase
import com.example.shoplist.domain.use_cases.EditShopItemUseCase
import com.example.shoplist.domain.use_cases.GetShopItemUseCase

class ShopItemViewModel: ViewModel() {

    val repository = ShopListRepositoryImpl

    val getShopItemUseCase = GetShopItemUseCase(repository)
    val addShopItemUseCase = AddShopItemUseCase(repository)
    val editShopItemUseCase = EditShopItemUseCase(repository)

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _shopItem = MutableLiveData<ShopItem>()
    val shopItem: LiveData<ShopItem>
        get() = _shopItem

    private val _closeScreen = MutableLiveData<Unit>()
    val closeScreen: LiveData<Unit>
        get() = _closeScreen

    fun addShopItem(name: String?, count: String?) {
        val parsedName = parseName(name)
        val parsedCount = parseCount(count)
        val fieldsValid = validateInput(parsedName, parsedCount)

        if (fieldsValid) {
            val newShopItem = ShopItem(parsedName, parsedCount, true)
            addShopItemUseCase.addShopItem(newShopItem)
            _closeScreen.value = Unit
        }


    }

    fun editShopItem(name: String?, count: String?) {

        val parsedName = parseName(name)
        val parsedCount = parseCount(count)
        val fieldsValid = validateInput(parsedName, parsedCount)

        if (fieldsValid) {
            _shopItem.value?.let {
                val item = it.copy(name = parsedName, count = parsedCount)
                editShopItemUseCase.editShopItem(item)
                _closeScreen.value = Unit
            }

        }
    }

    fun getShopItem(shopItemId: Int) {
        val item = getShopItemUseCase.getShopItem(shopItemId)
        _shopItem.value = item
    }

    private fun parseName(name: String?): String {
        return name?.trim() ?: ""
    }

    private fun parseCount(count: String?): Int {
        return try {
            count?.trim()?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean {
        var result = true

        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }

        if (count <= 0) {
            _errorInputCount.value = true
            result = false
        }

        return result
    }

    private fun resetErrorInputName() {
        _errorInputName.value = false
    }

    private fun resetErrorInputCount() {
        _errorInputCount.value = false
    }
}
package com.example.shoplist.presentation.bindingadapters

import androidx.databinding.BindingAdapter
import com.example.shoplist.R
import com.example.shoplist.presentation.viewmodels.ShopItemViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("showNameError")
fun bindShowNameError(til: TextInputLayout, isError: Boolean) {

    val message = if(isError) {
        til.context.getString(R.string.error_input_name)
    } else {
        null
    }
    til.error = message
}

@BindingAdapter("showCountError")
fun bindShowCountError(til: TextInputLayout, isError: Boolean) {

    val message = if(isError) {
        til.context.getString(R.string.error_input_count)
    } else {
        null
    }
    til.error = message
}


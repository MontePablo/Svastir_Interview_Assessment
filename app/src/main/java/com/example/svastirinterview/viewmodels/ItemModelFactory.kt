package com.example.svastirinterview.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.svastirinterview.repositories.ItemRepository
import javax.inject.Inject

class ItemModelFactory @Inject constructor(private val repository: ItemRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemViewModel(repository) as T
    }
}
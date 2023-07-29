package com.example.svastirinterview.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.svastirinterview.models.Item
import com.example.svastirinterview.repositories.ItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ItemViewModel (private val repository:ItemRepository): ViewModel() {
    init {
        CoroutineScope(Dispatchers.IO).run {
            repository.getItems()
        }
    }
    val items:LiveData<ArrayList<Item>>
        get() = repository.items

    fun updateSaved(position:Int,isSaved:Boolean){
        repository.updateSaved(position,isSaved)
    }
}
package com.example.svastirinterview.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.svastirinterview.models.Item
import com.example.svastirinterview.retrofit.RetrofitApiHolder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ItemRepository @Inject constructor(private val apiHolder: RetrofitApiHolder) {
    private val itemsLiveData=MutableLiveData<ArrayList<Item>>()
    val items:LiveData<ArrayList<Item>>
        get() = itemsLiveData

    fun getItems(){
        apiHolder.getItems().enqueue(object:Callback<ArrayList<Item>>{
            override fun onResponse(
                call: Call<ArrayList<Item>>,
                response: Response<ArrayList<Item>>
            ) {
                if(response.code()==200){
                    Log.d("TAG",response.code().toString())
                    itemsLiveData.value=response.body()
                }else {
                    Log.d("TAG","repository onResponse else"+response.code().toString() + response.message().toString())
                }
            }

            override fun onFailure(call: Call<ArrayList<Item>>, t: Throwable) {
                Log.d("TAG","repository onFailure"+t.localizedMessage)
            }
        })
    }
    fun updateSaved(position:Int,isSaved:Boolean){
        var value=itemsLiveData.value
        var item= value?.get(position)
        item!!.updateSave(isSaved)
        value!![position] = item!!
        itemsLiveData.postValue(value)
        Log.d("TAG","data updated (repository)")
    }

}
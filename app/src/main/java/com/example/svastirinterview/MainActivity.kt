package com.example.svastirinterview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.svastirinterview.adapters.ItemAdapter
import com.example.svastirinterview.adapters.itemFunctions
import com.example.svastirinterview.dagger.ApplicationComponentProvider
import com.example.svastirinterview.databinding.ActivityMainBinding
import com.example.svastirinterview.models.Item
import com.example.svastirinterview.viewmodels.ItemModelFactory
import com.example.svastirinterview.viewmodels.ItemViewModel
import com.google.gson.Gson
import java.io.Serializable
import javax.inject.Inject

class MainActivity : AppCompatActivity(), itemFunctions {
    lateinit var binding: ActivityMainBinding
    lateinit var mItemViewModel: ItemViewModel
    @Inject
    lateinit var mItemModelFactory: ItemModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val daggerComponent= DaggerApplicationComponent.builder().build()
//        daggerComponent.inject(this)
        (application as ApplicationComponentProvider).applicationComponent.inject(this)

        mItemViewModel=ViewModelProvider(this,mItemModelFactory).get(ItemViewModel::class.java)

        val adapter=ItemAdapter(this)
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(this)

        mItemViewModel.items.observe(this) {
            if (it != null) {
                adapter.update(it)
            }else{
                Log.d("TAG","data fetched is null (on MainActivity)")
            }
        }
        KeepObjectOfItemFunctions.setListener(this)
    }

    override fun ItemClickFunc(item: Item,position: Int) {
        val gson = Gson()
        val intent = Intent(applicationContext, DetailPage()::class.java)
        intent.putExtra("item", gson.toJson(item))
        intent.putExtra("position",position)
        startActivity(intent)
    }

    override fun updateSaved(position: Int, isSaved: Boolean) {
        mItemViewModel.updateSaved(position,isSaved)
    }
}
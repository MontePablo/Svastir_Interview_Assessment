package com.example.svastirinterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.svastirinterview.adapters.itemFunctions
import com.example.svastirinterview.databinding.ActivityDetailPageBinding
import com.example.svastirinterview.models.Item
import com.google.gson.Gson
import java.io.Serializable

class DetailPage : AppCompatActivity() {
    lateinit var listener:itemFunctions
    lateinit var binding:ActivityDetailPageBinding
    init {
        listener=KeepObjectOfItemFunctions.getListener()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item = Gson().fromJson(intent.getStringExtra("item"), Item::class.java)
        val position=intent.getIntExtra("position",0)
        binding.apply {
            id.text=item.id
            albumid.text=item.albumId
            title.text=item.title
            Glide.with(applicationContext).load(item.url).into(binding.image)
            if(item.isSaved){
                binding.save.setImageResource(R.drawable.logo_saved)
            }else{
                binding.save.setImageResource(R.drawable.logo_save)
            }
        }

        binding.save.setOnClickListener(View.OnClickListener {
            if(item.isSaved) {
                listener.updateSaved(position, false)
                binding.save.setImageResource(R.drawable.logo_save)
            }
            else{
                listener.updateSaved(position, true)
                binding.save.setImageResource(R.drawable.logo_saved)
            }
        })
    }
}
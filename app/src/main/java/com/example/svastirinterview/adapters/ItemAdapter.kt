package com.example.svastirinterview.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.svastirinterview.R
import com.example.svastirinterview.models.Item
import java.io.Serializable


class ItemAdapter(
    listener: itemFunctions,
): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    var listener:itemFunctions
    var items= arrayListOf<Item>()

    init {
        this.listener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.custom_view_item,parent,false)
        val vh=ViewHolder(view)
        return vh
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun update(items:ArrayList<Item>){
        this.items=items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.albumId.text=items[position].albumId
        holder.id.text=items[position].id
        holder.title.text=items[position].title
        Glide.with(holder.image.context).load(items[position].thumbnailUrl).into(holder.image)
        holder.root.setOnClickListener(View.OnClickListener {
            listener.ItemClickFunc(items[position],position)
        })
        if(items[position].isSaved){
            holder.save.setImageResource(R.drawable.logo_saved)
        }else{
            holder.save.setImageResource(R.drawable.logo_save)
        }
        holder.save.setOnClickListener(View.OnClickListener {
            if(items[position].isSaved)
                listener.updateSaved(position,false)
            else
                listener.updateSaved(position,true)
        })

    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var image=view.findViewById<ImageView>(R.id.item_image)
        var title=view.findViewById<TextView>(R.id.item_title)
        var root=view.findViewById<ConstraintLayout>(R.id.item_root)
        var id=view.findViewById<TextView>(R.id.item_id)
        var albumId=view.findViewById<TextView>(R.id.item_albumid)
        var save=view.findViewById<ImageButton>(R.id.item_save)
    }
}
interface itemFunctions : Serializable{
    fun ItemClickFunc(item: Item,position: Int)
    fun updateSaved(position: Int,isSaved:Boolean)
}

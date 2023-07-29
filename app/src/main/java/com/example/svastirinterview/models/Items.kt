package com.example.svastirinterview.models

//class Items {
//    val items= arrayListOf<Item>()
//}
class Item{
    var albumId=""
    var id=""
    var thumbnailUrl=""
    var url=""
    var title=""
    var isSaved=false
    fun updateSave(isSaved:Boolean){
        this.isSaved=isSaved
    }
}
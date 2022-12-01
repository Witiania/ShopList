package com.example.shoplist.domain

data class ShopItem (
    val name:String,
    val count:Int,
    val enabled:Boolean,
    var id:Int = UNDIFINED_ID// Означает что ID еще не установлен и ему нужно присвоить значение при добавлении объекта в коллекцию
        )
{
    companion object{
        const val UNDIFINED_ID = -1

    }
}

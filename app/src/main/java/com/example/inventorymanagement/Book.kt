package com.example.inventorymanagement

class Book{
    var id: Int = 0
    var author : String = ""
    var pages : Int = 0
    var title :String = ""

    constructor(author:String, pages:Int, title:String){
        this.author = author
        this.pages = pages
        this.title = title
    }
}
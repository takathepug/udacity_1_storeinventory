package com.example.storeinventory.model

data class Fruit(
    var name: String,
    var company: String = "",
    var kilos: Int = 0,
    var description: String = "",
    var image: Int) {}

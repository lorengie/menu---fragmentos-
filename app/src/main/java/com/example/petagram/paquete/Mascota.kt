package com.example.petagram.paquete

data class Mascota(
    val nombre: String,
    val foto: Int,
    val colorFondo: Int,
    var raiting: Int = 0
)
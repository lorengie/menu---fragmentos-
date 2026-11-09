package com.example.petagram.paquete

import com.example.petagram.R

object MascotasDummy {

    fun todas(): MutableList<Mascota> = mutableListOf(
        Mascota("Catty", R.drawable.ic_perro, 0xFFF06292.toInt(), 5),
        Mascota("Ronny", R.drawable.ic_perro, 0xFF1976D2.toInt(), 3),
        Mascota("Rocky", R.drawable.ic_perro, 0xFF66BB6A.toInt(), 0),
        Mascota("Luna", R.drawable.ic_perro, 0xFFFFA726.toInt(), 4),
        Mascota("Max", R.drawable.ic_perro, 0xFF9575CD.toInt(), 2),
        Mascota("Toby", R.drawable.ic_perro, 0xFF26A69A.toInt(), 0),
        Mascota("Kira", R.drawable.ic_perro, 0xFFEF5350.toInt(), 1)
    )

    // Las 5 favoritas "dummy" de la parte 2
    fun favoritas(): MutableList<Mascota> = mutableListOf(
        Mascota("Ronny", R.drawable.ic_perro, 0xFF1976D2.toInt(), 3),
        Mascota("Catty", R.drawable.ic_perro, 0xFFF06292.toInt(), 5),
        Mascota("Luna", R.drawable.ic_perro, 0xFFFFA726.toInt(), 4),
        Mascota("Max", R.drawable.ic_perro, 0xFF9575CD.toInt(), 2),
        Mascota("Kira", R.drawable.ic_perro, 0xFFEF5350.toInt(), 1)
    )
}
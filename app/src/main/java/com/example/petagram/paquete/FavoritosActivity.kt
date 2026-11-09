package com.example.petagram



import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petagram.paquete.MascotaAdapter
import com.example.petagram.paquete.MascotasDummy
import com.google.android.material.appbar.MaterialToolbar

class FavoritosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favoritos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))
        // Flecha "<" para volver al Activity padre
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rvFavoritos = findViewById<RecyclerView>(R.id.rvFavoritos)
        rvFavoritos.layoutManager = LinearLayoutManager(this)
        rvFavoritos.adapter = MascotaAdapter(MascotasDummy.favoritas())
    }

    // Vuelve a la lista sin recrearla, así se conservan los likes dados
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
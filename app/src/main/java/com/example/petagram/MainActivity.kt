package com.example.petagram

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petagram.paquete.MascotaAdapter
import com.example.petagram.paquete.MascotasDummy
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        val rvMascotas = findViewById<RecyclerView>(R.id.rvMascotas)
        rvMascotas.layoutManager = LinearLayoutManager(this)
        rvMascotas.adapter = MascotaAdapter(MascotasDummy.todas())

        findViewById<FloatingActionButton>(R.id.fabCamara).setOnClickListener {
            Toast.makeText(this, "Cámara: próximamente", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        // Un Action View no dispara onOptionsItemSelected:
        // el clic se configura directamente sobre su vista
        val estrella = menu.findItem(R.id.action_favoritos).actionView
        estrella?.findViewById<TextView>(R.id.tvContadorFavoritos)?.text =
            MascotasDummy.favoritas().size.toString()
        estrella?.setOnClickListener {
            startActivity(Intent(this, FavoritosActivity::class.java))
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_contacto, R.id.action_acerca -> {
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
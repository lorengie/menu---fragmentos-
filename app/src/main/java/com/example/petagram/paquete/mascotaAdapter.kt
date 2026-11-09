package com.example.petagram.paquete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petagram.R

class MascotaAdapter(
    private val mascotas: MutableList<Mascota>
) : RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {

    class MascotaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val tvRaiting: TextView = view.findViewById(R.id.tvRaiting)
        val btnLike: ImageButton = view.findViewById(R.id.btnLike)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mascota, parent, false)
        return MascotaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        val mascota = mascotas[position]
        holder.imgFoto.setImageResource(mascota.foto)
        holder.imgFoto.setBackgroundColor(mascota.colorFondo)
        holder.tvNombre.text = mascota.nombre
        holder.tvRaiting.text = mascota.raiting.toString()

        // Hueso blanco: suma un like y refresca solo esa tarjeta
        holder.btnLike.setOnClickListener {
            val pos = holder.bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                mascotas[pos].raiting++
                notifyItemChanged(pos)
            }
        }
    }

    override fun getItemCount(): Int = mascotas.size
}
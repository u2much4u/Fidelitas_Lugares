package com.fidelitas_lugares.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fidelitas_lugares.databinding.LugarFilaBinding
import com.fidelitas_lugares.model.Lugar

class LugarAdapter : RecyclerView.Adapter<LugarAdapter.LugarViewHolder>(){

    private var lstLugares = emptyList<Lugar>()

    inner class LugarViewHolder(private val itemBinding: LugarFilaBinding) : RecyclerView.ViewHolder(itemBinding.root)
    {
         fun dibuja(entLugar : Lugar){
             itemBinding.tvNombre.text = entLugar.nombre
             itemBinding.tvCorreo.text = entLugar.correo
             itemBinding.tvTelefono.text = entLugar.telefono
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
        val itemBinding = LugarFilaBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return LugarViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar  = lstLugares[position]
        holder.dibuja(lugar)
    }

    override fun getItemCount(): Int {
        return lstLugares.size
    }

    fun setData(lugares : List<Lugar>){
        this.lstLugares = lugares
        notifyDataSetChanged()
    }

}
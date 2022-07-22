package com.fidelitas_lugares.adapter

import android.Manifest
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fidelitas_lugares.databinding.LugarFilaBinding
import com.fidelitas_lugares.model.Lugar
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class LugarAdapter : RecyclerView.Adapter<LugarAdapter.LugarViewHolder>(){

    private var lstLugares = emptyList<Lugar>()

    inner class LugarViewHolder(private val itemBinding: LugarFilaBinding) : RecyclerView.ViewHolder(itemBinding.root)
    {
         fun dibuja(entLugar : Lugar){
             itemBinding.tvNombre.text = entLugar.nombre
             itemBinding.tvCorreo.text = entLugar.correo
             itemBinding.tvTelefono.text = entLugar.telefono

             Glide.with(itemBinding.root.context).load(entLugar.rutaImagen)
                 .circleCrop()
                 .into(itemBinding.imagen)
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

    private fun UbicaGPS(){
      /*  val ubicacion : FusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())
        if(ActivityCompat.checkSelfPermission(requireContext()
        ,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                &&
           ActivityCompat.checkSelfPermission(requireContext()
        ,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(requireActivity()
                ,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)*/
    }

}
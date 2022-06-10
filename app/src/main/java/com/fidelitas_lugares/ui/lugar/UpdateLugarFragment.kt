package com.fidelitas_lugares.ui.lugar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.fidelitas_lugares.databinding.FragmentUpdateLugarBinding
import com.fidelitas_lugares.model.Lugar
import com.fidelitas_lugares.viewmodel.lugarViewModel


//(Semana 3) Al crear el fragmenteo desde mobile_navigation y borrar casi todo
class UpdateLugarFragment : Fragment() {

    //Se encarga de buscar datos
    private lateinit var lugarViewModel: lugarViewModel

    //Acceso a la parte visual
    private var _binding: FragmentUpdateLugarBinding? = null
    private val binding get()=_binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lugarViewModel = ViewModelProvider(this)[lugarViewModel::class.java]
        _binding = FragmentUpdateLugarBinding.inflate(inflater,container,false)

        binding.btnActualizar.setOnClickListener{UpdateLugar()}

        return  binding.root
    }

    private fun UpdateLugar() {
        val Nombre = binding.txtNombre.text.toString()
        val Correo = binding.txtCorreo.text.toString()
        val Telefono = binding.txtTelefono.text.toString()
        val SitioWeb = binding.txtSitioWeb.text.toString()

        if(Nombre.isNotEmpty()){
            val entLugar = Lugar(0,Nombre,Correo,Telefono,0.0,0.0,0.0,null,null)
            lugarViewModel.addLugar(entLugar)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.fidelitas_lugares.ui.lugar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.fidelitas_lugares.R
import com.fidelitas_lugares.databinding.FragmentAddLugarBinding
import com.fidelitas_lugares.model.Lugar
import com.fidelitas_lugares.viewmodel.lugarViewModel
import com.lugares.utiles.AudioUtiles


//(Semana 3) Al crear el fragmenteo desde mobile_navigation y borrar casi todo
class AddLugarFragment : Fragment() {

    //Se encarga de buscar datos
    private lateinit var lugarViewModel: lugarViewModel

    //Acceso a la parte visual
    private var _binding: FragmentAddLugarBinding? = null
    private val binding get()=_binding!!

    private lateinit var audioUtiles : AudioUtiles


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lugarViewModel = ViewModelProvider(this)[lugarViewModel::class.java]
        _binding = FragmentAddLugarBinding.inflate(inflater,container,false)

        binding.btAgregar.setOnClickListener{addLugar()}

        audioUtiles = AudioUtiles(requireActivity(),requireContext(),binding.btAccion,
        binding.btPlay,binding.btDelete,getString(R.string.msg_graba_audio), getString(R.string.msg_detener_audio))

        return  binding.root
    }

    private fun addLugar() {
        val Nombre = binding.etNombre.text.toString()
        val Correo = binding.etCorreo.text.toString()
        val Telefono = binding.etTelefono.text.toString()
        val SitioWeb = binding.etWeb.text.toString()

        if(Nombre.isNotEmpty()){
            val entLugar = Lugar("",Nombre,Correo,Telefono,0.0,0.0,0.0,null,null)
            lugarViewModel.SaveLugar(entLugar)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
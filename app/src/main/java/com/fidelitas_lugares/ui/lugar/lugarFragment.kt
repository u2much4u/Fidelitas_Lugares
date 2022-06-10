package com.fidelitas_lugares.ui.lugar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fidelitas_lugares.R
import com.fidelitas_lugares.adapter.LugarAdapter
import com.fidelitas_lugares.databinding.FragmentLugarBinding
import com.fidelitas_lugares.viewmodel.lugarViewModel


//(Semana 3) Al crear el fragmenteo desde mobile_navigation y borrar casi todo
class LugarFragment : Fragment() {

    //Se encarga de buscar datos
    private lateinit var lugarViewModel: lugarViewModel

    //Acceso a la parte visual
    private var _binding: FragmentLugarBinding? = null
    private val binding get()=_binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lugarViewModel = ViewModelProvider(this)[lugarViewModel::class.java]
        _binding = FragmentLugarBinding.inflate(inflater,container,false)

        binding.btnAddLugar.setOnClickListener{
            findNavController().navigate(R.id.action_nav_home_to_addLugarFragment)
        }

        //Activar el reciclador
        val lugarAdapter = LugarAdapter()
        val reciclador = binding.Reciclador

        reciclador.adapter = lugarAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        lugarViewModel = ViewModelProvider (this)[lugarViewModel::class.java]
        lugarViewModel.getAllData.observe(viewLifecycleOwner){
            lugares -> lugarAdapter.setData(lugares)
        }

        return  binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
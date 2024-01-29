package com.mpd.pmdm.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.mpd.pmdm.mvvm.databinding.FragmentContadorBinding

class ContadorFragment : Fragment() {

    private var _binding:FragmentContadorBinding? = null
    private val binding get() = _binding!!

    //Esta es la clave del SharedViewModel. Se usa igual en el oltro fragmento
    // Cambiamos la función delegada de propiedad. Usamos activityViewModels en lugar de viewModels
    //De este modo, indicamos que el dueño del ciclo de vida del viewmodel será la activity
    //y lo que manejan los fragmentos es una misma instancia compartida
    private val contadorVM: ContadorClicks by activityViewModels<ContadorClicks> {
        ContadorClickFactory(5)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentContadorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.contador = contadorVM
        binding.lifecycleOwner = viewLifecycleOwner

        //Ya no necesitamos indicar un observador, ya que mostramos el LiveData directamente en el layout con DataBinding
/*        contadorVM.cuentaClicks.observe(viewLifecycleOwner){
            actualizaContador()
        }*/
    }

    private fun actualizaContador() {
        binding.tvContador.text = contadorVM.cuentaClicks.value.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
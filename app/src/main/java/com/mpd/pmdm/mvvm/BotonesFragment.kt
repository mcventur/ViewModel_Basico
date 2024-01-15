package com.mpd.pmdm.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mpd.pmdm.mvvm.databinding.FragmentBotonesBinding

class BotonesFragment : Fragment() {

    private var _binding: FragmentBotonesBinding? = null
    private val binding get() = _binding!!

    private val contadorViewModel: ContadorClicks by activityViewModels<ContadorClicks> {
        ContadorClickFactory(5)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBotonesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnIncrementa.setOnClickListener {
            contadorViewModel.incrementa()
        }

        binding.btnResta.setOnClickListener {
            contadorViewModel.decrementa()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
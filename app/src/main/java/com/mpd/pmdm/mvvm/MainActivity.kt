package com.mpd.pmdm.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mpd.pmdm.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val contador: ContadorClicks by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actualizaContador()

        binding.btnIncrementa.setOnClickListener {
            contador.incrementa()
            actualizaContador()
        }

        binding.btnResta.setOnClickListener {
            contador.decrementa()
            actualizaContador()
        }
    }

    private fun actualizaContador() {
        binding.tvContador.text = contador.cuentaClicks.toString()
    }
}
package com.mpd.pmdm.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mpd.pmdm.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val contador: ContadorClicks by viewModels{
        ContadorClickFactory(5)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contador.cuentaClicks.observe(this){
            actualizaContador()
        }

        actualizaContador()

        binding.btnIncrementa.setOnClickListener {
            contador.incrementa()
        }

        binding.btnResta.setOnClickListener {
            contador.decrementa()
        }
    }

    private fun actualizaContador() {
        binding.tvContador.text = contador.cuentaClicks.value.toString()
    }
}
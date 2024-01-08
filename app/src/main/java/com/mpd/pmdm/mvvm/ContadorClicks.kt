package com.mpd.pmdm.mvvm

import androidx.lifecycle.ViewModel

class ContadorClicks: ViewModel() {
    var cuentaClicks: Int = 0

    fun incrementa() = cuentaClicks++

    fun decrementa() = cuentaClicks--

}
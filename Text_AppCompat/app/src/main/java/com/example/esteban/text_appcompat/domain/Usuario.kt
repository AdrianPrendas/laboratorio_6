package com.example.esteban.text_appcompat.domain;

import java.util.Date;
/**
 * Created by _Adrian_Prendas_ on 18/04/2018.
 */
data class Usuario(
        var id: Int,
        var nombre: String,
        var apellido: String,
        var ocupacion: String,
        var numeroTelefono: Int,
        var imageUrl: String,
        var email: String,
        var direccion: String
){
    companion object {
        val ADMIN = 0
        val USER = 1
    }
}
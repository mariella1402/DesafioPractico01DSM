package com.example.desafiopractico01dsm

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ActivityMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }
    fun irEjercicio1(view: View){
        val ejercicio1= Intent(this, ActivityEjercicio1::class.java)
        startActivity(ejercicio1)
    }

    fun irEjercicio2(view: View){
        val ejercicio2= Intent(this, ActivityEjercicio2::class.java)
        startActivity(ejercicio2)
    }
    fun CerrarSesion(view: View){
        finish() //
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}
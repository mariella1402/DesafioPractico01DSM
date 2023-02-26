package com.example.desafiopractico01dsm

import android.R
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.sqrt
import android.widget.TextView


class ActivityEjercicio2 : AppCompatActivity() {
    var txta:EditText?=null
    var txtb:EditText?=null
    var txtc:EditText?=null
    var resultado:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.desafiopractico01dsm.R.layout.activity_ejercicio2)
        txta = findViewById(com.example.desafiopractico01dsm.R.id.txta)
        txtb = findViewById(com.example.desafiopractico01dsm.R.id.txtb)
        txtc = findViewById(com.example.desafiopractico01dsm.R.id.txtc)
        resultado = findViewById(com.example.desafiopractico01dsm.R.id.resultado)
    }

    fun cuadratica(view: View){
        val a = txta?.text.toString().toDouble()
        val b = txtb?.text.toString().toDouble()
        val c = txtc?.text.toString().toDouble()

        val discriminante = b * b - 4 * a * c

        if (discriminante < 0) {
            resultado?.text = "La ecuación no tiene solución real"
            txta?.setText("")
            txtb?.setText("")
            txtc?.setText("")
        } else {
            val x1 = (-b + sqrt(discriminante)) / (2 * a)
            val x2 = (-b - sqrt(discriminante)) / (2 * a)

            resultado?.text = "x1 = $x1\nx2 = $x2"
            txta?.setText("")
            txtb?.setText("")
            txtc?.setText("")
        }

    }
}
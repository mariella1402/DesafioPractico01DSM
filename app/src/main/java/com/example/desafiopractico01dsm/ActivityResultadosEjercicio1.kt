package com.example.desafiopractico01dsm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ActivityResultadosEjercicio1 : AppCompatActivity() {

    private lateinit var mesSeleccionado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resultado_ficha_vendedor)

        // Recuperar los valores enviados a través del Intent
        val nombre = intent.getStringExtra("nombre")
        val codigo = intent.getStringExtra("codigo")
        val mesSeleccionado = intent.getStringExtra("mes")
        val ventas = intent.getDoubleExtra("ventas", 0.0)
        val porcentajeComision = intent.getIntExtra("porcentajeComision", 0)
        val totalComisiones = intent.getDoubleExtra("totalComisiones", 0.0)

        // Mostrar los valores en la interfaz de usuario
        val nombreTextView: TextView = findViewById(R.id.tvnombre)
        nombreTextView.text = "nombre: $nombre"

        val codigoTextView: TextView = findViewById(R.id.tvcodigo)
        codigoTextView.text = "codigo: $codigo"

        val mesTextView: TextView = findViewById(R.id.tvmes)
        mesTextView.text = "Mes seleccionado: $mesSeleccionado"

        val ventasTextView: TextView = findViewById(R.id.tvVentas)
        ventasTextView.text = "Ventas: $ventas"

        val porcentajeTextView: TextView = findViewById(R.id.tvComision)
        porcentajeTextView.text = "Porcentaje de comisión: $porcentajeComision%"

        val totalTextView: TextView = findViewById(R.id.tvVentas)
        totalTextView.text = "Total de comisiones: $totalComisiones"
    }
}

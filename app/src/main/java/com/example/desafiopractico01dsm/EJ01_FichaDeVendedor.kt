package com.example.desafiopractico01dsm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.text.NumberFormat
import java.util.*

class EJ01_FichaDeVendedor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ej01_ficha_de_vendedor)
        val submit: Button = findViewById(R.id.submit)
        val txtventas: TextView = findViewById(R.id.txtVentas)
        val resComision: TextView = findViewById(R.id.resComision)
        val resTotal: TextView = findViewById(R.id.resTotal)
        // Configurar el botón para que calcule la comisión
        submit.setOnClickListener {
            calcularComision()
        }
    }

    private fun calcularComision() {
        val txtVentas: TextView = findViewById(R.id.txtVentas)
        val ventas = obtenerDouble(txtVentas)
        val comision = when {
            ventas < 500 -> 0.0
            ventas < 1000 -> ventas * 0.05
            ventas < 2000 -> ventas * 0.1
            ventas < 3000 -> ventas * 0.15
            ventas < 4000 -> ventas * 0.2
            else -> ventas * 0.3
        }

        // Crear un objeto Currency para formatear los valores en USD
        val format = NumberFormat.getCurrencyInstance(Locale.US)
        val usdCurrency = Currency.getInstance("USD")

        // Actualizar las etiquetas de resultados con la comisión y el total
        val formatter = NumberFormat.getCurrencyInstance().apply {
            currency = usdCurrency
        }
        val resComision: TextView = findViewById(R.id.resComision)
        resComision.text = "${formatter.format(comision)} (${(comision / ventas * 100).toInt()}%)"

        val resTotal: TextView = findViewById(R.id.resTotal)
        resTotal.text = formatter.format(ventas - comision)
    }

    private fun obtenerDouble(editText: TextView): Double {
        return editText.text.toString().toDoubleOrNull() ?: 0.0
    }
}

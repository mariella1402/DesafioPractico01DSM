package com.example.desafiopractico01dsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class ActivityEjercicio1 : AppCompatActivity() {
    private var mesSeleccionado: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ej01_ficha_de_vendedor)
        val submit: Button = findViewById(R.id.submit)
        // Configurar el botón para que calcule la comisión
        submit.setOnClickListener {
            calcularComision()
        }
    }

    private fun calcularComision() {
        val empleado: TextView = findViewById(R.id.txtNombreEmpleado)
        val codigo: TextView = findViewById(R.id.txtCodigoEmpleado)
        val nombre = empleado.text.toString()
        val codigoStr = codigo.text.toString()
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
        //val resComision: TextView = findViewById(R.id.resComision)
        //resComision.text = "${formatter.format(comision)} (${(comision / ventas * 100).toInt()}%)"
        val porcentajeComision = (comision / ventas * 100).toInt()
        val totalComisiones = comision

        val spinnerMes: Spinner = findViewById(R.id.month_spinner)
        val mesSeleccionado: String = spinnerMes.selectedItem.toString()



        //val resTotal: TextView = findViewById(R.id.resTotal)
        //resTotal.text = formatter.format(ventas - comision)
        // Crear un Intent para abrir la nueva pantalla
        val intent = Intent(this, ActivityResultadosEjercicio1::class.java)
        intent.putExtra("nombre", nombre)
        intent.putExtra("codigo", codigoStr)
        intent.putExtra("mes", mesSeleccionado) // Aquí deberás pasar el mes seleccionado por el usuario
        intent.putExtra("ventas", txtVentas.text.toString())
        intent.putExtra("porcentajeComision", porcentajeComision)
        intent.putExtra("totalComisiones", totalComisiones)

        // Abrir la nueva pantalla
        startActivity(intent)

    }

    private fun obtenerDouble(editText: TextView): Double {
        return editText.text.toString().toDoubleOrNull() ?: 0.0
    }
}

package com.example.desafiopractico01dsm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var txtUsu:EditText?=null
    var txtPass:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtUsu = findViewById(R.id.txtUsu)
        txtPass = findViewById(R.id.txtPass)
    }
    fun guardar(view: View){
        var pref= getSharedPreferences(txtUsu?.text.toString(),Context.MODE_PRIVATE)
        var editor=pref.edit()
        editor.putString("pass",txtPass?.text.toString())
        editor.commit()
        Toast.makeText(this, "El usuario se registró correctamente", Toast.LENGTH_LONG).show();
        txtPass?.setText("")
        txtUsu?.setText("")
    }
    fun irLogin(view: View){
        val login=Intent(this, ActivityLogin::class.java)
        startActivity(login)
    }
}
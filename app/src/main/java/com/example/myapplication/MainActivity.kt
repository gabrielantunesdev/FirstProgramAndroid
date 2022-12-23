package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val etNome = findViewById<EditText>(R.id.etNome)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btLimpar = findViewById<Button>(R.id.btLimpar)
        val btMandar = findViewById<Button>(R.id.btMandar)

        btEnviar.setOnClickListener {
            if (etNome.text.isNotBlank()) {
                tvResultado.text = getString(R.string.hello, etNome.text.toString())
            } else{
                etNome.error = getString(R.string.type_your_name)
            }
        }

        btLimpar.setOnClickListener {
            if (etNome.text.isNotBlank()) {
                etNome.text.clear()
                tvResultado.text = getString(R.string.hello_word)
            } else{
                etNome.error = getString(R.string.No_To_Clean)
            }
        }

        btMandar.setOnClickListener {
            val nomeDigitado = etNome.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("NOME_DIGITADO", nomeDigitado)
            startActivity(intent)

        }
    }
}
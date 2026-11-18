package com.esempio.testapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mostraDatiIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        mostraDatiIntent(intent)
    }

    private fun mostraDatiIntent(intent: Intent?) {
        val txtParametri = findViewById<TextView>(R.id.txtParametri)
        val sb = StringBuilder()

        sb.append("=== DATI INTENT RICEVUTI ===\n\n")
        sb.append("Action: ${intent?.action}\n")
        sb.append("Data URI: ${intent?.dataString ?: "Nessuno"}\n\n")

        val extras = intent?.extras
        if (extras != null && !extras.isEmpty) {
            sb.append("--- PARAMETRI EXTRA ---\n")
            for (chiave in extras.keySet()) {
                val valore = extras.get(chiave)
                sb.append("• $chiave = $valore (${valore?.javaClass?.simpleName})\n")
            }
        } else {
            sb.append("Nessun parametro Extra ricevuto.")
        }

        txtParametri.text = sb.toString()
    }
}

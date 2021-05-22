package com.example.android.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val text1 = findViewById<TextView>(R.id.text1)
        text1.setOnClickListener {
            Toast.makeText(this@LoginActivity, "La page de Signup n'est pas prête", Toast.LENGTH_SHORT).show()
        }

        val text2 = findViewById<TextView>(R.id.text2)
        text2.setOnClickListener {
            Toast.makeText(this@LoginActivity, "La page de recuperation de mot de passe n'est pas prête", Toast.LENGTH_SHORT).show()
        }

        val exit = findViewById<TextView>(R.id.exit)
        exit.setOnClickListener {
            finish()
        }

        val username = findViewById<EditText>(R.id.username)

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("info",username.text.toString())
            startActivity(intent)
        }
    }
}
package com.uber

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        binding.btnRegister.setOnClickListener { goToRegister() }
        binding.btnLogin.setOnClickListener { login() }
    }

    private fun goToRegister() {
        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)
    }

    private fun login() {
        val email = binding.textFieldEmail.text.toString()
        val password = binding.textFieldPassword.text.toString()
        if (isValidForm(email, password)) {
            Toast.makeText(this, "Formulario valido", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidForm(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            Toast.makeText(this, "Ingresa tu correo electronico", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password.isEmpty()) {
            Toast.makeText(this, "Ingresa tu contraseña", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }


}
package com.example.docdefaut.presentation.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.docdefaut.BuildConfig
import com.example.docdefaut.R
import com.example.docdefaut.databinding.ActivityMainBinding
import com.example.docdefaut.presentation.login.viewModel.viewModel
import com.example.test.Test
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // Para puxar os ids do xml de forma mais facil
    private val viewModel: viewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater) // configuração do binding
        setContentView(binding.root)// configuração do binding
        viewModel.onEvent(
            LoginEvent.LoginTest("teste")
        )
        // aqui é para fazer um codigo especifico para cada build variante
        if (
           BuildConfig.FLAVOR == "versionTestTwo"
        ){
            binding.main.setBackgroundColor(getColor(R.color.white))
        }else{
            binding.main.setBackgroundColor(getColor(R.color.black))
        }

        viewModel.effect.observe(this) { event ->
            event?.getContentIfNotHandled()?.let { effect ->
                when (effect) {
                    is LoginEffect.ShowLoading -> {
                        Toast.makeText(this, "dsnajasnk", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
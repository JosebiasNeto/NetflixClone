package com.example.netflixclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.netflixclone.databinding.ActivityDetalhesFilmeBinding

class DetalhesFilme : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesFilmeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesFilmeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
package com.example.netflixclone

import android.content.Intent
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netflixclone.Adapter.FilmesAdapter
import com.example.netflixclone.Model.addFilmes
import com.example.netflixclone.databinding.ActivityDetalhesFilmeBinding
import com.squareup.picasso.Picasso

class DetalhesFilme : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesFilmeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesFilmeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val capaTheWitcher = "https://firebasestorage.googleapis.com/v0/b/netflix-clone-be917.appspot.com/o/download.jpeg?alt=media&token=ec8da1b1-adbf-466b-b3b0-747d22899e1a"
        Picasso.get().load(capaTheWitcher).fit().into(binding.ivCapa)



        val recycler_outros_filmes = binding.recyclerview2
        recycler_outros_filmes.adapter = FilmesAdapter(addFilmes())
        recycler_outros_filmes.layoutManager = GridLayoutManager(applicationContext, 3)

        binding.playVideo.setOnClickListener{
            val intent = Intent(this, Video::class.java)
            startActivity(intent)
        }
    }


    private fun Toolbar(){
        val toolbar_detalhes = binding.toolbarDetalhes
        toolbar_detalhes.setNavigationIcon(getDrawable(R.drawable.ic_back))
        toolbar_detalhes.setNavigationOnClickListener {
            val intent = Intent(this, ListaFilmes::class.java)
            startActivity(intent)
            finish()
        }
    }

}
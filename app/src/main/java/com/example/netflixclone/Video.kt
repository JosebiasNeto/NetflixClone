package com.example.netflixclone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.netflixclone.databinding.ActivityVideoBinding

class Video : AppCompatActivity() {

    private lateinit var binding: ActivityVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val videoUrl = Uri.parse ("https://firebasestorage.googleapis.com/v0/b/netflix-clone-be917.appspot.com/o/THE%20WITCHER%20_%20TRAILER%20PRINCIPAL%20_%20NETFLIX.mp4?alt=media&token=f80fc0fe-dfaf-48d0-b5e3-f3dda36a7faa")
        val video = binding.video
        video.setMediaController(MediaController(this))
        video.setVideoURI(videoUrl)
        video.requestFocus()
        video.start()
    }
}
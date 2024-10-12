package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_HERO = "extra_hero" // Kunci untuk menerima data
    }

    private lateinit var imgPhoto: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail) // Pastikan Anda memiliki layout ini

        // Inisialisasi view
        imgPhoto = findViewById(R.id.img_item_photo)
        tvName = findViewById(R.id.tv_item_name)
        tvDescription = findViewById(R.id.tv_item_description)

        // Menerima data dari Intent
        val hero = intent.getParcelableExtra<Hero>(EXTRA_HERO)
        if (hero != null) {
            populateHeroDetails(hero)
        }
    }

    // Metode untuk mengisi detail hero
    private fun populateHeroDetails(hero: Hero) {
        imgPhoto.setImageResource(hero.photo)
        tvName.text = hero.name
        tvDescription.text = hero.description
    }
}

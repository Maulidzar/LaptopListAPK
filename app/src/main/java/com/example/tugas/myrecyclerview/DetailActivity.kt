package com.example.tugas.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val laptop = intent.getParcelableExtra<Laptop>("LAPTOP")

        laptop?.let {
            findViewById<ImageView>(R.id.img_detail_photo).setImageResource(it.photo)
            findViewById<TextView>(R.id.tv_detail_name).text = it.name
            findViewById<TextView>(R.id.tv_detail_price).text = it.price
            findViewById<TextView>(R.id.tv_detail_information).text = it.description
        }

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            finish() //
        }
    }
}

package com.example.tugas.myrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvLaptop: RecyclerView
    private val list = ArrayList<Laptop>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvLaptop = findViewById(R.id.rv_laptop)
        rvLaptop.setHasFixedSize(true)
        list.addAll(getListLaptop())
        showRecyclerList()

        (rvLaptop.adapter as ListLaptopAdapter).setOnItemClickListener(object : ListLaptopAdapter.OnItemClickListener {
            override fun onItemClick(laptop: Laptop) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("LAPTOP", laptop)
                startActivity(intent)
            }
        })

        findViewById<Button>(R.id.about_page).setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }

    private fun getListLaptop(): ArrayList<Laptop> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val listLaptop = ArrayList<Laptop>()
        for (i in dataName.indices) {
            val laptop = Laptop(dataName[i], dataPrice[i], dataPhoto.getResourceId(i, -1), dataDescription[i])
            listLaptop.add(laptop)
        }
        return listLaptop
    }

    private fun showRecyclerList() {
        rvLaptop.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListLaptopAdapter(list)
        rvLaptop.adapter = listHeroAdapter
    }
}
package com.devspace.recyclerview

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)

        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }
    }
}

val contacts = listOf(
    Contact("Dani", "1234567890", R.drawable.sample1),
    Contact("Eduardo", "12393839", R.drawable.sample2),
    Contact("Paola", "4343567890", R.drawable.sample3),
    Contact("Matheus", "21323123", R.drawable.sample4),
    Contact("Joana", "454354444", R.drawable.sample5),
    Contact("Luana", "64565464", R.drawable.sample6),
    Contact("Renata", "76876876876", R.drawable.sample7),
    Contact("Abílio", "423423432", R.drawable.sample8),
    Contact("Marcelo", "5464352342", R.drawable.sample9),
    Contact("Caio", "654765867867", R.drawable.sample10),
    Contact("Maiara", "5342543643", R.drawable.sample11),
    Contact("Arthur", "32323232", R.drawable.sample12),
    Contact("Camila", "45364353464", R.drawable.sample13),
    Contact("Rodrigo", "4243254654654", R.drawable.sample14),
    Contact("Lara", "43654657676", R.drawable.sample15)
)
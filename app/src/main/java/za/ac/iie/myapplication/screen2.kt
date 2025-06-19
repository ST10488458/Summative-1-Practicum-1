package za.ac.iie.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen2)

        val songs = intent.getStringArrayListExtra("songs") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("artist's") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()
        val total = findViewById<TextView>(R.id.txtView)
        val displayList = mutableListOf<String>()
        for (i in songs.indices) {
            if (ratings[i] <= 5) {
                displayList.add("Song: ${songs[i]}, Artist: ${artists[i]}, Rating: ${ratings[i]}, Comments: ${comments[i]}")
            }
        }

        val listView = findViewById<ListView>(R.id.allView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, displayList)
        listView.adapter = adapter

        val average = findViewById<Button>(R.id.btnAverage)
        average.setOnClickListener {
        }

        val btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }}

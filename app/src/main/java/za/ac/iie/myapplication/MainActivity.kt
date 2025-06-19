package za.ac.iie.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val songTitle = mutableListOf<String>()
    private val artistName = mutableListOf<String>()
    private val ratingTxt = mutableListOf<Int>()
    private val comment = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val song = findViewById<EditText>(R.id.songTitle)
        val artist = findViewById<EditText>(R.id.artistName)
        val ratings = findViewById<EditText>(R.id.ratingTxt)
        val commentUser = findViewById<EditText>(R.id.comment)

        val add = findViewById<Button>(R.id.addBtn)
        val next = findViewById<Button>(R.id.btnNext)
        val exit = findViewById<Button>(R.id.closeBtn)

        add.setOnClickListener {
            try {
                val song = song.text.toString()
                val artist = artist.text.toString()
                val rating = ratings.text.toString().toInt()
                val comments = commentUser.text.toString()

                if (song.isNotEmpty() && artist.isNotEmpty()) {
                    songTitle.add(song)
                    artistName.add(artist)
                    ratingTxt.add(rating)
                    comment.add(comments)
                    Log.d("MainActivity", "Song added: $song, $artist, $rating, $comments")
                    Toast.makeText(this, "Song added", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Invalid quantity", Toast.LENGTH_SHORT).show()
                Log.e("MainActivity", "Error parsing quantity", e)
            }
        }

        next.setOnClickListener {
            val intent = Intent(this, screen2::class.java)
            intent.putStringArrayListExtra("songs", ArrayList(songTitle))
            intent.putStringArrayListExtra("artist's", ArrayList(artistName))
            intent.putIntegerArrayListExtra("ratings", ArrayList(ratingTxt))
            intent.putStringArrayListExtra("comments", ArrayList(comment))
            startActivity(intent)
        }

        exit.setOnClickListener {
            finish()


        }
    }
}
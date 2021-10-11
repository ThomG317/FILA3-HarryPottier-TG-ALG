package imt.legrand_gaubert

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class BookDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)
        val intent = intent
        val extras = intent.extras

        val imageView = findViewById<ImageView>(R.id.details_book_cover)
        val titleTextView = findViewById<TextView>(R.id.details_book_title)
        val pricetextView = findViewById<TextView>(R.id.details_price)
        val synopsisTextView = findViewById<TextView>(R.id.details_synopsis)

        Picasso.get().load(extras?.getString("BOOK_COVER")).into(imageView)
        titleTextView.text = extras?.getString("BOOK_TITLE")
        pricetextView.text = extras?.getInt("BOOK_PRICE").toString().plus(" €")
        synopsisTextView.text = extras?.getStringArrayList("BOOK_SYNOPSIS")?.joinToString("\n")
    }

}
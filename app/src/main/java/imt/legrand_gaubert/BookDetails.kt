package imt.legrand_gaubert

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import imt.legrand_gaubert.model.Book


class BookDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)
        val intent = intent
        val globalVariable: GlobalClass = applicationContext as GlobalClass
        val book = intent.getParcelableExtra<Book>("BOOK")
        val cart = globalVariable.appShopingCart

        val button = findViewById<Button>(R.id.details_button)
        val imageView = findViewById<ImageView>(R.id.details_book_cover)
        val titleTextView = findViewById<TextView>(R.id.details_book_title)
        val pricetextView = findViewById<TextView>(R.id.details_price)
        val synopsisTextView = findViewById<TextView>(R.id.details_synopsis)


        if (cart.find { it.isbn.equals(book?.isbn)} != null) {
            Log.i("TEST ALAN : ", "oui")
            button.isEnabled = false // fonctionne mais le style ne change pas
        }

        button.setOnClickListener {
            if (book != null) {
                cart.add(book)
            }
            globalVariable.appShopingCart = cart
        }

        Picasso.get().load(book?.cover).into(imageView)
        titleTextView.text = book?.title
        pricetextView.text = book?.price.toString().plus(" €")
        synopsisTextView.text = book?.synopsis?.joinToString("\n")
    }

}
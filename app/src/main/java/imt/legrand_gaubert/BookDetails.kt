package imt.legrand_gaubert

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import imt.legrand_gaubert.model.Book


class BookDetails : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val intent = this.activity?.intent
        val globalVariable: GlobalClass = this.activity?.applicationContext as GlobalClass
        val book = intent?.getParcelableExtra<Book>("BOOK")
        val cart = globalVariable.appShopingCart

        val button = this.activity?.findViewById<Button>(R.id.details_button)
        val imageView = this.activity?.findViewById<ImageView>(R.id.details_book_cover)
        val titleTextView = this.activity?.findViewById<TextView>(R.id.details_book_title)
        val pricetextView = this.activity?.findViewById<TextView>(R.id.details_price)
        val synopsisTextView = this.activity?.findViewById<TextView>(R.id.details_synopsis)


        if (cart.find { it.isbn.equals(book?.isbn)} != null) {
            button?.isEnabled ?: false
            button?.setTextColor(Color.GRAY)
            button?.setBackgroundColor(Color.LTGRAY)
            button?.text = "Déjà ajouté au panier !"
        }

        button?.setOnClickListener {
            if (book != null) {
                cart.add(book)
            }
            globalVariable.appShopingCart = cart
            button?.isEnabled ?: false
            button?.setTextColor(Color.GRAY)
            button?.setBackgroundColor(Color.LTGRAY)
            button?.text = "Déjà ajouté au panier !"
        }

        Picasso.get().load(book?.cover).into(imageView)
        titleTextView?.text = book?.title
        pricetextView?.text = book?.price.toString().plus(" €")
        synopsisTextView?.text = book?.synopsis?.joinToString("\n")
    }

}
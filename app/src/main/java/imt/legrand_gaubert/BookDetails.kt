package imt.legrand_gaubert

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import imt.legrand_gaubert.model.Book

class BookDetails : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.book_details, container, false)

        val globalVariable: GlobalClass = this.activity?.applicationContext as GlobalClass
        val cart = globalVariable.appShopingCart
        val book = arguments?.getParcelable<Book>("BOOK")
        val imageView = view?.findViewById<ImageView>(R.id.details_book_cover)
        val titleTextView = view?.findViewById<TextView>(R.id.details_book_title)
        val pricetextView = view?.findViewById<TextView>(R.id.details_price)
        val synopsisTextView = view?.findViewById<TextView>(R.id.details_synopsis)
        val button = view?.findViewById<Button>(R.id.details_button)

        if (book == null) {
            imageView?.visibility = GONE
            titleTextView?.visibility = GONE
            pricetextView?.text = "Aucun livre séletionné"
            pricetextView?.textAlignment = TEXT_ALIGNMENT_CENTER
            pricetextView?.setTextColor(Color.GRAY)
            synopsisTextView?.visibility = GONE
            button?.visibility = GONE
        } else {

            if (cart.find { it.isbn.equals(book?.isbn)} != null) {
                button?.isEnabled ?: false
                button?.setTextColor(Color.GRAY)
                button?.setBackgroundColor(Color.LTGRAY)
                button?.text = "Déjà ajouté au panier !"
            }

            button?.setOnClickListener {
                if (book != null) {
                    cart.add(book!!)
                }
                globalVariable.appShopingCart = cart
                button?.isEnabled ?: false
                button?.setTextColor(Color.GRAY)
                button?.setBackgroundColor(Color.LTGRAY)
                button?.text = "Déjà ajouté au panier !"
            }
            Log.i(null, view.toString())
            Picasso.get().load(book?.cover).into(imageView)
            titleTextView?.text = book?.title
            pricetextView?.text = book?.price.toString().plus(" €")
            synopsisTextView?.text = book?.synopsis?.joinToString("\n")
        }

        return view;
    }

}
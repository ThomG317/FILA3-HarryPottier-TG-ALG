package imt.legrand_gaubert.model

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import imt.legrand_gaubert.BookDetails
import imt.legrand_gaubert.R

class BookHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private val context: Context = view.context
    lateinit var book: Book

    val textView: TextView      = view.findViewById(R.id.item_title)
    val imageView: ImageView    = view.findViewById(R.id.item_image)

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(context, BookDetails::class.java)
        intent.putExtra("BOOK_TITLE", book.title)
        intent.putExtra("BOOK_PRICE", book.price)
        intent.putExtra("BOOK_COVER", book.cover)
        intent.putExtra("BOOK_SYNOPSIS", book.synopsis)
        context.startActivity(intent)
    }
}
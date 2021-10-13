package imt.legrand_gaubert.model

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import imt.legrand_gaubert.BookDetails
import imt.legrand_gaubert.ListBook
import imt.legrand_gaubert.R

class BookHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

    lateinit var listener: Listener
    private val context: Context = view.context
    lateinit var book: Book

    val textView: TextView      = view.findViewById(R.id.item_title)
    val imageView: ImageView    = view.findViewById(R.id.item_image)

    init {
        when (context) {
            is Listener -> listener = context
            else -> throw Exception("Not a listener of Listbook Activity")
        }
        view.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        listener.onBookSelected(book)
    }


    interface Listener {
        fun onBookSelected(item: Book)
    }
}
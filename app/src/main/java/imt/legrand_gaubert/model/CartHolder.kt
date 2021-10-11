package imt.legrand_gaubert.model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import imt.legrand_gaubert.R

class CartHolder(view: View) : RecyclerView.ViewHolder(view) {

    lateinit var book: Book

    val cartBookImageView: ImageView = view.findViewById(R.id.cartBookImage)
    val cartBookTitleView: TextView = view.findViewById(R.id.cartBookTitle)
    val cartBookPriceView: TextView = view.findViewById(R.id.cartBookPrice)

}
package imt.legrand_gaubert.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import imt.legrand_gaubert.R

class CartAdapter(private val dataSet: ArrayList<Book>) :
    RecyclerView.Adapter<CartHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item, parent, false)

        return CartHolder(view)
    }

    override fun onBindViewHolder(cartHolder: CartHolder, position: Int) {

        val book = dataSet[position]

        cartHolder.book = book
        Picasso.get().load(book.cover).into(cartHolder.cartBookImageView)
        cartHolder.cartBookTitleView.text = book.title
        cartHolder.cartBookPriceView.text = book.price.toString().plus(" €")
    }

    override fun getItemCount() = dataSet.size

}
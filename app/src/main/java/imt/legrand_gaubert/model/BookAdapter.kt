package imt.legrand_gaubert.model

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import imt.legrand_gaubert.R
import kotlinx.android.parcel.Parcelize

class BookAdapter(private var dataSet: Array<Book>) : RecyclerView.Adapter<BookHolder>() {

    fun setData(data: Array<Book>) {
        this.dataSet = data
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_item, parent, false)
        return BookHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(bookHolder: BookHolder, position: Int) {

        val book = dataSet[position]

        bookHolder.book = book
        bookHolder.textView.text = book.title
        Picasso.get().load(book.cover).into(bookHolder.imageView)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
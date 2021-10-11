package imt.legrand_gaubert.model

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import imt.legrand_gaubert.R

class BookHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

    val textView: TextView = view.findViewById(R.id.item_title)

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        Log.d("RecyclerView", "CLICK!")
    }
}
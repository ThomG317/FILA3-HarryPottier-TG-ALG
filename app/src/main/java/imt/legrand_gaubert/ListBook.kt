package imt.legrand_gaubert

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import imt.legrand_gaubert.api.Api
import imt.legrand_gaubert.model.Book
import imt.legrand_gaubert.model.BookAdapter
import imt.legrand_gaubert.model.BookHolder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListBook : Fragment() {

    lateinit var adapter: BookAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = this.activity?.findViewById<RecyclerView>(R.id.rvBooks)
        recyclerView?.layoutManager = GridLayoutManager(this.activity, 2)
        adapter = BookAdapter(emptyArray())
        recyclerView?.adapter = adapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // api setup
        val retrofit = Retrofit.Builder()
            .baseUrl("https://henri-potier.techx.fr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)

        api.getBooks().enqueue(object : Callback<Array<Book>> {
            override fun onResponse(call: Call<Array<Book>>, response: Response<Array<Book>>) {
                val books = response.body()?: emptyArray()
                adapter.setData(books)
            }
            override fun onFailure(call: Call<Array<Book>>, t: Throwable) {
            }
        })
    }

}
package imt.legrand_gaubert

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import imt.legrand_gaubert.api.Api
import imt.legrand_gaubert.model.Book
import imt.legrand_gaubert.model.BookAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ListBookActivity : Fragment() {

    lateinit var listener: Listener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            is Listener -> listener = context
            else -> throw Exception("Not a listner of ListbookActivity")
        }

        // api setup
        val retrofit = Retrofit.Builder()
            .baseUrl("https://henri-potier.techx.fr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)
        val recyclerView = this.activity?.findViewById<RecyclerView>(R.id.rvBooks)
        recyclerView?.layoutManager = GridLayoutManager(this.activity, 2)

        api.getBooks().enqueue(object : Callback<Array<Book>> {
            override fun onResponse(call: Call<Array<Book>>, response: Response<Array<Book>>) {
                val books = response.body()?: emptyArray()
                val adapter = BookAdapter(books)
                recyclerView?.adapter = adapter
            }
            override fun onFailure(call: Call<Array<Book>>, t: Throwable) {
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return listener.onOptionsItemSelected(item)
    }

    interface Listener {
        fun onOptionsItemSelected(item: MenuItem): Boolean
    }


}
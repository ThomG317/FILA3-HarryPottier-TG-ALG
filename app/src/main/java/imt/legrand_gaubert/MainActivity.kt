package imt.legrand_gaubert

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
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


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        // api setup
        val retrofit = Retrofit.Builder()
            .baseUrl("https://henri-potier.techx.fr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)
        val recyclerView = findViewById<RecyclerView>(R.id.rvBooks)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        api.getBooks().enqueue(object : Callback<Array<Book>> {
            override fun onResponse(call: Call<Array<Book>>, response: Response<Array<Book>>) {
                val books = response.body()?: emptyArray()
                val adapter = BookAdapter(books)
                recyclerView.adapter = adapter
            }
            override fun onFailure(call: Call<Array<Book>>, t: Throwable) {
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.cart_item -> {
                intent = Intent(this, ShopCart::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
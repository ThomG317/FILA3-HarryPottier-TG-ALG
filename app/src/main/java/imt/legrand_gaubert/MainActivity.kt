package imt.legrand_gaubert

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
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


class MainActivity : AppCompatActivity(), ListBookActivity.Listener {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState);
        setSupportActionBar(findViewById(R.id.toolbar))

        setContentView(R.layout.list_book_activity);
        supportFragmentManager.beginTransaction()
            .replace(R.id.list_book_activity, ListBookActivity(), ListBookActivity::class.java.name)
            .addToBackStack(ListBookActivity::class.java.name)
            .commit()
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
            else -> super<AppCompatActivity>.onOptionsItemSelected(item)
        }
    }

}
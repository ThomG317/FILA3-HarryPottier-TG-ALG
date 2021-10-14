package imt.legrand_gaubert

import android.content.Intent
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import imt.legrand_gaubert.model.Book
import imt.legrand_gaubert.model.BookHolder


class MainActivity : AppCompatActivity(), BookHolder.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT) {
            setContentView(R.layout.main_activity)
        } else {
            setContentView(R.layout.main_activity_land)
        }
        setSupportActionBar(findViewById(R.id.toolbar))

        if (getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fragment_fade_enter, R.anim.fragment_fade_exit)
                .replace(R.id.fragment, ListBook(), ListBook::class.java.name)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fragment_fade_enter, R.anim.fragment_fade_exit)
                .replace(R.id.fragment_list, ListBook(), ListBook::class.java.name)
                .commit()

            supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fragment_fade_enter, R.anim.fragment_fade_exit)
                .replace(R.id.fragment_detail, BookDetails(), BookDetails::class.java.name)
                .commit()
        }
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

    override fun onBookSelected(item: Book) {
        val fragment = BookDetails()
        val args =  Bundle()
        args.putParcelable("BOOK", item)
        fragment.arguments = args

        if (getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fragment_open_enter, R.anim.fragment_close_exit)
                .replace(R.id.fragment, fragment, BookDetails::class.java.name)
                .addToBackStack(BookDetails::class.java.name)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_detail, fragment, BookDetails::class.java.name)
                .addToBackStack(BookDetails::class.java.name)
                .commit()
        }
    }

}
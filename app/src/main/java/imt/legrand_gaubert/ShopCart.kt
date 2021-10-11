package imt.legrand_gaubert

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import imt.legrand_gaubert.model.CartAdapter

class ShopCart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_cart)

        val globalVariable: GlobalClass = applicationContext as GlobalClass

        val booksInCart = globalVariable.appShopingCart

        val recyclerView = findViewById<RecyclerView>(R.id.rvCart)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        val adapter = CartAdapter(booksInCart)
        recyclerView.adapter = adapter

    }
}
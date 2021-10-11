package imt.legrand_gaubert

import android.app.Application
import imt.legrand_gaubert.model.Book

class GlobalClass : Application() {

    var appShopingCart: ArrayList<Book> = ArrayList()

}
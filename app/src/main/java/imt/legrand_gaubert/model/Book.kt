package imt.legrand_gaubert.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Book (
    val isbn: String,
    val title: String,
    val price: Int,
    val cover: String,
    val synopsis: ArrayList<String>,
) : Parcelable {
    override fun toString(): String {
        return "Book(isbn='$isbn', title='$title', price='$price', cover='$cover', synopsis=${synopsis.toString()})"
    }
}
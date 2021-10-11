package imt.legrand_gaubert.model

class Book(
    val isbn: String,
    val title: String,
    val price: Int,
    val cover: String,
    val synopsis: ArrayList<String>,
) {
    override fun toString(): String {
        return "Book(isbn='$isbn', title='$title', price='$price', cover='$cover', synopsis=${synopsis.toString()})"
    }
}
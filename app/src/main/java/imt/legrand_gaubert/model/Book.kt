package imt.legrand_gaubert.model

class Book(
    val isbn: String,
    val title: String,
    val cover: String,
    val synopsis: Array<String>,
) {
    override fun toString(): String {
        return "Book(isbn='$isbn', title='$title', cover='$cover', synopsis=${synopsis.contentToString()})"
    }
}
package imt.legrand_gaubert.api

import imt.legrand_gaubert.model.Book
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("books")
    fun getBooks(): Call<Array<Book>>

}
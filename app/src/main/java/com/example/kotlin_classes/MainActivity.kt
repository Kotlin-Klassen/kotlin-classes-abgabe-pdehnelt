package com.example.kotlin_classes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlin_classes.abschluss_abgabe.BookStatus
import com.example.kotlin_classes.abschluss_abgabe.Book
import com.example.kotlin_classes.abschluss_abgabe.Genre
import com.example.kotlin_classes.abschluss_abgabe.Library


class MainActivity : AppCompatActivity() {
    private lateinit var tvLibraryInfo: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvLibraryInfo = findViewById(R.id.tvLibraryInfo)

        val library = Library()

        val address = Library.LibraryAddress("123 Library St.", "Be happy", "12345")
        address.printAddress()

        val book1 = Book("Das letzte Einhorn", "Arthur Rankin", Genre.FICTION, BookStatus.Available)
        val book2 = Book("Der König der Löwen", "Chris Sanders", Genre.CHILDREN, BookStatus.Available)
        val book3 = Book("Murder on the Orient Express", "Agatha Christie", Genre.NON_FICTION, BookStatus.Available)

        library.addBook(book1)
        library.addBook(book2)
        library.addBook(book3)

        val member = library.LibraryMember("Carl Heinz", 1)
        member.checkoutBook(book1, "2024-10-15")
        member.reserveBook(book2)

        library.displayAllBooks { bookInfo -> updateUI(bookInfo) }
    }
    private fun updateUI(message: String) {
        tvLibraryInfo.append("$message\n")
    }
}
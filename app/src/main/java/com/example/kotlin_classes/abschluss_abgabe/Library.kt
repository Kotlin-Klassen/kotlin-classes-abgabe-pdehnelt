package com.example.kotlin_classes.abschluss_abgabe

import com.example.kotlin_classes.classes.nested_inner.Library


class Library {
    private val books = mutableListOf<Books>()

    class LibraryAddress(val street: String, val city: String, val zipCode: String) {
        fun printAddress() {
            println("Address: $street, $city, $zipCode")
        }
    }


    inner class LibraryMember(val name: String, val memberID: Int) {
        fun checkoutBook(book: Books, dueDate: String) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                println("$name checked out ${book.title} until $dueDate")
            } else {
                println("${book.title} is not available for checkout.")
            }
        }

        fun reserveBook(book: Books) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                println("$name reserved ${book.title}")
            } else {
                println("${book.title} cannot be reserved.")
            }
        }
    }

    fun addBook(book: Books) {
        books.add(book)
        println("Added: ${book.title}")
    }

    fun searchBookByTitle(title: String) {
        books.filter { it.title.equals(title, ignoreCase = true) }.forEach {
            println("Found: ${it.title} by ${it.author}")
        }
    }

    fun searchBookByAuthor(author: String) {
        books.filter { it.author.equals(author, ignoreCase = true) }.forEach {
            println("Found: ${it.title} by ${it.author}")
        }
    }



    fun displayAllBooks(onDisplay: (String) -> Unit) {
        books.forEach {
            val bookInfo = "${it.title} by ${it.author}, Genre: ${it.genre}, Status: "
            onDisplay(bookInfo)
            onDisplay(it.status.toStatusString())
        }
    }

    fun BookStatus.toStatusString(): String {
        return when (this) {
            is BookStatus.Available -> "Available"
            is BookStatus.CheckedOut -> "Checked out until $dueDate"
            is BookStatus.Reserved -> "Reserved by $reservedBy"
        }
    }
}

fun main() {
    // Erstellen einer Nested Class-Instanz
    val book = Library.Book("Kotlin Programming", "John Doe")
    println(book.getBookInfo())  // Ausgabe: "Book Title: Kotlin Programming, Author: John Doe"

    // Erstellen einer Library-Instanz und einer Inner Class-Instanz
    val myLibrary = Library("City Library")
    val librarian = myLibrary.Librarian("Alice Smith")
    println(librarian.getLibrarianInfo())  // Ausgabe: "Librarian: Alice Smith, Library: City Library"
}
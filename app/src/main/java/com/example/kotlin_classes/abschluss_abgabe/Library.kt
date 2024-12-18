package com.example.kotlin_classes.abschluss_abgabe

import com.example.kotlin_classes.classes.nested_inner.Library


class Library {
    private val books = mutableListOf<Book>()

    class LibraryAddress(val street: String, val city: String, val zipCode: String) {
        fun printAddress() {
            println("Address: $street, $city, $zipCode")
        }
    }


    inner class LibraryMember(val name: String, val memberID: Int) {
        fun checkoutBook(book: Book, dueDate: String) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                println("$name checked out ${book.title} until $dueDate")
            } else {
                println("${book.title} is not available for checkout.")
            }
        }

        fun reserveBook(book: Book) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                println("$name reserved ${book.title}")
            } else {
                println("${book.title} cannot be reserved.")
            }
        }
    }

    fun addBook(book: Book) {
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
    val library = Library()

    val book1 = Book("Das letzte Einhorn", "Arthur Rankin", Genre.FICTION, BookStatus.Available)
    val book2 = Book("Das letzte Einhorn", "Arthur Rankin", Genre.FICTION, BookStatus.Available)
    val book3 = Book("Murder on the Orient Express", "Agatha Christie", Genre.NON_FICTION, BookStatus.Available)

    library.addBook(book1)
    library.addBook(book2)
    library.addBook(book3)

    library.searchBookByTitle("Das letzte Einhorn")
    library.searchBookByAuthor("Agatha Christie")

    val member = library.LibraryMember("Karl Heinz", 101)
    member.checkoutBook(book1, "2028-06-06")
    member.reserveBook(book3)

    println("\nCurrent Library Inventory:")
    library.displayAllBooks { info -> println(info) }
}

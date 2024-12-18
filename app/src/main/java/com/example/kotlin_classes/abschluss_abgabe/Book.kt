package com.example.kotlin_classes.abschluss_abgabe

data class Book(
    val title : String,
    val author : String,
    val genre : Genre,
    var status : BookStatus
)

fun main() {
    // Buchinstanzen erstellen
    val book1 = Book("Das letzte Einhorn", "Arthur Rankin", Genre.FICTION, BookStatus.Available)
    val book2 = Book("Das letzte Einhorn", "Arthur Rankin", Genre.FICTION, BookStatus.Available)
    val book3 = Book("Murder on the Orient Express", "Agatha Christie", Genre.NON_FICTION, BookStatus.Available)

    // Vergleich der beiden Bücher mit equals()
    println(".equals() Methoden:\n${book1 == book2}\n${book1 == book3} \n")
    println()

    // Ausgabe mit toString()
    println(".toString() Methode\n"+book1+"\n")


    // Kopieren und Ändern eines Buches mit copy()
    val book1Copy = book1.copy(title = "Der Bobbit", author = "Jo", status = BookStatus.CheckedOut("2024-12-30"))
    println(".copy() Methode:\n$book1\n$book1Copy \n")
    println()

    // Komponenten mit componentN() anzeigen
    println("Book1 Komponente 1: ${book1.component1()}\nBook1 Komponente 2: ${book1.component2()} \n")
    println()

    // Hashcodes anzeigen
    println("Hash-Code von book1: ${book1.hashCode()}")
    println("Hash-Code von book2: ${book2.hashCode()}")
    println("Hash-Code von book3: ${book3.hashCode()}")
}
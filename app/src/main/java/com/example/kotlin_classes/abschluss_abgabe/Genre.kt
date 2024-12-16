package com.example.kotlin_classes.abschluss_abgabe

enum class Genre(val genre: String) {
    FICTION("Fictional stories and novels"),
    NON_FICTION("Non-Fictional stories and novels"),
    SCIENCE("Scientific books"),
    HISTORY("Historical books"),
    CHILDREN("Children books");

    fun printDescription() {
        println(genre)
    }
}

fun main() {
    // Alle Genres anzeigen
    println("Verfügbare Genres:")
    for (genre in Genre.values()) {
        println("- ${genre.name}: ${genre.genre}")
    }

    println("\nBeschreibungen anzeigen mit printDescription():")
    Genre.FICTION.printDescription()
    Genre.SCIENCE.printDescription()

    // Genre vergleichen
    println("\nVergleich von Genres:")
    val genre1 = Genre.FICTION
    val genre2 = Genre.SCIENCE
    val genre3 = Genre.FICTION

    println("genre1 == genre2: ${genre1 == genre2}")
    println("genre1 == genre3: ${genre1 == genre3}")

    // Überprüfen, ob ein Genre existiert
    val searchGenre = "HISTORY"
    val foundGenre = try {
        Genre.valueOf(searchGenre)
    } catch (e: IllegalArgumentException) {
        null
    }

    if (foundGenre != null) {
        println("\nGefundenes Genre: ${foundGenre.name} - ${foundGenre.genre}")
    } else {
        println("\nGenre '$searchGenre' existiert nicht.")
    }
}
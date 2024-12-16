package com.example.kotlin_classes.abschluss_abgabe



sealed class BookStatus {
    object Available : BookStatus()
    data class CheckedOut(val dueDate: String) : BookStatus()
    data class Reserved(val reservedBy: String) : BookStatus()

    fun printStatus() {
        when (this) {
            is Available -> println("Available")
            is CheckedOut -> println("Checked out until $dueDate")
            is Reserved -> println("Reserved by $reservedBy")
        }
    }


}

fun main() {
    val availableBook = BookStatus.Available
    val checkedOutBook = BookStatus.CheckedOut("2020-12-31")
    val reservedBook = BookStatus.Reserved("Karl Heinz")

    availableBook.printStatus()
    checkedOutBook.printStatus()
    reservedBook.printStatus()
}

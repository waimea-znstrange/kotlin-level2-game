/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Chain Reaction
 * Project Author: Zeb Strange
 * GitHub Repo:    https://github.com/waimea-znstrange/kotlin-level2-game
 * ---------------------------------------------------------------------
 * Notes:
 * This is an implementation of the Chain Reaction game
 * =====================================================================
 */

// Box Drawings ┻ ┳ ┫ ┣ ┏ ┓ ┛ ┗ ┃ ━

//Global variables
val boxes = mutableListOf<String>()
val empty = " ⃠ "

fun main() {
    //Heading
    println("┏━━━━━━━━━━━━━━━━━━━━━━━┓")
    println("┃  Chain Reaction Game  ┃")
    println("┗━━━━━━━━━━━━━━━━━━━━━━━┛")

    getUserNames()
    createBoxes()
    showBoxes()
}

fun createBoxes() {
    repeat(12) {
        boxes.add(empty)
    }
}

fun showBoxes(){
    //Box labels
    for (i in 1..boxes.size) {
        print("  $i  ")
    }
    println()

    //Top border
    println("┏━━━━" + "┳━━━━".repeat(boxes.size - 1) + "┓")

    //Box contents
    for (box in boxes){
        print("┃ ${box.padEnd(4)}")
    }
    println("┃")

    //Bottom border
    println("┗━━━━" + "┻━━━━".repeat(boxes.size - 1) + "┛")
}

fun getUserNames() {
    var userName1: String
    while (true) {
        println("Player 1: ")
        userName1 = readln()
        if (userName1.isNotBlank()) break
    }
    var userName2: String
    while (true) {
        println("Player 2: ")
        userName2 = readln()
        if (userName2.isNotBlank()) break
    }
}


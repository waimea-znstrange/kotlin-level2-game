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

// Box Drawings ┻ ┳ ┫ ┣ ┏ ┓ ┛ ┗ ┃ ━   ⃠
// Player 1: ♥♦♠♣
// Player 2: ♡♢♤♧

//Global variables
val boxes = mutableListOf<String>()
val empty = ""


fun main() {
    //Heading
    println("┏━━━━━━━━━━━━━━━━━━━━━━━┓")
    println("┃  Chain Reaction Game  ┃")
    println("┃  By Zeb Strange       ┃")
    println("┗━━━━━━━━━━━━━━━━━━━━━━━┛")

    getUserNames()
    createBoxes()
    showBoxes()
    getPlayer1Move()
    makeMove()

//    checkForWin()
//    fun score()
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
        print("┃ ${box.padEnd(3)}")
    }
    println("┃")

    //Bottom border
    println("┗━━━━" + "┻━━━━".repeat(boxes.size - 1) + "┛")
}

var user1 = ""
var user2 = ""
var userSymbol1 = ""
var userSymbol2 = ""

fun getUserNames() {
    // Ask for player 1 name
    var userName1: String
    while (true) {
        print("Player 1 name: ")
        userName1 = readln()
        println()
        if (userName1.isNotBlank()) break
    }

    // Ask for player 1 symbol
    println("Pick a symbol:")
    println("[1]●")
    println("[2]■")
    println("[3]▴")
    println("[4]")
    println("Choice: ")

    var symbol1 = readln()

    when {
        symbol1 == "1" -> symbol1 = "♥"
        symbol1 == "2" -> symbol1 = "♦"
        symbol1 == "3" -> symbol1 = "♠"
        symbol1 == "4" -> symbol1 = "♣"
    }
    println("$userName1 chose $symbol1 as their symbol")
    println()
    println()
    user1 = userName1
    userSymbol1 = symbol1

    // Ask for player 2 name
    var userName2: String
    while (true) {
        print("Player 2 name: ")
        userName2 = readln()
        println()
        if (userName2.isNotBlank()) break
    }

    // Ask for player 2 symbol
    println("Pick a symbol:")
    println("[1]○")
    println("[2]□")
    println("[3]▵")
    println("[4]")
    println("Choice: ")

    var symbol2 = readln()

    when {
        symbol2 == "1" -> symbol2 = "♡"
        symbol2 == "2" -> symbol2 = "♢"
        symbol2 == "3" -> symbol2 = "♤"
        symbol2 == "4" -> symbol2 = "♧"
    }
    println("$userName2 chose $symbol2 as their symbol")
    println()
    println()
    user2 = userName2
    userSymbol2 = symbol2
}


fun getPlayer1Move() {
    while (true) {
        var position: Int?
        while (true) {
            println("$user1, choose a square: ")
            position = readlnOrNull()?.toIntOrNull()
            if (position != null && position in 1..12) break
        }

        val index = position!! - 1

        if (boxes[index] == empty){
            boxes[index] = userSymbol1
            break
        } else {
            println("This box is taken!")
        }
    }
}
//fun getPlayer2Move() {
//
// }


fun makeMove() {
    for (i in 1..boxes.size) {

    }
}



//fun score() {
//
//}
//
//fun checkForWin() {
//
//}
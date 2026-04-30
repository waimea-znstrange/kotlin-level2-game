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
// Player 1: ●■▲◆
// Player 2: ○□△◇

//Global variables
val boxes = mutableListOf<String>()
val empty = ""
var user1 = ""
var user2 = ""
var userSymbol1 = ""
var userSymbol2 = ""
var p1score = "0"
var p2score = "0"

fun main() {
    //Heading
    println("┏━━━━━━━━━━━━━━━━━━━━━━━┓".bgRed())
    println("┃  Chain Reaction Game  ┃".bgMagenta())
    println("┃  By Zeb Strange       ┃".bgBlue())
    println("┗━━━━━━━━━━━━━━━━━━━━━━━┛".bgCyan())

    getUserNames()
    createBoxes()
    while (true) {
        showBoxes()
        getPlayer1Move()
        checkForExplosion1()
        checkForDefuse1()
//        checkForWin()

        showBoxes()
        getPlayer2Move()
        checkForExplosion2()
        checkForDefuse2()
//        checkForWin()
//        score()
    }
}


fun createBoxes() {
    repeat(12) {
        boxes.add(empty)
    }
}


fun showBoxes(){
    //Box labels
    for (i in 1..boxes.size) {
        print("   $i  ".blue())
    }
    println()

    //Top border
    println("┏━━━━━".blue() + "┳━━━━━".repeat(boxes.size - 1).blue() + "┓".blue())

    //Box contents
    for (box in boxes){
        print("┃  ${box.padEnd(3)}".blue())
    }
    println("┃".blue())

    //Bottom border
    println("┗━━━━━".blue() + "┻━━━━━".repeat(boxes.size - 1).blue() + "┛".blue())
}



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
    println("[3]▲")
    println("[4]◆")
    println("Choice: ")

    var symbol1 = readln()
// change symbol1 variable to the selected symbol
    when {
        symbol1 == "1" -> symbol1 = "●"
        symbol1 == "2" -> symbol1 = "■"
        symbol1 == "3" -> symbol1 = "▲"
        symbol1 == "4" -> symbol1 = "◆"
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
    println("[3]△")
    println("[4]◇")
    println("Choice: ")

    var symbol2 = readln()
// change symbol2 variable to the selected symbol
    when {
        symbol2 == "1" -> symbol2 = "○"
        symbol2 == "2" -> symbol2 = "□"
        symbol2 == "3" -> symbol2 = "△"
        symbol2 == "4" -> symbol2 = "◇"
    }
    println("$userName2 chose $symbol2 as their symbol")
    println()
    println()
    user2 = userName2
    userSymbol2 = symbol2
}
// make global variable for p1placement
var placement1 = 0
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
            placement1 = position
            break
        } else {
            println("This box is taken!")
        }
    }
}
// make global variable for p2placement
var placement2 = 0
fun getPlayer2Move() {
    while (true) {
        var position: Int?
        while (true) {
            println("$user2, choose a square: ")
            position = readlnOrNull()?.toIntOrNull()
            if (position != null && position in 1..12) break
        }

        val index = position!! - 1

        if (boxes[index] == empty){
            boxes[index] = userSymbol2
            placement2 = position
            break
        } else {
            println("This box is taken!")
        }
    }
}


fun checkForExplosion1() {
    var totalCounter = 1
    val index = placement1 - 1
    var right = index + 1
    while (right < boxes.size && boxes[right] == userSymbol1) {
        totalCounter++
        right++
    }
    var left = index - 1
    while (left >= 0 && boxes[left] == userSymbol1) {
        totalCounter++
        left--
    }
    // if total counters is 3 or more: replace the bombs for empty
    if (totalCounter >= 3) {
        for (placement1 in right - 1 downTo left + 1) {
            boxes[placement1] = empty
        }
    println("KABOOM!")
    }
}

fun checkForExplosion2() {
    var totalCounter = 1
    val index = placement2 - 1
    var right = index + 1
    while (right < boxes.size && boxes[right] == userSymbol2) {
        totalCounter++
        right++
    }
    var left = index - 1
    while (left >= 0 && boxes[left] == userSymbol2) {
        totalCounter++
        left--
    }
    // if total counters is 3 or more: replace the bombs for empty
    if (totalCounter >= 3) {
        for (placement2 in right - 1 downTo left + 1) {
            boxes[placement2] = empty
        }
        println("KABOOM!")
    }
}

fun checkForDefuse1() {
    val index = placement2 - 1
    var right = index + 1
    while (right < boxes.size && boxes[right] == userSymbol2) {
        right++
    }
    var left = index - 1
    while (left >= 0 && boxes[left] == userSymbol2) {
        left--
    }
    if (boxes[right] == userSymbol1 && boxes[left] == userSymbol1) {
        for (counter1 in right - 1 downTo left + 1) {
            boxes[counter1] = empty
        }
    println("$user2's bomb defused!")
    }
}

fun checkForDefuse2() {
    val index = placement1 - 1
    var right = index + 1
    while (right < boxes.size && boxes[right] == userSymbol1) {
        right++
    }
    var left = index - 1
    while (left >= 0 && boxes[left] == userSymbol1) {
        left--
    }
    if (boxes[right] == userSymbol2 && boxes[left] == userSymbol2) {
        for (counter1 in right - 1 downTo left + 1) {
            boxes[counter1] = empty
        }
        println("$user1's bomb defused!")
    }
}

//fun checkForDefuse2() {
//
//}
//
//fun score()
//
//}
//
//fun checkForWin() {
//
//}
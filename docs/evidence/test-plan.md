# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## Input: Placing a counter - Valid

The player must place a counter in an open position between the spaces of the box labeled 1 - 12

### Test Data Used

A valid counter must be placed in an empty box

### Expected Test Result

When the user inputs a number to pick where they want to place, The code should place the symbol in that box.

---

## Input: Test if Name is Not Blank - Valid

I will test that players can enter a name and it is accepted

### Test Data Used

I will try to enter a  valid, non-blank name: **Zeb**.

### Expected Test Result

The code should let the game be able to continue when a valid name is entered.

---

### Input: If Name is Blank - Invalid

The user must put in a valid name.

### Test Data Used

A valid name is a name that is not blank.

### Expected Test Result

The game should keep asking you to enter a name ("Player 1 name: ") until you enter a valid name.

---

### Input: Test for Invalid positioning - Invalid

The user cant place their symbol in between two of the opponents symbols.

### Test Data Used

t cannot place in between z's symbols.

### Expected Test Result

The code should keep printing ("This box is taken!") then ("choose a square: ") until you pick a valid position on the board.

---

## Input: Test for explosion - Valid

explosion when 3 counters align on the board.

### Test Data Used

t's symbol.

### Expected Test Result

When 3 or more of one of the players counters align it should explode and those players counters will be removed freeing
up space on the board.

---

## Gameplay: Winner Detection - Valid

I will test that when a players counters explode they will get the number of counters
exploded added to their score and once their score reaches 10 they win.

### Test Data Used

6

### Expected Test Result

The game should output text showing 
z's score = 10 (or more)
z wins!"

---

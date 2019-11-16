import kotlin.random.Random

fun main()
{
    do {
        val victory = guessTheNumber()
        if (!victory) println("\nRestart")
    }while (!victory)
}

fun guessTheNumber() : Boolean
{
    val randomNumber: Int = Random.nextInt(1,101) //101 is not included

    println("Enter number 1 to select easy")
    println("Enter number 2 to select medium")
    println("Enter number 3 to select hard")


    //difficultyAsString is a string version of user input
    val difficultyAsString: String? = readLine()
    val difficulty: Int
    if (difficultyAsString != null) {
        difficulty = difficultyAsString.toInt()
    }
    else {
        return false
    }


    var steps: Int = when (difficulty) {
        1 -> 7
        2 -> 5
        3 -> 3
        else -> return false
    }


    println("Enter a number between 1 and 100")
    println("You have $steps steps")


    while (steps > 0) {
        //choiceAsString is a string version of user input
        val choiceAsString: String? = readLine()
        val choice: Int
        if (choiceAsString != null) {
            choice = choiceAsString.toInt()
        }
        else {
            return false
        }
        if (choice > randomNumber) println("take lower")
        else if (choice < randomNumber) println("take higher")
        else {
            println("You Won")
            break
        }
        steps--
    }

    //if steps is equal to zero that means you lost the game and you need to replay it,
    //otherwise you win
    return steps != 0
}




import java.util.*

class UI {
    private val game = Game()
    private val ai = AIPlayer();

    fun playGame() {
        val scanner = Scanner(System.`in`)
        var userInput: String?

        println("Welcome to the game!")
        println("Commands: W (Up), S (Down), A (Left), D (Right), Q (Quit)")

        while (true) {
            println("\nCurrent Board:")
            println(this)

            print("Enter a command: ")
            userInput = scanner.nextLine().trim().uppercase(Locale.getDefault())

            when (userInput) {
                "W" -> game.moveUp()
                "S" -> game.moveDown()
                "A" -> game.moveLeft()
                "D" -> game.moveRight()
                "Q" -> {
                    println("Thanks for playing!")
                    return
                }
                else -> println("Invalid command. Please try again.")
            }

            if (game.isGameWon()) {
                println("You've won! Congratulations")
                return
            }
        }
    }

    fun playGameAI() {
        println("Welcome to the AI game!")

        while (true) {
            println("\nCurrent Board:")
            println(this)

            if (game.isGameWon()) {
                println("AI Player has won! Congratulations")
                return
            }

            ai.playGame(game)
        }
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()

        for (i in 0 until game.getBoardSize()) {
            for (j in 0 until game.getBoardSize()) {
                if (game.getBoard()[i][j] == -1)
                    stringBuilder.append(' ')
                else
                    stringBuilder.append(game.getBoard()[i][j])
                stringBuilder.append("\t")
            }
            stringBuilder.appendLine()
        }
        return stringBuilder.toString()
    }
}
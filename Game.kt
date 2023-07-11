class Game {
    enum class Directions {
        North,
        South,
        East,
        West
    }

    private val boardSize = 4;
    private var board: Array<Array<Int>> = Array(boardSize) { Array(boardSize) { 0 } }

    init {
        val numbers = (1..15).toList() + listOf(-1)
        val shuffledNumbers = numbers.shuffled()

        var index = 0
        for (i in 0 until boardSize) {
            for (j in 0 until boardSize) {
                board[i][j] = shuffledNumbers[index++]
            }
        }
    }

    fun getBoard() = board

    fun getBoardSize() = boardSize;

    fun moveUp() {
        makeMove(Directions.North)
    }

    fun moveDown() {
        makeMove(Directions.South)
    }

    fun moveRight() {
        makeMove(Directions.East)
    }

    fun moveLeft() {
        makeMove(Directions.West)
    }

    fun isGameWon(): Boolean {
        var value = 1
        for (i in 0 until boardSize) {
            for (j in 0 until boardSize) {
                if (board[i][j] != value) {
                    return false
                }
                value++
                if (value == boardSize * boardSize) {
                    break
                }
            }
        }
        return true
    }

    private fun makeMove(direction: Directions) {
        val emptyPosition = findEmptyPosition()

        when (direction) {
            Directions.North -> moveTile(emptyPosition.first, emptyPosition.second, emptyPosition.first - 1, emptyPosition.second)
            Directions.South -> moveTile(emptyPosition.first, emptyPosition.second, emptyPosition.first + 1, emptyPosition.second)
            Directions.East -> moveTile(emptyPosition.first, emptyPosition.second, emptyPosition.first, emptyPosition.second + 1)
            Directions.West -> moveTile(emptyPosition.first, emptyPosition.second, emptyPosition.first, emptyPosition.second - 1)
        }
    }

    private fun moveTile(row1: Int, col1: Int, row2: Int, col2: Int) {
        if (isValidPosition(row1, col1) && isValidPosition(row2, col2)) {
            val temp = board[row1][col1]
            board[row1][col1] = board[row2][col2]
            board[row2][col2] = temp
        }
    }

    private fun isValidPosition(row: Int, col: Int): Boolean = row in 0 until boardSize && col in 0 until boardSize

    private fun findEmptyPosition(): Pair<Int, Int> {
        for (i in 0 until boardSize) {
            for (j in 0 until boardSize) {
                if (board[i][j] == -1) {
                    return Pair(i, j)
                }
            }
        }
        return Pair(-1, -1)
    }
}

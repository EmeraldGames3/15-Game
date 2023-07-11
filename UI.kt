class UI {
    private val game = Game();

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
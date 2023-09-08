package hangman.model;

public interface GameScore {

    /**
     * @param correctCount   numero de letras correctas
     * @param incorrectCount numero de letras incorrectas
     * @return score
     */
    default int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        return 0;
    }
}
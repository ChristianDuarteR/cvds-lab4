package hangman.model;

public interface GameScore {

    /**
     * @param CorrectCount   numero de letras correctas
     * @param IncorrectCount numero de letras incorrectas
     * @return score
     */
    default int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        return 0;
    }
}
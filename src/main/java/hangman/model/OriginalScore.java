package hangman.model;

public class OriginalScore implements GameScore {
    /**
     * @pre Se inicia con 100 puntos, puntaje mínimo 0
     * @pos Se penaliza con 10 puntos por cada letra incorrecta
     * @param correctCount número de letras correctas
     * @param incorrectCount número de letras incorrectas
     * @return Puntaje calculado
     */
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        if (correctCount < 0 || incorrectCount < 0) {
            throw new GameScoreException(GameScoreException.INVALID_PARAMETERS);
        }


        int score = 100;

        // Penalización por letras incorrectas
        if(incorrectCount > 0 ){
            score -= incorrectCount * 10;
        }

        if(score < 0 ){ score = 0;}

        return score;
    }
}

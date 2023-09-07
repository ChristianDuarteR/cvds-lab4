package hangman.model;

public class OriginalScore implements GameScore {
    /**
     * @pre Se inicia con 100 puntos, puntaje mínimo 0
     * @pos Se penaliza con 10 puntos por cada letra incorrecta
     * @param CorrectCount número de letras correctas
     * @param IncorrectCount número de letras incorrectas
     * @return Puntaje calculado
     */
    public int CalculateScore(int CorrectCount, int IncorrectCount) throws GameScoreException {
        if (CorrectCount < 0 || IncorrectCount < 0) {
            throw new GameScoreException(GameScoreException.INVALID_PARAMETERS);
        }

        int score = 100;

        // Penalización por letras incorrectas
        score -= 10 * IncorrectCount;

        // Limitar el puntaje mínimo a 0
        if (score < 0) {
            score = 0;
        }

        return score;
    }
}
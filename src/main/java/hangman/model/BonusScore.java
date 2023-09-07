package hangman.model;

public class BonusScore implements GameScore {
    /**
     * @pre Inicia con 0 puntos, puntaje mínimo 0
     * @pos Se bonifica con 10 puntos cada letra correcta, se penaliza con 5 puntos cada letra incorrecta
     * @param CorrectCount número de letras correctas
     * @param IncorrectCount número de letras incorrectas
     * @return Puntaje calculado
     */
    public int CalculateScore(int CorrectCount, int IncorrectCount) throws GameScoreException {
        if (CorrectCount < 0 || IncorrectCount < 0) {
            throw new GameScoreException(GameScoreException.INVALID_PARAMETERS);
        }

        int score = 0;

        // Bonificación por letras correctas
        score += 10 * CorrectCount;

        // Penalización por letras incorrectas
        score -= 5 * IncorrectCount;

        // Limitar el puntaje mínimo a 0
        if (score < 0) {
            score = 0;
        }

        // Limitar el puntaje máximo a 500
        if (score > 500) {
            score = 500;
        }

        return score;
    }
}
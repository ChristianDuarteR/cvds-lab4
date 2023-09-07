package hangman.model;

public class PowerBonusScore implements GameScore {
    /**
     * @pre Inicia con 0 puntos, puntaje mínimo 0
     * @pos Se bonifica con 5^i puntos cada letra correcta, se penaliza con 8 puntos por letra incorrecta
     * @param CorrectCount número de letras correctas
     * @param IncorrectCount número de letras incorrectas
     * @return Puntaje calculado
     */
    public int calculateScore(int correctCount, int incorrectCount) throws GameScoreException {
        if (CorrectCount < 0 || IncorrectCount < 0) {
            throw new GameScoreException(GameScoreException.INVALID_PARAMETERS);
        }

        int score = 0;

        // Bonificación por letras correctas
        for (int i = 0; i < CorrectCount; i++) {
            score += Math.pow(5, i);
        }

        // Penalización por letras incorrectas
        score -= 8 * IncorrectCount;

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

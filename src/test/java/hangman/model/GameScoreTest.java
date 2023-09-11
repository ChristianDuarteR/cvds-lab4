package hangman.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameScoreTest {
    private  GameScore original;
    private  GameScore bonus;
    private GameScore power;

    @Before
    public void setUp() {
        original = new OriginalScore();
        bonus = new BonusScore();
        power = new PowerBonusScore();

    }

    @Test
    public void TestShouldCatchAnExceptionBonusScore(){
        try{
            int score = bonus.calculateScore(-1,0);
            fail("Deberia agarrar una excepcionx");
        }catch (GameScoreException e){
            assertEquals(e.getMessage(),GameScoreException.INVALID_PARAMETERS);
        }
    }

    @Test
    public void TestShouldCatchAnExceptionOriginalScore(){
        try{
            int score = original.calculateScore(-1,0);
            fail("Deberia agarrar una excepcionx");
        }catch (GameScoreException e){
            assertEquals(e.getMessage(),GameScoreException.INVALID_PARAMETERS);
        }
    }
    @Test
    public void TestShouldCatchAnExceptionPowerBonusScore(){
        try{
            int score = power.calculateScore(-1,0);
            fail("Deberia agarrar una excepcionx");
        }catch (GameScoreException e){
            assertEquals(e.getMessage(),GameScoreException.INVALID_PARAMETERS);
        }
    }


    @Test
    public void TestScoreNeverBeNegativeOriginalScore() throws GameScoreException {
        int score = original.calculateScore(0,1000);
        assertTrue(score>=0);
    }

    @Test
    public void TestScoreNeverBeNegativePowerScore() throws GameScoreException {
        int score = original.calculateScore(0,1000);
        assertTrue(score>=0);
    }

    @Test
    public void TestScoreNeverBeNegativeBonusScore() throws GameScoreException {
        int score = bonus.calculateScore(0,1000);
        assertTrue(score>=0);
    }

    @Test
    public void TestScoreNeverBeSoBigOriginalScore() throws GameScoreException {
        int score = original.calculateScore(10000,0);
        assertTrue(score <= 500);
    }

    @Test
    public void TestScoreNeverBeSoBigBonusScore() throws GameScoreException {
        int score = bonus.calculateScore(100000, 0);
        assertTrue(score <= 500);
    }

    @Test
    public void TestScoreNeverBeSoBigPowerBonusScore() throws GameScoreException {
        int score = power.calculateScore(100000, 0);
        assertTrue(score <= 500);
    }

    @Test
    public void TestIncorrectCountOrCorrectCountNeverbeZeroOriginalScore() {
        try {
            int score = original.calculateScore(0, 0);
            fail("Deberia Atrapar una excepcion");
        } catch (GameScoreException e){
            assertEquals(e.getMessage(),GameScoreException.INVALID_PARAMETERS);
        }
    }

    @Test
    public void TestIncorrectCountOrCorrectCountNeverbeZeroPowerBonusScore() {
        try {
            int score = power.calculateScore(0, 0);
            fail("Deberia Atrapar una excepcion");
        } catch (GameScoreException e){
            assertEquals(e.getMessage(),GameScoreException.INVALID_PARAMETERS);
        }
    }

    @Test
    public void TestIncorrectCountOrCorrectCountNeverbeZeroBonusScore() {
        try {
            int score = bonus.calculateScore(0, 0);
            fail("Deberia Atrapar una excepcion");
        } catch (GameScoreException e){
            assertEquals(e.getMessage(),GameScoreException.INVALID_PARAMETERS);
        }
    }


}
package model;

import java.sql.SQLException;

/**
 * Handles high score to display.
 *
 *
 * @author Isabelle Romhagen, Ludvig Lundin
 * @version 1.2
 */
public class HighScore {

    private static HighScore highScore;

    private HighScoreBean[] top10;

    /**
     * Get top 10 to display.
     */
    private HighScore() {
        top10 = new DBUtil().updateHighScore();
    }

    /**
     * Call the database to update top 10 to display.
     */
    public void updateTop10() {
        top10 = new DBUtil().updateHighScore();
    }

    /**
     * Creates a new high score.
     *
     * @return highScore
     */
    public static HighScore getHighScore() {
        if (highScore == null) {
            highScore = new HighScore();
        }
        return highScore;
    }

    /**
     * Call the updateTop10 method, get the first value from the array top10.
     *
     * @return top10[0]
     */
    public int getBestHighestScore() {
        updateTop10();
        if (top10[0] != null) {
            return top10[0].getScore();
        }

        return 0;
    }

    public HighScoreBean[] getTop10() {
        return top10;
    }

    /**
     * Save score along with name to database.
     *
     * @param name Player's alias
     * @param highscore Player's score
     * @throws SQLException
     */
    public void saveNewHighscore(String name, int highscore) throws SQLException {
        new DBUtil().handleHighScore(name, highscore);
    }

}

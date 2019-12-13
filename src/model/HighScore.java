package model;


import java.sql.SQLException;

public class HighScore {

    private static HighScore highScore;

    private HighScoreBean[] top10;

    private HighScore() {
        top10 = new DBUtil().updateHighScore();
    }

    public void updateTop10() {
        top10 = new DBUtil().updateHighScore();
    }

    public static HighScore getHighScore() {
        if (highScore == null) {
            highScore = new HighScore();
        }
        return highScore;
    }


    public HighScoreBean[] getTop10() {
        return top10;
    }

    public void saveNewHighscore(String name, int highscore) throws SQLException {
        new DBUtil().handleHighScore(name, highscore);
    }

}

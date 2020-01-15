package model;

/**
 *
 * @author Isabelle Romhagen, Ludvig Lundin
 * @version 1.2
 */
public class HighScoreBean {
    private String username;
    private int score;

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    /**
     * Constructor sets Player alias and score.
     * @param username Player alias
     * @param score Player score
     */
    public HighScoreBean(String username, int score) {
        this.username = username;
        this.score = score;
    }
}

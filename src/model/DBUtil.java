package model;
import java.sql.*;

/**
 * This is a utility class for the database.
 * It has methods to add new data after the game is finished and to display top 10.
 *
 * @author Isabelle Romhagen
 * @version 1.2
 */
public class DBUtil {

    public static InGameModel model;

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String CONNECTION = "jdbc:mysql://localhost:3316/highscoredb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    /**
     * This method establishes the connection to the database using the username,
     * password and connection link specified above and saves the player alias and score into it.
     * Then it calls updateHighscore().
     *
     * @param name Player alias from user input.
     * @param score Player's score obtained from score count at the end of the game.
     * @exception SQLException
     * */
    void handleHighScore(String name, int score) throws SQLException {
        System.out.println("Connecting to database...");

        try {

            Connection connection = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
            PreparedStatement st = connection.prepareStatement("INSERT INTO highscore (name, score)" + "VALUES (?, ?)");


            st.setString(1, name);
            st.setInt(2, score);

            st.execute();

        }
        catch(Exception e){
            System.err.println(e);
        }
        System.out.println("Saved to database");
        updateHighScore();
    }

    /**
     *This method connects to the database, orders all scores by highest score and returns the 10 highest scores.
     *
     * @return top10 the 10 highest scores
     */

    HighScoreBean[] updateHighScore() {
        HighScoreBean[] top10 = new HighScoreBean[10];
        System.out.println("Connecting to database...");
        System.out.println("Current high score:");
        try{

            Connection conn = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
            String query = "SELECT * FROM highscore" +" ORDER BY score DESC" + " LIMIT 10";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            int currentBean = 0;

            while (rs.next())
            {
                top10[currentBean] = new HighScoreBean(rs.getString("name"), rs.getInt("score"));
                currentBean++;
            }

        }
        catch (Exception e) {
            System.err.println(e);
        }
        return top10;
    }

}
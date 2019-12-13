package model;

import view.SpaceInvaderInGameView;

import java.sql.*;

public class DBUtil {

    public static SpaceInvaderInGameView view;
    public static InGameModel model;

    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    public static final String CONNECTION = "jdbc:mysql://localhost:3316/highscoredb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public void handleHighScore(String name, int score) throws SQLException {
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


    public HighScoreBean[] updateHighScore() {
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
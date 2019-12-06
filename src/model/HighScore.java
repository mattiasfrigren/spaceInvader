package model;
import view.SpaceInvaderInGameView;

import java.sql.*;

public class HighScore {
    public static SpaceInvaderInGameView view;
    public static InGameModel model;


        public static void handleHighScore() throws SQLException {
            model = InGameModel.getGameModel();
            view = SpaceInvaderInGameView.getGameView();
            int scoreToEnter = model.getPoints();
            String enteredName = model.getNameInput();
            System.out.println("Connecting database...");
            System.out.println("Current high score:");


            try
                    (Connection conn = DriverManager.getConnection(DBUtil.CONNECTION, DBUtil.USERNAME, DBUtil.PASSWORD);
                     PreparedStatement st = conn.prepareStatement("INSERT INTO highscoretable (name, score)" + "VALUES (?, ?)")) {

                st.setString(1, enteredName);
                st.setInt(2, scoreToEnter);

                st.execute();



                    String query = "SELECT * FROM highscoretable" +" ORDER BY score DESC" + " LIMIT 10";
                    ResultSet rs = st.executeQuery(query);


                while (rs.next())
                {
                    String name = rs.getString("name");
                    int score = rs.getInt("score");

                    // print the results
                    System.out.format("%s, %s\n", name, score);
                }

            }
            catch (Exception e) {
                System.err.println(e);
            }

        }

}

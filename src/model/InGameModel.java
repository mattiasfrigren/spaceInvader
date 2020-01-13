package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

// All info from Model to the game.
public class InGameModel {

    private static InGameModel gameModel;
    private PlayerShip playerModel;
    private ArrayList<IBullet> bulletsModelList = new ArrayList<>();
    private ArrayList<EnemyShip> enemiesModelList = new ArrayList<>();

    private HpUp heartHpUp;
    private Meteor modelMeteor;
    private int points = 0;
    private int level = 1;

    /////////************** Getter and setters ***********************

    public HpUp getHeartHpUp() {
        return heartHpUp;
    }

    public void setHeartHpUp(HpUp heartHpUp) {
        this.heartHpUp = heartHpUp;
    }

    public int getLevel() {
        return level;
    }

    public void addLevel() {
        this.level++;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Meteor getModelMeteor() {
        return modelMeteor;
    }
    public void setModelMeteor(Meteor modelMeteor) {
        this.modelMeteor = modelMeteor;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public void addPoints(int points) {
        this.points += points;
    }

    public static InGameModel getGameModel() {
        if (gameModel == null) {
            gameModel = new InGameModel();
        }
        return gameModel;
    }

    private InGameModel() {
        playerModel = new PlayerShip(Constants.playerShipURL);
    }

    public PlayerShip getPlayerModel() {
        return playerModel;
    }

    public void setPlayerModel(PlayerShip playerModel) {
        this.playerModel = playerModel;
    }

    public void setPlayerModelImage(String url) {
        playerModel = new PlayerShip(url);
    }

    public void setBulletsModelList(ArrayList<IBullet> bulletsModelList) {
        this.bulletsModelList = bulletsModelList;
    }

    public ArrayList<IBullet> getBulletsModelList() {
        return bulletsModelList;
    }

    // add modelinfo
    public void addBullets(IBullet bullet) {
        bulletsModelList.add(bullet);
    }

    public IBullet getLastBullet() {
        return bulletsModelList.get(bulletsModelList.size() - 1);
    }

    public ArrayList<EnemyShip> getEnemyModelList() {
        return enemiesModelList;
    }

    //Adds enemies to enemieModelList
    public void addEnemyModel(EnemyShip enemy) {
        enemiesModelList.add(enemy);
    }

    //adds meteor to meteorModelList

    ///// ******************* END OF GETTERS AND SETTERS  ******************************

    public void resetAllModel() {
        playerModel = new PlayerShip(Constants.playerShipURL);
        bulletsModelList.clear();
        enemiesModelList.clear();
        modelMeteor = null;
        points = 0;
        heartHpUp = null;
        level = 1;
    }





}

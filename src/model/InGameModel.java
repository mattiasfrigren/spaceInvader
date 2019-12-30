package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

// All info in the game.
public class InGameModel {

    private static InGameModel gameModel;

    private PlayerShip playerModel;
    private ArrayList<IBullet> bulletsModelList = new ArrayList<>();
    private ArrayList<EnemyShip> enemiesModelList = new ArrayList<>();
    private ArrayList<Meteor> meteorModelList = new ArrayList<>();

    private int points = 0;

    /////////************** Getter and setters ***********************


    public ArrayList<Meteor> getMeteorModelList() {
        return meteorModelList;
    }

    public void setMeteorModelList(ArrayList<Meteor> meteorModelList) {
        this.meteorModelList = meteorModelList;
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
        playerModel = new PlayerShip();
    }

    public PlayerShip getPlayerModel() {
        return playerModel;
    }

    public void setPlayerModel(PlayerShip playerModel) {
        this.playerModel = playerModel;
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
    public void addMeteorModel(Meteor meteor) {
        meteorModelList.add(meteor);
    }

    public void removeMeteorModel(Meteor meteor) {
        meteorModelList.remove(meteor);
    }

    ///// ******************* END OF GETTERS AND SETTERS  ******************************

    public void resetAllModel() {
        playerModel = new PlayerShip();
        bulletsModelList.clear();
        enemiesModelList.clear();
        meteorModelList.clear();
        points = 0;
    }





}

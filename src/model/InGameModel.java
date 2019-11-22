package model;

import java.util.ArrayList;

// All info in the game.
public class InGameModel {

    private static InGameModel gameModel;

    private PlayerShip playerModel;
    private ArrayList<IBullet> bulletsModelList = new ArrayList<>();
    private ArrayList<EnemyShip> enemiesModelList = new ArrayList<>();

    private boolean isShooting = false;

    public boolean isShooting() {
        return isShooting;
    }

    public void setShooting(boolean shooting) {
        isShooting = shooting;
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

    public ArrayList<IBullet> getBulletsModelList() {
        return bulletsModelList;
    }

    // add modelinfo
    public void addBullets(IBullet bullet) {
        bulletsModelList.add(bullet);
    }

    public IBullet getLastBullet() {
        return bulletsModelList.get(bulletsModelList.size()-1);
    }

    public ArrayList<EnemyShip> getEnemy() {
        return enemiesModelList;
    }

    public void addEnemy(EnemyShip enemy) {
        enemiesModelList.add(enemy);
    }

    public void updateBullets() {
        for (IBullet bullet : bulletsModelList) {
            OnScreenItems itemBullet = (OnScreenItems)bullet;
            itemBullet.moveUp();
        }
    }
}

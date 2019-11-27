package model;

import java.util.ArrayList;

// All info in the game.
public class InGameModel {

    private static InGameModel gameModel;

    private PlayerShip playerModel;
    private ArrayList<IBullet> bulletsModelList = new ArrayList<>();
    private ArrayList<EnemyShip> enemiesModelList = new ArrayList<>();

    //lister is changing this value 'space'
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

    public boolean checkIfPlayerIsShooting() {
        if (isShooting()) {
            return playerModel.performShootingAction();
        }
        return false;
    }

    public void updateBullets() {
        for (IBullet bullet : bulletsModelList) {
            OnScreenItems itemBullet = (OnScreenItems)bullet;
            itemBullet.moveUp();
        }
    }

    private boolean checkIfOutOfScreen(double x, double y) {
        return y > Constants.SCREENHEIGHT+50 || x > Constants.SCREENWIDTH+50 || y < -50 || x < -50;
    }

    public ArrayList<Integer> getBulletRemoveList() {
        ArrayList<Integer> bulletsToRemove = new ArrayList<>();
        for (int i = 0; i < bulletsModelList.size() ; i++) {
            OnScreenItems itemBullet = (OnScreenItems)bulletsModelList.get(i);
            if (checkIfOutOfScreen(itemBullet.getItemCoordX(), itemBullet.getItemCoordY())){
                bulletsToRemove.add(i);
            }
        }
        for (int index : bulletsToRemove) {
            bulletsModelList.remove(index);
        }
        return bulletsToRemove;
    }

    public void updateWeaponsState() {
        playerModel.getWeapon().addToReadyToShoot();
       /* for (EnemyShip enemyShip: enemiesModelList) {
            enemyShip.getWeapon().addToReadyToShoot();
        }*/
    }
}

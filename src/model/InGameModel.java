package model;

import java.util.ArrayList;

// All info in the game.
public class InGameModel {

    private static InGameModel gameModel;

    private PlayerShip player;
    private ArrayList<IBullet> bullets = new ArrayList<>();
    private ArrayList<EnemyShip> enemies = new ArrayList<>();

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
        player = new PlayerShip();
    }


    public PlayerShip getPlayer() {
        return player;
    }

    public void setPlayer(PlayerShip player) {
        this.player = player;
    }

    public ArrayList<IBullet> getBullets() {
        return bullets;
    }

    // add modelinfo
    public void addBullets(IBullet bullet) {
        bullets.add(bullet);
    }

    public ArrayList<EnemyShip> getEnemy() {
        return enemies;
    }

    public void addEnemy(EnemyShip enemy) {
        enemies.add(enemy);
    }
}

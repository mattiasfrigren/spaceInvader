package model;

import java.util.Random;

public class LaserGun extends Weapons {

    public LaserGun(boolean isFacingPlayer, int shootInterval, Ship theShip) {
        readyToShoot = new Random().nextInt(shootInterval);
        this.isFacingPlayer = isFacingPlayer;
        this.shootInterval = shootInterval;
        this.theShip = theShip;
    }

    @Override
    public IBullet shoot() {
        if (readyToShoot >= shootInterval) {
            double setBulletX = theShip.getItemCoordX() + theShip.getItemWidth()/2;
            double offsetY = (theShip.getItemHeight()/2) - 20;
            double createPosY = isFacingPlayer ? offsetY : -offsetY;
            readyToShoot = 0;
            return new LaserBullet(setBulletX,(theShip.getItemCoordY() + createPosY + 60), isFacingPlayer);
        }
        return null;
    }
}

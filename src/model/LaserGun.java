package model;

public class LaserGun extends Weapons {

    public LaserGun(boolean isFacingPlayer, int shootInterval, Ship theShip) {
        readyToShoot = shootInterval;
        this.isFacingPlayer = isFacingPlayer;
        this.shootInterval = shootInterval;
        this.theShip = theShip;
    }

    @Override
    public IBullet shoot() {
        if (readyToShoot >= shootInterval) {
            double offsetY = theShip.getItemHeight()/2;
            double createPosY = isFacingPlayer ? offsetY : -offsetY;
            readyToShoot = 0;
            return new LaserBullet(theShip.getItemCoordX(),(theShip.getItemCoordY() + createPosY), isFacingPlayer);
        }
        return null;
    }
}

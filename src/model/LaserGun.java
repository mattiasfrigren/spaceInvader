package model;

public class LaserGun extends Weapons {

    public LaserGun(boolean isFacingPlayer, int shootInterval, Ship theShip) {
        readyToShoot = shootInterval;
        this.isFacingPlayer = isFacingPlayer;
        this.shootInterval = shootInterval;
        this.theShip = theShip;
    }

    @Override
    public boolean shoot() {
        if (readyToShoot >= shootInterval) {
            double offsetY = theShip.getItemHeight()/2;
            double createPosY = isFacingPlayer ? offsetY : -offsetY;
            InGameModel.getGameModel().addBullets(new LaserBullet(theShip.getItemCoordX(),(theShip.getItemCoordY() + createPosY), isFacingPlayer));
            readyToShoot = 0;
            return true;
        }
        return false;
    }
}

package model;

public class LaserGun extends Weapons {

    public LaserGun(boolean isFacingPlayer, int shootInterval, Ship theShip) {
        readyToShoot = true;
        this.isFacingPlayer = isFacingPlayer;
        this.shootInterval = shootInterval;
        this.theShip = theShip;
    }

    @Override
    public IBullet shoot() {
        if (readyToShoot) {
            double offsetY = theShip.getImage().getHeight()/2;
            double creatPosY = isFacingPlayer ? offsetY : -offsetY;
            return new LaserBullet((int)theShip.getX(),(int)(theShip.getY() + creatPosY), isFacingPlayer);
        }
        return null;
    }
}

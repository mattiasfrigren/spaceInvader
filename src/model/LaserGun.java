package model;

public class LaserGun extends Weapons {

    public LaserGun(boolean isFacingPlayer, int shootInterval, Ship theShip) {
        readyToShoot = true;
        this.isFacingPlayer = isFacingPlayer;
        this.shootInterval = shootInterval;
        this.theShip = theShip;
    }

    @Override
    public void shoot() {
        if (readyToShoot) {
            double offsetY = theShip.getItemHeight()/2;
            double createPosY = isFacingPlayer ? offsetY : -offsetY;
            InGameModel.getGameModel().addBullets(new LaserBullet((int)theShip.getItemCoordX(),(int)(theShip.getItemCoordY() + createPosY), isFacingPlayer));
        }
    }
}

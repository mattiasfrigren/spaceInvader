package model;

public class LaserBullet extends OnScreenItems implements IBullet {

    public LaserBullet(double itemCoordX, double itemCoordY, boolean isFacingPlayer) {
        super(Constants.laserBulletURL, itemCoordX, itemCoordY, Constants.laserBulletHeight, Constants.laserBulletWidth, Constants.laserBulletMovementSpeed, isFacingPlayer);
    }

}

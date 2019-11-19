package model;

public class LaserBullet extends OnScreenItems implements IBullet {

    public LaserBullet(int itemCoordX, int itemCoordY, double itemHeight, double itemWidth, double movementSpeed, boolean isFacingPlayer) {
        super("laserBulletURL", itemCoordX, itemCoordY, itemHeight, itemWidth, movementSpeed, isFacingPlayer);
    }

}

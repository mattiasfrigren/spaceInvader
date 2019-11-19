package model;

public class PlayerShip extends Ship {

    public PlayerShip() {
        super(Constants.playerShipURL, (int)Constants.playerShipStartPosX, (int)Constants.playerShipStartPosY, Constants.playerShipHeight, Constants.playerShipWidth, Constants.playerShipMovementSpeed, false);
        setWeapons(new LaserGun(false, (int)Constants.laserBulletShootInterval, this));
    }

}

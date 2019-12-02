package model;

public class PlayerShip extends Ship {

    public PlayerShip() {
        super(Constants.playerShipURL, Constants.playerShipStartPosX, Constants.playerShipStartPosY, Constants.playerShipHeight, Constants.playerShipWidth, Constants.playerShipMovementSpeed, false, Constants.playerLifes);

        setWeapons(new LaserGun(false, (int)Constants.laserBulletShootInterval, this));
    }

}

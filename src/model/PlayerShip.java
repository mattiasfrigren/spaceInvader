package model;

public class PlayerShip extends Ship {

    int ultCounter = 0;

    public PlayerShip(String playerShipURL) {
        super(playerShipURL, Constants.playerShipStartPosX, Constants.playerShipStartPosY, Constants.playerShipHeight, Constants.playerShipWidth, Constants.playerShipMovementSpeed, false, Constants.playerLifes);

        setWeapons(new LaserGun(false, (int)Constants.laserBulletShootInterval, this));
    }

    public int getUltCounter() {
        return ultCounter;
    }

    public boolean IsUltReady() {
        return ultCounter >= Constants.ultReadyAt;
    }

    public void addToUltCounter() {
        this.ultCounter++;
    }

    public void resetUltCounter() {
        ultCounter = 0;
    }
}

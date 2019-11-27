package model;

public abstract class Weapons {

    protected boolean isFacingPlayer;
    protected int readyToShoot;
    protected int shootInterval;
    protected Ship theShip;

    public abstract IBullet shoot();

    public void addToReadyToShoot() {
        if (readyToShoot < shootInterval) {
            readyToShoot++;
        }
    }


}

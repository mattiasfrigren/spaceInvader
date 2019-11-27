package model;

public abstract class Weapons {

    protected boolean isFacingPlayer; /* Move to Constants? */
    protected int readyToShoot;
    protected int shootInterval;
    protected Ship theShip;

    public abstract boolean shoot();

    public void addToReadyToShoot() {
        if (readyToShoot < shootInterval) {
            readyToShoot++;
        }
    }


}

package model;

/**
 * This class declares weapon variables.
 *
 * @author Isabelle Romhagen, Ludvig Lundin, Mattias Frigren, Jasmine Söderberg, Khazar Mehraban
 * @version 1.2
 */


public abstract class Weapons {

    protected boolean isFacingPlayer; /* Move to Constants? */
    protected int readyToShoot;
    protected int shootInterval;
    protected Ship theShip;

    public abstract IBullet shoot();

    /**
     * Checks if it's time to shoot again.
     */
    public void addToReadyToShoot() {
        if (readyToShoot < shootInterval) {
            readyToShoot++;
        }
    }


}

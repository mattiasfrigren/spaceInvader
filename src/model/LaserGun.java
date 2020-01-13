package model;

import java.util.Random;

/**
 * This class creates a laser gun with shooting bullets.
 * It is a child of Weapons.
 *
 * @author Isabelle Romhagen, Ludvig Lundin, Mattias Frigren, Jasmine Söderberg, Khazar Mehraban
 * @version 1.2
 */
public class LaserGun extends Weapons {

    /**
     * Constructor determines if it's time to shoot, in what direction the shot should go and ship object.
     * @param isFacingPlayer direction
     * @param shootInterval shooting interval
     * @param theShip ship object
     */
    public LaserGun(boolean isFacingPlayer, int shootInterval, Ship theShip) {
        readyToShoot = new Random().nextInt(shootInterval);
        this.isFacingPlayer = isFacingPlayer;
        this.shootInterval = shootInterval;
        this.theShip = theShip;
    }

    /**
     * Creates a bullet.
     * @return LaserBullet if it's time to shoot.
     */
    @Override
    public IBullet shoot() {
        if (readyToShoot >= shootInterval) {
            double setBulletX = theShip.getItemCoordX() + theShip.getItemWidth()/2;
            double offsetY = (theShip.getItemHeight()/2) - 20;
            double createPosY = isFacingPlayer ? offsetY : -offsetY;
            readyToShoot = 0;
            return new LaserBullet(setBulletX,(theShip.getItemCoordY() + createPosY + 60), isFacingPlayer);
        }
        return null;
    }
}

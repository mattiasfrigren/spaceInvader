package model;

/**
 * This class defines what an enemy ship of any kind should contain.
 * Inherits OnScreenItems and implements IBullet.
 *
 * @author Isabelle Romhagen, Ludvig Lundin, Mattias Frigren, Jasmine Söderberg, Khazar Mehraban
 * @version 1.2
 */

public class LaserBullet extends OnScreenItems implements IBullet {

    /**
     * Constructor gets the essentials from parent class.
     * @param itemCoordX x position
     * @param itemCoordY y position
     * @param isFacingPlayer direction
     */
    public LaserBullet(double itemCoordX, double itemCoordY, boolean isFacingPlayer) {
        super(Constants.laserBulletURL, itemCoordX, itemCoordY, Constants.laserBulletHeight, Constants.laserBulletWidth, Constants.laserBulletMovementSpeed, isFacingPlayer);
    }

}

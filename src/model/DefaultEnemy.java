package model;

/**
 * This class defines the default enemies weapon type and shooting interval.
 * It is a child of EnemyShip.
 *
 * @author Mattias Frigren
 * @version 1.2
 */

public class DefaultEnemy extends EnemyShip {
    /**
     * The constructor gets the image, X and Y starting position, height, width,
     * speed, direction and initial life count from the Constants class.
     * Creates a Laser gun and gets direction and interval.
     */
    public DefaultEnemy() {
        super(Constants.enemyShipURL,Constants.enemyShipStartPosX,Constants.enemyShipStartPosY,
                Constants.enemyShipHeight,Constants.enemyShipWidth,Constants.enemyShipMovementSpeed,true, Constants.enemyLifes);

        setWeapons(new LaserGun(true, (int)Constants.enemyLaserGunShootingInterval,this));

    }
}

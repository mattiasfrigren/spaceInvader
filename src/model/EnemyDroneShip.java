package model;

/**
 * This class defines the default enemy drone ship weapon type and shooting interval.
 * It is a child of EnemyShip.
 *
 * @author Isabelle Romhagen, Ludvig Lundin, Mattias Frigren, Jasmine Söderberg, Khazar Mehraban
 * @version 1.2
 */

public class EnemyDroneShip extends EnemyShip {

    /**
     * The constructor gets the image, X and Y starting position, height, width,
     * speed, direction and initial life count from the Constants class.
     * Creates a Laser gun and gets direction and interval.
     */
    public EnemyDroneShip() {
        super(Constants.enemyDroneShipUrl,Constants.enemyDroneShipStartPosX,Constants.enemyDroneShipStartPosY,Constants.enemyDroneShipHeight
        ,Constants.enemyDroneShipWidth,Constants.enemyDroneShipMovmentSpeed,true,Constants.enemyDroneShipLifes);
        setWeapons(new LaserGun(true,(int) Constants.enemyDroneShipLaserGunShootingInterval,this));

    }

}

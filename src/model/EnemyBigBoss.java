package model;

/**
 * This class defines the big boss weapon type and shooting interval.
 * It is a child of EnemyShip.
 *
 * @author Isabelle Romhagen, Ludvig Lundin, Mattias Frigren, Jasmine Söderberg, Khazar Mehraban
 * @version 1.2
 */

public class EnemyBigBoss extends EnemyShip {

    /**
     * The constructor gets the image, X and Y starting position, height, width,
     * speed, direction and initial life count from the Constants class.
     * Creates a Laser gun and gets direction and interval.
     */
    public EnemyBigBoss() {
        super(Constants.enemyBigBossUrl,Constants.enemyBigBossStartPosX, Constants.enemyBigBossStartPosY,
                Constants.enemyBigBossHeight,Constants.enemyBigBossWidth,Constants.enemyBigBossMovmentSpeed, true,Constants.enemyBigBossLifes);
        setWeapons(new LaserGun(true, (int)Constants.enemyBigBossShootingInterval,this));
    }

}

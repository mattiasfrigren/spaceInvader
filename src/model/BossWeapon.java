package model;

import java.util.Random;


/**
 * Creates a boss weapon.
 * Child of Weapons.
 *
 * @author Isabelle Romhagen, Ludvig Lundin, Mattias Frigren, Jasmine Söderberg, Khazar Mehraban
 * @version 1.2
 */
public class BossWeapon extends Weapons {

    private int amountOfShots = 0;

    public BossWeapon(boolean isFacingPlayer, int shootInterval, Ship theShip) {
        readyToShoot = 0;
        this.isFacingPlayer = isFacingPlayer;
        this.shootInterval = shootInterval;
        this.theShip = theShip;
    }

    /**
     * Shoots if it's time, sets bullet's position an amount to shots.
     *
     * @return new LaserBullet along with its attributes.
     */
    @Override
    public IBullet shoot() {
        if (readyToShoot >= shootInterval) {
            double setBulletX = (theShip.getItemCoordX() + theShip.getItemWidth()/2) - 40;
            double offsetY = (theShip.getItemHeight()/2) -40;
            double createPosY = isFacingPlayer ? offsetY : -offsetY;
            if (amountOfShots > 1) {
                readyToShoot = 0;
                amountOfShots = 0;
            }
            else {
                amountOfShots++;
            }
            return new LaserBullet(setBulletX + (amountOfShots * 40),(theShip.getItemCoordY()  + createPosY), isFacingPlayer);
        }
        return null;
    }
}

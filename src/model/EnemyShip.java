package model;

public class EnemyShip extends Ship{
    public EnemyShip(){
        //Make a enemyShip
        super(Constants.enemyShipURL,Constants.enemyShipStartPosX,Constants.enemyShipStartPosY,
                Constants.enemyShipHeight,Constants.enemyShipWidth,Constants.enemyShipMovementSpeed,true, Constants.enemyLifes);
        //Set the model objects weaponType and shooting interval
        setWeapons(new LaserGun(true, (int)Constants.enemyLaserGunShootingInterval,this));
    }


}
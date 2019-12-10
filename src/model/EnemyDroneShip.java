package model;

public class EnemyDroneShip extends Ship {

    public EnemyDroneShip() {
        super(Constants.enemyDroneShipUrl,Constants.enemyDroneShipStartPosX,Constants.enemyDroneShipStartPosY,Constants.enemyDroneShipHeight
        ,Constants.enemyDroneShipWidth,Constants.enemyDroneShipMovmentSpeed,true,Constants.enemyDroneShipLifes);
        setWeapons(new LaserGun(true,(int) Constants.enemyDroneShipLaserGunShootingInterval,this));

    }

}

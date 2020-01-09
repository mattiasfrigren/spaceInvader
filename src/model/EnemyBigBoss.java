package model;

public class EnemyBigBoss extends EnemyShip {

    public EnemyBigBoss() {
        super(Constants.enemyBigBossUrl,Constants.enemyBigBossStartPosX, Constants.enemyBigBossStartPosY,
                Constants.enemyBigBossHeight,Constants.enemyBigBossWidth,Constants.enemyBigBossMovmentSpeed, true,Constants.enemyBigBossLifes);
        setWeapons(new LaserGun(true, (int)Constants.enemyBigBossShootingInterval,this));
    }

}

package model;

public class LaserGun extends Weapons {

    public LaserGun(boolean isFacingPlayer, double projectileSpeed, int shootInterval) {
        readyToShoot = true;
        this.isFacingPlayer = isFacingPlayer;
        this.projectileSpeed = projectileSpeed;
        this.shootInterval = shootInterval;
    }
    @Override
    public void shoot() {
        if (readyToShoot) {
            IBullet bullet = new LaserBullet()
        }
    }
}

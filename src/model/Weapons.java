package model;

public abstract class Weapons {

    protected boolean isFacingPlayer;
    protected double projectileSpeed;
    protected boolean readyToShoot;
    protected int shootInterval;

    public abstract void shoot();

}

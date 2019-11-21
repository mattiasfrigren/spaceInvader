package model;

public abstract class Weapons {

    protected boolean isFacingPlayer;
    protected boolean readyToShoot;
    protected int shootInterval;
    protected Ship theShip;

    public abstract void shoot();

}

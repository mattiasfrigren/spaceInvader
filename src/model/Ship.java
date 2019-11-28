package model;

public class Ship extends OnScreenItems{

    protected Weapons weapon;
    private int lifes;


    public Ship(String imageURL, double itemCoordX, double itemCoordY, double itemHeight, double itemWidth, double movementSpeed, boolean isFacingPlayer, int lifes) {
        super(imageURL,itemCoordX, itemCoordY, itemHeight, itemWidth, movementSpeed, isFacingPlayer);
        this.lifes = lifes;
    }

    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public void looseLife(int lifes) {
        this.lifes -= lifes;
    }

    public void setWeapons(Weapons weapon) {
        this.weapon = weapon;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public IBullet performShootingAction() {
        if (weapon != null) {
            return weapon.shoot();
        }
        return null;
    }
}

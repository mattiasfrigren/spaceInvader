package model;

public class Ship extends OnScreenItems{

 protected Weapons weapon;


    public Ship(String imageURL, double itemCoordX, double itemCoordY, double itemHeight, double itemWidth, double movementSpeed, boolean isFacingPlayer) {
        super(imageURL,itemCoordX, itemCoordY, itemHeight, itemWidth, movementSpeed, isFacingPlayer);
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

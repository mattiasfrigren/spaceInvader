package model;

public class Ship extends OnScreenItems{

 protected Weapons weapon;


    public Ship(String imageURL, int itemCoordX, int itemCoordY, double itemHeight, double itemWidth, double movementSpeed, double shootInterval, Weapons weapon) {
        super(imageURL,itemCoordX, itemCoordY, itemHeight, itemWidth, movementSpeed);
        this.weapon = weapon;
    }

    public void performShootingAction() {
        weapon.shoot();

    }
}

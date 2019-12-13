package model;

public class EnemyShip extends Ship{
    public EnemyShip(String imageURL, double itemCoordX, double itemCoordY, double itemHeight, double itemWidth, double movementSpeed, boolean isFacingPlayer, int lifes){
        //Make a enemyShip
            super(imageURL,itemCoordX, itemCoordY, itemHeight, itemWidth, movementSpeed, isFacingPlayer,lifes);

    }
}
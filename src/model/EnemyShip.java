package model;

public class EnemyShip extends Ship{
    private boolean moveState =true;
    public EnemyShip(String imageURL, double itemCoordX, double itemCoordY, double itemHeight, double itemWidth, double movementSpeed, boolean isFacingPlayer, int lifes){
        //Make a enemyShip
            super(imageURL,itemCoordX, itemCoordY, itemHeight, itemWidth, movementSpeed, isFacingPlayer,lifes);

    }
    public boolean isMoveState() {
        return moveState;
    }
    public void setMoveState(boolean moveState) {
        this.moveState = moveState;
    }

}
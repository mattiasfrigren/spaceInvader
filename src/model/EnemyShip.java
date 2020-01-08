package model;

public class EnemyShip extends Ship{
    private boolean moveStateUpDown =true;

    private boolean moveStateRightLeft = true;
    public EnemyShip(String imageURL, double itemCoordX, double itemCoordY, double itemHeight, double itemWidth, double movementSpeed, boolean isFacingPlayer, int lifes){
        //Make a enemyShip
            super(imageURL,itemCoordX, itemCoordY, itemHeight, itemWidth, movementSpeed, isFacingPlayer,lifes);

    }
    public boolean isMoveStateUpDown() {
        return moveStateUpDown;
    }
    public void setMoveStateUpDown(boolean moveStateUpDown) {
        this.moveStateUpDown = moveStateUpDown;
    }

    public boolean isMoveStateRightLeft() {
        return moveStateRightLeft;
    }

    public void setMoveStateRightLeft(boolean moveStateRightLeft) {
        this.moveStateRightLeft = moveStateRightLeft;
    }

}
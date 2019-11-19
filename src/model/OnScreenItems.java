package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OnScreenItems extends ImageView {

    private double movementSpeed;
    private boolean isFacingPlayer;
    double moveX;
    double moveY;

    public OnScreenItems(String imageURL, int itemCoordX, int itemCoordY, double itemHeight, double itemWidth, double movementSpeed,boolean isFacingPlayer) {

        super(imageURL);
        setX(itemCoordX);
        setY(itemCoordY);
        resize(itemWidth, itemHeight);
        this.movementSpeed = movementSpeed;
        this.isFacingPlayer = isFacingPlayer;
    }

    public void moveRight() {
        moveX = isFacingPlayer ? -movementSpeed : movementSpeed;
        setX(getX() + moveX);
    }

    public void moveLeft() {
        moveX = isFacingPlayer ? movementSpeed : -movementSpeed;
        setX(getX() + moveX);
    }
    public void moveUp() {
        moveY = isFacingPlayer ? movementSpeed : -movementSpeed;
        setY(getY() - moveY);
    }
    public void moveDown() {
        moveY = isFacingPlayer ? -movementSpeed : movementSpeed;
        setY(getY()+ moveY);
    }

}
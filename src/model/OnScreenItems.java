package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OnScreenItems extends ImageView {

    private ImageView itemImageView;
    private double movementSpeed;
    private boolean isFacingPlayer;
    double moveX;
    double moveY;

    public OnScreenItems(String imageURL, int itemCoordX, int itemCoordY, double itemHeight, double itemWidth, double movementSpeed,boolean isFacingPlayer) {

        itemImageView = new ImageView(new Image(imageURL));

        itemImageView.setX(itemCoordX);
        itemImageView.setY(itemCoordY);
        itemImageView.resize(itemWidth, itemHeight);
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
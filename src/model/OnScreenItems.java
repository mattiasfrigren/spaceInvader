package model;

public class OnScreenItems {

    private String imageUrl;
    private double itemCoordX;
    private double itemCoordY;
    private double itemWidth;
    private double itemHeight;

    private double movementSpeed;
    private boolean isFacingPlayer;


    // Used by movement functions
    private double moveX;
    private double moveY;


    public OnScreenItems(String imageURL, double itemCoordX, double itemCoordY, double itemHeight, double itemWidth, double movementSpeed,boolean isFacingPlayer) {
        this.imageUrl = imageURL;
        this.itemCoordX = itemCoordX-itemWidth/2;
        this.itemCoordY = itemCoordY-itemHeight/2;
        this.itemHeight = itemHeight;
        this.itemWidth = itemWidth;
        this.movementSpeed = movementSpeed;
        this.isFacingPlayer = isFacingPlayer;
        //TODO add rotation based on isFacingPlayer
    }


    public void moveRight() {
        moveX = isFacingPlayer ? -movementSpeed : movementSpeed;
        itemCoordX += moveX;
    }

    public void moveLeft() {
        moveX = isFacingPlayer ? movementSpeed : -movementSpeed;
        itemCoordX += moveX;
    }
    public void moveUp() {
        moveY = isFacingPlayer ? movementSpeed : -movementSpeed;
        itemCoordY += moveY;
    }
    public void moveDown() {
        moveY = isFacingPlayer ? -movementSpeed : movementSpeed;
        itemCoordY += moveY;
    }

    public boolean isFacingPlayer() {
        return isFacingPlayer;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getItemCoordX() {
        return itemCoordX;
    }

    public void setItemCoordX(double itemCoordX) {
        this.itemCoordX = itemCoordX;
    }

    public double getItemCoordY() {
        return itemCoordY;
    }

    public void setItemCoordY(double itemCoordY) {
        this.itemCoordY = itemCoordY;
    }

    public double getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(double itemWidth) {
        this.itemWidth = itemWidth;
    }

    public double getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(double itemHeight) {
        this.itemHeight = itemHeight;
    }

}
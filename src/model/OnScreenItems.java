package model;

/**
 * This class handles all items present on screen in the game and their attributes.
 * Defines movement direction.
 *
 * @author Isabelle Romhagen, Ludvig Lundin, Mattias Frigren, Jasmine Söderberg, Khazar Mehraban
 * @version 1.2
 */
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


    /**
     * Sets following attributes for item:
     *
     * @param imageURL image link
     * @param itemCoordX x position
     * @param itemCoordY y position
     * @param itemHeight height
     * @param itemWidth width
     * @param movementSpeed speed
     * @param isFacingPlayer direction
     */
    public OnScreenItems(String imageURL, double itemCoordX, double itemCoordY, double itemHeight, double itemWidth, double movementSpeed, boolean isFacingPlayer) {
        this.imageUrl = imageURL;
        this.itemCoordX = itemCoordX-itemWidth/2;
        this.itemCoordY = itemCoordY-itemHeight/2;
        this.itemHeight = itemHeight;
        this.itemWidth = itemWidth;
        this.movementSpeed = movementSpeed;
        this.isFacingPlayer = isFacingPlayer;
        //TODO add rotation based on isFacingPlayer

    }

    /**
     * Moves item to the right, taking direction into account.
     */
    public void moveRight() {
        if (isFacingPlayer) {
            moveX = -movementSpeed;
        } else {
            moveX = movementSpeed;
        }
        itemCoordX += moveX;
    }

    /**
     * Moves item to the left, taking direction into account.
     */
    public void moveLeft() {
        moveX = isFacingPlayer ? movementSpeed : -movementSpeed;
        itemCoordX += moveX;
    }

    /**
     * Moves item up, taking direction into account.
     */
    public void moveUp() {
        moveY = isFacingPlayer ? movementSpeed : -movementSpeed;
        itemCoordY += moveY;
    }

    /**
     * Moves item down, taking direction into account.
     */
    public void moveDown() {
        moveY = isFacingPlayer ? -movementSpeed : movementSpeed;
        itemCoordY += moveY;
    }

    /////////************** Getter and setters ***********************

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

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    /////////**************End of Getter and setters ***********************

}
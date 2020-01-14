package model;

/**
 * This class handles the heart power up.
 * It is a child of OnScreenItems.
 *
 * @author Ludvig Lundin, Mattias Frigren
 * @version 1.2
 */

public class HpUp extends OnScreenItems {

    /**
     * Constructor gets image, starting position X and Y, height, width, speed and direction from Constants class.
     */
    public HpUp() {
        super(Constants.heartURL,Constants.heartStartX,Constants.heartStartY,
                Constants.heartHeight,Constants.heartWidth,Constants.heartMovementSpeed,true);
    }
}

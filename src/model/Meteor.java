package model;

/**
 * This class creates meteors and sets its attributes.
 * Child of OnScreenItems.
 *
 * @author Mattias Frigren
 * @version 1.2
 */
public class Meteor extends OnScreenItems {

    public Meteor() {
        super(Constants.meteorImage,Constants.spawnPointMeteor,0,Constants.meteorHeight,
                Constants.meteorWidth,Constants.meteorMovementSpeed,true);
    }

}

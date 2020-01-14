package model;

/**
 * This class handles the ship options.
 *
 * @author Ludvig Lundin
 * @version 1.2
 */

public enum SHIPCHOOSER {

    GREY(Constants.playerShipURL),
    GREEN(Constants.greenPlayerShipURL),
    BLUE(Constants.bluePlayerShipURL),
    RED(Constants.redPlayerShipURL);

    private String urlShip;

    private SHIPCHOOSER(String urlShip) {

        this.urlShip = urlShip;
    }

    public String getURL() {
        return this.urlShip;
    }

}

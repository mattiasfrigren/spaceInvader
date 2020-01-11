package model;

public enum SHIPCHOOSER {

    BLUE(Constants.playerShipURL),
    GREEN(Constants.playerShipURL),
    ORANGE(Constants.playerShipURL),
    RED(Constants.enemyShipURL);

    private String urlShip;

    private SHIPCHOOSER(String urlShip) {

        this.urlShip = urlShip;
    }

    public String getURL() {
        return this.urlShip;
    }

}

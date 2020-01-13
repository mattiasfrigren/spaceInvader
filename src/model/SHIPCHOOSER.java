package model;

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

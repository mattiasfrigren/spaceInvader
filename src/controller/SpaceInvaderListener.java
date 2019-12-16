package controller;


        import javafx.event.ActionEvent;
        import javafx.event.Event;
        import javafx.event.EventHandler;
        import javafx.scene.input.KeyCode;
        import javafx.scene.input.KeyEvent;
        import javafx.scene.input.MouseEvent;
        import model.Constants;
        import model.InGameModel;
        import model.LaserGun;

public class SpaceInvaderListener implements EventHandler<KeyEvent> {
    private static SpaceInvaderListener listener;

    public static SpaceInvaderListener getListener() {
        if (listener == null) {
            listener = new SpaceInvaderListener();
        }
        return listener;
    }

    private SpaceInvaderListener() {
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
            if (event.getCode() == KeyCode.SPACE) {
                SpaceInvaderController.getController().setShooting(true);
            }
            if (event.getCode() == KeyCode.A){
                SpaceInvaderController.getController().setMovingLeft(true);
            }
            if (event.getCode() == KeyCode.D){
                SpaceInvaderController.getController().setMovingRight(true);
            }
            if (event.getCode() == KeyCode.W){
                SpaceInvaderController.getController().setMovingUp(true);
            }
            if (event.getCode() == KeyCode.S){
                SpaceInvaderController.getController().setMovingDown(true);
            }
            if (event.getCode() ==KeyCode.SHIFT)
                InGameModel.getGameModel().getPlayerModel().setMovementSpeed(Constants.SCREENHEIGHT*0.016);
            // TODO add all pressed down events.
            if (event.getCode() == KeyCode.ESCAPE) {
                SpaceInvaderController.getController().pauseGame();
            }
        }
        else if (event.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            if (event.getCode() == KeyCode.SPACE) {
                SpaceInvaderController.getController().setShooting(false);
            }
            if (event.getCode() == KeyCode.A){
                SpaceInvaderController.getController().setMovingLeft(false);
            }
            if (event.getCode() == KeyCode.D){
                SpaceInvaderController.getController().setMovingRight(false);
            }
            if (event.getCode() == KeyCode.W){
                SpaceInvaderController.getController().setMovingUp(false);
            }
            if (event.getCode() == KeyCode.S){
                SpaceInvaderController.getController().setMovingDown(false);
            }
            if (event.getCode() == KeyCode.SHIFT) {
                InGameModel.getGameModel().getPlayerModel().setMovementSpeed(Constants.playerShipMovementSpeed);
            }
            //TODO add all released events.
        }


    }


}


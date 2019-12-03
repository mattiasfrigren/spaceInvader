package controller;


        import javafx.event.ActionEvent;
        import javafx.event.Event;
        import javafx.event.EventHandler;
        import javafx.scene.input.KeyCode;
        import javafx.scene.input.KeyEvent;
        import javafx.scene.input.MouseEvent;
        import model.InGameModel;

public class SpaceInvaderListener implements EventHandler<KeyEvent> {

    private static SpaceInvaderListener listener;

    public static SpaceInvaderListener getListener() {
        if (listener == null) {
            listener = new SpaceInvaderListener();
        }
        return listener;
    }

    private SpaceInvaderListener() { }

    @Override
    public void handle(KeyEvent event) {
        if (event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
            if (event.getCode() == KeyCode.SPACE) {
                InGameModel.getGameModel().setShooting(true);
            }
            if (event.getCode() == KeyCode.A){
               InGameModel.getGameModel().setMovingLeft(true);
            }
            if (event.getCode() == KeyCode.D){
                InGameModel.getGameModel().setMovingRight(true);
            }
            if (event.getCode() == KeyCode.W){
                InGameModel.getGameModel().setMovingUp(true);
            }
            if (event.getCode() == KeyCode.S){
                InGameModel.getGameModel().setMovingDown(true);
            }
            // TODO add all pressed down events.
        }
        else if (event.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            if (event.getCode() == KeyCode.SPACE) {
                InGameModel.getGameModel().setShooting(false);
            }
            if (event.getCode() == KeyCode.A){
                InGameModel.getGameModel().setMovingLeft(false);
            }
            if (event.getCode() == KeyCode.D){
                InGameModel.getGameModel().setMovingRight(false);
            }
            if (event.getCode() == KeyCode.W){
                InGameModel.getGameModel().setMovingUp(false);
            }
            if (event.getCode() == KeyCode.S){
                InGameModel.getGameModel().setMovingDown(false);
            }
            //TODO add all released events.
        }


    }


}


package controller;

import model.PlayerShip;
import view.ViewManager;

public class SpaceInvaderController {

    private static SpaceInvaderController controller;
    private static SpaceInvaderListener listener;
    private static ViewManager view;

    public static SpaceInvaderController getController() {
        if (controller == null) {
            controller = new SpaceInvaderController();
        }
        return controller;
    }


    private SpaceInvaderController() {
        setGameToStart();
        this.view = ViewManager.getViewManager();
        listener = SpaceInvaderListener.getListener(view);



    }

    private void setGameToStart() {
        view.setPlayer(new PlayerShip());

    }


    }



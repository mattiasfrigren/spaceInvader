package view;

public class ViewManager {

    public void enableView(boolean inGame){
        if (inGame) {
            SpaceInvaderInGameView inGameView = new SpaceInvaderInGameView();
        }
    }


}

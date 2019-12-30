package model;

import controller.SpaceInvaderController;
import javafx.scene.media.AudioClip;


import java.io.File;

public class SoundEffects {

    public void playSound(String soundPath) {
        if (SpaceInvaderController.getController().isSoundOn()) {
            new AudioClip(new File(soundPath).toURI().toString()).play();
        }
    }

}

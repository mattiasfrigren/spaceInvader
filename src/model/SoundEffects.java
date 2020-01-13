package model;

import controller.SpaceInvaderController;
import javafx.scene.media.AudioClip;


import java.io.File;

/**
 * This class handles the sound.
 *
 * @author Isabelle Romhagen, Ludvig Lundin, Mattias Frigren, Jasmine Söderberg, Khazar Mehraban
 * @version 1.2
 */

public class SoundEffects {

    /**
     * Checks if sound is on, and plays if true.
     * @param soundPath link to where the sound file is stored
     */
    public static void playSound(String soundPath) {
        if (SpaceInvaderController.getController().isSoundOn()) {
            new AudioClip(new File(soundPath).toURI().toString()).play();
        }
    }

}

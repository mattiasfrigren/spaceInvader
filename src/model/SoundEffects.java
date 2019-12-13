package model;

import controller.SpaceInvaderController;
import javafx.scene.media.AudioClip;


import java.io.File;

public class SoundEffects {

    private static SoundEffects soundEffects;
    public static SoundEffects getSoundEffects() {
        if (soundEffects==null){
            soundEffects=new SoundEffects();
        }
        return soundEffects;
    }




    private String laser1 = "src\\model\\resources\\Laser1.wav";
    private String laser2 = "src\\model\\resources\\Laser2.wav";
    private String explo = "src\\model\\resources\\Explosion.wav";
    private String explo2 = "src\\model\\resources\\Explosion2.wav";
    private String pUp = "src\\model\\resources\\Powerup.wav";
    private String plasma = "src\\model\\resources\\Sci-Fi Plasma.mp3";

    private AudioClip laserSound1 = new AudioClip(new File(laser2).toURI().toString());
    private AudioClip laserSound2 = new AudioClip(new File(laser2).toURI().toString());
    private AudioClip explosion = new AudioClip(new File(explo).toURI().toString());
    private AudioClip explosion2 = new AudioClip(new File(explo2).toURI().toString());
    private AudioClip powerUp = new AudioClip(new File(pUp).toURI().toString());


    public void playLaser1Sound() {
        if (SpaceInvaderController.getController().isSoundOn()) {
            laserSound1.play();
        }
    }

    public void playLaser2Sound() {
        if (SpaceInvaderController.getController().isSoundOn()) {
            laserSound2.play();
        }
    }

    public void playExplosion1Sound() {
        explosion.play();
    }

    public void playExplosion2Sound() {
        explosion2.play();
    }

    public void playPowerUpSound() {
        if (SpaceInvaderController.getController().isSoundOn()) {
            powerUp.play();
        }
    }

}

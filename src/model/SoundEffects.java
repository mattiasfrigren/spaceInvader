package model;

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
     String laser1 ="src\\media\\Laser1.wav";
     String laser2 = "src\\media\\Laser2.wav";
     String explo = "src\\media\\Explosion.wav";
     String explo2 = "src\\media\\Explosion2.wav";
     String pUp = "src\\media\\Powerup.wav";
     String plasma = "src\\media\\Sci-Fi Plasma.mp3";

    private AudioClip laserSound1 = new AudioClip(new File(laser2).toURI().toString());
    private AudioClip laserSound2 = new AudioClip(new File(laser2).toURI().toString());
    private AudioClip explosion = new AudioClip(new File(explo).toURI().toString());
    private AudioClip explosion2 = new AudioClip(new File(explo2).toURI().toString());
    private AudioClip powerUp = new AudioClip(new File(pUp).toURI().toString());
    private AudioClip plasmaSciFi = new AudioClip(new File(plasma).toURI().toString());

    public void playLaser1Sound() {
        laserSound1.play();
    }

    public void playLaser2Sound() {
        laserSound2.play();
    }

    public void playExplosion1Sound() {
        explosion.play();
    }

    public void playExplosion2Sound() {
        explosion2.play();
    }

    public void playPowerUpSound() {
        powerUp.play();
    }

    public void playPlasmaSound() {
        plasmaSciFi.play();
    }


}

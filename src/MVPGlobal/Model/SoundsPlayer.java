package MVPGlobal.Model;

import MVPGlobal.View.UISettings;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

/**
 * This is the class for the sound player
 * sound player handles everything that is involving sounds
 *
 * @author Sam Rotthier
 * @author Matthias Vermeiren
 * @version 3.0
 */
public class SoundsPlayer {

    private UISettings uiSettings;
    private MediaPlayer backgroundMusic;
    private AudioClip startBtn;
    private AudioClip loadBtnSound;
    private AudioClip infoBtnSound;
    private AudioClip cardDeal1;
    private AudioClip cardDeal2;
    private AudioClip cardDeal3;
    private AudioClip cardDeal4;
    private AudioClip cardDeal5;
    private static final int NUM_DEAL = 5;

    /**
     * This is the constructor for the sound player
     */
    public SoundsPlayer() {
        this.uiSettings = new UISettings();
        initialiseNodes();
        layoutNodes();
    }

    /**
     * In this method we initialize all the necessary things.
     */
    private void initialiseNodes() {
        try {
            backgroundMusic = new MediaPlayer(new Media(uiSettings.getBackgroundMusicGame().toUri().toURL().toString()));
        } catch (MalformedURLException ex) {
        }
        startBtn = new AudioClip(uiSettings.getStartBtnSound().toUri().toString());
        loadBtnSound = new AudioClip(uiSettings.getLoadBtnSound().toUri().toString());
        infoBtnSound = new AudioClip(uiSettings.getInfoBtnSound().toUri().toString());
        cardDeal1 = new AudioClip(uiSettings.getCardDealSound1().toUri().toString());
        cardDeal2 = new AudioClip(uiSettings.getCardDealSound2().toUri().toString());
        cardDeal3 = new AudioClip(uiSettings.getCardDealSound3().toUri().toString());
        cardDeal4 = new AudioClip(uiSettings.getCardDealSound4().toUri().toString());
        cardDeal5 = new AudioClip(uiSettings.getCardDealSound5().toUri().toString());
        setVolumeTo80();

    }

    private void layoutNodes() {
    }

    /**
     * Here we set the volume to 80%
     */
    private void setVolumeTo80(){
        backgroundMusic.setVolume(0.8);
        startBtn.setVolume(0.8);
        infoBtnSound.setVolume(0.8);
        loadBtnSound.setVolume(0.8);
        cardDeal1.setVolume(0.8);
        cardDeal2.setVolume(0.8);
        cardDeal3.setVolume(0.8);
        cardDeal4.setVolume(0.8);
        cardDeal5.setVolume(0.8);
    }

    /**
     * This will start the sounds in the start screen
     */
    public void playBlackjackStart(){
       try{
            String blackjackStartSound = uiSettings.getBlackjackStartSound().toString();
            AudioClip blackjackStart = new AudioClip(new File(blackjackStartSound).toURI().toURL().toString());
            blackjackStart.play();
        }
        catch(MalformedURLException ex){}
    }

    /**
     * This will start the background music in the main screen
     */
    public void playBackgroundMusic(){
        backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);
        backgroundMusic.play();
    }

    /**
     * This will stop the background music
     */
    public void stopBackgroundMusic(){
        backgroundMusic.stop();
    }

    /**
     * This will play the sound for the play button
     */
    public void playStartBtn(){
            startBtn.play();
    }

    /**
     * This will play the sound for the load button
     */
    public void playLoadBtn(){
            loadBtnSound.play();
    }

    /**
     * This will play the sound for the info button
     */
    public void playInfoBtn(){
            infoBtnSound.play();
    }

    /**
     * This will play the sound for the deal or hit button
     */
    public void playDealCard() {
        Random random = new Random();
        int dealSoundNumber = random.nextInt(NUM_DEAL) + 1;

        switch (dealSoundNumber) {
            case 1:
                cardDeal1.play();
                break;
            case 2:
                cardDeal2.play();
                break;
            case 3:
                cardDeal3.play();
                break;
            case 4:
                cardDeal4.play();
                break;
            case 5:
                cardDeal5.play();
                break;
        }

    }
    // Getters & Setters
    public double getBackgroundMusicVolume(){
        return backgroundMusic.getVolume() * 100;
    }

    public double getSoundFXVolume(){
        return cardDeal1.getVolume() * 100;
    }

    public void setBackgroundMusicVolume(double volume) {
        backgroundMusic.setVolume(volume);
    }

    public void setSoundFXVolume(double volume){
        startBtn.setVolume(volume);
        infoBtnSound.setVolume(volume);
        loadBtnSound.setVolume(volume);
        cardDeal1.setVolume(volume);
        cardDeal2.setVolume(volume);
        cardDeal3.setVolume(volume);
        cardDeal4.setVolume(volume);
        cardDeal5.setVolume(volume);
    }
}


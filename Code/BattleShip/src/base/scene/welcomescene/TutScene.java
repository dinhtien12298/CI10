package base.scene.welcomescene;

import base.GameObject;
import base.scene.Scene;
import javafx.scene.media.MediaPlayer;
import tklibs.AudioUtils;

public class TutScene extends Scene {
    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        AudioUtils.initialize();
        MediaPlayer mediaPlayer = AudioUtils.playMedia("assets/sounds/glassbell.wav");
        mediaPlayer.play();
        GameObject bannerlv1 = GameObject.recycle(BannerTut.class);
    }

    @Override
    public void run() {

    }
}
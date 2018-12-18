package base.scene.welcomescene;

import base.GameObject;
import base.scene.Scene;
import javafx.scene.media.MediaPlayer;
import tklibs.AudioUtils;

public class Level1Scene extends Scene {
    @Override
    public void destroy() {
       GameObject.clearAll();
    }

    @Override
    public void init() {
        AudioUtils.initialize();
        MediaPlayer mediaPlayer = AudioUtils.playMedia("assets/sounds/glassbell.wav");
        mediaPlayer.play();
        GameObject bannerlv1 = GameObject.recycle(Bannerlv1.class);
    }

    @Override
    public void run() {

    }
}
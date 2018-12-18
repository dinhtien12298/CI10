package base.scene.gamewinscene;

import base.GameObject;
import base.scene.Scene;
import javafx.scene.media.MediaPlayer;
import tklibs.AudioUtils;

public class GameWinScene extends Scene {
    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        AudioUtils.initialize();
        MediaPlayer mediaPlayer = AudioUtils.playMedia("assets/sounds/win.mp3");
        mediaPlayer.play();
        GameObject.recycle(BannerWinScene.class);
    }

    @Override
    public void run() {

    }
}

package base.scene;

import base.BackgroundStone;
import base.GameObject;
import base.player.Player;
import base.stone.StoneSummon;
import javafx.scene.media.MediaPlayer;
import tklibs.AudioUtils;

public class SceneStage2 extends Scene {

    public BackgroundStone backgroundStone;
    public Player player;
    StoneSummon stoneSummon;

    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        AudioUtils.initialize();
        MediaPlayer mediaPlayer = AudioUtils.playMedia("assets/sounds/background.mp3");
        mediaPlayer.play();
        this.backgroundStone = GameObject.recycle(BackgroundStone.class);
        this.player = GameObject.recycle(Player.class);
        stoneSummon= GameObject.recycle(StoneSummon.class);
    }
    @Override
    public void run() {
        super.run();
        stoneSummon.isEnd = backgroundStone.isEnd;
    }
}

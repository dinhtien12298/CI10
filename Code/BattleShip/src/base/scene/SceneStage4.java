package base.scene;

import base.BackgroundBoss;
import base.GameObject;
import base.enemy.enemyboss.EnemyBoss;
import base.player.Player;
import base.scene.gamewinscene.GameWinScene;
import base.stone.StoneSummon;
import base.tank.TankSummon;
import javafx.scene.media.MediaPlayer;
import tklibs.AudioUtils;

public class SceneStage4 extends Scene {

    public BackgroundBoss background;
    public Player player;
    TankSummon tankSummon;
    EnemyBoss enemyBoss;

    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        AudioUtils.initialize();
        MediaPlayer mediaPlayer = AudioUtils.playMedia("assets/sounds/background.mp3");
        mediaPlayer.play();

        this.background = GameObject.recycle(BackgroundBoss.class);
        this.player = GameObject.recycle(Player.class);
        enemyBoss = GameObject.recycle(EnemyBoss.class);
        tankSummon= GameObject.recycle(TankSummon.class);

    }

    @Override
    public void run() {
        super.run();
    }
}


package base.enemy;

import base.GameObject;
import base.Vector2D;
import base.renderer.AnimationRenderer;

import java.awt.*;

public class Explosion extends GameObject {
    public Explosion() {
        this.position = new Vector2D();
        this.renderer = new AnimationRenderer(
                3   , true,
                "assets/images/enemies/explosion/0.png",
                "assets/images/enemies/explosion/1.png",
                "assets/images/enemies/explosion/2.png",
                "assets/images/enemies/explosion/3.png",
                "assets/images/enemies/explosion/4.png",
                "assets/images/enemies/explosion/5.png",
                "assets/images/enemies/explosion/6.png",
                "assets/images/enemies/explosion/7.png"
        );
    }
}

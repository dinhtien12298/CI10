package base.canon;

import base.GameObject;
import base.Vector2D;
import base.event.KeyEventPress;
import base.event.MouseEvent;

public class Canon extends GameObject {
    public Canon() {
        this.position = new Vector2D();
        this.renderer = new CanonAnimator();
    }

    @Override
    public void run() {
    }
}

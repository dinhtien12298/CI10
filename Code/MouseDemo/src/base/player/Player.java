package base.player;

import base.*;
import base.counter.FrameCounter;
import base.event.KeyEventPress;
import base.physics.BoxCollider;
import base.physics.Physics;

public class Player extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider collider;
    int hp;
    Vector2D velocity;

    public Player() {
        super();
        //TODO: EDITED
        this.renderer = new PlayerAnimator();
        this.position = new Vector2D(Settings.START_PLAYER_POSITION_X
                , Settings.START_PLAYER_POSITION_Y);
        this.fireCounter = new FrameCounter(10);
        this.collider = new BoxCollider(32, 48);
        this.hp = 20;
        this.velocity = new Vector2D(0, 0);
    }

    @Override
    public void run() {
        //TODO: EDITED
        int vx = 0;
        int vy = 0;
        if(KeyEventPress.isUpPress) {
            vy -= 1;
        }
        if(KeyEventPress.isDownPress) {
            vy += 1;
        }
        if(KeyEventPress.isRightPress) {
            vx += 1;
        }
        if(KeyEventPress.isLeftPress) {
            vx -= 1;
        }
        this.move(vx, vy);
        //fire
        boolean fireCounterRun = this.fireCounter.run();
        if(KeyEventPress.isFirePress && fireCounterRun) {
            this.fire();
        }
        this.position.addThis(this.velocity);
    }

    public void fire() {
        PlayerBulletType1 bullet = GameObject.recycle(PlayerBulletType1.class);
        PlayerBulletType1 bullet2 = GameObject.recycle(PlayerBulletType1.class);
        PlayerBulletType1 bullet3 = GameObject.recycle(PlayerBulletType1.class);

        bullet.velocity.set(0, -2);
        bullet2.velocity.set(2, -2);
        bullet3.velocity.set(-2, -2);

        bullet.position.set(this.position.x, this.position.y);        bullet.position.set(this.position.x, this.position.y);
        bullet2.position.set(this.position.x, this.position.y);
        bullet3.position.set(this.position.x, this.position.y);

        this.fireCounter.reset();
    }

    public void move(int velocityX, int velocityY) {
        //TODO: EDITED
        if(velocityX == 0 && velocityY == 0) {
            this.velocity.set(0, 0);
        } else {
            this.velocity.addThis(velocityX, velocityY);
            this.velocity.set(clamp(velocity.x, -3, 3),
                    clamp(velocity.y, -3, 3));
        }
    }

    public float clamp(float number, float min, float max) {
        return number < min ? min : number > max ? max : number;
    }


    public void takeDamage(int damage) {
        this.hp -= damage;
        if(this.hp <= 0) {
            this.destroy();
            hp = 0;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}

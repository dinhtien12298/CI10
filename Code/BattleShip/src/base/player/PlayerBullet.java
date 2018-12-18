package base.player;

import base.Settings;
import base.enemy.EnemyBullet;
import base.enemy.enemyboss.EnemyBoss;
import base.enemy.enemyboss.EnemyBossBullet;
import base.physics.BoxCollider;
import base.GameObject;
import base.physics.Physics;
import base.Vector2D;
import base.enemy.Enemy;
import base.renderer.AnimationRenderer;
import base.tank.Tank;
import base.tank.TankBullet1;
import base.tank.TankBullet2;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject implements Physics {
    public Vector2D velocity;
    int damage;

    public PlayerBullet() {
        super();
        this.position = new Vector2D(0, 0);
        this.velocity = new Vector2D(0, 0);
        this.damage = Settings.PLAYER_DAMAGE;
    }

    @Override
    public void run() {
        Enemy enemy = GameObject.intersect(Enemy.class, this);
        EnemyBullet enemyBullet = GameObject.intersect(EnemyBullet.class,this);
        EnemyBossBullet enemyBossBullet = GameObject.intersect(EnemyBossBullet.class, this);
        TankBullet1 tankBullet1 = GameObject.intersect(TankBullet1.class, this);
        TankBullet2 tankBullet2 = GameObject.intersect(TankBullet2.class, this);
        Tank tank=GameObject.intersect(Tank.class,this);
        EnemyBoss boss = GameObject.intersect(EnemyBoss.class, this);

       if (enemyBullet!=null){
            this.destroy();
            enemyBullet.destroy();
       }

        if (enemyBossBullet!=null){
            this.destroy();
            enemyBossBullet.destroy();
        }

        if (tankBullet1!=null){
            this.destroy();
            tankBullet1.destroy();
        }

        if (tankBullet2!=null){
            this.destroy();
            tankBullet2.destroy();
        }
        
        if(enemy != null) {
            enemy.takeDamage(this.damage);
            this.hitEnemy();
            return;
        }
        
        if(tank!=null){
            this.destroy();
            tank.destroy();
        }

        if(boss != null) {
            boss.takeDamageByPlayer(this.damage);
            this.hitBoss();
            return;
        }
        
        if(this.position.y < -50) {
            this.destroy();
            return;
        }
        this.position.addThis(velocity);
    }

    public void hitBoss() {
    }

    public void hitEnemy() {
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}

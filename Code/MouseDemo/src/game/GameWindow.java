package game;

import base.event.KeyEventPress;
import base.Settings;
import base.event.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;

public class GameWindow extends JFrame {
    GameCanvas canvas;

    public GameWindow() {
        //setup window
        this.setSize(Settings.SCREEN_WIDHT, Settings.SCREEN_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setupEventListtener();
        //init game
        this.canvas = new GameCanvas();
        this.add(canvas);

        this.setVisible(true);
    }

    private void setupEventListtener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isLeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isLeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isFirePress = false;
                }
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e) {
                saveMousePosition(e.getX(), e.getY());
            }
        });
    }

    private void saveMousePosition(int x, int y) {
        Insets insets = this.getInsets();
        MouseEvent.mousePosition.set(x - insets.left, y - insets.top);
    }

    public void gameLoop() {
        long delay = 1000 / 60;
        long lastTime = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime > delay) {
                canvas.run(); //runAll()
                canvas.render(); // render all to backBuffer
                this.repaint(); // render backBuffer to game
                lastTime = currentTime;
            }
        }
    }
}

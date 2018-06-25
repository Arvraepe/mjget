/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.windows;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author arvraepe
 */
public class GameWindowManager {
    
    public static GameWindowManager instance = new GameWindowManager();
    
    private GameWindow window;
    
    public GameWindowManager () {}
    
    public void create (String title) {
        this.window = new GameWindow("Game v0.1");
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) { }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });
    }
    
    public void addKeyListener (KeyListener listener) {
        this.window.addKeyListener(listener);
    }
    
    public void hideCursor () {
        this.window.hideCursor();
    }
    
    public GameWindow getWindow () {
        return this.window;
    }
    
}

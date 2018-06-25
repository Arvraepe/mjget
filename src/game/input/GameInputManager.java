/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.input;

import game.windows.GameWindowManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author arvraepe
 */
public class GameInputManager {
    
    public static GameInputManager instance = new GameInputManager();
    
    private ArrayList<Integer> pressed = new ArrayList<>();
    
    public GameInputManager () {
        GameWindowManager.instance.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {  }

            @Override
            public void keyPressed(KeyEvent e) {
                if (!pressed.contains(e.getKeyCode())) pressed.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Iterator<Integer> it = pressed.iterator();
                while(it.hasNext()) {
                    if(it.next().equals(e.getKeyCode())) {
                        it.remove();
                    }
                }
            }
        
        });
    }
    
    public boolean isPressed (int keyCode) {
        return pressed.contains(keyCode);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.content.levels;

import game.content.map.blocks.AbstractBlock;
import game.helpers.GamePoint;
import game.helpers.IRenderable;
import game.helpers.IUpdatable;
import game.input.GameInputManager;
import game.windows.GameWindowManager;
import game.windows.IGameScene;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author arvraepe
 */
public abstract class AbstractGameLevel implements IGameScene, IUpdatable, IRenderable {
    
    private GamePoint offset = GamePoint.origin();
    
    protected ArrayList<ArrayList<AbstractBlock>> environment = new ArrayList<ArrayList<AbstractBlock>>();
    
    @Override
    public void render () {       
        for (int x = 0; x < environment.size(); x++) {
            for (int y = 0; y < environment.get(x).size(); y++) {
                AbstractBlock block = environment.get(x).get(y);
                
                GameWindowManager.instance.getWindow().getGameScreen().copy(offset.getX() + x * block.getWidth(), offset.getY() + y * block.getWidth(), block.getPixels(), block.getWidth());
            }
        }        
    }
    
    @Override
    public void update () {
       
        int width = GameWindowManager.instance.getWindow().getSize().width;
        int height = GameWindowManager.instance.getWindow().getSize().height;        
        int speed = 1;
        
        if (GameInputManager.instance.isPressed(KeyEvent.VK_UP)) {
            if (offset.getY() - speed > 0) offset.up(speed);
        }
        
        if (GameInputManager.instance.isPressed(KeyEvent.VK_DOWN)) {
            if (offset.getY() + speed < height) offset.down(speed);
        }
        
        if (GameInputManager.instance.isPressed(KeyEvent.VK_LEFT)) {
            if (offset.getX() - speed > 0) offset.left(speed);
        }
        
        if (GameInputManager.instance.isPressed(KeyEvent.VK_RIGHT)) {
            if (offset.getX() - speed < height) offset.right(speed);
        }
                
    }
    
}

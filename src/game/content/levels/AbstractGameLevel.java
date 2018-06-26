/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.content.levels;

import game.content.map.blocks.AbstractBlock;
import game.content.map.blocks.VoidBlock;
import game.helpers.GamePoint;
import game.helpers.IRenderable;
import game.helpers.IUpdatable;
import game.input.GameInputManager;
import game.windows.GameScreenSettings;
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
        
        int sx = offset.getX() / GameScreenSettings.getGameTileSize();
        int sy = offset.getY() / GameScreenSettings.getGameTileSize();
        
        int mx = sx + GameWindowManager.instance.getWindow().getSize().width / GameScreenSettings.getGameTileSize();
        int my = sy + GameWindowManager.instance.getWindow().getSize().height / GameScreenSettings.getGameTileSize();
        
        int sxOffset = offset.getX() % GameScreenSettings.getGameTileSize();
        int syOffset = offset.getY() % GameScreenSettings.getGameTileSize();
        
        for (int x = sx; x < mx; x++) {
            for (int y = sy; y < my; y++) {
                AbstractBlock block = getBlock(x, y);
                
                int exOffset = x == mx - 1 ? offset.getX() % GameScreenSettings.getGameTileSize() : 0;
                int eyOffset = y == my - 1 ? offset.getY() % GameScreenSettings.getGameTileSize() : 0;
                
                GameWindowManager.instance.getWindow().getGameScreen().copy(sxOffset + x * block.getWidth(), syOffset + y * block.getWidth(), block.getPixels(), block.getWidth() - exOffset);
            }
        }        
    }
    
    public AbstractBlock getBlock (int x, int y) {
        if (x < environment.size()) {
            if (y < environment.get(x).size()) {
                return environment.get(x).get(y);
            } else {
                return new VoidBlock();
            }
        }
        
        return new VoidBlock();        
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

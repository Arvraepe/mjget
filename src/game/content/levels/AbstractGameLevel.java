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
import java.awt.Point;
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
        
        int sxt = offset.getX() / GameScreenSettings.getGameTileSize();
        int syt = offset.getY() / GameScreenSettings.getGameTileSize();
        
        int mxt = sxt + GameWindowManager.instance.getWindow().getSize().width / GameScreenSettings.getGameTileSize();
        int myt = syt + GameWindowManager.instance.getWindow().getSize().height / GameScreenSettings.getGameTileSize();
        
        int sxpOffset = offset.getX() % GameScreenSettings.getGameTileSize();
        int sypOffset = offset.getY() % GameScreenSettings.getGameTileSize();
        
        for (int xt = sxt; xt < mxt; xt++) {
            for (int yt = syt; yt < myt; yt++) {
                AbstractBlock block = getBlock(xt, yt);

                Point bsOffset = new Point(0, 0);
                Point beOffset = new Point(block.getWidth(), block.getHeight());
                
                if (xt == sxt) {
                    // block in the first column
                    bsOffset.x = sxpOffset;
                }                               
                
                if (xt == mxt - 1) {
                    // block in the last column
                    beOffset.x = block.getWidth() - sxpOffset;
                }
                
                if (yt == syt) {
                    // block the first row
                    bsOffset.y = sypOffset;
                }
                
                if (yt == myt - 1) {
                    // block the last row
                    bsOffset.y = block.getHeight() - sypOffset;
                }
                                
                GameWindowManager.instance.getWindow().getGameScreen().copy(sxpOffset + xt * block.getWidth(), sypOffset + yt * block.getWidth(), block.getPixels(), block.getWidth(), bsOffset, beOffset);
                
            }
        }        
    }
    
    public AbstractBlock getBlock (int x, int y) {
        if (x >= 0 && x < environment.size()) {
            if (y >= 0 && y < environment.get(x).size()) {
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
            offset.down(speed);
        }
        
        if (GameInputManager.instance.isPressed(KeyEvent.VK_DOWN)) {
            offset.up(speed);
        }
        
        if (GameInputManager.instance.isPressed(KeyEvent.VK_LEFT)) {
            offset.right(speed);
        }
        
        if (GameInputManager.instance.isPressed(KeyEvent.VK_RIGHT)) {
            offset.left(speed);
        }
                
    }
    
}

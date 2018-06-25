/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.content.map.blocks;

import game.windows.GameColor;
import game.windows.GameScreenEntity;
import game.windows.GameScreenSettings;

/**
 *
 * @author arvraepe
 */
public class StoneBlock extends AbstractBlock {
    
    public StoneBlock () {
        super(GameScreenSettings.getGameTileSize());
        
        fill(GameColor.argb("#333333"));
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.content.map.blocks;

import game.windows.GameColor;
import game.windows.GameScreenSettings;

/**
 *
 * @author arvraepe
 */
public class VoidBlock extends AbstractBlock {
    
    public VoidBlock() {
        super(GameScreenSettings.getGameTileSize());
        
        fill(GameColor.argb("#111111"));
    }
    
}

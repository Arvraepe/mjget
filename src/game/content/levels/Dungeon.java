/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.content.levels;

import game.content.map.blocks.*;
import game.windows.GameWindowManager;
import java.util.ArrayList;

/**
 *
 * @author arvraepe
 */
public class Dungeon extends AbstractGameLevel {
    
    public Dungeon () {
        /**
         * TEST CODE
         */
        int xs = GameWindowManager.instance.getWindow().getSize().width / 5;
        int ys = GameWindowManager.instance.getWindow().getSize().height / 5;
        
        for (int x = 0; x < xs; x++) {
            
            ArrayList<AbstractBlock> row = new ArrayList<AbstractBlock>();
            
            for (int y = 0; y < ys; y++) {
                row.add(new StoneBlock());
            }
            
            this.environment.add(row);
        }   
        
        this.environment.get(10).set(30, new FloorBlock());
    }
    
}

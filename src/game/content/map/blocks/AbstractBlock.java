/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.content.map.blocks;

import game.windows.GameScreenEntity;

/**
 *
 * @author arvraepe
 */
public class AbstractBlock extends GameScreenEntity {
    
    public AbstractBlock (int size) {
        super(size, size);
    }
    
}

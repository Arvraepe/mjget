/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.windows;

/**
 *
 * @author arvraepe
 */
public class GameScreenEntityGenerator {
    
    public GameScreenEntity rectangle (int width, int height, int color) {
        GameScreenEntity entity = new GameScreenEntity (new int[width * height], width, height);
        
        for (int i = 0; i < entity.getPixels().length; i++) {
            entity.setPixel(i, color);
        }
        
        return entity;
    }
    
}

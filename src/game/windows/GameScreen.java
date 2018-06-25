/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.windows;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 *
 * @author arvraepe
 */
public final class GameScreen extends GameScreenEntity {
    
    private BufferedImage screen;
    
    public GameScreen(int width, int height) {
        this.screen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        this.width = width;
        this.height = height;
        this.pixels = ((DataBufferInt) this.screen.getRaster().getDataBuffer()).getData();              

        // This defaults the GameScreen to a beautiful blacke
        for (int i = 0; i < this.pixels.length; i++) {
            setPixel(i, GameColor.foreground);
        }
    }    
    
    public BufferedImage image () {
        return this.screen;
    }
    
}

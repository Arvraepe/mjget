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
public class GameScreenEntity {
    
    protected int[] pixels;
    
    protected int width, height;    
    
    public GameScreenEntity () { }
    
    public GameScreenEntity (int width, int height) {
        this(new int[width * height], width, height);
    }
    
    public GameScreenEntity (int[] pixels, int width, int height) {
        this.pixels = pixels;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public int[] getPixels() {
        return pixels;
    }
    
    public void copy (int x, int y, int[] pixels, int xOffset, int yOffset, int width) {
        int partialWidth = width - xOffset;
        
        for (int i = 0; i < pixels.length; i++) {
            int screenxp = x + i % width;
            int screenyp = y + i / width;
            
            setPixel(screenxp, screenyp, pixels[i]);   
        }
    }
        
    public void setPixel (int x, int y, int color) {
        setPixel(x + y * this.width, color);
    }
    
    public void setPixel (int position, int color) {
        if (position >= 0 && position < this.pixels.length)
            this.pixels[position] = color;
    } 
    
    protected void fill (int color) {
        for (int i = 0; i < this.pixels.length; i++) {
            setPixel (i, color);
        }
    }
    
}

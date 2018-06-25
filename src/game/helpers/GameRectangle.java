/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.helpers;

/**
 *
 * @author arvraepe
 */
public class GameRectangle {

    private GamePoint topLeft, topRight, bottomLeft, bottomRight;
    private int width, height;
    
    /**
     * 
     * Coordinates passed along to the constructor always represent Top Left coordinate of the Rectangle
     * 
     * @param x
     * @param y
     * @param width
     * @param height 
     */
    public GameRectangle (int x, int y, int width, int height) {        
        this.width = width;
        this.height = height;
        
        this.topLeft = new GamePoint(x, y);
        this.topRight = new GamePoint(x + width, y);
        this.bottomLeft = new GamePoint(x, y + height);
        this.bottomRight = new GamePoint(x + width, y + height);        
    }
    
    public static GameRectangle create (int x, int y, int width, int height) {
        return new GameRectangle(x, y, width, height);
    }
    
    public void transform (int x, int y) {
        this.topLeft = new GamePoint(x, y);
        this.topRight = new GamePoint(x + this.width, y);
        this.bottomLeft = new GamePoint(x, y + this.height);
        this.bottomRight = new GamePoint(x + this.width, y + this.height);
    }

    public GamePoint getTopLeft() {
        return topLeft;
    }

    public GamePoint getTopRight() {
        return topRight;
    }

    public GamePoint getBottomLeft() {
        return bottomLeft;
    }

    public GamePoint getBottomRight() {
        return bottomRight;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
}

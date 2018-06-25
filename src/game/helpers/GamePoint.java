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
public class GamePoint {
    
    private int x, y;
    
    public GamePoint (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void up (int amount) {
         this.y -= amount;
    }
    
    public void down (int amount) {
        this.y += amount;
    }
    
    public void left (int amount) {
        this.x -= amount;
    }
    
    public void right (int amount) {
        this.x += amount;
    }
    
    public static GamePoint origin () {
        return new GamePoint(0, 0);
    }
    
}

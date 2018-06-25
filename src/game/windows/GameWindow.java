/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.windows;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import javax.swing.JFrame;

/**
 *
 * @author arvraepe
 */
public class GameWindow extends JFrame { 
    
    public static final int FPS = 60;
    
    private GameScreen screen;
    
    public GameWindow (String title) {
        super(title);
        
        initialize();
        
    }
    
    private void initialize () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);         
        getContentPane().setBackground(Color.BLACK);                   
                
        setUndecorated(true);  
        setVisible(true);
        
        hideCursor();
        
        pack();            
        
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);                        
        
        createGameScreen();
    }
    
    public void hideCursor () {
        setCursor(getToolkit().createCustomCursor(new BufferedImage( 1, 1, BufferedImage.TYPE_INT_ARGB ), new Point(), null ));
    }
    
    public void showCursor (BufferedImage cursor) {
        showCursor(cursor, new Point(this.getSize().width / 2, this.getSize().height / 2));
    }
    
    public void showCursor (BufferedImage cursor, Point coordinates) {
        setCursor(getToolkit().createCustomCursor(cursor, coordinates, null ));
    }
    
    private void createGameScreen() {        
        this.screen = new GameScreen(this.getSize().width, this.getSize().height);
    }
    
    public GameScreen getGameScreen () {
        return this.screen;
    }
    
    @Override
    public void paint (Graphics g) {                                            
        if (this.screen != null) {            
            g.drawImage(this.screen.image(), 0, 0, this.screen.getWidth(), this.screen.getHeight(), null);
        }
    }
    
}


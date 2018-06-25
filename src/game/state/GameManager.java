/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import game.windows.GameWindow;
import game.windows.GameWindowManager;

/**
 *
 * @author arvraepe
 */
public class GameManager implements Runnable{
    
    public static final int UPS = 60;
    
    public static GameManager instance = new GameManager();
    
    private GameState state;
   
    private boolean running = false;
    
    public void start () {
        this.running = true;
        
        // This will happen when the game starts... not when the application is 
        // booted... but for now it's the same this
        this.state = GameState.create();
        
        new Thread(this).start();
    }    
    
    @Override
    public void run() {
    
        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / UPS;
        final double timeF = 1000000000 / GameWindow.FPS;
        double deltaU = 0, deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();

        while (running) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaU >= 1) {                
                update();
                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                render();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
//                if (RENDER_TIME) {
//                    System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
//                }
                frames = 0;
                ticks = 0;
                timer += 1000;
            }
        }
    }
    
    public GameState getState() {
        return this.state;
    }
    
    private void update () {
        if (this.state != null) this.state.update();
    }
    
    private void render () {    
        
        if (this.state != null) this.state.render();
        
        GameWindowManager.instance.getWindow().revalidate();
        GameWindowManager.instance.getWindow().repaint();
    }

    private void getInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

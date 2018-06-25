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
public class GameScreenSettings {
    
    private static int GAME_TILE_SIZE = 5;
    
    public static int getGameTileSize () {
        return GAME_TILE_SIZE;
    }
    
    public static void setGameTileSize (int GAME_TILE_SIZE) {
        GameScreenSettings.GAME_TILE_SIZE = GAME_TILE_SIZE;
    }
    
}

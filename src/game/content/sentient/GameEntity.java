/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.content.sentient;

import game.helpers.GamePoint;
import game.windows.GameScreenEntity;

/**
 *
 * @author arvraepe
 */
public abstract class GameEntity extends GameScreenEntity {
    
    protected GamePoint coordinates;  

    public GamePoint getCoordinates() {
        return coordinates;
    }
        
}

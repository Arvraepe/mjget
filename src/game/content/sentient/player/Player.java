/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.content.sentient.player;

import game.content.sentient.GameEntity;
import game.helpers.GamePoint;

/**
 *
 * @author arvraepe
 */
public class Player extends GameEntity {
    
    public Player () {
        this.coordinates = new GamePoint(0, 0);
    }
    
}

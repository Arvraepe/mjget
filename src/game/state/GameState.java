/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import game.content.levels.AbstractGameLevel;
import game.content.levels.Dungeon;
import game.content.sentient.player.Player;
import game.helpers.IRenderable;
import game.helpers.IUpdatable;
import game.input.GameInputManager;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author arvraepe
 */
public class GameState implements IUpdatable, IRenderable {
    
    private Player player;
    private AbstractGameLevel level;
    
    public GameState () {
        this.player = new Player();
        this.level = new Dungeon();
    }
    
    public static GameState create () {
        return new GameState();
    }
    
    public static GameState load () {
        throw new NotImplementedException();
    }

    public Player getPlayer() {
        return player;
    }
    
    @Override
    public void update () {
        this.level.update();
    }
    
    @Override
    public void render () {
        this.level.render();
    }
    
}

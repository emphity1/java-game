package game.states;

import java.awt.Graphics;
import game.*;



public abstract class State {
    
    //someting separate, i put it here anyway.
    private static State currentState = null;
    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }


    //Class func.
    
    protected Game game;
    public State(Game game){
        this.game = game;
    }
    public abstract void tick();

    public abstract void render(Graphics g);

    

}

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class End extends BasicGameState {

	Image winscreen;
	
	
	
	public End(int state) {
		
	}
	

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	 gc.setShowFPS(false);
	winscreen = new Image("res/winscreen.png");

	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		winscreen.draw(0,0);
		
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		
	}


	public int getID() {
		return 4;
	}

}

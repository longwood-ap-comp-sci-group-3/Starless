import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


public class Menu extends BasicGameState {
	Image menubackground;
	Music menumusic;
	
	
	public String mouse = "No input.";
	
	public Menu(int state) {
		
	}
	

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	 gc.setShowFPS(false);
	menubackground = new Image("res/menubackground.png");
	menumusic = new Music("res/menumusic.wav");
		
	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Starless", 400, 50);
		menubackground.draw(0,0);
		
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (!menumusic.playing()) {
			menumusic.play(1, (float) 1);
			}
		Input input = gc.getInput();
		int xpos = input.getMouseX();
		int ypos = input.getMouseY();
			
		
			if((xpos> 100 && xpos<273) && (ypos>172 && ypos<212)) {
				if(input.isMouseButtonDown(0)) {
					menumusic.stop();
					sbg.enterState(1, new FadeOutTransition(Color.black, 2000), new FadeInTransition(Color.black, 1000));
				}
			}
			
			if((xpos>124 && xpos<670) && (ypos>44 && ypos < 104)) {
				if(input.isMouseButtonDown(0)) {
					menumusic.stop();
					sbg.enterState(2);
				}
			}
			
				if((xpos>528 && xpos<682) && (ypos>172 && ypos<212)) {
					if(input.isMouseButtonDown(0)) {
					gc.exit();
					}
		}
		
		
		mouse = "X:" + xpos + " Y:" + ypos;
		
	}


	public int getID() {
		return 0;
	}

}

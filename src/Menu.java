import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;

public class Menu extends BasicGameState {

	Image menubackground;
	Music menumusic;
	
	
	public String mouse = "No input.";
	Image bruh;
	int bruhx = 200;
	int bruhy = 200;
	
	public Menu(int state) {
		
	}
	

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	
	bruh = new Image("res/download.jpg"); // Image example.
	menubackground = new Image("res/menubackground.png");
	menumusic = new Music("res/menumusic.wav");
		
	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Starless", 400, 50);
		menubackground.draw(0,0);
		g.drawString(mouse, 10, 25);
		
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (!menumusic.playing()) {
			menumusic.play(1, (float) 1);
			}
		Input input = gc.getInput();
		int xpos = input.getMouseX();
		int ypos = input.getMouseY();
			
		
			if((xpos> 240 && xpos<535) && (ypos>175 && ypos<250)) {
				if(input.isMouseButtonDown(0)) {
					menumusic.stop();
					sbg.enterState(1);
				}
			}
			
			if((xpos>80 && xpos<800) && (ypos>0 && ypos < 100)) {
				if(input.isMouseButtonDown(0)) {
					menumusic.stop();
					sbg.enterState(2);
				}
			}
			
				if((xpos>260 && xpos<532) && (ypos>384 && ypos<455)) {
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

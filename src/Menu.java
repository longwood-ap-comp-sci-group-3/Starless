import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;

public class Menu extends BasicGameState {

	Image playNow;
	Image exitGame;
	
	public String mouse = "No input.";
	Image bruh;
	int bruhx = 200;
	int bruhy = 200;
	
	public Menu(int state) {
		
	}
	

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	bruh = new Image("res/download.jpg"); // Image example.
	 playNow = new Image("res/button.png");
	exitGame = new Image ("res/button.png");

		
	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Starless", 400, 50);
		playNow.draw(400, 100);
		exitGame.draw(400, 200);
		g.drawString(mouse, 10, 25);
		g.drawImage(bruh, bruhx, bruhy);
		g.fillOval(75, 160, 100, 100);
		
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_UP)) {bruhy -= 2;;}
		if(input.isKeyDown(Input.KEY_DOWN)) {bruhy += 2;}
		if(input.isKeyDown(Input.KEY_LEFT)) {bruhx -= 2;}
		if(input.isKeyDown(Input.KEY_RIGHT)) {bruhx += 2;}
		int xpos = input.getMouseX();
		int ypos = input.getMouseY();
		if((xpos>75 && xpos<175) && (ypos>160 && ypos < 260)) {
			if(input.isMouseButtonDown(0)) {
				sbg.enterState(1);
			}
		}
		
		
		mouse = "X:" + xpos + " Y:" + ypos;
		}
		
	


	public int getID() {
		return 0;
	}

}

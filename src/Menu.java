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
	playNow = new Image("res/button.jpg");
	exitGame = new Image ("res/button.jpg");

		
	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Starless", 400, 50);
		playNow.draw(400, 100);
		exitGame.draw(400, 200);
		g.drawString(mouse, 10, 25);
		g.drawImage(bruh, bruhx, bruhy);
		g.fillOval(125, 125, 100, 100);;
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_UP)) {bruhy--;;}
		if(input.isKeyDown(Input.KEY_DOWN)) {bruhy++;}
		if(input.isKeyDown(Input.KEY_LEFT)) {bruhx--;}
		if(input.isKeyDown(Input.KEY_RIGHT)) {bruhx++;}
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

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

	Animation gunshot, standattack1, knifetoss, playerattackSpecial;
	Animation idle, enemyattack1, enemyattack2, enemyattackSpecial;
	Image worldMap;
	Animation movingUp, movingDown, movingLeft, movingRight;
	
	boolean quit = false;
	int[] duration = {200, 200};
	float enemyPositionX = 0;
	float enemyPositionY = 0;
	float shiftX = enemyPositionX + 400;
	float shiftY = enemyPositionY + 300;
	
	
	public Play(int state) {
		
	}
	

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	worldMap = new Image("res/worldMap.png");
	Image[] walkUp = {new Image("res/5head.png"), new Image("res/button.jpg")};
	Image[] walkDown = {new Image("res/5head.png"), new Image("res/button.jpg")};
	Image[] walkLeft = {new Image("res/5head.png"), new Image("res/button.jpg")};
	Image[] walkRight = {new Image("res/5head.png"), new Image("res/button.jpg")};

	movingUp = new Animation(walkUp, duration, false);
	movingDown = new Animation(walkDown, duration, false);
	movingLeft = new Animation(walkLeft, duration, false);
	movingRight = new Animation(walkRight, duration, false);
	idle = movingDown;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		worldMap.draw(enemyPositionX,enemyPositionY);
		idle.draw(shiftX, shiftY);
		g.drawString("X: " + enemyPositionX + "\nY: " + enemyPositionY, 0, 50);
		
		/* if (quit == true) {
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit Game (Q)", 250, 200);
		}
		if (quit == false) {
			g.clear();
		}
		*/
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_UP)) {idle = movingUp;
		enemyPositionY += delta * .1f;
		}
		if(input.isKeyDown(Input.KEY_DOWN)) {idle = movingDown;
		enemyPositionY -= delta * .1f;
		}
		if(input.isKeyDown(Input.KEY_LEFT)) {idle = movingLeft;
		enemyPositionX += delta * .1f;
		}
		if(input.isKeyDown(Input.KEY_RIGHT)) {idle = movingRight;
		enemyPositionX -= delta * .1f;
		}
		int xpos = input.getMouseX();
		int ypos = input.getMouseY();
	}


	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}

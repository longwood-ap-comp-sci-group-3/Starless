import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;



public class Fight extends BasicGameState {
	Animation gunshot, standattack1, knifetoss, playerattackSpecial;
	Animation idle, enemyattack1, enemyattack2, enemyattackSpecial;
	Image fightbattle, enemy, fight, fightbattlebackground;
	Music fightmusic;
	float enemyPositionX = 0;
	float enemyPositionY = 0;
	public String mouse = "No input.";
	
	public Fight(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		fightbattle = new Image("res/fightbattle.png");
		enemy = new Image("res/test.png");
		fight = new Image("res/fighticon.png");
		fightbattlebackground = new Image("res/fightbattleresources.png");
		fightmusic = new Music("res/fightmusic.wav");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawRect(52, 452, 698, 98);
		g.drawRect(52, 52, 698, 348);
		g.drawString(mouse, 200, 200);
		fightbattlebackground.draw(enemyPositionX + 53, enemyPositionY + 53);
		fightbattle.draw(enemyPositionX,enemyPositionY);
		enemy.draw(enemyPositionX + 300,enemyPositionY + 150);
		fight.draw(enemyPositionX + 70, enemyPositionY + 470);
		
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (!fightmusic.playing()) {
			fightmusic.play(1, (float) 0.03);
			}
		
		Input input = gc.getInput();
		int xpos = input.getMouseX();
		int ypos = input.getMouseY();
		
		mouse = "X:" + xpos + " Y:" + ypos;
		
	}

	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}

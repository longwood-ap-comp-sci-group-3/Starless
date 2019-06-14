import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import java.util.Random;





public class Fight extends BasicGameState {
	int enemyHealth, playerHealth;
	int time;
	int bruh;
	int spirit;
	int damage;
	int totalTime;
	boolean playerTurn, didPlayerTakeTurn;
	Image fightbattle, enemy, fight, special, run, fightbattlebackground, winscreen;
	Animation gunshot, standattack1, knifetoss, playerattackSpecial;
	Animation idle, enemyattack1, enemyattack2, enemyattackSpecial;
	long counter;
	
	
	
	Music fightmusic;
	boolean PAUSED = false;
	float enemyPositionX = 0;
	float enemyPositionY = 0;
	
	java.awt.Font fonter;
	TrueTypeFont awtFont;
	
	public Fight(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		gc.setShowFPS(false);
		spirit = 20;
		time = 0;
		damage = 0;
		bruh = 0;
		counter = 0;
		totalTime = 200;
		fonter =  new java.awt.Font("Comic Sans MS", java.awt.Font.PLAIN, 24);
		awtFont = new TrueTypeFont(fonter, false);
		enemyHealth = 500;
		playerHealth = 100;
		playerTurn = true;
		didPlayerTakeTurn = false;
		fightbattle = new Image("res/fightbattle.png");
		enemy = new Image("res/fightenemy.png");
		fight = new Image("res/fighticon.png");
		run = new Image("res/run.png");
		special = new Image("res/special.png");
		winscreen = new Image("res/winscreen.png");
		fightbattlebackground = new Image("res/fightbattleresources.png");
		fightmusic = new Music("res/fightmusic.wav");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		fightbattlebackground.draw(enemyPositionX + 53, enemyPositionY + 53);
		g.drawRect(52, 452, 698, 98);
		g.drawRect(52, 52, 698, 348);
		fightbattle.draw(enemyPositionX,enemyPositionY);
		enemy.draw(enemyPositionX + 280,enemyPositionY + 150);
		fight.draw(enemyPositionX + 70, enemyPositionY + 470);
		special.draw(enemyPositionX + 300, enemyPositionY + 470);
		run.draw(enemyPositionX + 530, enemyPositionY + 470);
		g.setColor(Color.black);
		g.drawString("Player HP: " + Integer.toString(playerHealth), enemyPositionX + 54, enemyPositionY + 53);
		g.drawString("Player Spirit: " + Integer.toString(spirit), enemyPositionX + 54, enemyPositionY + 73);
		g.drawString("Enemy HP: " + Integer.toString(enemyHealth), enemyPositionX + 54, enemyPositionY + 93);
		g.setColor(Color.white);
		
		if(enemyHealth <= 0 || playerHealth <= 0) {
			g.clear();
		}
		
		if(fight.getAlpha() == (float)0.0001) {
			g.drawString("You fire a shot from your revolver at the enemy, dealing " + damage + "\npoints of damage.", 65, 470);
			
			   
		}
		else if(special.getAlpha() == (float)0.0001) {
			g.drawString("You manifest your spirit's vines, entangling the opponent. \nYou shoot an entire cylinder of shots, dealing " + damage + " points of damage.", 65, 470);
		}
		else if (fight.getAlpha() == (float)0.0002) {
			g.drawString("The enemy lashes out at you with it's metallic claw, dealing " + damage + "\npoints of damage.", 65, 470);
		}
		else if (special.getAlpha() == (float)0.0002) {
			g.drawString("You're out of spirit!", 65, 470);
		}
		
		 if (PAUSED) {
		        Color trans = new Color(0f,0f,0f,0.5f);
		        g.setColor(trans);
		        g.fillRect(0,0, 800, 600);
		        g.drawString("Resume (R)", 250, 100);
				g.drawString("Main Menu (M)", 250, 150);
				g.drawString("Quit Game (Q)", 250, 200);
		   }
		 
		 
		
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		counter += delta;
		if (didPlayerTakeTurn == true) {
			if (counter >= 1250 && counter <= 1270) {
				playerTurn = false;
				didPlayerTakeTurn = false;
			}
		}
		if (counter >= 2500) {
			fight.setAlpha(1);
			special.setAlpha(1);
			run.setAlpha(1);
			counter = 0;
		}
		
		if (!fightmusic.playing()) {
			fightmusic.play(1, (float) 1);
			}
		
		if(input.isKeyPressed(Input.KEY_ESCAPE)) {
	    	  PAUSED = !PAUSED;
		}
		int xpos = input.getMouseX();
		int ypos = input.getMouseY();
		
		
		
		
		
		
		if (!PAUSED) {
			
			if (enemyHealth <= 0) {
				fightmusic.stop();
				sbg.enterState(4, new FadeOutTransition(Color.black, 100), new FadeInTransition(Color.black, 1000));
			}
			if (playerTurn) {
			if((xpos> 70 && xpos<269) && (ypos>473 && ypos<529)) {
				if(input.isMousePressed(0)) {
					counter = 0;
					Random rand = new Random();
					damage = rand.nextInt(80 - 20 + 1) + 20;
					enemyHealth -= damage;
					fight.setAlpha((float) 0.0001);
					special.setAlpha(0);
					run.setAlpha(0);
					didPlayerTakeTurn = true;
				}
				
				
			}
			
			if((xpos> 300 && xpos<500) && (ypos>473 && ypos<529)) {
				if (spirit <= 0 && input.isMousePressed(0)) {
					counter = 0;
					fight.setAlpha(0);
					special.setAlpha((float) 0.0002);
					run.setAlpha(0);
				}
				
				if(input.isMousePressed(0) && spirit > 0) {
					counter = 0;
					spirit -= 10;
					Random rand = new Random();
					damage = rand.nextInt(200 - 50 + 1) + 50;
					enemyHealth -= damage;
					fight.setAlpha(0);
					special.setAlpha((float) 0.0001);
					run.setAlpha(0);
					didPlayerTakeTurn = true;
					}
				
				
				
					}
						 
				
			if((xpos> 530 && xpos<728) && (ypos>473 && ypos<529)) {
				if(input.isMousePressed(0)) {
					counter = 0;
					fight.setAlpha(0);
					special.setAlpha(0);
					run.setAlpha((float) 0.0001);
					enemyHealth = -1;
					playerHealth = -1;
					
				}
			}
		}
			else {
				Random rand = new Random();
				damage = rand.nextInt(20 - 5 + 1) + 5;
				playerHealth -= damage;
				fight.setAlpha((float) 0.0002);
				special.setAlpha(0);
				run.setAlpha(0);
				playerTurn = true;
			}
			
			
	
		}
		else {
			fightmusic.stop();
			}
}

			
		

	public int getID() {
		return 2;
	}
	
	
	

}

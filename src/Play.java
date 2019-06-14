import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.HorizontalSplitTransition;


public class Play extends BasicGameState {
	SpriteSheet idleDown, playerup, playerdown, playerleft, playerright;
	Animation idle;
	Music playmusic;
	Image worldMap, overworldenemy;
	Animation movingUp, movingDown, movingLeft, movingRight;
	
	public static boolean PAUSED = false;
	float enemyPositionX = 0;
	float enemyPositionY = 0;
	float shiftX = enemyPositionX + 400;
	float shiftY = enemyPositionY + 300;
	
	
	public Play(int state) {
		
	}
	

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		gc.setShowFPS(false);
		idleDown = new SpriteSheet("res/idleDown.png", 42, 42);
	idle = new Animation(idleDown, 100);
	playerup = new SpriteSheet("res/sprites/walkUp.png", 42, 42);
	playerdown = new SpriteSheet("res/sprites/walkDown.png", 42, 42);
	playerleft = new SpriteSheet("res/sprites/walkLeft.png", 42, 42);
	playerright = new SpriteSheet("res/sprites/walkRight.png", 42, 42);
	overworldenemy = new Image("res/overworldenemy.png");
	movingUp = new Animation(playerup, 200);
	movingDown = new Animation(playerdown, 200);
	movingLeft = new Animation(playerleft, 200);
	movingRight = new Animation(playerright, 200);
	worldMap = new Image("res/worldMap.png");
	playmusic = new Music("res/playmusic.wav");
	

	
	
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		worldMap.draw(enemyPositionX -980,enemyPositionY -480);
		idle.draw(shiftX, shiftY);
		overworldenemy.draw(enemyPositionX + 475,enemyPositionY + 750);
		

		
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
		
		
		if(input.isKeyPressed(Input.KEY_ESCAPE)) {
			PAUSED = !PAUSED;
		}
		
		if (!PAUSED) {
			if (!playmusic.playing()) {
				playmusic.play(1, (float) 1);
				}
			
			if(input.isKeyDown(Input.KEY_UP)) {
				idle.start();
				idle = movingUp;
				
				
			enemyPositionY += delta * .1f;
			
			if(enemyPositionY>316) {
				enemyPositionY -= delta * 1f;
			}
			
			
				
			}
			
			else if(input.isKeyDown(Input.KEY_DOWN)) { 
				idle.start();
				idle = movingDown;
			enemyPositionY -= delta * .1f;
			
			if(enemyPositionY<-624) {
				enemyPositionY += delta * 1f;
			}
			
			}
	
			else if(input.isKeyDown(Input.KEY_LEFT)) { 
				idle.start();
				idle = movingLeft;
			enemyPositionX += delta * .1f;
			
			if(enemyPositionX>414) {
				enemyPositionX -= delta * 1f;
			}
		}
			
			else if(input.isKeyDown(Input.KEY_RIGHT)) { 
				idle.start();
				idle = movingRight;
			enemyPositionX -= delta * .1f;
			
			if(enemyPositionX<-840) {
				enemyPositionX += delta * 1f;
			}
			
			}
			else {
				idle.stop();
			}
			
			if (enemyPositionX < -71 && enemyPositionX > -100 && enemyPositionY < -403 && enemyPositionY > -445) {
				 Color trans = new Color(0f,0f,0f,0.5f);
				 playmusic.fade(800, 0, true);
				 sbg.enterState(2, new FadeInTransition(Color.white), new HorizontalSplitTransition(trans));
			 }
		

		}
		    else {
		    	playmusic.stop();
			   if(input.isKeyPressed(Input.KEY_ESCAPE)) {
				   PAUSED = !PAUSED;
			    	  
				}
			   
			   
			   
			   
		  }
			
		}

	
	public int getID() {
		//TODO Auto-generated method stub
		return 1;
	}

}

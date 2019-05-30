import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
/**
 * 
 * @Arsalan Taseer
 * This is a very basic example which
 * initializes a container
 *
 */
public class Slick extends BasicGame{

  public Slick() {
		
		super("Slick Example");

	}
	public void render(GameContainer gmc, Graphics gr) throws SlickException
	{
	
	
	}
	/**
	 * This initializes the container
	 */
	public void init(GameContainer gc) throws SlickException
	{
	    
	}
	
	public void update(GameContainer gc, int delta) throws SlickException
	{}
	
	/**
	 * 
	 * This is the main arg
	 */
	
	public static void main(String[] args) {
		// initially the container is set to null.We will add properties later
		AppGameContainer screen = null;
		try {
			screen = new AppGameContainer(new Slick());
		} catch (SlickException e1) {
		
			e1.printStackTrace();
		}
		try {
			screen.setDisplayMode(600, 400, false);
		} catch (SlickException e) {
			
			e.printStackTrace();
		}
		
		try {
			screen.start();
		} catch (SlickException e) {
		
			e.printStackTrace();
		}
	}

}
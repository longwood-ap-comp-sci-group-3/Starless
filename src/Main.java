import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class Main extends StateBasedGame
{
	
	public static final String gamename = "Starless";
	public static final int menu = 0;
	public static final int play = 1;
	
	
  public Main(String gamename)
  {
    super(gamename);
    this.addState(new Menu(menu));
    this.addState(new Play(play));
  }
  
  public static void main(String[] args) throws SlickException
  {
    AppGameContainer appgc;
    try {
    	appgc = new AppGameContainer(new Main(gamename));
    }catch(SlickException e) {
    	e.printStackTrace();
    }
    appgc = new AppGameContainer(new Main("Starless"));
    appgc.setDisplayMode(800, 600, false);
    appgc.start();
  }

@Override
public void initStatesList(GameContainer gc) throws SlickException {
	this.getState(menu).init(gc,  this);
	this.getState(play).init(gc,  this);
	this.enterState(menu);
	
}

}

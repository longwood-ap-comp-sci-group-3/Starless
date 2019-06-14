import org.newdawn.slick.state.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class Main extends StateBasedGame
{
	
	public static final String gamename = "Starless";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int fight = 2;
	public static final int pause = 3;
	public static final int end = 4;
	
	
  public Main(String gamename)
  {
    super(gamename);
    this.addState(new Menu(menu));
    this.addState(new Play(play));
    this.addState(new Fight(fight));
    this.addState(new End(end));
  }
  
  public static void main(String[] args) throws SlickException
  {
	  AppGameContainer appgc;
	  try {
		  appgc = new AppGameContainer(new Main(gamename));
		  appgc.setDisplayMode(800, 600, false);
		   appgc.start();
	  } catch(SlickException e) {
		  e.printStackTrace();
	  }

  }

@Override
public void initStatesList(GameContainer gc) throws SlickException {
	this.getState(menu).init(gc, this);
	this.getState(play).init(gc, this);
	this.getState(fight).init(gc, this);
	this.getState(end).init(gc, this);
	this.enterState(menu);
	
}

}

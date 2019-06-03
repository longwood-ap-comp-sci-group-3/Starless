import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame
{
  public Main(String title)
  {
    super(title);
  }
  
  public static void main(String[] args) throws SlickException
  {
    AppGameContainer app = null;
    app = new AppGameContainer(new Main("Starless"));
    app.setDisplayMode(800, 600, false);
    app.start();
  }
  
  public void render(GameContainer arg0, org.newdawn.slick.Graphics arg1)
    throws SlickException
  {}
  
  public void init(GameContainer arg0)
    throws SlickException
  {}
  
  public void update(GameContainer arg0, int arg1)
    throws SlickException
  {}
}

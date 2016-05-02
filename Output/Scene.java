import java.util.ArrayList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.Color;

public class Scene extends BasicGame{

   // public ArrayList<Sprite> Sprites;

    public Scene(String gamename)
    {
    		super(gamename);
    		//Sprites = new ArrayList<>();
    }

    public void init(GameContainer gc) throws SlickException {
Player player =  new Player(20);
Player player2 =  new Player(100);

    }

    public void update(GameContainer gc, int delta) throws SlickException {
        for(Sprite s : Global.game.Sprites) {
            s.update();
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        for(Sprite s : Global.game.Sprites) {
            g.draw(new Rectangle(s.x, s.y, s.sizeX, s.sizeY));
        }
        g.drawString(Integer.toString(Global.game.Sprites.size()), 100, 100);
    }



}

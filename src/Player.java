
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player
{
    Rectangle p = new Rectangle();
    
    int x;
    int y;
    int xDirection;
    
    public Player()
    {
        x = 200;
        y = 200;
    }
    public void move()
    {
        x += xDirection;
        if(x <= 0)
            x = 0;
        if(x >= 360)
            x = 360;
    }
    public void setXDirection(int xdir)
    {
        xDirection = xdir;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 40, 10);
    }
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            setXDirection(1);
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            System.exit(0);
        }
    }
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_D){
            setXDirection(0);
        }
    }
}


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable
{
    
    static final String title = "Untitled Game";
    Image Background;
    static Player p = new Player();
    private Graphics dbg;
    private Image dbImage;
    boolean Loading_Screen;
    boolean Main_Menu;
    boolean Pause_Menu;
    boolean Upgrade_Menu;
    
    public Game(){
        //Load images
    	BufferedImageLoader loader = new BufferedImageLoader();
    	BufferedImage spriteSheet = null;
		try 
		{
			Background = loader.loadImage("Background.jpg");
		} 
		catch (IOException e) 
		{
		}     
        
        //Game properties
        this.setSize(800, 500);
        this.setTitle(title);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new AL());
    }
    @Override
    public void paint(Graphics g)
    {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    public void paintComponent(Graphics g)
    {
        g.drawImage(Background, 0, 0, 1600, 900, null);
                                                                                 //Paints the Player's Graphics
        p.draw(g);
                                                                              //Repaint the screen
        repaint();
    }
    public class AL extends KeyAdapter 
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            p.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e)
        {
            p.keyReleased(e);
        }
    }
    @Override
public void run() 
    {
        try
	{
            while (true)
            {
                long beforeTime;
                long timeTaken;
                long sleepTime;
        	beforeTime = System.nanoTime();
                p.move();
                timeTaken = System.nanoTime() - beforeTime;
                sleepTime = 10 - timeTaken / 100000;
        	    if(sleepTime <= 0)
    	    	sleepTime = 0;
                    Thread.sleep(sleepTime);
            }
        }
	catch(Exception e)
	{
            System.out.println(e);
	}
    }
    public static void main(String[] args) 
    {
        Game g = new Game();
        new Thread(g).start();
    }
}

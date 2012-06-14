import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;

public final class Game extends JFrame implements Runnable
{
    
    static final String title = "MineFront";
    Image Background, Main_Menu_Image, Loading_Screen_Image;
    private Graphics dbg;
    private Image dbImage;
    boolean Loading_Screen;
    boolean Main_Menu;
    boolean Playing;
    boolean Pause_Menu;
    boolean Upgrade_Menu;
    
    public Game()
    {
        //Game properties
        this.setSize(800, 700);
        this.setTitle(title);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new AL());
        addMouseListener(new Mouse());
        init();
    }
    public void init()
    {
                                                                                //Load Images
        Loading_Screen = true;
        BufferedImageLoader loader = new BufferedImageLoader();
    	BufferedImage spriteSheet = null;
	try 
	{
            Background = loader.loadImage("Background.jpg");
            Main_Menu_Image = loader.loadImage("Main Menu.jpg");
            Loading_Screen_Image = loader.loadImage("Loading Screen.jpg");
	} 
	catch (IOException e) 
	{
            System.err.println(e);
	} 
        Loading_Screen = false;
        Main_Menu = true;
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
        if(Loading_Screen)
        {
            g.drawImage(Loading_Screen_Image, 0, 0, null);
        }
        if(Main_Menu)
        {
            g.drawImage(Main_Menu_Image, 0, 0, null);
        }
        if(Playing)
        {
          g.drawImage(Background, 0, 0, null);
                                                                                //Paints the Player's Graphics
        }
                                                                                //Repaint the screen
        repaint();
    }
    public class AL extends KeyAdapter 
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
        }
        @Override
        public void keyReleased(KeyEvent e)
        {
        }
    }
    public class Mouse extends MouseAdapter
    {
	public void mousePressed(MouseEvent e)
	{
            int xCoord = e.getX();
            int yCoord = e.getY();
            if(Main_Menu)
            {
                
            }
            if(Upgrade_Menu)
            {
                
            }
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

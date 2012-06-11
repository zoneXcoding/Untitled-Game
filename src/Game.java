
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;

public class Game extends JFrame{
    
    static final String title = "Untitled Game";
    Image Background;
    static Player p = new Player();
    private Graphics dbg;
    private Image dbImage;
    
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
        this.setSize(1600, 900);
        this.setTitle(title);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new AL());
    }
    
    @Override
    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    
    public void paintComponent(Graphics g){
        g.drawImage(Background, 0, 0, 1600, 900, null);
        
        //Draw the player
        p.draw(g);
        
        //Repaint the screen
        repaint();
    }
    
    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            p.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e){
            p.keyReleased(e);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        
        //Threads
        Thread Player = new Thread(p);
        Player.start();
    }
}

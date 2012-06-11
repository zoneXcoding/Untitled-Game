
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame{
    
    static final String title = "Untitled Game";
    Image bg;
    
    public Game(){
        //Load images
        ImageIcon i = new ImageIcon("C:/Users/Fred/Documents/NetBeansProjects/Untitled Game/src/res/bg.jpg");
        bg = i.getImage();        
        
        //Game properties
        this.setSize(1600, 900);
        this.setTitle(title);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(bg, 0, 0, 1600, 900, null);
        
        //Repaint the screen
        repaint();
    }

    public static void main(String[] args) {
        Game g = new Game();
    }
}

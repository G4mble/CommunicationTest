package komponente.GUI1;

import java.awt.BorderLayout;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;

/**
 * 
 * @author Anna Lengert
 *
 */

public class PlayingAreaMain {

		public static void main(String[] args){
			
			
			List<Monster> mon = new LinkedList<Monster>();
			mon.add(new Monster(100, 100));
			
			List<Player> pl = new LinkedList<Player>();
			pl.add(new Player (200, 200));
			
			 LooksAndMoving lm = new LooksAndMoving(300, 300, 640, 400);
			//Background background = new Background(1);
			
			 FrameGUI1 frame = new FrameGUI1(lm, mon, pl);  							//background);
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 frame.setSize(800, 600);
			 
			 
			 frame.setResizable(false);
			 frame.setUndecorated(true);
			 frame.setLocationRelativeTo(null);
			 
			 
			 //Fullscreen mit DisplayMode
			 //32 -> BitDept 
			 //60 -> Refreshrate
			 DisplayMode displayMode = new DisplayMode(640, 400, 32, 60);
			 GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
			 GraphicsDevice device = environment.getDefaultScreenDevice();
			 
			 device.setFullScreenWindow(frame);
			 device.setDisplayMode(displayMode);
			 
			 frame.setVisible(true);
			 
			 long lastFrame = System.currentTimeMillis();
			 
			 while(true){
				 
				 long thisFrame = System.currentTimeMillis();
				 float timeSinceLastFrame = (float)(thisFrame - lastFrame)/1000f;
				 lastFrame = thisFrame;
				 
				 lm.update(frame.getUp(), frame.getDown(), frame.getLeft(), frame.getRight(), frame.getAttack(), frame.getPick());
				 
				 //background.update(timeSinceLastFrame);
				 
				 //berechnungen Berechnungsschritt
				 //Wie schnell soll sich der Spieler bewegen?
				
				 //repaint
				 frame.repaintScreen();
				 
				 //Updaten des Frames
				 for(int j = 0; j<pl.size(); j++){
					 pl.get(j).update(timeSinceLastFrame);
				 }
				 
				 for(int i = 0; i<mon.size(); i++){
					 mon.get(i).update(timeSinceLastFrame);
				 }
				 
				 
				 
				 //Sleeping Thread
				 try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   //15 millisekunden pause zwischen den Frames -> 60 Frames pro Sekunde
			 }
			 
		}
}

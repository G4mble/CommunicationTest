


package komponente.GUI1;

/**
 * 
 * @author Anna Lengert
 *
 */


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class FrameGUI1 extends JFrame {
 
 LooksAndMoving lm = null;
 private List<Monster> mon;
 private List<Player> pl;
	
 private final int WIDTH = 800;
 private final int HEIGHT = 600;

 //Bewegung
 private boolean keyUp = false;
 private boolean keyDown = false;
 private boolean keyLeft = false;
 private boolean keyRight = false;
 private boolean keyAttack = false;
 private boolean keyPick = false;
 
 //Tiles
 private int xTiles = 640/160;
 private int yTiles = 400/160;
 private int[][] tileArray = new int [xTiles][yTiles];

 static int movingArrayX = 0;
 static int movingArrayY = 0;
 
 private Screen screen;
 Image img = null;
 
 
 
 
 public FrameGUI1(LooksAndMoving lm, List<Monster> mon, List<Player> pl){ 
	 
	 screen = new Screen();
	 screen.setBounds(0, 0, 640, 400);
	 add(screen);
	 
	 addKeyListener(new KeyHandler());
	 
	 this.lm = lm;
	 this.mon = mon;
	 this.pl = pl;
	 //this.background = background;	 
 }	 
	 

 
 
 
 //what to put on Screen 
 private class Screen extends JPanel{
	 protected void paintComponent(Graphics g){
		 super.paintComponent(g);
		 
		 g.setColor(Color.RED);
		 	
			int tilePositionX = 0;
			int tilePositionY = -1600;
			
			int k = -7840;
			
			for(int i = 0; i<=100; i++){
				g.drawImage(lm.getWater(), tilePositionX + k + movingArrayX, tilePositionY + movingArrayY, null);
				k += 160;
			}
			
			tilePositionY += 160;
			
			k = -7840;
			
			for(int i = 0; i<=100; i++){
				g.drawImage(lm.getStone(), tilePositionX + k + movingArrayX, tilePositionY + movingArrayY, null);
				k += 160;
			}
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
			
			//Tiles besetzt fuer x-Koordinate nach rechts
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			//Tiles besetzt fuer x-Koordinate nach links
			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
			tilePositionY += 160;
		
		if(keyLeft == true){	
		 for(int j = 0; j<pl.size(); j++){
			Player p1 = pl.get(j);
			g.drawImage(p1.getLookPlayerWalkingWest(), p1.getBounding().x, p1.getBounding().y, null);
		 }
		}
		
		if(keyRight == true){
		 for(int j = 0; j<pl.size(); j++){
			Player p1 = pl.get(j);
			g.drawImage(p1.getLookPlayerWalkingEast(), p1.getBounding().x, p1.getBounding().y, null);
		 }
		} 
		
		if(keyUp == true){
		 for(int j = 0; j<pl.size(); j++){
			Player p1 = pl.get(j);
			g.drawImage(p1.getLookPlayerWalkingNorth(), p1.getBounding().x, p1.getBounding().y, null);	
		 }
		} 
		
		if(keyDown == true) {
		 for(int j = 0; j<pl.size(); j++){
			Player p1 = pl.get(j);
			g.drawImage(p1.getLookPlayerWalkingSouth(), p1.getBounding().x, p1.getBounding().y, null);
		 }
		} 
		
		if(keyDown == false && keyUp == false && keyRight == false && keyLeft == false){
		 for(int j = 0; j<pl.size(); j++){
			Player p1 = pl.get(j);
			g.drawImage(p1.getLookPlayerPausedWest(), p1.getBounding().x, p1.getBounding().y, null);
		 }
		}
		
		if(keyAttack == true){
		 for(int j = 0; j<pl.size(); j++){
			Player p1 = pl.get(j);
			g.drawImage(p1.getLookPlayerAttackingWest(), p1.getBounding().x, p1.getBounding().y, null);
		 }
		}
		
		 for(int i = 0; i<mon.size(); i++){
			 Monster m1 = mon.get(i);
			 g.drawImage(m1.getLookPlayerWalkingNorth(), m1.getBounding().x, m1.getBounding().y, null);
		 }
	 
	 }
 } 
 

 


 //KeyHandler fuer down, up, left, right und escape (schliessen des Frames)
 class KeyHandler implements KeyListener{

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN) keyDown = true;
		if(e.getKeyCode() == KeyEvent.VK_UP) keyUp = true;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) keyRight = true;
		if(e.getKeyCode() == KeyEvent.VK_LEFT) keyLeft = true;	
		if(e.getKeyCode() == KeyEvent.VK_A) keyAttack = true;
		if(e.getKeyCode() == KeyEvent.VK_S) keyPick = true;
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN) keyDown = false;
		if(e.getKeyCode() == KeyEvent.VK_UP) keyUp = false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) keyRight = false;
		if(e.getKeyCode() == KeyEvent.VK_LEFT) keyLeft = false;
		if(e.getKeyCode() == KeyEvent.VK_A) keyAttack = false;
		if(e.getKeyCode() == KeyEvent.VK_S) keyPick = false;
	}

	//Wird zwar ausgefuehrt, aber nicht genutzt
	public void keyTyped(KeyEvent e) {	
	} 
	
  
 }



//Getter-Methoden fuer keyUp, keyDown, keyRight, keyLeft, keyAttack, keyPick fuer Zugriff auf boolean Wert
public boolean getUp() {
	return keyUp;
}

public boolean getDown() {
	return keyDown;
}

public boolean getLeft() {
	return keyLeft;
}

public boolean getRight() {
	return keyRight;
}

public boolean getAttack(){
	return keyAttack;
}

public boolean getPick(){
	return keyPick;
}




public int[][] getTileArray(){
	
	int [][] tileArray2 = new int [tileArray.length][tileArray.length];
	
	for(int i = 0; i<tileArray.length; i++){
		for(int j = 0; j<tileArray[i].length; j++){
			tileArray[i][j] = tileArray2 [i][j];
		}
	}
	
	return tileArray2;	
}


//Screen soll nicht nur einmal gezeichnet werden sondern nach jeder KeyHandler Abfrage neu
public void repaintScreen(){
	 screen.repaint();
}

}




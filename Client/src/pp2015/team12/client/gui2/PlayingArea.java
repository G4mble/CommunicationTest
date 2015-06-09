package pp2015.team12.client.gui2;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
public class PlayingArea  extends JPanel implements KeyListener{
	private final int WIDTH = 4000;
	private final int HEIGHT = 4000; 
	private int posX = 0;
	private int posY = 0; 
	private JPanel panel = null;
	Image img = null; public
	PlayingArea(){ //Hauptanweisungen 
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT)); 
		//setFocusable(true);
		//Bild holen
		ImageIcon wolke = new ImageIcon("C:/Users/Lumpi's/Documents/Studienzeug/H-Wolken_hintergrund.jpg");
		img = wolke.getImage();
	}
	public void paint(Graphics g){
		super.paint(g); 
		//panel.getGraphics().drawImage(img, 0, 0, null); 
		Graphics2D f2 = (Graphics2D)g;
		f2.drawImage(img, posX, posY, null); 
		int xTiles = WIDTH/542;
		int yTiles = HEIGHT/334; 
		int tilePositionX = 0; 
		int tilePositionY = 0; 
		int[][] tileArray = new int [xTiles][yTiles];
		for (int i = 0; i< tileArray.length; i++){
			f2.drawImage(img, tilePositionX, tilePositionY, null);
			for (int j = 1; j< tileArray[i].length; j++){ 
				f2.drawImage(img, tilePositionX, tilePositionY, null);
				tilePositionY += 334; 
				}
			tilePositionX += 542; tilePositionY -= HEIGHT;
			}
		}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			posX+=10;                           
		if (e.getKeyCode() == KeyEvent.VK_UP)
			posY+=10;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			posX-=10;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			posY-=10;
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

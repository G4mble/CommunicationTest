package komponente.guiII;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.*;
/**
 * class for the minimap
 * @author Vinzenz Liem Bui
 */
public class MiniMap extends JPanel {
	/**
	 * @author Vinzenz Liem Bui
	 */
	
	private int[][] map;
	private BufferedImage tile;
	private int mapResolution;
	
	/**
	 * constructor, just creates a BufferedImage
	 * @author Vinzenz Liem Bui
	 */
	public MiniMap(){
		super();
		tile = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
	}
	/**
	 * receive and repaint the map
	 * @author Vinzenz Liem Bui
	 */
	public void setMap(int[][] map){
		this.map = map;
		repaint();
	}
	/**
	 * sets the size of the map, including its resolution
	 * @author Vinzenz Liem Bui
	 */
	public void setSize(){
		tile = new BufferedImage(getWidth(), getWidth(), BufferedImage.TYPE_INT_ARGB);
		mapResolution = getWidth() / map.length; 
	}
	/**
	 * draws the map
	 * @author Vinzenz Liem Bui
	 */
	private void drawOnBackgroundImage() {
		Graphics surface = tile.getGraphics();
		surface.setColor(Color.BLACK);
		surface.fillRect(0, 0, getSize().width, getSize().height); 
		surface.setColor(Color.WHITE);
		for(int i = 0; i<map.length;i++){
			for(int j = 0; j<map[i].length;j++){
				if(map[i][j] == 0){
					surface.fillRect(j * mapResolution, i * mapResolution, mapResolution, mapResolution);
				}
			}
		}
		surface.setColor(Color.BLUE);
		surface.fillOval(10*mapResolution,10*mapResolution, mapResolution, mapResolution);
	}
	
	@Override
	public void paint(Graphics g) {
		drawOnBackgroundImage();
		g.drawImage(tile, 0, 0, null);
	}
	
	
}

package pp2015.team12.client.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.*;

import pp2015.team12.shared.map.Tile;

public class MiniMap extends JPanel {
	/**
	 * @author Vinzenz Liem Bui
	 */
	
	// map ist 30*60 tiles
	
	private Tile[][] map;
	private BufferedImage tile;
	private int mapResolution;
	public MiniMap(){
		super();
		tile = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
	}
	
	public void setMap(Tile[][] map){
		this.map = map;
		repaint();
	}
	
	public void setSize(){
		tile = new BufferedImage(getWidth(), getWidth(), BufferedImage.TYPE_INT_ARGB);
		//mapResolution = getWidth() / map.length; 
		mapResolution = 10;
	}
	
	private void drawOnBackgroundImage() {
		Graphics surface = tile.getGraphics();
		surface.setColor(Color.BLACK);
		surface.fillRect(0, 0, getSize().width, getSize().height); 
		surface.setColor(Color.WHITE);
		for(int i = 0; i<map.length;i++){
			for(int j = 0; j<map[i].length;j++){
				if(map[i][j].getAccessible() == true){
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

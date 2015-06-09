package pp2015.team12.client.gui;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class LooksAndMoving {

	private Rectangle bounding;
	private float posXPlayer;
	private float posYPlayer;
	private int gameSizeX;
	private int gameSizeY;
	
	private BufferedImage look;
	private BufferedImage grass;
	private BufferedImage water;
	private BufferedImage stone;
	
			
			
	public LooksAndMoving(int x, int y, int gameSizeX, int gameSizeY){
	
		
		//fuer Background
		try {
			look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//paused e0002.bmp"));
			grass = ImageIO.read(getClass().getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//ground0007.jpg"));
			water = ImageIO.read(getClass().getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//ground0009.jpg"));
			stone = ImageIO.read(getClass().getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//stone0007.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bild nicht geladen.");
		}
		
		
		
		
		//Boundingbox! 
		bounding = new Rectangle(x, y, look.getHeight(), look.getWidth());
		posXPlayer = x;
		posYPlayer = y;
		
		
	
		this.gameSizeX = gameSizeX;
		this.gameSizeY = gameSizeY;
	}
	
	//Tastenupdate update fuer jedes frame
	public void update(boolean up, boolean down, boolean right, boolean left){
	
//		GamePanel gamePanel = new GamePanel();
//		
//		int msg;
//		
//		 if(up){                           
//			 GamePanel.movingArrayY += 2;
//		 	 msg = 1;
//		 }	
//		 if(right){ 
//			 GamePanel.movingArrayX += 2;
//			 msg = 2;
//		 } 
//		 if(down){ 
//			 GamePanel.movingArrayY -= 2;
//			 msg = 3;
//		 }
//		 if(left){
//			 GamePanel.movingArrayX -= 2;
//			 msg = 4;
//		 }
		 
		    
		 
		 
		 
//		 if(up) 
//			 posYPlayer -= 5;
//		 if(down) 
//			 posYPlayer += 5;
//		 if(left) 
//			 posXPlayer += 5;
//		 if(right) 
//			 posXPlayer -= 5;
		 
		 //Überlegung: Bounding Box auf das komplette Spielfeld anwenden???
		 //Spieler soll nicht aus dem Frame "laufen" koennen
		 if(posXPlayer<0)
			 posXPlayer = 0;
		 if(posYPlayer<0)
			 posYPlayer = 0;
		 if(posXPlayer>gameSizeX - bounding.width)
			 posXPlayer = gameSizeX - bounding.width;
		 if(posYPlayer>gameSizeY - bounding.height)
			 posYPlayer = gameSizeY - bounding.height;
		 
		 bounding.x = (int) posXPlayer;
		 bounding.y = (int) posYPlayer;
	}
	 
	//getter der boundingbox zurueckgibt
	public Rectangle getBounding(){
		return bounding;
	}
	
	
	public BufferedImage getLook(){
		return look;
	}
	
	public BufferedImage getGrass(){
		return grass;
	}

	public BufferedImage getWater(){
		return water;
	}
	
	public BufferedImage getStone(){
		return stone;
	}
	
	
}

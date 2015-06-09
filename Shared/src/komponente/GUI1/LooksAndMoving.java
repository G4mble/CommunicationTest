package komponente.GUI1;


import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 
 * @author Anna Lengert
 *
 */

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
			look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("graphics/paused e0002.bmp"));
			grass = ImageIO.read(getClass().getClassLoader().getResourceAsStream("graphics/ground0007.jpg"));
			water = ImageIO.read(getClass().getClassLoader().getResourceAsStream("graphics/ground0009.jpg"));
			stone = ImageIO.read(getClass().getClassLoader().getResourceAsStream("graphics/stone0007.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bild nicht geladen.");
		}
		
		
		
		
		//Boundingbox! 
		bounding = new Rectangle(x, y, look.getHeight(), look.getWidth());
		FrameGUI1.movingArrayX = x;
		FrameGUI1.movingArrayY = y;
		
		
	
		this.gameSizeX = gameSizeX;
		this.gameSizeY = gameSizeY;
	}
	
	//Tastenupdate update fuer jedes frame
	public void update(boolean up, boolean down, boolean right, boolean left, boolean attack, boolean pick){
	
		int speed = 5;
		
		 if(up)                           
			 FrameGUI1.movingArrayY += 8;
		 if(down) 
			 FrameGUI1.movingArrayY -= 8;
		 if(left) 
			 FrameGUI1.movingArrayX -= 8;
		 if(right) 
			 FrameGUI1.movingArrayX += 8;
		 
			 
		 
		 
		 
//		 if(up) 
//			 posYPlayer -= 5;
//		 if(down) 
//			 posYPlayer += 5;
//		 if(left) 
//			 posXPlayer += 5;
//		 if(right) 
//			 posXPlayer -= 5;
		 
		 //Ueberlegung: Bounding Box auf das komplette Spielfeld anwenden???
		 //Spieler soll nicht aus dem Frame "laufen" koennen
//		 if(FrameGUI1.movingArrayX< (-400))
//			 FrameGUI1.movingArrayX = 0;
//		 if(FrameGUI1.movingArrayY< (-400))
//			 FrameGUI1.movingArrayY = 0;
//		 if(FrameGUI1.movingArrayX>FrameGUI1.movingArrayX - bounding.width)
//			 FrameGUI1.movingArrayX = gameSizeX - bounding.width;
//		 if(FrameGUI1.movingArrayY>FrameGUI1.movingArrayY - bounding.height)
//			 FrameGUI1.movingArrayY = gameSizeY - bounding.height;
		 
		 bounding.x = (int) FrameGUI1.movingArrayX;
		 bounding.y = (int) FrameGUI1.movingArrayY;
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


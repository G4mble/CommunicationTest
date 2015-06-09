package pp2015.team12.client.gui;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Monster {
	
	private static BufferedImage[] lookPlayerWalkingNorth = new BufferedImage [25]; 
	//Wie lang dauert der Durchlauf der Animation?
	private final static float animationTime = 1.5f; //1Sekunde
	private float aniTime = 0;
	
	private float posXPlayer;
	private float posYPlayer;
	
	private Rectangle bounding;
	
	
	static{
		
		try {
			lookPlayerWalkingNorth[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//appearing s0000.bmp"));
			lookPlayerWalkingNorth[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//appearing s0001.bmp"));
			lookPlayerWalkingNorth[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//appearing s0002.bmp"));
			lookPlayerWalkingNorth[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//appearing s0003.bmp"));
			lookPlayerWalkingNorth[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//appearing s0004.bmp"));
			lookPlayerWalkingNorth[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//appearing s0005.bmp"));
			lookPlayerWalkingNorth[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//appearing s0006.bmp"));
			lookPlayerWalkingNorth[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//appearing s0007.bmp"));
			lookPlayerWalkingNorth[8] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//appearing s0008.bmp"));
			lookPlayerWalkingNorth[9] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//appearing s0009.bmp"));
		    lookPlayerWalkingNorth[10] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//appearing s0010.bmp"));
		    lookPlayerWalkingNorth[11] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//appearing s0011.bmp"));
			
			lookPlayerWalkingNorth[12] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//disappearinjg s0000.bmp"));
			lookPlayerWalkingNorth[13] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//disappearinjg s0001.bmp"));
			lookPlayerWalkingNorth[14] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//disappearinjg s0002.bmp"));
			lookPlayerWalkingNorth[15] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//disappearinjg s0003.bmp"));
			lookPlayerWalkingNorth[16] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//disappearinjg s0004.bmp"));
			lookPlayerWalkingNorth[17] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//disappearinjg s0005.bmp"));
			lookPlayerWalkingNorth[18] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//disappearinjg s0006.bmp"));
			lookPlayerWalkingNorth[19] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//disappearinjg s0007.bmp"));
			lookPlayerWalkingNorth[20] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//disappearinjg s0008.bmp"));
			lookPlayerWalkingNorth[21] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//disappearinjg s0009.bmp"));
			lookPlayerWalkingNorth[22] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//disappearinjg s0010.bmp"));
			lookPlayerWalkingNorth[23] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//disappearinjg s0011.bmp"));
			lookPlayerWalkingNorth[24] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//disappearinjg s0012.bmp"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public Monster(float x, float y){
		this.posXPlayer = x;
		this.posYPlayer = y;
		
		bounding = new Rectangle((int)x, (int)y, lookPlayerWalkingNorth[0].getWidth(), lookPlayerWalkingNorth[0].getHeight());
	}
	
	public void update(float timeSinceLastFrame){
		aniTime += timeSinceLastFrame;
		if(aniTime > animationTime)aniTime = 0;
	}
	
	public Rectangle getBounding(){
		return bounding;
	}
	
	public BufferedImage getLookPlayerWalkingNorth(){
		if(lookPlayerWalkingNorth.length == 0)return null;
		
		for(int i = 0; i<lookPlayerWalkingNorth.length; i++){
			if(aniTime<(float)(animationTime/lookPlayerWalkingNorth.length*(i+1))){
				return lookPlayerWalkingNorth[i];
			}
		}
		return lookPlayerWalkingNorth[lookPlayerWalkingNorth.length -1];
	}

}

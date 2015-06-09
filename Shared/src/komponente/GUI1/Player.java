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

public class Player {
	
	private static BufferedImage[] LookPlayerWalkingWest = new BufferedImage [8]; 
	private static BufferedImage[] LookPlayerWalkingEast = new BufferedImage [8];
	private static BufferedImage[] LookPlayerWalkingSouth = new BufferedImage [8];
	private static BufferedImage[] LookPlayerWalkingNorth = new BufferedImage [8];
	private static BufferedImage[] LookPlayerPausedWest = new BufferedImage [9];
	private static BufferedImage[] LookPlayerAttackingWest = new BufferedImage[13];
	
	//Wie lang dauert der Durchlauf der Animation?
	private final static float animationTime = 1.5f; //1Sekunde
	private float aniTime = 0;
	
	private float posXPlayer;
	private float posYPlayer;
	
	private Rectangle bounding;
	
	
	static{
		
		try {
			LookPlayerWalkingWest[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking w0000.bmp"));
			LookPlayerWalkingWest[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking w0001.bmp"));
			LookPlayerWalkingWest[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking w0002.bmp"));
			LookPlayerWalkingWest[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking w0003.bmp"));
			LookPlayerWalkingWest[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking w0004.bmp"));
			LookPlayerWalkingWest[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking w0005.bmp"));
			LookPlayerWalkingWest[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking w0006.bmp"));
			LookPlayerWalkingWest[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking w0007.bmp"));	
			
			LookPlayerWalkingEast[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking e0000.bmp"));
			LookPlayerWalkingEast[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking e0001.bmp"));
			LookPlayerWalkingEast[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking e0002.bmp"));
			LookPlayerWalkingEast[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking e0003.bmp"));
			LookPlayerWalkingEast[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking e0004.bmp"));
			LookPlayerWalkingEast[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking e0005.bmp"));
			LookPlayerWalkingEast[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking e0006.bmp"));
			LookPlayerWalkingEast[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking e0007.bmp"));
			
			LookPlayerWalkingNorth[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking n0000.bmp"));
			LookPlayerWalkingNorth[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking n0001.bmp"));
			LookPlayerWalkingNorth[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking n0002.bmp"));
			LookPlayerWalkingNorth[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking n0003.bmp"));
			LookPlayerWalkingNorth[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking n0004.bmp"));
			LookPlayerWalkingNorth[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking n0005.bmp"));
			LookPlayerWalkingNorth[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking n0006.bmp"));
			LookPlayerWalkingNorth[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking n0007.bmp"));
			
			LookPlayerWalkingSouth[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking s0000.bmp"));
			LookPlayerWalkingSouth[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking s0001.bmp"));
			LookPlayerWalkingSouth[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking s0002.bmp"));
			LookPlayerWalkingSouth[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking s0003.bmp"));
			LookPlayerWalkingSouth[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking s0004.bmp"));
			LookPlayerWalkingSouth[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking s0005.bmp"));
			LookPlayerWalkingSouth[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking s0006.bmp"));
			LookPlayerWalkingSouth[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/walking s0007.bmp"));
			
			LookPlayerPausedWest[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/paused w0000.bmp"));
			LookPlayerPausedWest[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/paused w0001.bmp"));
			LookPlayerPausedWest[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/paused w0002.bmp"));
			LookPlayerPausedWest[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/paused w0003.bmp"));
			LookPlayerPausedWest[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/paused w0004.bmp"));
			LookPlayerPausedWest[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/paused w0005.bmp"));
			LookPlayerPausedWest[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/paused w0006.bmp"));
			LookPlayerPausedWest[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/paused w0007.bmp"));
			LookPlayerPausedWest[8] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/paused w0008.bmp"));
			
			LookPlayerAttackingWest[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/attack w0000.bmp"));
			LookPlayerAttackingWest[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/attack w0001.bmp"));
			LookPlayerAttackingWest[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/attack w0002.bmp"));
			LookPlayerAttackingWest[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/attack w0003.bmp"));
			LookPlayerAttackingWest[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/attack w0004.bmp"));
			LookPlayerAttackingWest[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/attack w0005.bmp"));
			LookPlayerAttackingWest[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/attack w0006.bmp"));
			LookPlayerAttackingWest[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/attack w0007.bmp"));
			LookPlayerAttackingWest[8] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/attack w0008.bmp"));
			LookPlayerAttackingWest[9] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/attack w0009.bmp"));
			LookPlayerAttackingWest[10] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/attack w0010.bmp"));
			LookPlayerAttackingWest[11] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/attack w0011.bmp"));
			LookPlayerAttackingWest[12] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("graphics/attack w0012.bmp"));
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public Player(float x, float y){
		this.posXPlayer = x;
		this.posYPlayer = y;
		
		bounding = new Rectangle((int)x, (int)y, LookPlayerWalkingWest[0].getWidth(), LookPlayerWalkingWest[0].getHeight());
	}
	
	public void update(float timeSinceLastFrame){
		aniTime += timeSinceLastFrame;
		if(aniTime > animationTime)aniTime = 0;
	}
	
	public Rectangle getBounding(){
		return bounding;
	}
	
	public BufferedImage getLookPlayerWalkingWest(){
		if(LookPlayerWalkingWest.length == 0)return null;
		
		for(int i = 0; i<LookPlayerWalkingWest.length; i++){
			if(aniTime<(float)(animationTime/LookPlayerWalkingWest.length*(i+1))){
				return LookPlayerWalkingWest[i];
			}
		}
		return LookPlayerWalkingWest[LookPlayerWalkingWest.length -1];
	}
	
	public BufferedImage getLookPlayerWalkingEast(){
		if(LookPlayerWalkingWest.length == 0)return null;
		
		for(int i = 0; i<LookPlayerWalkingEast.length; i++){
			if(aniTime<(float)(animationTime/LookPlayerWalkingEast.length*(i+1))){
				return LookPlayerWalkingEast[i];
			}
		}
		return LookPlayerWalkingEast[LookPlayerWalkingEast.length -1];
	}
	
	public BufferedImage getLookPlayerWalkingSouth(){
		if(LookPlayerWalkingSouth.length == 0)return null;
		
		for(int i = 0; i<LookPlayerWalkingSouth.length; i++){
			if(aniTime<(float)(animationTime/LookPlayerWalkingSouth.length*(i+1))){
				return LookPlayerWalkingSouth[i];
			}
		}
		return LookPlayerWalkingSouth[LookPlayerWalkingSouth.length -1];
	}
	
	public BufferedImage getLookPlayerWalkingNorth(){
		if(LookPlayerWalkingNorth.length == 0)return null;
		
		for(int i = 0; i<LookPlayerWalkingNorth.length; i++){
			if(aniTime<(float)(animationTime/LookPlayerWalkingNorth.length*(i+1))){
				return LookPlayerWalkingNorth[i];
			}
		}
		return LookPlayerWalkingNorth[LookPlayerWalkingNorth.length -1];
	}
	
	public BufferedImage getLookPlayerPausedWest(){
		if(LookPlayerPausedWest.length == 0)return null;
		
		for(int i = 0; i<LookPlayerPausedWest.length; i++){
			if(aniTime<(float)(animationTime/LookPlayerPausedWest.length*(i+1))){
				return LookPlayerPausedWest[i];
			}
		}
		return LookPlayerPausedWest[LookPlayerPausedWest.length -1];
	}
	
	public BufferedImage getLookPlayerAttackingWest(){
		if(LookPlayerAttackingWest.length == 0)return null;
		
		for(int i = 0; i<LookPlayerAttackingWest.length; i++){
			if(aniTime<(float)(animationTime/LookPlayerAttackingWest.length*(i+1))){
				return LookPlayerAttackingWest[i];
			}
		}
		return LookPlayerAttackingWest[LookPlayerAttackingWest.length -1];
	}
	
}

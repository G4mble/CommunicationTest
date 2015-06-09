package pp2015.team12.client.gui;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Player {
	
	private static BufferedImage[] LookPlayerWalkingWest = new BufferedImage [8]; 
	private static BufferedImage[] LookPlayerWalkingEast = new BufferedImage [8];
	private static BufferedImage[] LookPlayerWalkingSouth = new BufferedImage [8];
	private static BufferedImage[] LookPlayerWalkingNorth = new BufferedImage [8];
	private static BufferedImage[] LookPlayerPausedWest = new BufferedImage [9];
	private static BufferedImage[] LookPlayerAttackingWest = new BufferedImage[13];
	private static BufferedImage[] LookPlayerAttackingSouth = new BufferedImage[13];
	private static BufferedImage[] LookPlayerPausedSouth = new BufferedImage[9];
	
	//Wie lang dauert der Durchlauf der Animation?
	private final static float animationTime = 1.5f; //1Sekunde
	private float aniTime = 0;
	
	private float posXPlayer;
	private float posYPlayer;
	
	private Rectangle bounding;
	
	 static boolean keyUp = false;
	 static boolean keyDown = false;
	 static boolean keyLeft = false;
	 static boolean keyRight = false;
	 static boolean keyAttack = false;
	 static boolean keyPick = false;
	 
//	public Player(boolean boolean boolean boolean){
//		
//	}
	

	
	
	
	static{
		
		try {
			LookPlayerWalkingWest[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking w0000.png"));
			LookPlayerWalkingWest[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking w0001.png"));
			LookPlayerWalkingWest[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking w0002.png"));
			LookPlayerWalkingWest[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking w0003.png"));
			LookPlayerWalkingWest[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking w0004.png"));
			LookPlayerWalkingWest[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking w0005.png"));
			LookPlayerWalkingWest[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking w0006.png"));
			LookPlayerWalkingWest[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking w0007.png"));	
			                                                                                                                                               
			LookPlayerWalkingEast[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking e0000.png"));
			LookPlayerWalkingEast[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking e0001.png"));
			LookPlayerWalkingEast[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking e0002.png"));
			LookPlayerWalkingEast[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking e0003.png"));
			LookPlayerWalkingEast[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking e0004.png"));
			LookPlayerWalkingEast[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking e0005.png"));
			LookPlayerWalkingEast[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking e0006.png"));
			LookPlayerWalkingEast[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking e0007.png"));
			
			LookPlayerWalkingNorth[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking n0000.png"));
			LookPlayerWalkingNorth[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking n0001.png"));
			LookPlayerWalkingNorth[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking n0002.png"));
			LookPlayerWalkingNorth[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking n0003.png"));
			LookPlayerWalkingNorth[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking n0004.png"));
			LookPlayerWalkingNorth[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking n0005.png"));
			LookPlayerWalkingNorth[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking n0006.png"));
			LookPlayerWalkingNorth[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking n0007.png"));
			                                                                                                                                                
			LookPlayerWalkingSouth[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking s0000.png"));
			LookPlayerWalkingSouth[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking s0001.png"));
			LookPlayerWalkingSouth[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking s0002.png"));
			LookPlayerWalkingSouth[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking s0003.png"));
			LookPlayerWalkingSouth[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking s0004.png"));
			LookPlayerWalkingSouth[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking s0005.png"));
			LookPlayerWalkingSouth[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking s0006.png"));
			LookPlayerWalkingSouth[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//walking s0007.png"));
			
			LookPlayerPausedSouth[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//paused s0000.png"));
			LookPlayerPausedSouth[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//paused s0001.png"));
			LookPlayerPausedSouth[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//paused s0002.png"));
			LookPlayerPausedSouth[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//paused s0003.png"));
			LookPlayerPausedSouth[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//paused s0004.png"));
			LookPlayerPausedSouth[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//paused s0005.png"));
			LookPlayerPausedSouth[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//paused s0006.png"));
			LookPlayerPausedSouth[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//paused s0007.png"));
			LookPlayerPausedSouth[8] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//paused s0008.png"));
			
			LookPlayerAttackingWest[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0000.bmp"));
			LookPlayerAttackingWest[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0001.bmp"));
			LookPlayerAttackingWest[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0002.bmp"));
			LookPlayerAttackingWest[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0003.bmp"));
			LookPlayerAttackingWest[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0004.bmp"));
			LookPlayerAttackingWest[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0005.bmp"));
			LookPlayerAttackingWest[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0006.bmp"));
			LookPlayerAttackingWest[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0007.bmp"));
			LookPlayerAttackingWest[8] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0008.bmp"));
			LookPlayerAttackingWest[9] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0009.bmp"));
			LookPlayerAttackingWest[10] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0010.bmp"));
			LookPlayerAttackingWest[11] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0011.bmp"));
			LookPlayerAttackingWest[12] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0012.bmp"));
		
			LookPlayerAttackingSouth[0] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0000.bmp"));
			LookPlayerAttackingSouth[1] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0001.bmp"));
			LookPlayerAttackingSouth[2] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0002.bmp"));
			LookPlayerAttackingSouth[3] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0003.bmp"));
			LookPlayerAttackingSouth[4] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0004.bmp"));
			LookPlayerAttackingSouth[5] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0005.bmp"));
			LookPlayerAttackingSouth[6] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0006.bmp"));
			LookPlayerAttackingSouth[7] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0007.bmp"));
			LookPlayerAttackingSouth[8] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0008.bmp"));
			LookPlayerAttackingSouth[9] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0009.bmp"));
			LookPlayerAttackingSouth[10] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0010.bmp"));
			LookPlayerAttackingSouth[11] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0011.bmp"));
			LookPlayerAttackingSouth[12] = ImageIO.read(Monster.class.getClassLoader().getResourceAsStream("pp2015//team12//client//gui//images//attack w0012.bmp"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public Player(float x, float y){
		this.posXPlayer = x;
		this.posYPlayer = y;
		
		bounding = new Rectangle((int)x, (int)y, LookPlayerWalkingWest[0].getWidth(), LookPlayerWalkingWest[0].getHeight());
	}
	






	/*
	 * 
	 */
	
	public void update(float timeSinceLastFrame){
		aniTime += timeSinceLastFrame;
		if(aniTime > animationTime)aniTime = 0;
	}
	
	public Rectangle getBounding(){
		return bounding;
	}
	
	/*
	 * 
	 */
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

	
	
	
	
	public static BufferedImage[] getArrayWalkingWest(){
		return LookPlayerWalkingWest;
	}
	
	public static BufferedImage[] getArrayWalkingNorth(){
		return LookPlayerWalkingNorth;
	}
	
	public static BufferedImage[] getArrayWalkingSouth(){
		return LookPlayerWalkingSouth;
	}
	
	public static BufferedImage[] getArrayWalkingEast(){
		return LookPlayerWalkingEast;
	}
	
	public static BufferedImage[] getArrayAttackSouth(){
		return LookPlayerAttackingSouth;
	}
	
	public static BufferedImage[] getArrayPausedSouth(){
		return LookPlayerPausedSouth;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}

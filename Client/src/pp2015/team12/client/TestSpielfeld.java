package pp2015.team12.client;
import java.awt.Color;

import pp2015.team12.shared.map.*;
import pp2015.team12.shared.message.*;
import pp2015.team12.shared.character.*;
import pp2015.team12.client.testimages.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * part of the test gui to test client engine
 * @author Heusser, Caspar
 *
 */

public class TestSpielfeld extends JPanel implements KeyListener{
	Tile[][]map;
	PlayerCharacter player;
	ClientCommunication com;
	ClientEngine cE;
	Monster[] mL;
	public TestSpielfeld(Tile[][] map,PlayerCharacter player,ClientCommunication com,ClientEngine cE){
		this.map = map;
		this.cE=cE;
		this.player = player;
		this.mL=cE.monsterList;
		this.com= com;
		this.setSize(new Dimension(2000,2000));
		this.setBackground(Color.DARK_GRAY);
		this.setVisible(true);
	}
	/**
	 * 
	 * @author Heusser, Caspar
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		getNewMap();
		getNewCPlayerPos();
		try{
		for(int i = 0; i<5;i++){
			for(int j = 0; j<8;j++){
				if(map[i][j].getImageID()==3030){
					 g.drawImage( ImageIO.read(getClass().getClassLoader().getResourceAsStream("pp2015//team12//client//testimages//ground0007.jpg")),(i*40) , (j*40), null); 
				}
				if(map[i][j].getImageID()==2010){
					 g.drawImage( ImageIO.read(getClass().getClassLoader().getResourceAsStream("pp2015//team12//client//testimages//ground0008.jpg")),(i*40) , (j*40), null); 
				}
				if(map[i][j].getImageID()==1041){
					 g.drawImage( ImageIO.read(getClass().getClassLoader().getResourceAsStream("pp2015//team12//client//testimages//ground0008.jpg")),(i*40) , (j*40), null); 
				}
			}
		}
		if(mL != null){
		for(int k = 0; k<mL.length;k++){
			
			if(this.mL[k].getImagePath().equals("Monster1")){
				System.out.println("Zeichne Monster");
				g.drawImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("pp2015//team12//client//testimages//ground0009.jpg")),this.mL[k].getPosX(), this.mL[k].getPosY(), null);
			}
		}
		}
		g.drawImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("pp2015//team12//client//testimages//stone0007.jpg")),player.getPosX() , player.getPosY(), null);
		}catch(Exception e){
			System.err.println("Fehler beim Laden der Texturen");
		}
		
	}
	/**
	 *  @author Heusser, Caspar
	 */
	public void getNewMap(){
		this.map = cE.map;
	}
	/**
	 *  @author Heusser, Caspar
	 */
	public void getNewCPlayerPos(){
		this.player = cE.player;
	}

	@Override
	/**
	 *  @author Heusser, Caspar
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			System.out.println("MoveMsg abgeschickt");
			this.com.receiveMessage(new MoveMsg(player.getPosX(),player.getPosY()-4, player,1,1));
			
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			System.out.println("MoveMsg abgeschickt");
			this.com.receiveMessage(new MoveMsg(player.getPosX(),player.getPosY()+4, player,1,1));
			
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			System.out.println("MoveMsg abgeschickt");
			this.com.receiveMessage(new MoveMsg(player.getPosX()+4,player.getPosY(), player,1,1));
			
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			System.out.println("MoveMsg abgeschickt");
			this.com.receiveMessage(new MoveMsg(player.getPosX()-4,player.getPosY(), player,1,1));
			
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			//System.out.println("Item aufheben");
			this.com.receiveMessage(new PickUpMsg(1));
			System.out.println();
			this.com.receiveMessage(new EngageFightMsg(1, 4)); //attack left
			System.out.println();
			this.com.receiveMessage(new EngageFightMsg(1, 1)); //attack up
			System.out.println();
			this.com.receiveMessage(new EngageFightMsg(1, 2)); //attack right
			System.out.println();
			this.com.receiveMessage(new EngageFightMsg(1, 3)); //attack down
			System.out.println();
			this.com.receiveMessage(new LevelChangeReqMsg(1));
			
		}
		
		
	}
	/**
	 *  @author Heusser, Caspar
	 */
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 *  @author Heusser, Caspar
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

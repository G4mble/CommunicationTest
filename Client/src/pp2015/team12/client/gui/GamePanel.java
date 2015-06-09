package pp2015.team12.client.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import pp2015.team12.shared.item.ItemModel;
import pp2015.team12.shared.map.Tile;



public class GamePanel extends JPanel{
	
	 private static LooksAndMoving lm = null;
	 static List<Monster> mon;
	 private List<Player> pl;
	 
	 private int imageint = 0;
	 
	 static int movingArrayX = 0;
	 static int movingArrayY = 0;
	 
	 private GamePanel gamePanel;
	 
	 private Tile[][] map;
	 
	 private ArrayList<ItemModel> globInv;
	 
	 private Character[] characterList;
	 
	 private Monster[] monsterList;
	 
	 private Character move;
	 
	 //Bewegung
	 static boolean keyUp = false;
	 static boolean keyDown = false;
	 static boolean keyLeft = false;
	 static boolean keyRight = false;
	 static boolean keyAttack = false;
	 static boolean keyPick = false;
	 
	 Image img = null;
	 
	 //Hoehe und Breite ->> Itemproblem loesen
	
	 protected void paintComponent(Graphics g){
		 super.paintComponent(g);
		 
		 g.setColor(Color.RED);
		 	
//			int tilePositionX = 0;
//			int tilePositionY = -1600;
//			
//			int k = -7840;
//			
//			for(int i = 0; i<=100; i++){
//				g.drawImage(lm.getWater(), tilePositionX + k + movingArrayX, tilePositionY + movingArrayY, null);
//				k += 160;
//			}
//			
//			tilePositionY += 160;
//			
//			k = -7840;
//			
//			for(int i = 0; i<=100; i++){
//				g.drawImage(lm.getStone(), tilePositionX + k + movingArrayX, tilePositionY + movingArrayY, null);
//				k += 160;
//			}
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
//			
//			//Tiles besetzt fuer x-Koordinate nach rechts
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX + 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX + 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX + 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			//Tiles besetzt fuer x-Koordinate nach links
//			g.drawImage(lm.getWater(), tilePositionX + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 1440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 1760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 1920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 2560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 2720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 2880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 3360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 3520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 3840 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4000 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4160 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 4320 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4480 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 4640 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4800 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 4960 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5120 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5280 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 5440 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5600 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 5760 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 5920 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6080 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6240 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6400 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 6560 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 6720 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 6880 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7040 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7200 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getWater(), tilePositionX - 7360 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getStone(), tilePositionX - 7520 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7680 + movingArrayX, tilePositionY + movingArrayY, null);
//			g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
//			
//			tilePositionY += 160;
		
		 	if(map!=null){
			for(int i = 0; i<map.length; i++){
				for(int j = 0; j<map[i].length; j++){
					
					Image imgMap = map[i][j].getTexture();
					g.drawImage(imgMap, i*96 + movingArrayX, j*96 + movingArrayY, null);		
				}
			}}
		 	else
		 		System.out.println("Map nicht vorhanden.");
			
		 	if(globInv!=null){
			for(int i = 0; i<globInv.size(); i++){
				ItemModel item = globInv.get(i);
				g.drawImage(item.getItemImage(), item.getXPos(), item.getYPos(), null);
			}}
		 	else
		 		System.out.println("GlobalInventory nicht vorhanden.");
			
		 	if(monsterList!=null)
			for(int i = 0; i<monsterList.length; i++){
//				Image imgMon = monsterList[i];
			}
			
		 	if(characterList!=null)
			for(int i = 0; i<characterList.length; i++){
//				Image imgChar = characterList[i].getCharacterImage();
			}
	//		g.drawImage(lm.getGrass(), tilePositionX - 7840 + movingArrayX, tilePositionY + movingArrayY, null);
			
		
		if(keyUp == true){
			g.drawImage(pl.get(0).getArrayWalkingNorth()[imageint], pl.get(0).getBounding().x, pl.get(0).getBounding().y, null);		
		} 
		
		if(keyDown == true){
			g.drawImage(pl.get(0).getArrayWalkingSouth()[imageint], pl.get(0).getBounding().x, pl.get(0).getBounding().y, null);		
		} 
		
		if(keyRight == true){
			g.drawImage(pl.get(0).getArrayWalkingEast()[imageint], pl.get(0).getBounding().x, pl.get(0).getBounding().y, null);		
		} 
		
		if(keyLeft == true){
			g.drawImage(pl.get(0).getArrayWalkingWest()[imageint], pl.get(0).getBounding().x, pl.get(0).getBounding().y, null);		
		} 
		
		if(keyAttack == true){
			g.drawImage(pl.get(0).getArrayAttackSouth()[imageint], pl.get(0).getBounding().x, pl.get(0).getBounding().y, null);
		}
		
		if(keyUp == false && keyDown == false && keyRight == false && keyLeft == false && keyAttack == false){
			g.drawImage(pl.get(0).getArrayPausedSouth()[imageint], pl.get(0).getBounding().x, pl.get(0).getBounding().y, null);
		}
		
//		if(keyLeft == true){	
//		 for(int j = 0; j<pl.size(); j++){
//			Player p1 = pl.get(j);
//			g.drawImage(p1.getLookPlayerWalkingWest(), p1.getBounding().x, p1.getBounding().y, null);
//		 }
//		}
//		
//		if(keyRight == true){
//		 for(int j = 0; j<pl.size(); j++){
//			Player p1 = pl.get(j);
//			g.drawImage(p1.getLookPlayerWalkingEast(), p1.getBounding().x, p1.getBounding().y, null);
//		 }
//		} 		
		
//		if(keyUp == true){
//			 for(int j = 0; j<pl.size(); j++){
//				Player p1 = pl.get(j);
//				g.drawImage(p1.getLookPlayerWalkingNorth(), p1.getBounding().x, p1.getBounding().y, null);	
//			 }
		
//		if(keyDown == true) {
//		 for(int j = 0; j<pl.size(); j++){
//			Player p1 = pl.get(j);
//			g.drawImage(p1.getLookPlayerWalkingSouth(), p1.getBounding().x, p1.getBounding().y, null);
//		 }
//		} 
//		
//		if(keyDown == false && keyUp == false && keyRight == false && keyLeft == false){
//		 for(int j = 0; j<pl.size(); j++){
//			Player p1 = pl.get(j);
//			g.drawImage(p1.getLookPlayerPausedWest(), p1.getBounding().x, p1.getBounding().y, null);
//		 }
//		}
//		
//		if(keyAttack == true){
//		 for(int j = 0; j<pl.size(); j++){
//			Player p1 = pl.get(j);
//			g.drawImage(p1.getLookPlayerAttackingWest(), p1.getBounding().x, p1.getBounding().y, null);
//		 }
//		}
		
		 for(int i = 0; i<mon.size(); i++){
			 Monster m1 = mon.get(i);
			 g.drawImage(m1.getLookPlayerWalkingNorth(), m1.getBounding().x, m1.getBounding().y, null);
		 }
		 
		 
		System.out.println("ja");
	 }
	 
	 
	//Getter-Methoden fuer keyUp, keyDown, keyRight, keyLeft, keyAttack, keyPick fuer Zugriff auf boolean Wert
	 public void getUp() {
		keyUp = true;
		keyDown = false;
		keyLeft = false;
		keyRight = false;
	 	movingArrayY += 4;
	 	if(imageint <pl.get(0).getArrayWalkingNorth().length){
	 		imageint++;
	 	} else
	 		imageint = 0;
//	 	if(keyUp == true)
	 		repaint();
	 }

	 public void getDown() { 
		 keyUp = false;
			keyDown = true;
			keyLeft = false;
			keyRight = false;
		 	movingArrayY -= 4;
		 	if(imageint <pl.get(0).getArrayWalkingSouth().length){
		 		imageint++;
		 	} else
		 		imageint = 0;
//		 	if(keyDown == true)
		 		repaint();
	 }

	 public void getLeft() {
		 keyUp = false;
			keyDown = false;
			keyLeft = true;
			keyRight = false;
		 	movingArrayX += 4;
		 	if(imageint <pl.get(0).getArrayWalkingWest().length){
		 		imageint++;
		 	} else
		 		imageint = 0;
//		 	if(keyLeft == true)
		 		repaint();
	 }

	 public void getRight() {
		 keyUp = false;
			keyDown = false;
			keyLeft = false;
			keyRight = true;
		 	movingArrayX -= 4;
		 	if(imageint <pl.get(0).getArrayWalkingEast().length){
		 		imageint++;
		 	} else
		 		imageint = 0;
//		 	if(keyRight == true)
		 		repaint();
	 }

	 public void getAttack(){
	 	keyAttack = true; 
	 	
	 	if(imageint <pl.get(0).getArrayAttackSouth().length){
	 		imageint++;
	 	} else
	 		imageint = 0;
//	 	if(keyAttack == true)
	 		repaint();
	 }

	 public static boolean getPick(){
	 	return keyPick;
	 }
	 
//	 class KeyHandler implements KeyListener{
//
//			public void keyPressed(KeyEvent e) {
//				if(e.getKeyCode() == KeyEvent.VK_DOWN) keyDown = true;
//				if(e.getKeyCode() == KeyEvent.VK_UP) keyUp = true;
//				if(e.getKeyCode() == KeyEvent.VK_RIGHT) keyRight = true;
//				if(e.getKeyCode() == KeyEvent.VK_LEFT) keyLeft = true;	
//				if(e.getKeyCode() == KeyEvent.VK_A) keyAttack = true;
//				if(e.getKeyCode() == KeyEvent.VK_S) keyPick = true;
//				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
//			}
//
//			public void keyReleased(KeyEvent e) {
//				if(e.getKeyCode() == KeyEvent.VK_DOWN) keyDown = false;
//				if(e.getKeyCode() == KeyEvent.VK_UP) keyUp = false;
//				if(e.getKeyCode() == KeyEvent.VK_RIGHT) keyRight = false;
//				if(e.getKeyCode() == KeyEvent.VK_LEFT) keyLeft = false;
//				if(e.getKeyCode() == KeyEvent.VK_A) keyAttack = false;
//				if(e.getKeyCode() == KeyEvent.VK_S) keyPick = false;
//			}
//
//			//Wird zwar ausgefuehrt, aber nicht genutzt
//			public void keyTyped(KeyEvent e) {	
//			} 
//			
//		  
//		 }
	 
	 public GamePanel(LooksAndMoving lm, List<Monster> mon, List<Player> pl){ 
//		 
//		 gamePanel = new GamePanel();
//		 gamePanel.setBounds(0, 0, 640, 400);
//		 add(gamePanel);
		 
//		 addKeyListener(new KeyHandler());
		 
		 this.lm = lm;
		 this.mon = mon;
		 this.pl = pl;
		 //this.background = background;	 
	 }


	public GamePanel() {
		// TODO Auto-generated constructor stub
	}
	
	public void repaintScreen(){
		 gamePanel.repaint();
	}
	 
	
	
	public void setMap(Tile[][] map){
		this.map = map;
	}
	
	
	public void setItem(ArrayList<ItemModel> globInv){	
		this.globInv = globInv; 
	}
	
	public void setMonster(Monster[] monsterList){
		this.monsterList = monsterList;
	}
	
	public void setCharacter(Character[] characterList){
		this.characterList = characterList;
	}
	
	public void setMove(Character move){
		this.move = move;
	}
 } 
 
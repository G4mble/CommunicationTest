package komponente.clientEngine;








import java.util.ArrayList;
import pp2015.team12.shared.character.Monster;
import pp2015.team12.shared.character.Monster_Tank;
import pp2015.team12.shared.character.PlayerCharacter;
import pp2015.team12.shared.character.Warrior;
import pp2015.team12.shared.item.HealthPotion;
import pp2015.team12.shared.item.ItemModel;
import pp2015.team12.shared.map.Coordinate;
import pp2015.team12.shared.map.Tile;
import pp2015.team12.shared.map.textures.*;
import pp2015.team12.shared.message.*;

/**
 * 
 * @author Heusser, Caspar
 *
 */

public class ClientEngine {
	
	private boolean signedIn;
	private int clientId = 1; //test wert
	ArrayList<ItemModel> gloInv= new ArrayList<ItemModel>();
	Tile[][] map = { { 	new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1()},
			{new RW_Border_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new RW_Border_1()},
			{new RW_Border_1(),new  UW_Floor_1(),new  UW_Floor_1(),new  UW_Floor_1(),new UW_Floor_1(),new  UW_Floor_1(),new  UW_Floor_1(),new RW_Border_1()},
			{new RW_Border_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new RW_Border_1()},
			{new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1()}};
	Monster[] monsterList = {new Monster_Tank( 0,0, 0, "", 64, 96,"Monster1")};
//	Monster[] monsterList;
	PlayerCharacter[] playerList;
	boolean farsight;
	
	int textureWidth = 32;
	PlayerCharacter player;
	ClientCommunication Com ;
	TestGui Gui;
	/**
	 * Constructor of the ClientEngine, Creates the ClientCommunication and the Gui
	 * @author Caspar Heusser
	 */
	public ClientEngine (){
		 Com = new ClientCommunication(this);
		 //Gui = new TestGui(map,player,Com,this);
		 this.farsight= false;
		 this.signedIn=false;
		 
		 playerList = new PlayerCharacter[10];
		 this.playerList[0] = new Warrior(clientId);
		 HealthPotion testPotion = new HealthPotion(1);
		 testPotion.setXPos(64);
		 testPotion.setYPos(96);
		 this.allocateClientPlayer();
		 this.gloInv.add(testPotion);
		 player.setPosX(32);
		 player.setPosY(32);
		 Gui = new TestGui(map,player,Com,this);
	}
	/**
	 * allocate the ClientPlayer out of the playerList and allocate it to the variable player
	 * @author Caspar Heusser
	 */
	public void allocateClientPlayer(){
		this.player= this.playerList[clientId-1];
	}
	/**
	 * Checks if a MoveMsg is valid by checking if the new position or a part of the texture would be on a field with a wall when the character moves.
	 * Also runs the Monster and Playercheck to prevent overlapping
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void consistencyCheck(MoveMsg message){
		System.out.println("Starte K-Check");
		if(map!=null){
			if(player.getPosX()< message.getnPosX()){
				if(map[((message.getnPosX()+31)/32)][(message.getnPosY()/32)].getAccessible()&&map[((message.getnPosX()+31)/32)][((message.getnPosY()+31)/32)].getAccessible()){
					if(this.checkMonsterK(message)&&this.checkPlayer(message)){	
						System.out.println("Feld begehbar - bewege Spieler");
						player.setPosX(message.getnPosX());
						player.setPosY(message.getnPosY());
						System.out.println("Sende Nachricht an Server");
						System.out.println("Empfange Bestaetigung von Server");
						this.Gui.feld.repaint();
					}
				}else{
					System.out.println("Feld belegt");
				}
			}
			else if(player.getPosY()< message.getnPosY()){
				if(map[(message.getnPosX()/32)][((message.getnPosY()+31)/32)].getAccessible()&&map[((message.getnPosX()+31)/32)][((message.getnPosY()+31)/32)].getAccessible()){
					if(this.checkMonsterK(message)&&this.checkPlayer(message)){		
						System.out.println("Feld begehbar - bewege Spieler");
						player.setPosX(message.getnPosX());
						player.setPosY(message.getnPosY());
						System.out.println("Sende Nachricht an Server");
						System.out.println("Empfange Bestaetigung von Server");
						this.Gui.feld.repaint();
					}
				
				}else{
					System.out.println("Feld belegt");
				}
			}
			else if(player.getPosX()> message.getnPosX()){
				if(map[(message.getnPosX()/32)][(message.getnPosY()/32)].getAccessible()&&map[(message.getnPosX()/32)][((message.getnPosY()+31)/32)].getAccessible()){
					if(this.checkMonsterK(message)&&this.checkPlayer(message)){	
						System.out.println("Feld begehbar - bewege Spieler");
						player.setPosX(message.getnPosX());
						player.setPosY(message.getnPosY());
						System.out.println("Sende Nachricht an Server");
						System.out.println("Empfange Bestaetigung von Server");
						this.Gui.feld.repaint();
					}
				}
			}
			else if(player.getPosY()>message.getnPosY()){
				if(map[(message.getnPosX()/32)][(message.getnPosY()/32)].getAccessible()&&map[((message.getnPosX()+31)/32)][(message.getnPosY()/32)].getAccessible()){
					if(this.checkMonsterK(message)&&this.checkPlayer(message)){	
						System.out.println("Feld begehbar - bewege Spieler");
						player.setPosX(message.getnPosX());
						player.setPosY(message.getnPosY());
						System.out.println("Sende Nachricht an Server");
						System.out.println("Empfange Bestaetigung von Server");
						this.Gui.feld.repaint();
					}
				}
			}
		}
		
	}
	/**
	 * 
	 * Checks if a monster is in range depending on the last movement. Acceptable Positions for the monster are in front of the character or to the front right or front left
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void engageFight(EngageFightMsg message){
		ArrayList<Monster> inRange = new ArrayList<Monster>();
		if(message.getDirection()==1){												//Last movement was up
			System.out.println("check Monster oben");
			for(Monster next: this.monsterList){
				if(this.player.getPosY()-next.getPosY()<(this.textureWidth*1.5)&&this.player.getPosY()-next.getPosY()>(this.textureWidth*0.3)&&this.player.getPosX()-next.getPosX()<=(this.textureWidth*1.2)&&this.player.getPosX()-next.getPosX()>=-(this.textureWidth*1.2)){
					inRange.add(next);
				}
			}
			
		}
		if(message.getDirection()==2){												//Last movement was right
			System.out.println("check Monster rechts");
			for(Monster next: this.monsterList){
				if(next.getPosX()-this.player.getPosX()<(this.textureWidth*1.5)&&next.getPosX()-this.player.getPosX()>(this.textureWidth*0.3)&&next.getPosY()-this.player.getPosY()<=(this.textureWidth*1.2)&&next.getPosY()-this.player.getPosY()>=-(this.textureWidth*1.2)){
					inRange.add(next);
				}
			}
			
		}
		if(message.getDirection()==3){												//Last movement was down
			System.out.println("check Monster unten");
			for(Monster next: this.monsterList){
				if(next.getPosY()-this.player.getPosY()<(this.textureWidth*1.5)&&next.getPosY()-this.player.getPosY()>(this.textureWidth*0.3)&&this.player.getPosX()-next.getPosX()<=(this.textureWidth*1.2)&&this.player.getPosX()-next.getPosX()>=-(this.textureWidth*1.2)){
					inRange.add(next);
				}
			}
			
		}
		if(message.getDirection()==4){												//Last movement was left
			System.out.println("check Monster links");
			for(Monster next: this.monsterList){
				if(this.player.getPosX()-next.getPosX()<(this.textureWidth*1.5)&&this.player.getPosX()-next.getPosX()>(this.textureWidth*0.3)&&next.getPosY()-this.player.getPosY()<=(this.textureWidth*1.2)&&next.getPosY()-this.player.getPosY()>=-(this.textureWidth*1.2)){
					inRange.add(next);
				}
			}
			
		}
		if(inRange.isEmpty()==true){												//No monster detected
			System.out.println("Kein Monster in Reichweite");
		}else{
			System.out.println("Monster angreifen - MonsterPos Client");			//Monster detected - send a message to server
		}
	}
	/**
	 * Checks if their is any overlapping between players when recieving a MoveMsg
	 * @author Heusser, Caspar
	 * @param message
	 * @return
	 */
	public boolean checkPlayer(MoveMsg message){
		ArrayList<PlayerCharacter> otherPlayer = new ArrayList<PlayerCharacter>();
		for(int j = 0; j<this.playerList.length;j++){
			if(this.playerList[j]!= null&& j != this.clientId -1){
				otherPlayer.add(this.playerList[j]);
			}
		}
		for(PlayerCharacter oP : otherPlayer){
			if((Math.abs(message.getnPosX() - oP.getPosX())<32 || Math.abs(oP.getPosX()-message.getnPosX())<32)&&(Math.abs(message.getnPosY() - oP.getPosY())<32 || Math.abs(oP.getPosY()-message.getnPosY())<32)){
				return false;
			}
			else{
				return true;
			}
			
		}
		return true;
	}
	/**
	 * Checks for item in a texturwidth field around the player 
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void pickUpItem(PickUpMsg message){	
		int posX = player.getPosX();
		int posY = player.getPosY();
	
		ArrayList<ItemModel> inRange = new ArrayList<ItemModel>();
		for(ItemModel next : this.gloInv){
			if((Math.abs(posX - next.getXPos())<=32||Math.abs(next.getXPos()-posX)<=32)&&(Math.abs(posY -next.getYPos())<=32)||Math.abs(next.getYPos()-posY)<=32){//doppelte texturen weite				//Eigenbreite
				inRange.add(next);
			
			}
		}
		if(inRange.size() == 0){
			System.out.println("Kein Item in Reichweite");
		}else if (inRange.size()==1){
			System.out.println("Nachicht an server mit Item das aufgehoben werden soll");
		}else{
			ItemModel nearest = inRange.get(0);
			
			int distance = Math.abs( nearest.getXPos()-player.getPosX())+Math.abs(nearest.getYPos()-player.getPosY());
			for(int i = 1; i< inRange.size(); i++){
				if(distance > (Math.abs(inRange.get(i).getXPos()- posX)+Math.abs(inRange.get(i).getYPos()-posY))){
					nearest= inRange.get(i);
					distance = (Math.abs(inRange.get(i).getXPos()- posX)+Math.abs(inRange.get(i).getYPos()-posY));
				}
			}
			System.out.println("Nachricht an Server mit Item das am naechsten zum Spieler liegt"); //Itempos + Client
		}
	}
	/**
	 * Checks if their is any overlapping between player and a monster when recieving a MoveMsg
	 * @author Heusser, Caspar
	 * @param message
	 * @return
	 */
	public boolean checkMonsterK(MoveMsg message){				
		
		for(int i = 0; i<this.monsterList.length;i++){
			if((Math.abs(message.getnPosX() - this.monsterList[i].getPosX())<32 || Math.abs(this.monsterList[i].getPosX()-message.getnPosX())<32)&&(Math.abs(message.getnPosY() - this.monsterList[i].getPosY())<32 || Math.abs(this.monsterList[i].getPosY()-message.getnPosY())<32)){
				return false;
			}
			else{
				return true;
			}
			
		}
		return true;

}
	/**
	 * Checks for door in a half texturwidth field around the player 
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void useDoor(LevelChangeReqMsg message){
		ArrayList<Coordinate> doorPosition = new ArrayList<Coordinate>();
		System.out.println("Bestimmte Position von Tuer");
		for(int i = 0;i<this.map.length;i++){
			for(int j=0;j<this.map[0].length;j++){
				if(this.map[i][j].getImageID()==1041||this.map[i][j].getImageID()==2042||this.map[i][j].getImageID()==2043){
					doorPosition.add(new Coordinate( i*this.textureWidth, j*this.textureWidth));
				}
			}
		}
		if(doorPosition.isEmpty()==true){
			System.out.println("Keine Tuer gefunden");
		}else{
			System.out.println("Alle Tueren auf der Ebene bestimmt");
			for(Coordinate next: doorPosition){
				if(Math.abs(this.player.getPosX() - next.getPosX())<=(this.textureWidth/2)&& Math.abs(next.getPosY()-this.player.getPosY())<=(this.textureWidth/2)){
					System.out.println("Nachricht mit tuerpos an server");
					break;
				}
			}
		}
	
	}
	/**
	 * update one Character
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateCharacter(CharacterUpdateMsg message){
		int i = message.getPlayer().getClientId();
		this.playerList[i-1]= message.getPlayer();
		this.allocateClientPlayer();
		}
	/**
	 * update the whole CharacerList
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateCharacterList(CharacterListMsg message){
		this.playerList = message.getCharacterList();
		this.allocateClientPlayer();
	}
	/**
	 * update Character life in result of a cheat message
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateLife(YConfirmationMsg message){
		player.setMaximumLife(message.getLife());
		player.setCurrentLife(message.getLife());
	}
	/**
	 * update Inventory in result of a cheat message
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateInventory(SConfirmationMsg message){
		this.player.setInventory(message.getLocInv());
	}
	/**
	 * update Inventory in result of picking up a new Item
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateInventory(PickUpConfirmationMsg message){
		this.player.setInventory(message.getLocInv());
	}
	/**
	 * update Inventory in result of an ordinary update message from the server
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateInventory(LocInvMsg message){
		this.player.setInventory(message.getLocInv());
	}
	/**
	 * update globel inventory in result of picking up a new Item
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateGlobInventory(PickUpConfirmationMsg message){
		this.gloInv = message.getGloInv();
	}
	/**
	 * update globel inventory in result an ordinary update message from the server
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateGlobInventory(GlobInvMsg message){
		this.gloInv = message.getGlobInv();
	}
	/**
	 * update Monsterlist
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateMonsterList(MonsterListMsg message){
		this.monsterList= message.getMonsterList();
	}
	/**
	 * Checks Chat messages sent by gui for cheatmessages
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void checkCheat(ChatMsg message){
		if(message.getContent().equals("#yolo")){
			System.out.println("unendlich leben - sende Nachricht an Server");
		}
		else if (message.getContent().equals("#swag")){
			System.out.println("10000 Gold - sende Nachricht an Server");
		}
		else if(message.getContent().equals("#nofilter")){
			System.out.println("setze Sichtweite hoch");
			this.farsight= true;
		}
		else if(message.getContent().equals("#filter")){
			System.out.println("setze Sichtweite runter");
			this.farsight= false;
		}else{
			System.out.println("Leite ChatNachricht an server weiter");
			System.out.println(message.getContent());
		}
		
	}
	/**
	 * update the map 
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void changeMap(MapMsg message){
		System.out.println("Neue Map abspeichern...");
		this.map = message.getMap();
		System.out.println("Map abgespeichert");
		this.loadTextures();
		System.out.println("Schicke UpdateMsg am Gui");
		this.Gui.feld.repaint();;
	}
	/**
	 * loading textures into the map
	 * @author Heusser, Caspar
	 */
	public void loadTextures(){
		for(int i = 0; i<this.map.length;i++){
			for(int j = 0; j<this.map[0].length;j++){
				map[i][j].readTexture(); //anpasse pfad
			}
		}
	}
	/**
	 * allocate the position of the item the player wants to use and send the information to the server
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void useItem(UseItemMsg message){
		this.gloInv.get(message.getPosInv());
		System.out.println("Nachricht an der Server mit Item das benutzt werden soll");
	}
	/**
	 * set the loginstatus
	 * @author Heusser, Caspar
	 * @param signedIn
	 */
	public void setSignedIn(boolean signedIn){
		this.signedIn= signedIn;
	}
	/**
	 * get the loginstatus
	 * @author Heusser, Caspar
	 * @return
	 */
	public boolean  getSignedIn(){
		return this.signedIn;
	}
	/**
	 * get the clientid
	 * @author Heusser, Caspar
	 * @return
	 */
	public int getClientId() {
		return clientId;
	}
	/**
	 * set the clientid
	 * @author Heusser, Caspar
	 * @param clientId
	 */
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
}

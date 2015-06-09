package pp2015.team12.client;








import java.util.ArrayList;







import pp2015.team12.client.communication.ClientCom;
import pp2015.team12.client.gui.Frame;

import pp2015.team12.shared.character.Monster;
import pp2015.team12.shared.character.Monster_Tank;
import pp2015.team12.shared.character.PlayerCharacter;
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

//TODO Kosistenzcheck auslagern
public class ClientEngine {
	
	private boolean signedIn;
	private int clientId = 1; //test wert
	ArrayList<ItemModel> gloInv= new ArrayList<ItemModel>();
	Tile[][] map = { { 	new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1()},
			{new RW_Border_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new RW_Border_1()},
			{new RW_Border_1(),new  UW_Floor_1(),new  UW_Floor_1(),new  UW_Floor_1(),new UW_Floor_1(),new  UW_Floor_1(),new  UW_Floor_1(),new RW_Border_1()},
			{new RW_Border_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new RW_Border_1()},
			{new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1()}};
	Monster[] monsterList = {new Monster_Tank( 0,0, 0, "", 80, 120,"Monster1")};
//	Monster[] monsterList;
	PlayerCharacter[] playerList;
	boolean farsight;
	
	int textureWidth = 40;
	PlayerCharacter player;
	ClientCommunication Com ;
	ClientCom ClientCommunication;
	TestGui Gui;
	Frame frame;
	/**
	 * Constructor of the ClientEngine, Creates the ClientCommunication and the Gui
	 * @author Caspar Heusser
	 */
	public ClientEngine (){
		 Com = new ClientCommunication(this);
		 frame = new Frame(Com);
		 //Gui = new TestGui(map,player,Com,this);
		 this.farsight= false;						//noch nicht implementiert
		 this.signedIn=false;
//		 this.ClientCommunication = new ClientCom(Com);
//		 playerList = new PlayerCharacter[10];
//		 this.playerList[0] = new Warrior(clientId);
//		 HealthPotion testPotion = new HealthPotion(1);
//		 testPotion.setXPos(80);
//		 testPotion.setYPos(120);
//		 this.allocateClientPlayer();
//		 this.gloInv.add(testPotion);
//		 player.setPosX(40);
//		 player.setPosY(40);
//		 Gui = new TestGui(map,player,Com,this);
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
		message.setClientId(this.clientId);
		if(map!=null){
			if(player.getPosX()< message.getnPosX()){
				System.out.println("prüfe Bewegung nach rechts");
				if(map[((message.getnPosX()+(this.textureWidth-1))/this.textureWidth)][message.getnPosY()/this.textureWidth].getAccessible()&&map[(message.getnPosX()+(this.textureWidth-1))/this.textureWidth][((message.getnPosY()+(this.textureWidth-1))/this.textureWidth)].getAccessible()){
					if(this.checkMonsterK(message)&&this.checkPlayer(message)){	
						System.out.println("Feld begehbar - bewege Spieler");
						player.setPosX(message.getnPosX());
						player.setPosY(message.getnPosY());
						System.out.println("Sende Nachricht an Server");
						this.ClientCommunication.getNextMessage(message);
//						System.out.println("Empfange Bestaetigung von Server");
//						this.Gui.feld.repaint();
					}
				}else{
					System.out.println("Feld belegt");
				}
			}
			else if(player.getPosY()< message.getnPosY()){
				System.out.println("prüfe Bewegung nach unten");
				if(map[(message.getnPosX()/this.textureWidth)][((message.getnPosY()+(this.textureWidth-1))/this.textureWidth)].getAccessible()&&map[((message.getnPosX()+(this.textureWidth-1))/this.textureWidth)][((message.getnPosY()+(this.textureWidth-1))/this.textureWidth)].getAccessible()){
					if(this.checkMonsterK(message)&&this.checkPlayer(message)){		
						System.out.println("Feld begehbar - bewege Spieler");
						player.setPosX(message.getnPosX());
						player.setPosY(message.getnPosY());
						System.out.println("Sende Nachricht an Server");
						this.ClientCommunication.getNextMessage(message);
//						System.out.println("Empfange Bestaetigung von Server");
//						this.Gui.feld.repaint();
					}
				
				}else{
					System.out.println("Feld belegt");
				}
			}
			else if(player.getPosX()> message.getnPosX()){
				System.out.println("prüfe Bewegung nach links");
				if(map[(message.getnPosX()/this.textureWidth)][(message.getnPosY()/this.textureWidth)].getAccessible()&&map[(message.getnPosX()/this.textureWidth)][((message.getnPosY()+(this.textureWidth-1))/this.textureWidth)].getAccessible()){
					if(this.checkMonsterK(message)&&this.checkPlayer(message)){	
						System.out.println("Feld begehbar - bewege Spieler");
						player.setPosX(message.getnPosX());
						player.setPosY(message.getnPosY());
						System.out.println("Sende Nachricht an Server");
						this.ClientCommunication.getNextMessage(message);
//						System.out.println("Empfange Bestaetigung von Server");
//						this.Gui.feld.repaint();
					}
				}
			}
			else if(player.getPosY()>message.getnPosY()){
				System.out.println("prüfe Bewegung nach oben");
				if(map[(message.getnPosX()/this.textureWidth)][(message.getnPosY()/this.textureWidth)].getAccessible()&&map[((message.getnPosX()+(this.textureWidth-1))/this.textureWidth)][(message.getnPosY()/this.textureWidth)].getAccessible()){
					if(this.checkMonsterK(message)&&this.checkPlayer(message)){	
						System.out.println("Feld begehbar - bewege Spieler");
						player.setPosX(message.getnPosX());
						player.setPosY(message.getnPosY());
						System.out.println("Sende Nachricht an Server");
						this.ClientCommunication.getNextMessage(message);
//						System.out.println("Empfange Bestaetigung von Server");
//						this.Gui.feld.repaint();
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
			System.out.println("Monster angreifen - MonsterPos ClientId");			//Monster detected - send a message to server
			for(Monster next: inRange){
				message.setClientId(this.clientId);
				message.setMonsterPos(new Coordinate(next.getPosX(),next.getPosY()));
				this.ClientCommunication.getNextMessage(message);
			}
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
			if((Math.abs(message.getnPosX() - oP.getPosX())<this.textureWidth || Math.abs(oP.getPosX()-message.getnPosX())<this.textureWidth)&&(Math.abs(message.getnPosY() - oP.getPosY())<this.textureWidth || Math.abs(oP.getPosY()-message.getnPosY())<this.textureWidth)){
				return false;			//player conflict
			}
//			else{
//				return true;			//no player conflict
//			}
			
		}
		return true;					//no playerconflict
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
			if((Math.abs(posX - next.getXPos())<=this.textureWidth||Math.abs(next.getXPos()-posX)<=this.textureWidth)&&(Math.abs(posY -next.getYPos())<=this.textureWidth)||Math.abs(next.getYPos()-posY)<=this.textureWidth){
				inRange.add(next);
			
			}
		}
		if(inRange.size() == 0){
			System.out.println("Kein Item in Reichweite");
		}else if (inRange.size()==1){
			System.out.println("Nachicht an server mit Item das aufgehoben werden soll");
			((PickUpMsg)message).setPos(new Coordinate(inRange.get(0).getXPos(),inRange.get(0).getYPos()));
			message.setClientId(this.clientId);
			this.ClientCommunication.getNextMessage(message);
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
			((PickUpMsg)message).setPos(new Coordinate(nearest.getXPos(),nearest.getYPos()));
			message.setClientId(this.clientId);
			this.ClientCommunication.getNextMessage(message);
		}
	}
	
	/**
	 * Checks if their is any overlapping between player and a monster when receiving a MoveMsg
	 * @author Heusser, Caspar
	 * @param message
	 * @return
	 */
	public boolean checkMonsterK(MoveMsg message){				
		
		for(int i = 0; i<this.monsterList.length;i++){													
			if((Math.abs(message.getnPosX() - this.monsterList[i].getPosX())<this.textureWidth || Math.abs(this.monsterList[i].getPosX()-message.getnPosX())<this.textureWidth)&&(Math.abs(message.getnPosY() - this.monsterList[i].getPosY())<this.textureWidth || Math.abs(this.monsterList[i].getPosY()-message.getnPosY())<this.textureWidth)){
				return false;							//monster conflict
			}
//			else{
//				return true;
//			}
			
		}
		return true;									//no monster conflict

}
	/**
	 * Checks for door in a half texturwidth field around the player 
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void useDoor(RequestLevelChangeMsg message){
		ArrayList<Coordinate> doorPosition = new ArrayList<Coordinate>();
		System.out.println("Bestimmte Position von Tuer");
		for(int i = 0;i<this.map.length;i++){
			for(int j=0;j<this.map[0].length;j++){
				if(this.map[i][j].getImageID()==1041||this.map[i][j].getImageID()==1042||this.map[i][j].getImageID()==1043||this.map[i][j].getImageID()==1044||this.map[i][j].getImageID()==1045||this.map[i][j].getImageID()==1046||this.map[i][j].getImageID()==2041||this.map[i][j].getImageID()==2042||this.map[i][j].getImageID()==2043||this.map[i][j].getImageID()==2044||this.map[i][j].getImageID()==2045||this.map[i][j].getImageID()==2046||this.map[i][j].getImageID()==3041||this.map[i][j].getImageID()==3042||this.map[i][j].getImageID()==3043||this.map[i][j].getImageID()==3044||this.map[i][j].getImageID()==3045||this.map[i][j].getImageID()==3046){
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
					System.out.println("Nachricht mit tuerpos an server"); //texturen id + client id
					((RequestLevelChangeMsg)message).setClientId(this.clientId);
					((RequestLevelChangeMsg)message).setTextureId((map[next.getPosX()/this.textureWidth][next.getPosY()/this.textureWidth]).getImageID());
					((RequestLevelChangeMsg)message).setCurrentLevelId(player.getLevelId());
					this.ClientCommunication.getNextMessage(message);
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
		System.out.println("CharacterUpdateMsg an Gui weiterleiten");
		this.frame.forwardMessage(message);
		}
	/**
	 * update the whole CharacerList
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateCharacterList(CharacterListMsg message){
		this.playerList = message.getCharacterList();
		this.allocateClientPlayer();
		System.out.println("CharacterListMsg an die Gui weiterleiten");
		this.frame.forwardMessage(message);
	}
	/**
	 * update Character life in result of a cheat message
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateLife(YConfirmationMsg message){			//TODO ggf durch player updates ersetzen
		player.setMaximumLife(message.getLife());
		player.setCurrentLife(message.getLife());
		System.out.println("Yolo - Update an Gui weiterleiten");
		CharacterUpdateMsg msg = new CharacterUpdateMsg(this.clientId, this.player);
		this.frame.forwardMessage(msg);
	}
	/**
	 * update Inventory in result of a cheat message
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateInventory(SConfirmationMsg message){		//TODO ggf durch player updates ersetzen
		this.player.setInventory(message.getLocInv());
		System.out.println("Swag - Update an gui Weiterleiten");
		CharacterUpdateMsg msg = new CharacterUpdateMsg(this.clientId, this.player);
		this.frame.forwardMessage(msg);
	}
	/**
	 * update Inventory in result of picking up a new Item
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateInventory(PickUpConfirmationMsg message){
		this.player.setInventory(message.getLocInv());
		System.out.println("PickUpConfirmation - Update an gui Weiterleiten");
		CharacterUpdateMsg msg = new CharacterUpdateMsg(this.clientId, this.player);
		this.frame.forwardMessage(msg);
	}
	/**
	 * update Inventory in result of an ordinary update message from the server
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateInventory(LocInvMsg message){
		this.player.setInventory(message.getLocInv());
		System.out.println("LocInv - Update an gui Weiterleiten");
		CharacterUpdateMsg msg = new CharacterUpdateMsg(this.clientId, this.player);
		this.frame.forwardMessage(msg);
	}
	/**
	 * update globel inventory in result of picking up a new Item
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateGlobInventory(PickUpConfirmationMsg message){
		this.gloInv = message.getGloInv();
		System.out.println("Global Inventory updaten - Nachricht an GUI");
		this.frame.forwardMessage(new GlobInvMsg(this.clientId,message.getGloInv()));
	}
	/**
	 * update globel inventory in result an ordinary update message from the server
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateGlobInventory(GlobInvMsg message){
		this.gloInv = message.getGlobInv();
		System.out.println("Global Inventory updaten - Nachricht an GUI");
		this.frame.forwardMessage(new GlobInvMsg(this.clientId,message.getGlobInv()));
	}
	/**
	 * update Monsterlist
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void updateMonsterList(MonsterListMsg message){
		this.monsterList= message.getMonsterList();
		System.out.println("MonsterList updaten - Nachricht an Gui");
		this.frame.forwardMessage(message);
	}
	/**
	 * Checks Chat messages sent by gui for cheatmessages
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void checkCheat(ChatMsg message){
		if(message.getContent().equals("#yolo")){
			System.out.println("unendlich leben - sende Nachricht an Server");
			this.ClientCommunication.getNextMessage(new YoloMsg(this.clientId));
			
		}
		else if (message.getContent().equals("#swag")){
			System.out.println("10000 Gold - sende Nachricht an Server");
			this.ClientCommunication.getNextMessage(new SwagMsg(this.clientId));
		}
		else if(message.getContent().equals("#nofilter")){
			System.out.println("setze Sichtweite hoch");
			this.farsight= true;
		}
		else if(message.getContent().equals("#filter")){
			System.out.println("setze Sichtweite runter");
			this.farsight= false;
		}else{
			this.ClientCommunication.getNextMessage(message);
			System.out.println("Kein Cheat - Leite ChatNachricht an server weiter");
			message.setClientId(this.clientId);
			this.ClientCommunication.getNextMessage(message);
		
		}
		
	}
	/**
	 * update the map 
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void changeMap(MapMsg message){
		this.map = message.getMap();
		System.out.println("Map abgespeichert");
		this.loadTextures();
		System.out.println("Texturen geladen");
		System.out.println("Schicke UpdateMsg am Gui");
							
		this.frame.forwardMessage(this.createSector());
		this.frame.forwardMessage(this.createSectorMini());
//		this.Gui.feld.repaint();;
	}
	/**
	 * loading textures into the map
	 * @author Heusser, Caspar
	 */
	public void loadTextures(){
		for(int i = 0; i<this.map.length;i++){
			for(int j = 0; j<this.map[0].length;j++){
				map[i][j].readTexture(); 
			}
		}
	}
	
//	public Tile[][] createSector (){
//		int posX = this.player.getPosX();
//		int posY = this.player.getPosY();
//		int scaledPosX = posX/this.textureWidth;
//		int scaledPosY = posY/this.textureWidth;
//		Tile[][] sector = new Tile[21][11];
//		if(scaledPosX >= 10&&scaledPosX<=51&&scaledPosY>=5&&scaledPosY<=26){		//kein Rand im sichtfeld
//			for(int i = scaledPosX-10, x = 0;i < scaledPosX+10;i++ , x++){
//				for(int j = scaledPosY-5, y = 0;j<scaledPosY+5;j++ , y++){
//					sector[x][y]=map[scaledPosX][scaledPosY];
//				}
//			}
//		}
//		else if(scaledPosX >= 10&&scaledPosX<=51&&scaledPosY<=4){					//oben rand
//			int dif = 5 -scaledPosY;
//			for(int i = scaledPosX-10, x = 0;i < scaledPosX+10;i++ , x++){
//				for(int j = scaledPosY-5+dif, y = 0;j<scaledPosY+5+dif;j++ , y++){
//					sector[x][y]=map[scaledPosX][scaledPosY];
//				}
//			}
//		}
//		else if(scaledPosX >= 10&&scaledPosX<=51&&scaledPosY>=27){					//unten rand
//			int dif = 5 - (31 -scaledPosY);
//			for(int i = scaledPosX-10, x = 0;i < scaledPosX+10;i++ , x++){
//				for(int j = scaledPosY-5-dif, y = 0;j<scaledPosY+5-dif;j++ , y++){
//					sector[x][y]=map[scaledPosX][scaledPosY];
//				}
//			}
//		}
//		else if(scaledPosX>=52&&scaledPosY>=5&&scaledPosY<=26){						//rechts rand
//			int dif = 10 - (61 - scaledPosX);
//			for(int i = scaledPosX-10-dif, x = 0;i < scaledPosX+10-dif;i++ , x++){
//				for(int j = scaledPosY-5, y = 0;j<scaledPosY+5;j++ , y++){
//					sector[x][y]=map[scaledPosX][scaledPosY];
//				}
//			}
//		}
//		else if(scaledPosX <= 9&&scaledPosY>=5&&scaledPosY<=26){					//links rand
//			int dif = 10 - scaledPosX;
//			for(int i = scaledPosX-10+dif, x = 0;i < scaledPosX+10+dif;i++ , x++){
//				for(int j = scaledPosY-5, y = 0;j<scaledPosY+5;j++ , y++){
//					sector[x][y]=map[scaledPosX][scaledPosY];
//				}
//			}
//		}
//		if(scaledPosX <= 9&&scaledPosY<=4){											//oben + links rand
//			int difX = 10-scaledPosX;
//			int difY = 5-scaledPosY;
//			for(int i = scaledPosX-10+difX, x = 0;i < scaledPosX+10+difX;i++ , x++){
//				for(int j = scaledPosY-5+difX, y = 0;j<scaledPosY+5+difX;j++ , y++){
//					sector[x][y]=map[scaledPosX][scaledPosY];
//				}
//			}
//		}
//		else if(scaledPosX<=9&&scaledPosY>=27){										//unten + links rand
//			int difX = 10-scaledPosX;
//			int difY = 5-(31-scaledPosY);
//			for(int i = scaledPosX-10+difX, x = 0;i < scaledPosX+10+difX;i++ , x++){
//				for(int j = scaledPosY-5-difY, y = 0;j<scaledPosY+5-difY;j++ , y++){
//					sector[x][y]=map[scaledPosX][scaledPosY];
//				}
//			}
//		}
//		else if(scaledPosX >= 52&&scaledPosY<=4){									//oben + rechts rand
//			int difX = 10 - (61 -scaledPosX);
//			int difY = 5 -scaledPosY;
//			for(int i = scaledPosX-10-difX, x = 0;i < scaledPosX+10-difX;i++ , x++){
//				for(int j = scaledPosY-5+difY, y = 0;j<scaledPosY+5+difY;j++ , y++){
//					sector[x][y]=map[scaledPosX][scaledPosY];
//				}
//			}
//		}
//		else if(scaledPosX >= 52&&scaledPosY>=27){									//unten + rechts rand
//			int difX = 10 - (61 -scaledPosX);
//			int difY = 5 - (31 -scaledPosY);
//			for(int i = scaledPosX-10-difX, x = 0;i < scaledPosX+10-difX;i++ , x++){
//				for(int j = scaledPosY-5-difY, y = 0;j<scaledPosY+5-difY;j++ , y++){
//					sector[x][y]=map[scaledPosX][scaledPosY];
//				}
//			}
//		}
//		return sector;
//	}
	//1200*720   30*18   31*19
//	public Tile[][] createSector (){
//		int posX = this.player.getPosX();
//		int posY = this.player.getPosY();
//		int scaledPosX = posX/this.textureWidth;
//		int scaledPosY = posY/this.textureWidth;
//		int mapMaxX = map.length-1;
//		int mapMaxY = map[0].length-1;
//		Tile[][] sector = new Tile[21][11];
//		if(scaledPosX >= 10&&scaledPosX<=mapMaxX-10&&scaledPosY>=5&&scaledPosY<=mapMaxY-5){		//kein Rand im sichtfeld
//			for(int i = scaledPosX-10, x = 0;i < scaledPosX+10;i++ , x++){
//				for(int j = scaledPosY-5, y = 0;j<scaledPosY+5;j++ , y++){
//					sector[x][y]=map[i][j];
//				}
//			}
//		}
//		else if(scaledPosX >= 10&&scaledPosX<=mapMaxX-10&&scaledPosY<=4){					//oben rand
//			int dif = 5 -scaledPosY;
//			for(int i = scaledPosX-10, x = 0;i < scaledPosX+10;i++ , x++){
//				for(int j = scaledPosY-5+dif, y = 0;j<scaledPosY+5+dif;j++ , y++){
//					sector[x][y]=map[i][j];
//				}
//			}
//		}
//		else if(scaledPosX >= 10&&scaledPosX<=mapMaxX-10&&scaledPosY>=mapMaxY-4){			//unten rand
//			int dif = 5 - (31 -scaledPosY);
//			for(int i = scaledPosX-10, x = 0;i < scaledPosX+10;i++ , x++){
//				for(int j = scaledPosY-5-dif, y = 0;j<scaledPosY+5-dif;j++ , y++){
//					sector[x][y]=map[i][j];
//				}
//			}
//		}
//		else if(scaledPosX>=mapMaxX-9&&scaledPosY>=5&&scaledPosY<=mapMaxY-5){				//rechts rand
//			int dif = 10 - (61 - scaledPosX);
//			for(int i = scaledPosX-10-dif, x = 0;i < scaledPosX+10-dif;i++ , x++){
//				for(int j = scaledPosY-5, y = 0;j<scaledPosY+5;j++ , y++){
//					sector[x][y]=map[i][j];
//				}
//			}
//		}
//		else if(scaledPosX <= 9&&scaledPosY>=5&&scaledPosY<=mapMaxY-5){						//links rand
//			int dif = 10 - scaledPosX;
//			for(int i = scaledPosX-10+dif, x = 0;i < scaledPosX+10+dif;i++ , x++){
//				for(int j = scaledPosY-5, y = 0;j<scaledPosY+5;j++ , y++){
//					sector[x][y]=map[i][j];
//				}
//			}
//		}
//		if(scaledPosX <= 9&&scaledPosY<=4){											//oben + links rand
//			int difX = 10-scaledPosX;
//			int difY = 5-scaledPosY;
//			for(int i = scaledPosX-10+difX, x = 0;i < scaledPosX+10+difX;i++ , x++){
//				for(int j = scaledPosY-5+difY, y = 0;j<scaledPosY+5+difY;j++ , y++){
//					sector[x][y]=map[i][j];
//				}
//			}
//		}
//		else if(scaledPosX<=9&&scaledPosY>=mapMaxY-4){										//unten + links rand
//			int difX = 10-scaledPosX;
//			int difY = 5-(31-scaledPosY);
//			for(int i = scaledPosX-10+difX, x = 0;i < scaledPosX+10+difX;i++ , x++){
//				for(int j = scaledPosY-5-difY, y = 0;j<scaledPosY+5-difY;j++ , y++){
//					sector[x][y]=map[i][j];
//				}
//			}
//		}
//		else if(scaledPosX >= mapMaxX-9&&scaledPosY<=4){									//oben + rechts rand
//			int difX = 10 - (61 -scaledPosX);
//			int difY = 5 -scaledPosY;
//			for(int i = scaledPosX-10-difX, x = 0;i < scaledPosX+10-difX;i++ , x++){
//				for(int j = scaledPosY-5+difY, y = 0;j<scaledPosY+5+difY;j++ , y++){
//					sector[x][y]=map[i][j];
//				}
//			}
//		}
//		else if(scaledPosX >= mapMaxX-9&&scaledPosY>=mapMaxY-4){									//unten + rechts rand
//			int difX = 10 - (61 -scaledPosX);
//			int difY = 5 - (31 -scaledPosY);
//			for(int i = scaledPosX-10-difX, x = 0;i < scaledPosX+10-difX;i++ , x++){
//				for(int j = scaledPosY-5-difY, y = 0;j<scaledPosY+5-difY;j++ , y++){
//					sector[x][y]=map[i][j];
//				}
//			}
//		}
//		return sector;
//	}
	
	public BigMapMsg createSector(){
		int scaledPosX =this.player.getPosX()/this.textureWidth;
		int scaledPosY =this.player.getPosY()/this.textureWidth;
		int mapMaxX = map.length-1;
		int mapMaxY = map[0].length-1;
		boolean movePlayer = false;
		Tile[][] sector = new Tile[19][31];
		if(scaledPosX <= mapMaxX-15 && scaledPosX >= 15 && scaledPosY <= mapMaxY-9 &&scaledPosY >= 9){			//kein rand
			for(int i = scaledPosY-9 , y = 0; i<scaledPosY+9;i++ , y++){
				for(int j = scaledPosX-15, x = 0; j<scaledPosX+15;j++ , x++ ){
					sector[y][x] = map[i][j];
					movePlayer=false;
				}
			}
		}
		else if(scaledPosX <= mapMaxX-15 && scaledPosX >= 15 &&scaledPosY >= mapMaxY-8){						//unten rand
			for(int i = mapMaxY-9 , y = 0; i<=mapMaxY;i++ , y++){
				for(int j = scaledPosX-15, x = 0; j<scaledPosX+15;j++ , x++ ){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX <= mapMaxX-15 && scaledPosX >= 15 &&scaledPosY <= 8){									//oben rand
			for(int i = 0 , y = 0; i<9;i++ , y++){
				for(int j = scaledPosX-15, x = 0; j<scaledPosX+15;j++ , x++ ){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX <= 15&&scaledPosY <= mapMaxY-9 &&scaledPosY >= 9 ){								//links rand
			for(int i = scaledPosY-9 , y = 0; i<scaledPosY+9;i++ , y++){
				for(int j = 0, x = 0; j<15;j++ , x++ ){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX >= mapMaxX -14 &&scaledPosY <= mapMaxY-9 &&scaledPosY >= 9 ){								//rechts rand
			for(int i = scaledPosY-9 , y = 0; i<scaledPosY+9;i++ , y++){
				for(int j = mapMaxX-15, x = 0; j<=mapMaxX;j++ , x++ ){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX <= 15&& scaledPosY <= 8){								//links oben
			for(int i = 0 , y = 0; i<9;i++ , y++){
				for(int j = 0, x = 0; j<15;j++ , x++ ){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX <= 15&&scaledPosY >= mapMaxY-8){								//links unten
			for(int i = mapMaxY-9 , y = 0; i<=mapMaxY;i++ , y++){
				for(int j = 0, x = 0; j<15;j++ , x++ ){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX >= mapMaxX -14&&scaledPosY >= mapMaxY-8 ){								//rechts unten
			for(int i = mapMaxY-9 , y = 0; i<=mapMaxY;i++ , y++){
				for(int j = mapMaxX-15, x = 0; j<=mapMaxX;j++ , x++){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX >= mapMaxX -14&&scaledPosY <= 8 ){								//rechts oben
			for(int i = 0 , y = 0; i<9;i++ , y++){
				for(int j = mapMaxX-15, x = 0; j<=mapMaxX;j++ , x++){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		
		
		return new BigMapMsg(sector,movePlayer);
		
	}
	public MiniMapMsg createSectorMini(){
		int scaledPosX =this.player.getPosX()/this.textureWidth;
		int scaledPosY =this.player.getPosY()/this.textureWidth;
		int mapMaxX = map.length-1;
		int mapMaxY = map[0].length-1;
		boolean movePlayer = false;
		Tile[][] sector = new Tile[23][35];
		if(scaledPosX <= mapMaxX-17 && scaledPosX >= 17 && scaledPosY <= mapMaxY-11 &&scaledPosY >= 11){			//kein rand
			for(int i = scaledPosY-11 , y = 0; i<scaledPosY+11;i++ , y++){
				for(int j = scaledPosX-17, x = 0; j<scaledPosX+17;j++ , x++ ){
					sector[y][x] = map[i][j];
					movePlayer=false;
				}
			}
		}
		else if(scaledPosX <= mapMaxX-17 && scaledPosX >= 17 &&scaledPosY >= mapMaxY-10){						//unten rand
			for(int i = mapMaxY-11 , y = 0; i<=mapMaxY;i++ , y++){
				for(int j = scaledPosX-17, x = 0; j<scaledPosX+17;j++ , x++ ){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX <= mapMaxX-17 && scaledPosX >= 17 &&scaledPosY <= 10){									//oben rand
			for(int i = 0 , y = 0; i<11;i++ , y++){
				for(int j = scaledPosX-17, x = 0; j<scaledPosX+17;j++ , x++ ){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX <= 17&&scaledPosY <= mapMaxY-11 &&scaledPosY >= 11 ){								//links rand
			for(int i = scaledPosY-11 , y = 0; i<scaledPosY+11;i++ , y++){
				for(int j = 0, x = 0; j<17;j++ , x++ ){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX >= mapMaxX -16 &&scaledPosY <= mapMaxY-11 &&scaledPosY >= 11 ){					//rechts rand
			for(int i = scaledPosY-11 , y = 0; i<scaledPosY+11;i++ , y++){
				for(int j = mapMaxX-17, x = 0; j<=mapMaxX;j++ , x++ ){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX <= 17&&scaledPosY <= 10){								//links oben
			for(int i = 0 , y = 0; i<11;i++ , y++){
				for(int j = 0, x = 0; j<17;j++ , x++){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX <= 17&&scaledPosY >= mapMaxY-10 ){								//links unten
			for(int i = mapMaxY-11 , y = 0; i<=mapMaxY;i++ , y++){
				for(int j = 0, x = 0; j<17;j++ , x++ ){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX >= mapMaxX -16&&scaledPosY >= mapMaxY-10 ){								//rechts unten
			for(int i = mapMaxY-11 , y = 0; i<=mapMaxY;i++ , y++){
				for(int j = mapMaxX-17, x = 0; j<=mapMaxX;j++ , x++){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		else if(scaledPosX >= mapMaxX -16&&scaledPosY <= 10){								//rechts oben
			for(int i = 0 , y = 0; i<11;i++ , y++){
				for(int j = mapMaxX-17, x = 0; j<=mapMaxX;j++ , x++){
					sector[y][x] = map[i][j];
					movePlayer=true;
				}
			}
		}
		
		
		return new MiniMapMsg(sector,movePlayer);
		
	}
	//35*23
	
	/**
	 * allocate the position of the item the player wants to use and send the information to the server
	 * @author Heusser, Caspar
	 * @param message
	 */
	public void useItem(UseItemMsg message){
		this.gloInv.get(message.getPosInv());
		System.out.println("Nachricht an der Server mit Item das benutzt werden soll");
		message.setClientId(this.clientId);								
		
		this.ClientCommunication.getNextMessage(message);
		}
	/**
	 * set the loginstatus
	 * @author Heusser, Caspar
	 * @param signedIn
	 */
	public void setSignedIn(boolean signedIn){
		this.signedIn= signedIn;
		System.out.println("Ändere LoginStatus");
		
	}
	/**
	 * get the loginstatus
	 * @author Heusser, Caspar
	 * @return
	 */
	public boolean  getSignedIn(){
		System.out.println("Liefere LoginStatus");
		return this.signedIn;
	}
	/**
	 * get the clientid
	 * @author Heusser, Caspar
	 * @return
	 */
	public int getClientId() {
		System.out.println("Liefere ClientId");
		return clientId;
	}
	/**
	 * set the clientid
	 * @author Heusser, Caspar
	 * @param clientId
	 */
	public void setClientId(int clientId) {
		System.out.println("Ändere ClientId");
		this.clientId = clientId;
	}
}

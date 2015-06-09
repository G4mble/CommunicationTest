package pp2015.team12.client;




import java.util.ArrayList;

import java.util.List;


import pp2015.team12.shared.message.*;
/**
 * message Handling class for client engine
 * @author Heusser,Caspar
 *
 */

public class ClientCommunication {
		ClientEngine cE;
		List<Message> msgList = new ArrayList<Message>();
		boolean messageHandling = false;
		public ClientCommunication(ClientEngine cE){
			this.cE = cE;
			//getMessage();
		}
		
		/**
		 * temporaly saves every recieved message in msgList
		 * @author Heusser,Caspar
		 * @param message
		 */
		public void receiveMessage(Message message){
			msgList.add(message);
			if(this.messageHandling == false){
			
				this.handleMessage();
				this.messageHandling=false;
			}
		}
		/**
		 * processing the messages stored in the msgList
		 * @author Heusser, Caspar
		 */
		public void handleMessage(){
			
			try{
			while(this.msgList.get(0)!=null){
				Message message = this.msgList.get(0);
				this.msgList.remove(0);
				if (message instanceof MoveMsg){
					if(((MoveMsg)message).getSubmitter().equals("gui")){
						System.out.println("Bearbeite MoveMsg - Fuehre KCHeck aus");
						this.cE.consistencyCheck((MoveMsg)message);
					}else{
						System.out.println("Leite Nachricht an Gui weiter");
						
						this.cE.frame.forwardMessage(message);
						this.cE.frame.forwardMessage(this.cE.createSector());
						this.cE.frame.forwardMessage(this.cE.createSectorMini());
					}
				}
				if (message instanceof MonsterListMsg){
					System.out.println("Bearbeite MonsterListMsg");
					this.cE.updateMonsterList((MonsterListMsg)message);
				}
				if (message instanceof MapMsg){
					System.out.println("Bearbeite MapMsg");
					this.cE.changeMap((MapMsg)message);
				}
				if (message instanceof GlobInvMsg){
					this.cE.updateGlobInventory((GlobInvMsg)message);
				}
				if (message instanceof CharacterUpdateMsg){ //client id auslesen	//auch kampf
					System.out.println("Bearbeite CharacterUpdateMsg");
					this.cE.updateCharacter((CharacterUpdateMsg)message);
				}
				if (message instanceof CharacterListMsg){
					System.out.println("Aktualisiere Character Liste");
					this.cE.updateCharacterList((CharacterListMsg)message);
				}
				if (message instanceof ChatMsg){ 
					System.out.println("Bearbeite ChatMsg");
					if(((ChatMsg) message).getSubmitter().equals("client")){
						System.out.println("Nachricht von Client an Server - Starte Cheat Check");
						this.cE.checkCheat((ChatMsg)message);
					}
					else{
						System.out.println("Leite Nachricht an gui weiter");
//						System.out.println(((ChatMsg) message).getContent());
						this.cE.frame.forwardMessage(message);					}
				}
				if (message instanceof YConfirmationMsg){ 
					System.out.println("#yolo aktiviert - setze Leben hoch");
					this.cE.updateLife((YConfirmationMsg)message);
				}
				if (message instanceof SConfirmationMsg){ 
					System.out.println("#swag aktiviert - Gold hinzugefuegt");
					this.cE.updateInventory((SConfirmationMsg)message);
				}
				if (message instanceof EngageFightMsg){
					System.out.println("Kampf - bestimme Gegner");
					this.cE.engageFight((EngageFightMsg)message);				
				}
				if (message instanceof PickUpMsg){								
					System.out.println("Item aufheben - bestimme Item");
					this.cE.pickUpItem((PickUpMsg)message);
				}
				if (message instanceof PickUpConfirmationMsg){								
					System.out.println("Item aufgehoben");
					this.cE.updateInventory((PickUpConfirmationMsg)message);
					this.cE.updateGlobInventory((PickUpConfirmationMsg)message);
				}
				if (message instanceof LoginRequestMsg){								
					System.out.println("Leite Login Anfrage an Server weiter");			
					message.setClientId(this.cE.getClientId());
					this.cE.ClientCommunication.getNextMessage(message);
					
				}
				if (message instanceof LoginReplyMsg){	
					if(((LoginReplyMsg)message).isSuccess()){
						System.out.println("Anmeldung erfolgreich");
						this.cE.setClientId(((LoginReplyMsg)message).getClientId());
						this.cE.setSignedIn(true);
						this.cE.frame.forwardMessage(message);
					}
					else{
						System.out.println("Anmeldung fehlgeschlagen");
						this.cE.setSignedIn(false);
						this.cE.frame.forwardMessage(message);
					}
				}
				if (message instanceof LogoutRequestMsg){								
					System.out.println("Leite Logout Anfrage an Server weiter");
					message.setClientId(this.cE.getClientId());
					this.cE.ClientCommunication.getNextMessage(message);
					
				}
				if (message instanceof LogoutReplyMsg){								
					if(((LogoutReplyMsg)message).isSuccess()){
						System.out.println("Logout erfolgreich");
						
						this.cE.setSignedIn(false);
						this.cE.frame.forwardMessage(message);
					}else{
						System.out.println("Logout fehlgeschlagen");
						this.cE.frame.forwardMessage(message);
					
					}
					
				}
				
				if (message instanceof CloseMsg){								
					if(this.cE.getSignedIn()){
						System.out.println("Beende Programm");
						System.exit(5);
					}
					else{
						
						System.out.println("Bitte erst abmelden");
						this.cE.frame.forwardMessage(new ErrorMsg("Bitte erst abmelden"));
					}
					
				}
				if (message instanceof UseItemMsg){
					this.cE.useItem((UseItemMsg)message);
				}
				if(message instanceof RequestLevelChangeMsg){
					System.out.println("Message an server");
					message.setClientId(this.cE.getClientId());
					this.cE.ClientCommunication.getNextMessage(message);
					
				}
				if(message instanceof SalvageRequestMsg){
					System.out.println("Message an server");
					message.setClientId(this.cE.getClientId());
					this.cE.ClientCommunication.getNextMessage(message);
					 //server braucht id + player
				}
				if(message instanceof LocInvMsg){
					this.cE.updateInventory((LocInvMsg)message);
				}
				if(message instanceof RequestLevelChangeMsg){
					this.cE.useDoor((RequestLevelChangeMsg)message);
				}
				if(message instanceof RegistrationReqMsg){
					this.cE.ClientCommunication.getNextMessage(message);
				}
				if(message instanceof CreateCharacterReqMsg){
					this.cE.ClientCommunication.getNextMessage(message);
				}
				if(message instanceof ChooseCharacterMsg){
					System.out.println("Weiterleiten an server");		//nicht mehr benoetigt
				}
				if(message instanceof ShowAvailableCharacterMsg ){
					System.out.println("Weiterleiten an gui");			//nicht mehr benoetigt
				}
				if(message instanceof RequestStatisticMsg){
					message.setClientId(this.cE.getClientId());
					this.cE.ClientCommunication.getNextMessage(message);
				}
				if(message instanceof ChangedInvPosMsg){
					message.setClientId(this.cE.getClientId());
					this.cE.ClientCommunication.getNextMessage(message);
				}
				if(message instanceof UnEquipMsg){
					message.setClientId(this.cE.getClientId());
					this.cE.ClientCommunication.getNextMessage(message);
				}
				if(message instanceof EquipMsg){
					message.setClientId(this.cE.getClientId());
					this.cE.ClientCommunication.getNextMessage(message);
				}
				//crafting //buy  //sell //drop //abruesten //ruesten //Item verschieben
				
				//karten ausschnitt
				//bosslevel komplette karte uebergeben
			
				
			}
			}
			catch (Exception e){
				System.out.println("Alle Nachrichten abgearbeitet");
			}
		}
}

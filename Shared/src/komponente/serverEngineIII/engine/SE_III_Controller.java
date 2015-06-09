package komponente.serverEngineIII.engine;

import java.util.ArrayList;

import komponente.serverEngineIII.platform.ProgramController;
import komponente.serverEngineIII.utility.ClearDbMsg;
import pp2015.team12.shared.item.ItemModel;
import pp2015.team12.shared.message.CharacterUpdateMsg;
import pp2015.team12.shared.message.SalvageRequestMsg;
import pp2015.team12.shared.message.CreateItemReqMsg;
import pp2015.team12.shared.message.GlobInvMsg;
import pp2015.team12.shared.message.HighscoreReplyMessage;
import pp2015.team12.shared.message.HighscoreRequestMsg;
import pp2015.team12.shared.message.LinkCharacterToUserReplyMsg;
import pp2015.team12.shared.message.LinkCharacterToUserRequestMsg;
import pp2015.team12.shared.message.LoginReplyMsg;
import pp2015.team12.shared.message.LoginRequestMsg;
import pp2015.team12.shared.message.Message;
import pp2015.team12.shared.message.RegistrationReplyMsg;
import pp2015.team12.shared.message.RegistrationReqMsg;
import pp2015.team12.shared.message.SavePlayerMsg;

/**
 * comunnication interface for ServerEngine_III</br> 
 * supervises all classes belonging to ServerEngine_III</br>
 * @author Staufenberg, Thomas, 5820359
 * */
public class SE_III_Controller
{
	private ArrayList<Message> incomingMessageList;
	private boolean messageIsProcessing;
	private DataBaseController dbController;
	private ProgramController programController;
	
	/**
	 * calls DataBaseController for the first time</br>
	 * initializes remaining global variables
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public SE_III_Controller(ProgramController paramProgramController)
	{
		this.programController = paramProgramController;
		this.messageIsProcessing = false;
		this.incomingMessageList = new ArrayList<>();
		this.dbController = DataBaseController.getInstance();
	}
	
	/**
	 * processes outgoing Messages and calls the receiveMessage method of the respective target address
	 * @param paramMessage the Message to be send
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private void sendMessage(Message paramMessage)
	{
		System.out.println("ServerEngine_III_Controller: Sende " + paramMessage.getClass().getName().substring(29));
		this.programController.receiveMessage(paramMessage);
		//TODO sendMessage to ServerEngine_I
	}
	
	/**
	 * called by ServerEngine_I for communication purpose</br>
	 * adds the given Message to a list and starts the handling process if it is not already running
	 * @param paramMessage the Message to receive
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void receiveMessage(Message paramMessage)
	{
		System.out.println("SE_III_Controller: Empfange " + paramMessage.getClass().getName().substring(29));
		this.incomingMessageList.add(paramMessage);
		if(!this.messageIsProcessing)
			this.handleMessage();
	}
	
	/**
	 * called by this.receiveMessage(), iterates over incomingMessageList while not empty</br>
	 * handles all incoming Messages
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private void handleMessage()
	{
		System.out.println("SE_III_Controller: Starte Message handling.");
		if(!this.messageIsProcessing)
			this.messageIsProcessing = true;
		while(true)
		{
			Message currentMessage;
			try
			{
				currentMessage = this.incomingMessageList.remove(0);
				System.out.println("SE_III_Controller: Behandle " + currentMessage.getClass().getName().substring(29));
			}
			catch(IndexOutOfBoundsException indexExc)
			{
				System.out.println("SE_III_Controller: Keine weiteren Messages vorhanden.");
				break;
			}
			
			if(currentMessage instanceof LoginRequestMsg)
			{
				LoginRequestMsg currentLoginMessage = (LoginRequestMsg) currentMessage;
				String currentUsername = currentLoginMessage.getUsername(); 
				String currentPassword = currentLoginMessage.getPassword();
				if(this.dbController.verifyLogin(currentUsername, currentPassword))
				{
					this.sendMessage(new LoginReplyMsg(-1, true, currentLoginMessage.getClientId()));
					this.sendMessage(new CharacterUpdateMsg(-1, this.dbController.loadPlayerData(currentUsername, currentLoginMessage.getClientId())));
				}
				else
					this.sendMessage(new LoginReplyMsg(-1, false, currentLoginMessage.getClientId(), "Benutzername oder Passwort falsch!"));
			}
			else if(currentMessage instanceof RegistrationReqMsg)
			{
				RegistrationReqMsg currentRegistrationMessage = (RegistrationReqMsg) currentMessage;
				if(this.dbController.createNewUser(currentRegistrationMessage.getUsername(), currentRegistrationMessage.getPassword()))
					this.sendMessage(new RegistrationReplyMsg(-1, true));
				else
					this.sendMessage(new RegistrationReplyMsg(-1, false, "Benutzername bereits vergeben!"));
			}
			else if(currentMessage instanceof LinkCharacterToUserRequestMsg)
			{
				LinkCharacterToUserRequestMsg currentLinkMessage = (LinkCharacterToUserRequestMsg) currentMessage;
				if(this.dbController.linkCharacterToUser(currentLinkMessage.getCurrentPlayer()))
				{
					this.sendMessage(new LinkCharacterToUserReplyMsg(-1, true));
					this.sendMessage(new CharacterUpdateMsg(-1, currentLinkMessage.getCurrentPlayer()));
				}
				else
					this.sendMessage(new LinkCharacterToUserReplyMsg(-1, false, "Fehler beim Zuordnen des Charakters zum Benutzer in der Datenbank!"));
			}
			else if(currentMessage instanceof CreateItemReqMsg)
			{
				CreateItemReqMsg currentItemMessage = (CreateItemReqMsg) currentMessage;
				ItemManager itemManager = new ItemManager(currentItemMessage.getCurrentPlayer());
				ArrayList<ItemModel> itemList = itemManager.generateRandomItem();
				itemManager = null;
				this.sendMessage(new GlobInvMsg(-1, itemList));
			}
			else if(currentMessage instanceof SalvageRequestMsg)
			{
				SalvageRequestMsg currentCraftMessage = (SalvageRequestMsg) currentMessage;
				ItemManager itemManager = new ItemManager(currentCraftMessage.getCurrentPlayer());
				switch(itemManager.craftEquipment(currentCraftMessage.getItemIndex()))
				{
					case -1: 
						System.out.println("Sie haben nicht genuegend Ressourcen um diesen Gegenstand herzustellen!");
						break;
					case -2:
						System.out.println("Sie koennen diesen Gegenstand nicht herstellen. Ihr Inventar ist voll!");
						break;
				}
			}
			else if(currentMessage instanceof SavePlayerMsg)
				this.dbController.savePlayerData(((SavePlayerMsg) currentMessage).getPlayerCharacter());
			else if(currentMessage instanceof HighscoreRequestMsg)
				this.sendMessage(new HighscoreReplyMessage(-1, this.dbController.loadHighscore(((HighscoreRequestMsg) currentMessage).getSortingKey())));
			else if(currentMessage instanceof ClearDbMsg)
				this.dbController.clearDB();
		}
		System.out.println("SE_III_Controller: Stoppe Message handling.");
		System.out.println("-----------------------------------------------------------");
		this.messageIsProcessing = false;
	}
}
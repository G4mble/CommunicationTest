package komponente.serverEngineIII.platform;

import java.util.ArrayList;

import pp2015.team12.shared.character.Mage;
import pp2015.team12.shared.character.PlayerCharacter;
import pp2015.team12.shared.character.Warrior;
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
import pp2015.team12.shared.item.ConsumableModel;
import pp2015.team12.shared.item.EquipmentModel;
import pp2015.team12.shared.item.ItemModel;
import komponente.serverEngineIII.engine.SE_III_Controller;
import komponente.serverEngineIII.utility.ClearDbMsg;
import komponente.serverEngineIII.utility.ServerEngine_III_Utility;

/**
 * used to simulate user inputs/requests</br>
 * also fires messages that would normally be send by other component controllers 
 * @author Staufenberg, Thomas, 5820359
 * */
public class ProgramController
{
	private SE_III_Controller serverEngine3Controller; 
	private ArrayList<Message> incomingMessageList;
	private ArrayList<ItemModel> globalInventoryList;
	private boolean messageIsProcessing;
	private int activeCharID;
	private String activeUsername;
	private Object[][] highscoreData;
	private PlayerCharacter activeCharacter;
	private boolean isLoggedIn;
	
	/**
	 * initializes global variables</br>creates SE_III communication interface
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public ProgramController()
	{
		this.isLoggedIn = false;
		this.serverEngine3Controller = new SE_III_Controller(this);
		this.globalInventoryList = new ArrayList<>();
		this.messageIsProcessing = false;
		this.highscoreData = null;
		this.incomingMessageList = new ArrayList<>();
	}
	
	/**
	 * processes outgoing Messages and calls the receiveMessage method of the respective target adress
	 * @param paramMessage the Message to be send
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private void sendMessage(Message paramMessage)
	{
		System.out.println("ProgramController: Sende " + paramMessage.getClass().getName().substring(29));
		this.serverEngine3Controller.receiveMessage(paramMessage);
	}
	
	/**
	 * simulates login process</br>
	 * forwards given data to dataBase for verification via Message
	 * @param paramUsername username entered in the login panel
	 * @param paramPassword password entered in the login panel
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void initiateLoginProcess(String paramUsername, String paramPassword)
	{
		this.activeUsername = paramUsername;
		this.sendMessage(new LoginRequestMsg(-1, paramUsername, paramPassword));
	}
	
	/**
	 * simulates registration and character selection process</br>
	 * forwards given data to dataBase for verification via Message
	 * @param paramCharID ID of the selected character
	 * @param paramUsername username entered in the register panel
	 * @param paramPassword password entered in the register panel
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void initiateRegistrationProcess(String paramUsername, String paramPassword, int paramCharID)
	{
		if((paramPassword.length() < 4) || (paramUsername.length() < 4) || (paramUsername.length() > 30) || (paramPassword.length() > 30))
			System.out.println("Benutzername und Passwort muessen jeweils zwischen 4 und 30 Zeichen lang sein!");
		else
		{
			this.activeCharID = paramCharID;
			this.activeUsername = paramUsername;
			this.sendMessage(new RegistrationReqMsg(-1, paramUsername, paramPassword));
		}
	}
	
	/**
	 * is called if the registration process was successful</br>
	 * creates a new character depending on the users selection</br>invokes link operation of user and character
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private void createNewCharacter()
	{
		if(this.activeCharID == 1)
			this.activeCharacter = new Warrior(1);				//set default clientID = 1
		else
			this.activeCharacter = new Mage(1);					//set default clientID = 1
		this.activeCharacter.setUsername(this.activeUsername);
		this.sendMessage(new LinkCharacterToUserRequestMsg(-1, this.activeCharacter));
		System.out.println("Neuer Charakter erstellt.");
		ServerEngine_III_Utility.printPlayerInformation("ProgramController", this.activeCharacter);
	}
	
	/**
	 * initializes playerAttributes in his inventory</br>
	 * is called after login has been verified or user has been successfully created
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private void finalizeAuthenticationProcess()
	{
		this.activeCharacter.getInventory().initializePlayerAttributes();
	}
	
	/**
	 * invokes highscore data update</br>notifies database to read highscore data
	 * @param paramFilterAttribute the attribute by which the highscore data is to be sorted (desc)
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public Object[][] updateHighscore(String paramFilterAttribute)
	{
		this.sendMessage(new HighscoreRequestMsg(-1, paramFilterAttribute));
		return this.highscoreData;
	}
	
	/**
	 * simulates logout process</br>invokes save operation
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void logoutUser()
	{
		this.sendMessage(new SavePlayerMsg(-1, this.activeCharacter));
		System.out.println("Sie wurden erfolgreich ausgeloggt.");
	}
	
	/**
	 * modifies the indicated player value by the given amount
	 * @param paramIndicator name of the value that has to be modified
	 * @param paramValue amount by which the specified value will be modified
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void modifyPlayerValues(String paramIndicator, int paramValue)
	{
		System.out.println("ProgramController: Modifiziere " + paramIndicator + ", Modifikator: " + paramValue);
		boolean savePlayerData = true;
		switch(paramIndicator)
		{
			case "killCount":
				this.activeCharacter.getStatistics().updateMonsterKillCount(paramValue);
				break;
			case "deathCount":
				this.activeCharacter.getStatistics().updateDeathCount(paramValue);
				break;
			case "timePlayed":
				this.activeCharacter.getStatistics().updateTimePlayed(paramValue);
				break;
			case "level":
				this.activeCharacter.setLevel((this.activeCharacter.getLevel() + paramValue));
				break;
			case "currentLife":
				this.activeCharacter.setCurrentLife((this.activeCharacter.getCurrentLife() - paramValue));
				savePlayerData = false;
				break;
			case "armorParts":
				this.activeCharacter.getInventory().modifyArmorPartsCount(paramValue);
				break;
			case "gold":
				this.activeCharacter.getInventory().modifyGoldCount(paramValue);
				break;
		}
		if(savePlayerData)
			this.sendMessage(new SavePlayerMsg(-1, this.activeCharacter));
		ServerEngine_III_Utility.printPlayerInformation("ProgramController", this.activeCharacter);
	}
	
	/**
	 * simualtes random word drop</br>invokes item creation
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void createNewItem()
	{
		this.sendMessage(new CreateItemReqMsg(-1, this.activeCharacter));
	}
	
	/**
	 * adds the items in the given list to the globalInventoryList
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void updateGlobalInventory(ArrayList<ItemModel> paramItemList)
	{
		for(int i = 0; i < paramItemList.size(); i++)
			this.globalInventoryList.add(paramItemList.get(i));
		ServerEngine_III_Utility.printGlobalInventory(this.globalInventoryList);
	}
	
	/**
	 * utility method used to print player data and the global inventory</br>
	 * also invokes save operation
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private void saveAndPrintPlayerData()
	{
		ServerEngine_III_Utility.printPlayerInformation("ProgramController", this.activeCharacter);
		ServerEngine_III_Utility.printGlobalInventory(this.globalInventoryList);
		this.sendMessage(new SavePlayerMsg(-1, this.activeCharacter));
	}
	
	/**
	 * performs item pickup operation</br>prints status information
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void pickupItem()
	{
		try
		{
			ItemModel currentItem = this.globalInventoryList.get(0); 
			if(currentItem.pickup(this.activeCharacter))
			{
				this.globalInventoryList.remove(0);
				System.out.println(currentItem.getItemName() + " wurde erfolgreich aufgenommen.");
				ServerEngine_III_Utility.printPlayerInformation("ProgramController", this.activeCharacter);
				ServerEngine_III_Utility.printGlobalInventory(this.globalInventoryList);
				this.saveAndPrintPlayerData();
			}
			else
				System.out.println("Sie koennen das gewuenschte Item nicht aufnehmen. Ihr Inventar ist voll!");
		}
		catch(IndexOutOfBoundsException iOoBE)
		{
			System.out.println("Kein Item zum aufnehmen vorhanden!");
		}
	}
	
	/**
	 * performs item equip operation</br>prints status information
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void equipItem(int paramItemIndex)
	{
		try
		{
			ItemModel currentItem = this.activeCharacter.getInventory().getInventoryContentList()[paramItemIndex];
			if(currentItem instanceof EquipmentModel)
			{
				if(((EquipmentModel) currentItem).equip(this.activeCharacter, paramItemIndex))
					System.out.println(currentItem.getItemName() + " wurde erfolgreich ausgeruestet.");
				this.saveAndPrintPlayerData();
			}
			else
				System.out.println("Sie koennen " + currentItem.getItemName() + " nicht ausruesten!");
		}
		catch(IndexOutOfBoundsException iOoBE)
		{
			System.out.println("An dieser Stelle befindet sich kein Item!");
		}
	}
	
	/**
	 * performs item consume operation</br>prints status information
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void consumeItem(int paramItemIndex)
	{
		try
		{
			ItemModel currentItem = this.activeCharacter.getInventory().getInventoryContentList()[paramItemIndex];
			if(currentItem instanceof ConsumableModel)
			{
				System.out.println("Konsumiere " + currentItem.getItemName() + "...");
				((ConsumableModel) currentItem).consume(this.activeCharacter);
				this.saveAndPrintPlayerData();
			}
			else
				System.out.println("Sie koennen " + currentItem.getItemName() + " nicht konsumieren!");
		}
		catch(IndexOutOfBoundsException iOoBE)
		{
			System.out.println("An dieser Stelle befindet sich kein Item!");
		}
	}
	
	/**
	 * performs item sell operation</br>prints status information
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void sellItem()
	{
		ItemModel[] currentInventory = this.activeCharacter.getInventory().getInventoryContentList();
		ItemModel currentItem = null;
		for(int i = 0; i < currentInventory.length; i++)
		{
			if(currentInventory[i] != null)
				currentItem = currentInventory[i];
		}
		if((currentItem != null) && (currentItem.sell(this.activeCharacter)))
		{
			System.out.println(currentItem.getItemName() + " verkauft, fuer " + currentItem.getItemGoldValue() + " Gold.");
			this.saveAndPrintPlayerData();
		}
		else
			System.out.println("Sie koennen dieses Item nicht verkaufen!");
	}
	
	/**
	 * performs item drop operation</br>prints status information
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void dropItem()
	{
		ItemModel[] currentInventory = this.activeCharacter.getInventory().getInventoryContentList();
		ItemModel currentItem = null;
		for(int i = 0; i < currentInventory.length; i++)
		{
			if(currentInventory[i] != null)
				currentItem = currentInventory[i];
		}
		if((currentItem != null) && (currentItem.drop(this.activeCharacter, this.globalInventoryList)))
		{
			System.out.println(currentItem.getItemName() + " abgelegt.");
			this.saveAndPrintPlayerData();
		}
		else
			System.out.println(currentItem.getItemName() + " konnte nicht abgelegt werden.");
	}
	
	/**
	 * performs item salvage operation</br>prints status information
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void salvageItem(int paramItemIndex)
	{
		try
		{
			ItemModel currentItem = this.activeCharacter.getInventory().getInventoryContentList()[paramItemIndex];
			if(currentItem instanceof EquipmentModel)
			{
				EquipmentModel currentEquip = (EquipmentModel) currentItem;
				currentEquip.salvage(this.activeCharacter);
				System.out.println(currentEquip.getItemName() + " zerlegt, " + currentEquip.getArmorPartsRevenue() + " Ruestungsteil(e) erhalten.");
				this.saveAndPrintPlayerData();
			}
			else
				System.out.println(currentItem.getItemName() + " kann nicht zerlegt werden.");
		}
		catch(IndexOutOfBoundsException iOoBE)
		{
			System.out.println("Kein Item zum zerlegen vorhanden!");
		}
	}
	
	/**
	 * simulates crafting request</br>forwards crafting request to SE_III communication interface</br>
	 * prints status information
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void craftItem(int paramItemIndex)
	{
		this.sendMessage(new SalvageRequestMsg(-1, paramItemIndex, this.activeCharacter));
		this.saveAndPrintPlayerData();
	}
	
	public void initiateDBCleanUp()
	{
		this.sendMessage(new ClearDbMsg(-1));
	}
	
	/**
	 * adds the given Message to a list and starts the handle process if not already running
	 * @param paramMessage the Message to receive
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void receiveMessage(Message paramMessage)
	{
		System.out.println("ProgramController: Empfange " + paramMessage.getClass().getName().substring(29));
		this.incomingMessageList.add(paramMessage);
		if(!this.messageIsProcessing)
			this.handleMessage();
	}
	
	/**
	 * called by this.receiveMessage, iterates over incomingMessageList while not empty
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private void handleMessage()
	{
		System.out.println("ProgramController: Starte Message handling.");
		if(!this.messageIsProcessing)
			this.messageIsProcessing = true;
		while(true)
		{
			Message currentMessage;			
			try
			{
				currentMessage = this.incomingMessageList.remove(0);
				System.out.println("ProgramController: Behandle " + currentMessage.getClass().getName().substring(29));
			}
			catch(IndexOutOfBoundsException indexExc)
			{
				System.out.println("ProgramController: Keine weiteren Messages vorhanden.");
				break;
			}
			if(currentMessage instanceof LoginReplyMsg)
			{
				LoginReplyMsg currentLoginMsg = (LoginReplyMsg) currentMessage;
				if(currentLoginMsg.isSuccess())
				{
					this.isLoggedIn = true;
					System.out.println("Sie wurden erfolgreich eingeloggt.");
				}
				else
					System.out.println(currentLoginMsg.getErrorMessage());
			}
			else if(currentMessage instanceof CharacterUpdateMsg)
			{
				this.activeCharacter = ((CharacterUpdateMsg) currentMessage).getPlayer();
				this.finalizeAuthenticationProcess();
			}
			else if(currentMessage instanceof RegistrationReplyMsg)
			{
				RegistrationReplyMsg currentRegistrationMessage = (RegistrationReplyMsg) currentMessage;
				if(currentRegistrationMessage.getSuccess())
				{
					System.out.println("Registrierung erfolgreich!");
					this.createNewCharacter();
				}
				else
					System.err.println(currentRegistrationMessage.getErrorMessage());
			}
			else if(currentMessage instanceof LinkCharacterToUserReplyMsg)
			{
				LinkCharacterToUserReplyMsg currentLinkMessage = (LinkCharacterToUserReplyMsg) currentMessage;
				if(!currentLinkMessage.getSuccess())
					System.out.println(currentLinkMessage.getErrorMessage());
				else
					this.isLoggedIn = true;
			}
			else if(currentMessage instanceof SavePlayerMsg)
				this.sendMessage(currentMessage);
			else if(currentMessage instanceof HighscoreReplyMessage)
				this.highscoreData = ((HighscoreReplyMessage) currentMessage).getHighscoreData();
			else if(currentMessage instanceof GlobInvMsg)
				this.updateGlobalInventory(((GlobInvMsg) currentMessage).getGlobInv());
		}
		System.out.println("ProgramController: Stoppe Message handling.");
		System.out.println("-----------------------------------------------------------");
		this.messageIsProcessing = false;
	}
	
	/**
	 * @return whether there is a user currently logged in or not
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean isLoggedIn()
	{
		return this.isLoggedIn;
	}
}
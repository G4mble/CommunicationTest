package pp2015.team12.server.engine.server3;

import java.util.ArrayList;

import pp2015.team12.server.engine.MessageHandler;
import pp2015.team12.shared.message.CharacterUpdateMsg;
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
	private DataBaseManager dbManager;
	private MessageHandler se1_messageHandler;
	
	/**
	 * calls DataBaseController for the first time</br>
	 * initializes remaining global variables
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public SE_III_Controller(MessageHandler se1_messageHandler)
	{
		this.se1_messageHandler = se1_messageHandler;
		this.messageIsProcessing = false;
		this.incomingMessageList = new ArrayList<>();
		this.dbManager = DataBaseManager.getInstance(this);
	}
	
	/**
	 * processes outgoing Messages and calls the receiveMessage method of the respective target address
	 * @param paramMessage the Message to be send
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private void sendMessage(Message paramMessage)
	{
		this.se1_messageHandler.addNewMsg(paramMessage);
	}
	
	/**
	 * called by ServerEngine_I for communication purpose</br>
	 * adds the given Message to a list and starts the handling process if it is not already running
	 * @param paramMessage the Message to receive
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void receiveMessage(Message paramMessage)
	{
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
		if(!this.messageIsProcessing)
			this.messageIsProcessing = true;
		while(true)
		{
			Message currentMessage;
			try
			{
				currentMessage = this.incomingMessageList.remove(0);
			}
			catch(IndexOutOfBoundsException indexExc)
			{
				//stop message handling if there is no message left
				break;
			}
			
			if(currentMessage instanceof LoginRequestMsg)
			{
				LoginRequestMsg currentLoginMessage = (LoginRequestMsg) currentMessage;
				String currentUsername = currentLoginMessage.getUsername(); 
				String currentPassword = currentLoginMessage.getPassword();
				if(this.dbManager.verifyLogin(currentUsername, currentPassword))
				{
					this.sendMessage(new LoginReplyMsg(-1, true, currentLoginMessage.getClientId()));
					this.sendMessage(new CharacterUpdateMsg(-1, this.dbManager.loadPlayerData(currentUsername, currentLoginMessage.getClientId())));
				}
				else
					this.sendMessage(new LoginReplyMsg(-1, false, currentLoginMessage.getClientId(), "Benutzername oder Passwort falsch!"));
			}
			else if(currentMessage instanceof RegistrationReqMsg)
			{
				RegistrationReqMsg currentRegistrationMessage = (RegistrationReqMsg) currentMessage;
				if(this.dbManager.createNewUser(currentRegistrationMessage.getUsername(), currentRegistrationMessage.getPassword()))
					this.sendMessage(new RegistrationReplyMsg(-1, true));
				else
					this.sendMessage(new RegistrationReplyMsg(-1, false, "Benutzername bereits vergeben!"));
			}
			else if(currentMessage instanceof LinkCharacterToUserRequestMsg)
			{
				LinkCharacterToUserRequestMsg currentLinkMessage = (LinkCharacterToUserRequestMsg) currentMessage;
				if(this.dbManager.linkCharacterToUser(currentLinkMessage.getCurrentPlayer()))
					this.sendMessage(new LinkCharacterToUserReplyMsg(-1, true));
				else
					this.sendMessage(new LinkCharacterToUserReplyMsg(-1, false, "Fehler beim Zuordnen des Charakters zum Benutzer in der Datenbank!"));
			}
			else if(currentMessage instanceof SavePlayerMsg)
				this.dbManager.savePlayerData(((SavePlayerMsg) currentMessage).getPlayerCharacter());
			else if(currentMessage instanceof HighscoreRequestMsg)
				this.sendMessage(new HighscoreReplyMessage(-1, this.dbManager.loadHighscore(((HighscoreRequestMsg) currentMessage).getSortingKey())));
		}
		this.messageIsProcessing = false;
	}
	
	/**
	 * @return the messageHandler of ServerEngine_I
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public MessageHandler getSE_I_messageHandler()
	{
		return this.se1_messageHandler;
	}
}
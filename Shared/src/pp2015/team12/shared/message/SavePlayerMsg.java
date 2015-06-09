package pp2015.team12.shared.message;

import pp2015.team12.shared.character.PlayerCharacter;

/**
 * Message used to transfer player data destined for database save operation
 * @author Staufenberg, Thomas, 5820359
 * */
@SuppressWarnings("serial")
public class SavePlayerMsg extends Message
{
	private PlayerCharacter currentPlayer;
	
	/**
	 * forwards paramClientID to superclass</br>stores paramPlayer in a global variable
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public SavePlayerMsg(int clientID, PlayerCharacter paramPlayer)
	{
		super(clientID);
		this.currentPlayer = paramPlayer;
	}

	/**
	 * @return the current player that is to be saved
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public PlayerCharacter getPlayerCharacter()
	{
		return this.currentPlayer;
	}
}
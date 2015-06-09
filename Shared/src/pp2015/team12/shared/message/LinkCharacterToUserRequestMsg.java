package pp2015.team12.shared.message;

import pp2015.team12.shared.character.PlayerCharacter;

/**
 * Message used to transfer playerData to the database after the user has selected a character
 * @author Staufenberg, Thomas, 5820359
 * */
@SuppressWarnings("serial")
public class LinkCharacterToUserRequestMsg extends Message
{
	private PlayerCharacter currentPlayer;
	
	/**
	 * forwards paramClientID to superclass</br>stores paramCurrentPlayer in global variable
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public LinkCharacterToUserRequestMsg(int paramClientID, PlayerCharacter paramCurrentPlayer)
	{
		super(paramClientID);
		this.currentPlayer = paramCurrentPlayer;
	}

	/**
	 * @return the current playerCharacter
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public PlayerCharacter getCurrentPlayer()
	{
		return this.currentPlayer;
	}
}
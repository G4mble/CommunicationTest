package pp2015.team12.shared.message;

import pp2015.team12.shared.character.PlayerCharacter;

/**
 * Message used to request an Item from the ItemManager
 * @author Staufenberg, Thomas, 5820359
 * */
@SuppressWarnings("serial")
public class CreateItemReqMsg extends Message
{
	private PlayerCharacter currentPlayer;
	
	/**
	 * fowards paramSubmitterID to superclass, stores paramPlayer in global variable
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public CreateItemReqMsg(int paramclientID, PlayerCharacter paramPlayer)
	{
		super(paramclientID);
		this.currentPlayer = paramPlayer;
	}
	
	/**
	 * @return the current player
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public PlayerCharacter getCurrentPlayer()
	{
		return this.currentPlayer;
	}
}
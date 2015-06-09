package pp2015.team12.shared.message;

import pp2015.team12.shared.character.PlayerCharacter;

/**
 * 
 * @author Heusser, Caspar
 *
 */
@SuppressWarnings("serial")
public class SalvageRequestMsg extends Message{
	private int itemIndex;
	
	private PlayerCharacter player;
	public PlayerCharacter getPlayer() {
		return player;
	}
	public void setPlayer(PlayerCharacter player) {
		this.player = player;
	}
	

	private PlayerCharacter currentPlayer;
	/**
	 * @author Heusser, Caspar
	 * @param clientId
	 * @param itemIndex
	 */
	public SalvageRequestMsg(int clientId,int itemIndex, PlayerCharacter paramPlayer){
		super(clientId);
		this.itemIndex= itemIndex;
		this.currentPlayer = paramPlayer;
	}
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public int getItemIndex() {
		return itemIndex;
	}
	
	public PlayerCharacter getCurrentPlayer()
	{
		return this.currentPlayer;
	}
}
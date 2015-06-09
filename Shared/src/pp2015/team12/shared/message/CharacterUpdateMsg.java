package pp2015.team12.shared.message;

import pp2015.team12.shared.character.PlayerCharacter;
/**
 * 
 * @author Heusser, Caspar
 *
 */
@SuppressWarnings("serial")
public class CharacterUpdateMsg extends Message{
	
	
	private PlayerCharacter player;
	/**
	 * @author Heusser, Caspar
	 * @param clientId
	 * @param player
	 */
	public CharacterUpdateMsg (int clientId, PlayerCharacter player){
		super(clientId);
		this.player = player;
		
	}
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public PlayerCharacter getPlayer() {
		return player;
	}
	

}

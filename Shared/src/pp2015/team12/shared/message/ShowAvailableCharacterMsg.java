package pp2015.team12.shared.message;
import java.util.ArrayList;

import pp2015.team12.shared.character.PlayerCharacter;
/**
 * @author Heusser, Caspar
 * 
 *
 */
@SuppressWarnings("serial")
public class ShowAvailableCharacterMsg extends Message {
	
	ArrayList<PlayerCharacter> availableCharacter;
	/**
	 * @author Heusser, Caspar
	 * @param clientID
	 * @param availableCharacter
	 */
	public ShowAvailableCharacterMsg(int clientID, ArrayList<PlayerCharacter> availableCharacter){
		super(clientID);
		this.availableCharacter= availableCharacter;
	}

}

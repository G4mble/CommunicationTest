package pp2015.team12.shared.message;
/**
 * 
 * @author Heusser, Caspar
 *
 */
@SuppressWarnings("serial")
public class ChooseCharacterMsg extends Message{
	private int characterNumber;
	/**
	 * @author Heusser, Caspar
	 * @param clientID
	 * @param characterNumber
	 */
	public ChooseCharacterMsg(int clientID, int characterNumber){
		super(clientID);
		this.characterNumber= characterNumber;
		
	}
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public int getCharacterNumber() {
		return characterNumber;
	}

}

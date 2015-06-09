package pp2015.team12.shared.message;
/**
 * @author Heusser, Caspar
 * 
 *
 */
@SuppressWarnings("serial")
public class CreateCharacterReqMsg extends Message{
	private String characterType;
	private String characterName;
	/**
	 * @author Heusser, Caspar
	 * @param clientID
	 * @param characterType
	 * @param characterName
	 */
	public CreateCharacterReqMsg(int clientID,String characterType,String characterName){
		super(clientID);
		this.characterType= characterType;
		this.characterName= characterName;
	}
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public String getCharacterType() {
		return characterType;
	}
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public String getCharacterName() {
		return characterName;
	}
	

}

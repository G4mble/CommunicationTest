package pp2015.team12.shared.message;
/**
 * 
 * @author Heusser, Caspar
 *
 */
@SuppressWarnings("serial")
public class UnEquipMsg extends Message{
	private int characterSlot;
	public int getCharacterSlot() {
		return characterSlot;
	}
	public UnEquipMsg(int characterSlot){
		this.characterSlot=characterSlot;
	}
}

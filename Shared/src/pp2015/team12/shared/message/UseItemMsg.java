package pp2015.team12.shared.message;
/**
 * @author Heusser, Caspar
 * 
 *
 */
@SuppressWarnings("serial")
public class UseItemMsg extends Message{
	private int posInv;
	
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public int getPosInv() {
		return posInv;
	}
	

	/**
	 * @author Heusser, Caspar
	 * @param clientId
	 * @param posInv
	 */
	public UseItemMsg (int clientId, int posInv){		//TODO clientId hinzufuegen
		super(clientId);
		this.posInv= posInv;
	}
}

package pp2015.team12.shared.message;

import pp2015.team12.shared.InventoryModel;
/**
 * @author Heusser, Caspar
 * 
 *
 */
@SuppressWarnings("serial")
public class LocInvMsg extends Message{
	private InventoryModel locInv;
	/**
	 * @author Heusser, Caspar
	 * @param clientID
	 * @param locInv
	 */
	public LocInvMsg (int clientID, InventoryModel locInv){
		super(clientID);
		this.locInv=locInv;
	}
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public InventoryModel getLocInv() {
		return locInv;
	}
	
}

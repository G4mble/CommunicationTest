package pp2015.team12.shared.message;
import java.util.ArrayList;

import pp2015.team12.shared.InventoryModel;
import pp2015.team12.shared.item.ItemModel;
/**
 * @author Heusser, Caspar
 * 
 *
 */
@SuppressWarnings("serial")
public class PickUpConfirmationMsg extends Message{
	private ArrayList<ItemModel> gloInv;
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public ArrayList<ItemModel> getGloInv() {
		return gloInv;
	}
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public InventoryModel getLocInv() {
		return locInv;
	}
	private InventoryModel locInv;
	/**
	 * @author Heusser, Caspar
	 * @param clientID
	 * @param gloInv
	 * @param locInv
	 */
	public PickUpConfirmationMsg(int clientID,ArrayList<ItemModel> gloInv, InventoryModel locInv ){
		super(clientID);
		this.gloInv= gloInv;
		this.locInv= locInv;
	}

}

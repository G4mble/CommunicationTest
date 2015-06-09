package pp2015.team12.shared.message;

import pp2015.team12.shared.InventoryModel;
/**
 * 
 * @author Heusser, Caspar
 *
 */
@SuppressWarnings("serial")
public class EquipMsg extends Message{
	private InventoryModel inv;
	public EquipMsg(InventoryModel inv){
		this.inv= inv;
	}
	public InventoryModel getInv() {
		return inv;
	}
}

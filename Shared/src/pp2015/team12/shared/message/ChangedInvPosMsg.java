package pp2015.team12.shared.message;

import pp2015.team12.shared.InventoryModel;

@SuppressWarnings("serial")
public class ChangedInvPosMsg extends Message {
	InventoryModel inv;
	public ChangedInvPosMsg(int clientID, InventoryModel inv){
		super(clientID);
		this.inv= inv;
	}

}

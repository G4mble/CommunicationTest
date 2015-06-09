package pp2015.team12.shared.message;
import java.util.ArrayList;

import pp2015.team12.shared.item.ItemModel;

/**
 * @author Heusser, Caspar
 * 
 *
 */
@SuppressWarnings("serial")
public class GlobInvMsg extends Message{
	private ArrayList <ItemModel> globInv;
	/**
	 * @author Heusser, Caspar
	 * @param clientId
	 * @param globInv
	 */
	public GlobInvMsg(int clientId, ArrayList<ItemModel> globInv){
		super(clientId);
		this.globInv= globInv;
		
	}
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	
	public ArrayList<ItemModel> getGlobInv() {
		return globInv;
	}

}

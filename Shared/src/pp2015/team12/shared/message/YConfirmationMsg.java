package pp2015.team12.shared.message;
/**
 * @author Heusser, Caspar
 * 
 *
 */
@SuppressWarnings("serial")
public class YConfirmationMsg extends Message{
	private int Life;
	/**
	 * @author Heusser, Caspar
	 * @param clientID
	 * @param Life
	 */
	public YConfirmationMsg(int clientID, int Life){
	super(clientID);
	this.Life= Life;
	}
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public int getLife() {
		return Life;
	}

}

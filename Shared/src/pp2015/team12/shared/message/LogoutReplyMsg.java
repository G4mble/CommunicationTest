package pp2015.team12.shared.message;
/**
 * @author Heusser, Caspar
 *
 *
 */
@SuppressWarnings("serial")
public class LogoutReplyMsg extends Message {
	private boolean success;
	/**
	 * @author Heusser, Caspar
	 */
	public LogoutReplyMsg(int clientID,boolean success){
		super(clientID);
		this.success=success;
		
	}
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public boolean isSuccess() {
		return success;
	}
}

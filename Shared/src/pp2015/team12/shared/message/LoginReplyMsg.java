package pp2015.team12.shared.message;
/**
 * @author Heusser, Caspar
 * 
 *
 */
@SuppressWarnings("serial")
public class LoginReplyMsg extends Message{
	
	private boolean success;
	private int clientId;
	private String errorMessage;
	
	/**
	 * @author Heusser, Caspar
	 * @param SubmitterID
	 * @param success
	 * @param clientId
	 */
	public LoginReplyMsg(int clientID, boolean success, int clientId){
		this(clientID, success, clientId, "");
	}
	
	public LoginReplyMsg(int submitterID, boolean success, int clientId, String errorMessage)
	{
		super(submitterID);
		this.success = success;
		this.clientId = clientId;
		this.errorMessage = errorMessage;
	}
	
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public boolean isSuccess() {
		return success;
	}
	
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public int getClientId(){
		return this.clientId;
	}
	
	public String getErrorMessage()
	{
		return this.errorMessage;
	}
}
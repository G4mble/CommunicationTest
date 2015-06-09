package pp2015.team12.shared.message;
/**
 * @author Heusser, Caspar
 * 
 *
 */
@SuppressWarnings("serial")
public class RegistrationReqMsg extends Message{
	
	private String username;
	private String password;
	
	
	/**
	 * @author Heusser, Caspar
	 * @param clientID
	 * @param username
	 * @param password
	 */
	public RegistrationReqMsg(int clientID, String username, String password){
		super(clientID);
		this.username=username;
		this.password=password;
	}
	
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public String getPassword() {
		return this.password;
	}
}
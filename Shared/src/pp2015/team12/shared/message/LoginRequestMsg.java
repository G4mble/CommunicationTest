package pp2015.team12.shared.message;
/**
 * @author Heusser, Caspar
 * 
 *
 */
@SuppressWarnings("serial")
public class LoginRequestMsg extends Message{
	
	private String username;
	private String password;
	
	
	/**
	 * @author Heusser, Caspar
	 * @param clientID
	 * @param username
	 * @param password
	 */
	public LoginRequestMsg(int clientID, String username, String password){
		super(clientID);
		this.username= username;
		this.password= password;
	}
	
	/**
	 * @author Heusser, Caspar
	 * @return
	 */

	
	/**
	 * @author Heusser, Caspar
	 * @param clientId
	 */
	
	
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public String getPassword() {
		return password;
	}
}
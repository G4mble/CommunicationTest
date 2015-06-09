package pp2015.team12.shared.message;

import java.io.Serializable;

/**
 * 
 * @author Heusser,Caspar
 *
 */
@SuppressWarnings("serial")
public abstract class Message implements Serializable{
	
	int clientId;
	
	/**
	 * @author Heusser, Caspar
	 * @param clientId
	 */
	public Message(int clientId){
		this.clientId = clientId;
	}
	public Message(){
		
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	/**
	 * @author Heusser, Caspar
	 * @return the submitterID
	 */
	public int getClientId() {
		return clientId;
	}
}
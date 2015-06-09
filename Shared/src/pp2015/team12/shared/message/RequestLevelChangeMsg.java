package pp2015.team12.shared.message;
/**
 * @author Heusser, Caspar
 * @author Friedrich Murillo, Simon, 5802318
 *
 */
@SuppressWarnings("serial")
public class RequestLevelChangeMsg extends Message {
	int textureId;
	int currentLevelId;
	
	/**
	 * @return the currentLevelId
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public int getCurrentLevelId()
	{
		return currentLevelId;
	}
	/**
	 * @param currentLevelId the currentLevelId to set
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public void setCurrentLevelId(int currentLevelId)
	{
		this.currentLevelId = currentLevelId;
	}
	/**
	 * @return the textureId
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public int getTextureId()
	{
		return textureId;
	}
	/**
	 * @param textureId the textureId to set
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public void setTextureId(int textureId)
	{
		this.textureId = textureId;
	}
	
	
	/**
	 * @author Heusser, Caspar
	 * @param clientId
	 */
	public RequestLevelChangeMsg(int clientId){
		super(clientId);
	}
	
	public RequestLevelChangeMsg(){
		
	}
	
	
}

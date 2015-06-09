package pp2015.team12.shared.message;
//wahrscheinlich nicht notwendig
/**
 * @author Heusser, Caspar
 * @author Friedrich Murillo, Simon, 5802318
 */
@SuppressWarnings("serial")
public class MapChangeMsg extends Message{
	int textureId;
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
	 * @param nextLevel
	 * @param clientId
	 */
	public MapChangeMsg(int textureId, int clientId){
		super(clientId);
		this.textureId = textureId;
	}
	
	
	
}

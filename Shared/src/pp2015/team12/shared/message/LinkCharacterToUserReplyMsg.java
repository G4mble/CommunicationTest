package pp2015.team12.shared.message;

/**
 * Message to notify client and server whether the LinkCharacterToUser operation was successful or not
 * @author Staufenberg, Thomas, 5820359 
 * */
@SuppressWarnings("serial")
public class LinkCharacterToUserReplyMsg extends Message
{
	private boolean success;
	private String errorMessage;
	
	/**
	 * primary constructor</br>forwards paramClientID to superclass</br>
	 * stores paramSuccess and paramErrorMessagein global variables
	 * @param paramSuccess whether the operation was successful (true) or not (false)
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public LinkCharacterToUserReplyMsg(int paramClientID, boolean paramSuccess, String paramErrorMessage)
	{
		super(paramClientID);
		this.success = paramSuccess;
		this.errorMessage = paramErrorMessage;
	}
	
	/**
	 * secondary constructor, calls primary
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public LinkCharacterToUserReplyMsg(int paramSubmitterID, boolean paramSuccess)
	{
		this(paramSubmitterID, paramSuccess, "");
	}
	
	/**
	 * @return true: operation successful</br>false: error during operation
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean getSuccess()
	{
		return this.success;
	}
	
	/**
	 * @return the current errorMessage
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public String getErrorMessage()
	{
		return this.errorMessage;
	}
}
package pp2015.team12.shared.message;

/**
 * Message to indicate whether the registration process has been successful or not
 * @author Staufenberg, Thomas, 5820359
 * */
@SuppressWarnings("serial")
public class RegistrationReplyMsg extends Message
{
	private boolean success;
	private String errorMessage;
	
	
	/**
	 * secondary constructor, calls primary
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public RegistrationReplyMsg(int paramClientID, boolean paramSuccess)
	{
		this(paramClientID, paramSuccess, "");
	}
	
	/**
	 * primary constructor</br>forawrds paramClientID to superclass</br>
	 * stores paramSuccess and paramErrorMessage in global variable
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public RegistrationReplyMsg(int paramClientID, boolean paramSuccess, String paramErrorMessage)
	{
		super(paramClientID);
		this.success = paramSuccess;
		this.errorMessage = paramErrorMessage;
	}

	/**
	 * @return true: registration successful</br>false: registration failed
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
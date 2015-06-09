package komponente.serverEngineIII.utility;

import pp2015.team12.shared.message.Message;

/**
 * Message used to notify database to clear all tables
 * @author Staufenberg, Thomas, 5820359
 * */
@SuppressWarnings("serial")
public class ClearDbMsg extends Message
{
	/**
	 * forwards submitterID to superclass
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public ClearDbMsg(int submitterID)
	{
		super(submitterID);
	}
}
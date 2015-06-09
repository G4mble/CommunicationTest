package pp2015.team12.shared.message;

/**
 * Message used to transfer highscore data from the database to the GUI
 * @author Staufenberg, Thomas, 5820359
 * */
@SuppressWarnings("serial")
public class HighscoreReplyMessage extends Message
{
	private Object[][] highscoreData;
	
	/**
	 * forwards paramClientID to superclass, stores paramHighscoreData in a global variable
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public HighscoreReplyMessage(int paramClientID, Object[][] paramHighscoreData)
	{
		super(paramClientID);
		this.highscoreData = paramHighscoreData;
	}
	
	/**
	 * @return the current highscoreData
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public Object[][] getHighscoreData()
	{
		return this.highscoreData;
	}
}
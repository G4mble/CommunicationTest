package pp2015.team12.shared.message;

/**
 * Message used to request highscore data from the database
 * @author Staufenberg, Thomas, 5820359
 * */
@SuppressWarnings("serial")
public class HighscoreRequestMsg extends Message
{
	private String sortingKey;
	
	/**
	 * forwards paramClientID to superclass</br>stores paramSortingKey in global variable
	 * @param paramSortingKey String argument by which the highscore data is to be sorted (descending)
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public HighscoreRequestMsg(int paramClientID, String paramSortingKey)
	{
		super(paramClientID);
		this.sortingKey = paramSortingKey;
	}
	
	/**
	 * @return the current sortingKey
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public String getSortingKey()
	{
		return this.sortingKey;
	}
}
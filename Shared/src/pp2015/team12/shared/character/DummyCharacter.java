package pp2015.team12.shared.character;

/**
 * DummyCharacter class used to block client slots on the server
 * @author Staufenberg, Thomas, 5820359
 * */
@SuppressWarnings("serial")
public class DummyCharacter extends PlayerCharacter
{
	/**
	 * sets characterName and characterImage in superclass
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public DummyCharacter() 
	{
		super("dummy", "dummy.png");
	}
}
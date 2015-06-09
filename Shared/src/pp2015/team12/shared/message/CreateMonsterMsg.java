package pp2015.team12.shared.message;

import java.util.Vector;

/**
 * 
 * @author Friedrich Murillo, Simon, 5802318
 *
 */
@SuppressWarnings("serial")
public class CreateMonsterMsg extends Message
{
	private Vector<Integer> monsterList;
	private int levelId;

	/**
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 * @param monsterList
	 * @param levelId
	 */
	public CreateMonsterMsg(Vector<Integer> monsterList, int levelId)
	{
		this.monsterList = monsterList;
		this.levelId = levelId;
	}

	/**
	 * @author Friedrich Murillo, Simon, 5802318
	 * @return the monsterList
	 */
	public Vector<Integer> getMonsterList()
	{
		return monsterList;
	}

	/**
	 * @author Friedrich Murillo, Simon, 5802318
	 * @param monsterList
	 *            the monsterList to set
	 */
	public void setMonsterList(Vector<Integer> monsterList)
	{
		this.monsterList = monsterList;
	}

	/**
	 * @author Friedrich Murillo, Simon, 5802318
	 * @return the levelId
	 */
	public int getLevelId()
	{
		return levelId;
	}

	/**
	 * @author Friedrich Murillo, Simon, 5802318
	 * @param levelId
	 *            the levelId to set
	 */
	public void setLevelId(int levelId)
	{
		this.levelId = levelId;
	}

}

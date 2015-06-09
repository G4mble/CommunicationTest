package pp2015.team12.shared.message;

import pp2015.team12.shared.character.Monster;
import pp2015.team12.shared.character.PlayerCharacter;
/**
 * 
 * @author Friedrich Murillo, Simon, 5802318
 *
 */
@SuppressWarnings("serial")
public class FightMsg extends Message
{
	private PlayerCharacter attacker;
	private Monster defender;
	/**
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 * @param attacker
	 * @param defender
	 */
	public FightMsg (PlayerCharacter attacker, Monster defender)
	{
		this.attacker = attacker;
		this.defender = defender;
	}
	/**
	 * @author Friedrich Murillo, Simon, 5802318
	 * @return the attacker
	 */
	public PlayerCharacter getAttacker()
	{
		return attacker;
	}
	/**
	 * @author Friedrich Murillo, Simon, 5802318
	 * @param attacker the attacker to set
	 */
	public void setAttacker(PlayerCharacter attacker)
	{
		this.attacker = attacker;
	}
	/**
	 * @author Friedrich Murillo, Simon, 5802318
	 * @return the defender
	 */
	public Monster getDefender()
	{
		return defender;
	}
	/**
	 * @author Friedrich Murillo, Simon, 5802318
	 * @param defender the defender to set
	 */
	public void setDefender(Monster defender)
	{
		this.defender = defender;
	}
}
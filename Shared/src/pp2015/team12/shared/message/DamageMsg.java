package pp2015.team12.shared.message;

import pp2015.team12.shared.character.CombatantModel;

/**
 * 
 * @author Balduin,Andreas,5800366 
 *
 */
@SuppressWarnings("serial")
public class DamageMsg extends Message {
	
	private int damage;
	private CombatantModel defender;
	
	
	public DamageMsg(int damage,CombatantModel defender){
		this.damage = damage;
		this.defender = defender;
	}


	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}


	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}


	/**
	 * @return the defender
	 */
	public CombatantModel getDefender() {
		return defender;
	}


	/**
	 * @param defender the defender to set
	 */
	public void setDefender(CombatantModel defender) {
		this.defender = defender;
	}
	
}

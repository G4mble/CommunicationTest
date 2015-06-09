package pp2015.team12.shared.character;


/**
 * abstract datamodel which extends "Character" and adds special attributes for combatants; e.g. attack, defense
 * @author Heusser, Caspar
 * @author Friedrich Murillo, Simon, 5802318
 */
@SuppressWarnings("serial")
public abstract class CombatantModel extends Character {
	private int currentLife;
	private int maximumLife;
	private int attack;
	private int defense;
	private int movementSpeed;
	/**
	 * constructor of CombatantModel
	 * @author Heusser, Caspar
	 * @param maximumLife
	 * @param attack
	 * @param defense
	 * @param movementSpeed
	 * @param characterId
	 * @param characterName
	 * @param posX
	 * @param posY
	 * @param attackable
	 * @param imagePath
	 */
	public CombatantModel(int maximumLife, int attack, int defense, int movementSpeed,String characterName, int posX, int posY,String imagePath, int levelId){
		super( characterName, posX, posY,true,imagePath,levelId);
		this.currentLife = maximumLife;
		this.maximumLife = maximumLife;
		this.attack = attack;
		this.defense=defense;
		this.movementSpeed= movementSpeed;
	}

	/**
	 * @author Balduin,Andreas,5800366
	 * @param defender
	 * @return
	 */
	public int damage_Calculation(CombatantModel defender) {
		int attack = this.attack;
		int defense = defender.getDefense();
		int damage = attack - defense;
		return damage;
	}
	/**
	 * @author Heusser, Caspar
	 * @return the life
	 */
	public int getCurrentLife() {
		return this.currentLife;
	}
	/**
	 * @author Heusser, Caspar
	 * @param life the life to set
	 */
	public boolean setCurrentLife(int life) 
	{
		if(life < this.currentLife)
		{
			if(life < 0)
				this.currentLife = 0;
			else
				this.currentLife = life;
			return true;
		}
		else if(this.currentLife < this.maximumLife)
		{
			if(life <= this.maximumLife)
				this.currentLife = life;
			else
				this.currentLife = this.maximumLife;
			return true;
		}
		else
		{
//			JOptionPane.showMessageDialog(null, "Sie haben bereits volle Lebenspunkte!", "Achtung!", JOptionPane.WARNING_MESSAGE);
			System.out.println("Sie haben bereits volle Lebenspunkte!");
			return false;
		}
	}
	
	public void setMaximumLife(int maxLife)
	{
		this.maximumLife = maxLife;
	}
	
	public int getMaximumLife()
	{
		return this.maximumLife;
	}
	
	/**
	 * @author Heusser, Caspar
	 * @return the attack
	 */
	public int getAttack() {
		return this.attack;
	}
	/**
	 * @author Heusser, Caspar
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	/**
	 * @author Heusser, Caspar
	 * @return the defense
	 */
	public int getDefense() {
		return this.defense;
	}
	/**
	 * @author Heusser, Caspar
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}
	/**
	 * @author Heusser, Caspar
	 * @return the movementSpeed
	 */
	public int getMovementSpeed() {
		return this.movementSpeed;
	}
	/**
	 * @author Heusser, Caspar
	 * @param movementSpeed the movementSpeed to set
	 */
	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}
	
}

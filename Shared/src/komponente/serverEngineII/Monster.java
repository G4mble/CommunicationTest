package komponente.serverEngineII;


public abstract class Monster extends CombatantModel {
	private int scaling;
	private int actID;
	private boolean hasKey;
	private boolean isAlive;
	/**
	 * 0 Monster patrols
	 * 1 Monster chases/attacks  a Player
	 *-1 Monster flees
	 */
	private int state;
	/**
	 * constructor of "Monster"
	 * @author Heusser, Caspar
	 * @param scaling
	 * @param actID
	 * @param life
	 * @param attack
	 * @param defense
	 * @param movementSpeed
	 * @param characterId
	 * @param characterName
	 * @param posX
	 * @param posY
	 * @param imagePath
	 */
	public Monster(int scaling, int actID,int life, int attack, int defense, int movementSpeed, int characterId, String characterName, int posX, int posY,String imagePath ){
		super(life,  attack,  defense, movementSpeed, characterId,  characterName, posX,  posY,  true, imagePath);
		this.hasKey=false;
		this.isAlive=true;
		this.scaling=scaling;
		this.actID=actID;
		this.state = 0;
	}
	
	/**
	 * returns the Path to a Player
	 * 
	 * @author Balduin,Andreas,5800366
	 * @param map
	 * @param player
	 * @return
	 */
	public Vertices[] path_to_Player(boolean[][] map, CombatantModel player) {

		A_Star_Algorithm A_Star = new A_Star_Algorithm(map);
		int pos_X_Monster = this.getPosX();
		int pos_Y_Monster = this.getPosY();
		int pos_X_Player = player.getPosX();
		int pos_Y_Player = player.getPosY();
		Vertices[] Path = A_Star.A_Star(pos_X_Monster, pos_Y_Monster,pos_X_Player, pos_Y_Player);
		return Path;
	}
	/**
	 * Attacks a player
	 * if the player dies return true
	 * else return false and lowers player health
	 * 
	 * @author Balduin,Andreas,5800366
	 * @param defender
	 */
	
	public void attack (CombatantModel defender){
		int damage = this.damage_Calculation_Attack(defender);
		if (damage == -1){ // defender died
		     defender.setCurrentLife(0);
		}
		else {
			int new_Life = defender.getCurrentLife() - damage;
			defender.setCurrentLife(new_Life);
		}
	}
	/**
	 * @return the scaling
	 */
	public int getScaling() {
		return scaling;
	}
	/**
	 * @param scaling the scaling to set
	 */
	public void setScaling(int scaling) {
		this.scaling = scaling;
	}
	/**
	 * @return the actID
	 */
	public int getActID() {
		return actID;
	}
	/**
	 * @param actID the actID to set
	 */
	public void setActID(int actID) {
		this.actID = actID;
	}
	/**
	 * @return the hasKey
	 */
	public boolean isHasKey() {
		return hasKey;
	}
	/**
	 * @param hasKey the hasKey to set
	 */
	public void setHasKey(boolean hasKey) {
		this.hasKey = hasKey;
	}
	/**
	 * @return the isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}
	/**
	 * @param isAlive the isAlive to set
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}

}


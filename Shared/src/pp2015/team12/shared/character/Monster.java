package pp2015.team12.shared.character;

import java.util.LinkedList;

@SuppressWarnings("serial")
public abstract class Monster extends CombatantModel {
	private int scaling;
	private boolean hasKey;
	private boolean isAlive;
	private int monsterId;
	private int textureWidth;
	private int exp_gain;
	/**
	 * 1 up
	 * 2 right
	 * 3 down
	 * 4 left
	 */
	private int direction;
	/**
	 * 0 Monster patrols
	 * 1 Monster chases  a Player
	 * 2 Monster attacks a Player
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
	public Monster(int scaling,int life, int attack, int defense, int movementSpeed,String characterName, int posX, int posY,String imagePath,int levelID,int monsterId,int exp_gain){
		super(life,  attack,  defense, movementSpeed, characterName, posX,  posY,imagePath,levelID);
		this.hasKey=false;
		this.isAlive=true;
		this.scaling=scaling;
		this.state = 0;
		this.direction = 1;
		this.textureWidth = 40;
		this.monsterId = monsterId;
		this.exp_gain = exp_gain;
		
	}
	
	/**
	 * Main Part of the Finite State Machine 
	 * @author Balduin,Andreas,5800366
	 * @param map
	 * @param player_Array
	 * @return
	 */
	public void change_State (boolean[][] map,PlayerCharacter[] player_Array) {
		
		if(!(this.nearest_Player_in_Range(map,player_Array)==null)){
			PlayerCharacter target = nearest_Player_in_Range(map,player_Array);
			{
				if(this.player_attackable(target)){
					this.setState(2);
				}
				else{
					this.setState(1);
				}
			}
		}
		else {
			this.setState(0);
		}
		if ((this.getCurrentLife())<= (this.getMaximumLife()*0.1)){
			this.setState(-1);
		}
	}
	/**
	 * returns the Path to a Player
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
	 * checks if a player in a list is in range
	 * @author Balduin,Andreas,5800366
	 * @param player_Array
	 * @return
	 */
	public PlayerCharacter nearest_Player_in_Range(boolean [][] map,PlayerCharacter[] player_Array) {
		int posX_Monster = (int) (this.getPosX())/(this.getTextureWidth());
		int posY_Monster = (int) (this.getPosY())/(this.getTextureWidth());
		LinkedList<PlayerCharacter> sameLevel = new LinkedList<PlayerCharacter>();
		for (int i = 0; i < player_Array.length; i++) {
			try {
				if (this.getLevelId() == player_Array[i].getLevelId()) {
					sameLevel.add(player_Array[i]);
					}
				}
			catch (NullPointerException e) {}
		}
		LinkedList<Iterationcounter> inRange = new LinkedList<Iterationcounter>();
		inRange.add(new Iterationcounter(posX_Monster,posY_Monster,0));
		while(!inRange.isEmpty()){
			Iterationcounter temp = inRange.remove();
			if(temp.getIteration() <= this.getMovementSpeed()){
				for (int i = 0; i < sameLevel.size(); i++){
					if ((temp.getPosX() == sameLevel.get(i).getPosX()) && (temp.getPosY() == sameLevel.get(i).getPosY())){
						this.setState(1);
						return sameLevel.get(i);
					}
				}
				if (map[temp.getPosX() + 1][temp.getPosY()]){
					inRange.add(new Iterationcounter(temp.getPosX() + 1,temp.getPosY(),temp.getIteration() + 1));
				}
				if (map[temp.getPosX() -1 ][temp.getPosY()]){
					inRange.add(new Iterationcounter(temp.getPosX() - 1,temp.getPosY(),temp.getIteration() + 1));
				}
				if (map[temp.getPosX()][temp.getPosY() + 1]){
					inRange.add(new Iterationcounter(temp.getPosX(),temp.getPosY() + 1,temp.getIteration() + 1));
				}
				if (map[temp.getPosX()][temp.getPosY() - 1]){
					inRange.add(new Iterationcounter(temp.getPosX(),temp.getPosY() - 1,temp.getIteration() + 1));
				}
			}
		}
		return null;
	}
	
	/**
	 * checks if a player is attackable
	 * @param player
	 * @return
	 */
	
	public boolean player_attackable (CombatantModel player){
		int pos_X_Monster = this.getPosX();
		int pos_Y_Monster = this.getPosY();
		int pos_X_Player = player.getPosX();
		int pos_Y_Player = player.getPosY();
		if (this.getDirection() == 1){
			double x_diff = pos_X_Player - pos_X_Monster;
			double y_diff = pos_Y_Player - pos_Y_Monster;
			if (((y_diff) <= (this.getTextureWidth()*1.5)) && ((y_diff) >= (this.getTextureWidth()*0.3)) && ((x_diff) <= (this.getTextureWidth()*1.2))){
				return true;
			}
		}
		if(this.getDirection() == 2){
			double x_diff = pos_X_Player - pos_X_Monster;
			double y_diff = pos_Y_Player - pos_Y_Monster;
			if (((x_diff) <= (this.getTextureWidth()*1.5)) && ((x_diff) >= (this.getTextureWidth()*0.3)) && ((y_diff) <= (this.getTextureWidth()*1.2))){
				return true;
			}
		}
		if(this.getDirection() == 3){
			double x_diff = pos_X_Monster - pos_X_Player;
			double y_diff = pos_Y_Monster - pos_Y_Player;
			if (((y_diff) <= (this.getTextureWidth()*1.5)) && ((y_diff) >= (this.getTextureWidth()*0.3)) && ((x_diff) <= (this.getTextureWidth()*1.2))){
				return true;
			}
		}
		if(this.getDirection() == 4){
			double x_diff = pos_X_Monster - pos_X_Player;
			double y_diff = pos_Y_Monster - pos_Y_Player;
			if (((x_diff) <= (this.getTextureWidth()*1.5)) && ((x_diff) >= (this.getTextureWidth()*0.3)) && ((y_diff) <= (this.getTextureWidth()*1.2))){
				return true;
			}
		}
		return false;
	}
	/**
	 * Attacks a player
	 * if the player dies return true
	 * else return false and lowers player health
	 * @author Balduin,Andreas,5800366
	 * @param defender
	 */
	public void attack (CombatantModel defender){
		int damage = this.damage_Calculation(defender);
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

	/**
	 * @return the textureWidth
	 */
	public int getTextureWidth() {
		return textureWidth;
	}

	/**
	 * @param textureWidth the textureWidth to set
	 */
	public void setTextureWidth(int textureWidth) {
		this.textureWidth = textureWidth;
	}

	/**
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * @return the monsterId
	 */
	public int getMonsterId() {
		return monsterId;
	}

	/**
	 * @param monsterId the monsterId to set
	 */
	public void setMonsterId(int monsterId) {
		this.monsterId = monsterId;
	}

	/**
	 * @return the exp_gain
	 */
	public int getExp_gain() {
		return exp_gain;
	}

	/**
	 * @param exp_gain the exp_gain to set
	 */
	public void setExp_gain(int exp_gain) {
		this.exp_gain = exp_gain;
	}

}


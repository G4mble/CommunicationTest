package pp2015.team12.shared.message;

import pp2015.team12.shared.character.Monster;
/**
 * 
 * @author Heusser, Caspar
 *
 */
@SuppressWarnings("serial")
public class MonsterListMsg extends Message {
	Monster[] monsterList;
	/**
	 * @author Heusser, Caspar
	 * @param monsterList
	 * @param clientID
	 */
	public MonsterListMsg (Monster[] monsterList, int clientID){
		super(clientID);
		this.monsterList=monsterList;
	}

	/**
	 * @author Heusser, Caspar
	 * @return the monsterList
	 */
	public Monster[] getMonsterList() {
		return monsterList;
	}
}
	
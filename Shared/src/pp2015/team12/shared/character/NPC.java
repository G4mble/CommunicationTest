package pp2015.team12.shared.character;

/**
 * abstract datamodel for NPC
 * @author Balduin,Andreas,5800366
 *
 */
@SuppressWarnings("serial")
public abstract class NPC extends Character {
	
	/**
	 * constructer of NPC class
	 * @author Balduin,Andreas,5800366
	 * @param characterId
	 * @param characterName
	 * @param posX
	 * @param posY
	 * @param imagePath
	 * @param inventory
	 */
	public NPC(String characterName, int posX, int posY,String imagePath,int levelId) {
		super(characterName, posX, posY, false, imagePath,levelId);
	}
}

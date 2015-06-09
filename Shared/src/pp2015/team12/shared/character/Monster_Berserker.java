package pp2015.team12.shared.character;
/**
 * 
 * @author Balduin,Andreas,5800366
 *
 */
@SuppressWarnings("serial")
public class Monster_Berserker extends Monster {
	
	/**
	 * Constructor for the Tank Monster
	 * @author Balduin,Andreas,5800366
	 * @param scaling
	 * @param actID
	 * @param characterId
	 * @param characaterName
	 * @param posX
	 * @param posY
	 * @param imagePath
	 */
	public Monster_Berserker (int scaling,String characaterName,int posX,int posY,String imagePath,int levelID,int monsterId,int exp_gain){
		super (scaling,(int)(20 + scaling *0.5),(int)(6 + scaling * 0.25),(int)(1.5 + scaling * 0.1),5,characaterName,posX,posY,imagePath,levelID,monsterId,exp_gain);
	}
	
	/**
	 * Constructor for SE_II_Controller
	 * @author Balduin,Andreas,5800366
	 * @param posX
	 * @param posY
	 * @param levelId
	 * @param monsterId
	 */
	public Monster_Berserker(int posX,int posY,int levelId,int monsterId){
			this(0," ",posX,posY," ",levelId,monsterId,0);
			// TODO definiere scaling + expgain durch levelId
			if (levelId < 22){
				// TODO change Name and Imagepath 
				this.setCharacterName("Berserker");
				this.setImagePath("Berserker1.jpg");
			}
			else if (levelId < 44){
				// TODO change Name and Imagepath
				this.setCharacterName("Berserker");
				this.setImagePath("Berserker2.jpg");
			}
			else {
				// TODO change Name and Imagepath
				this.setCharacterName("Berserker");
				this.setImagePath("Berserker3.jpg");
			}
	}
}

package pp2015.team12.shared.character;

/**
 * 
 * @author Balduin,Andreas,5800366
 *
 */
@SuppressWarnings("serial")
public class Monster_Assasin extends Monster {

	/**
	 * Standard Constructor
	 * 
	 * @author Balduin,Andreas,5800366
	 * @param scaling
	 * @param actID
	 * @param characterId
	 * @param characaterName
	 * @param posX
	 * @param posY
	 * @param imagePath
	 */

	public Monster_Assasin(int scaling,String characaterName, int posX, int posY, String imagePath,int levelID,int monsterId,int exp_gain) {
		super(scaling,(int) (15 + scaling * 0.5),(int) (8 + scaling * 0.25), (int) (1 + scaling * 0.1), 7, characaterName, posX, posY, imagePath,levelID,monsterId,exp_gain);
	}
	/**
	 * Constructor for SE_II_Controller
	 * @author Balduin,Andreas,5800366
	 * @param posX
	 * @param posY
	 * @param levelId
	 * @param monsterId
	 */
	public Monster_Assasin(int posX,int posY,int levelId,int monsterId){
			this(0," ",posX,posY," ",levelId,monsterId,0);
			// TODO definiere scaling + expgain durch levelId
			if (levelId < 22){
				// TODO change Name and Imagepath
				this.setCharacterName("Assasin");
				this.setImagePath("Assasin1.jpg");
			}
			else if (levelId < 44){
				// TODO change Name and Imagepath
				this.setCharacterName("Assasin");
				this.setImagePath("Assasin2.jpg");
			}
			else {
				// TODO change Name and Imagepath 
				this.setCharacterName("Assasin");
				this.setImagePath("Assasin3.jpg");
			}
	}
	
	
	
}
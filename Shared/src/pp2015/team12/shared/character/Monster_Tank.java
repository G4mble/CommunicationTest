package pp2015.team12.shared.character;
/**
 * 
 * @author Balduin,Andreas,5800366
 *
 */
@SuppressWarnings("serial")
public class Monster_Tank extends Monster {
	// old attribute
	private int actId;
	
	
	
	
	
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
	public Monster_Tank (int scaling,String characaterName,int posX,int posY,String imagePath,int levelID,int monsterId,int exp_gain){
		super (scaling,(int)(25 + scaling *0.5),(int)(4 + scaling * 0.25),(int)(2 + scaling * 0.1),3,characaterName,posX,posY,imagePath,levelID,monsterId,exp_gain);
	}
	/**
	 * Constructor for SE_II_Controller
	 * @author Balduin,Andreas,5800366
	 * @param posX
	 * @param posY
	 * @param levelId
	 * @param monsterId
	 */
	public Monster_Tank(int posX,int posY,int levelId,int monsterId){
			this(0," ",posX,posY," ",levelId,monsterId,0);
			// TODO definiere scaling + expgain durch levelId
			if (levelId < 22){
				// TODO change Name and Imagepath
				this.setCharacterName("Tank");
				this.setImagePath("Tank1.jpg");
			}
			else if (levelId < 44){
				// TODO change Name and Imagepath
				this.setCharacterName("Tank");
				this.setImagePath("Tank2.jpg");
			}
			else {
				// TODO change Name and Imagepath 
				this.setCharacterName("Tank");
				this.setImagePath("Tank3.jpg");
			}
	}
	/**
	 *old Constructor
	 * @param scaling
	 * @param actID
	 * @param ClientID
	 * @param characaterName
	 * @param posX
	 * @param posY
	 * @param imagePath
	 */
	public Monster_Tank(int scaling, int actID, int ClientID, String characaterName, int posX,int posY, String imagePath) {
		super(scaling,(int)(25 + scaling *0.5),(int)(4 + scaling * 0.25),(int)(2 + scaling * 0.1),3,characaterName,posX,posY,imagePath,-1,-1,-1);
		this.actId = actID;
	}
	/**
	 * @return the actId
	 */
	public int getActId() {
		return actId;
	}
	/**
	 * @param actId the actId to set
	 */
	public void setActId(int actId) {
		this.actId = actId;
	}
}

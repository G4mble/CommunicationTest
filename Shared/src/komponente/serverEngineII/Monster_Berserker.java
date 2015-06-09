package komponente.serverEngineII;
/**
 * 
 * @author Balduin,Andreas,5800366
 *
 */
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
	public Monster_Berserker (int scaling,int actID,int characterId,String characaterName,int posX,int posY,String imagePath){
		super (scaling,actID,(int)(20 + scaling *0.5),(int)(6 + scaling * 0.25),(int)(1.5 + scaling * 0.1),5,characterId,characaterName,posX,posY,imagePath);
	}
}

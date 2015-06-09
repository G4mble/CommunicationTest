package pp2015.team12.shared.character;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
/**
 * abstract datamodel which provides the basic attributes for all characters in the game, e.g. monster and players
 * @author Heusser, Caspar
 *
 */
@SuppressWarnings("serial")
public abstract class Character implements Serializable{	
	private String characterName;					//NOT THE USERNAME this is the name of the characterClass (used for database storage)
	private int posX;
	private int posY;
	private boolean attackable; 					//fuer evtuelle NPC
	private Image characterImage;					//Textur fuer den Spielercharacter
	private String imagePath;						//Dateipfad der Textur (wird fuer die Datenbankspeicherung benoetigt)
	private int levelId;
	/**
	 * constructor of "Character
	 * @author Heusser, Caspar
	 * @param characterId
	 * @param characterName
	 * @param posX
	 * @param posY
	 * @param attackable
	 * @param imagePath
	 */
	public Character(String characterName, int posX, int posY, boolean attackable, String imagePath,int levelId){
		this.characterName = characterName;
		this.posX=posX;
		this.posY=posY;
		this.attackable=attackable;
		this.imagePath = imagePath;
		this.levelId = levelId;
		try
		{
			this.characterImage= ImageIO.read(new File(imagePath));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
		}
	}
	public void readTexture() {
		try {
			this.characterImage = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @author Heusser, Caspar
	 * @return the characterName
	 */
	public String getCharacterName() {
		return characterName;
	}
	/**
	 * @author Heusser, Caspar
	 * @param characterName the characterName to set
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	/**
	 * @author Heusser, Caspar
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}
	/**
	 * @author Heusser, Caspar
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	/**
	 * @author Heusser, Caspar
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}
	/**
	 * @author Heusser, Caspar
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	/**
	 * @author Heusser, Caspar
	 * @return the attackable
	 */
	public boolean isAttackable() {
		return attackable;
	}
	/**
	 * @author Heusser, Caspar
	 * @param attackable the attackable to set
	 */
	public void setAttackable(boolean attackable) {
		this.attackable = attackable;
	}
	/**
	 * @author Heusser, Caspar
	 * @return the characterImage
	 */
	public Image getCharacterImage() {
		return characterImage;
	}
	/**
	 * @author Heusser, Caspar
	 * @param characterImage the characterImage to set
	 */
	public void setCharacterImage(Image characterImage) {
		this.characterImage = characterImage;
	}
	/**
	 * @author Staufenberg, Thomas
	 * @return texture image path as String
	 * */
	public String getImagePath(){
		return this.imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	/**
	 * @return the levelId
	 */
	public int getLevelId() {
		return levelId;
	}

	/**
	 * @param levelId the levelId to set
	 */
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
}

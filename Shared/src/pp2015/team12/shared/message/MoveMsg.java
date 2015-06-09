package pp2015.team12.shared.message;

import pp2015.team12.shared.character.Character;
/**
 * 
 * @author Heusser,Caspar
 *
 */
@SuppressWarnings("serial")
public class MoveMsg extends Message {
	int nPosX;
	int nPosY;
	Character character;
	int characterId;
	String submitter;
	public String getSubmitter() {
		return submitter;
	}
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	/**
	 * @author Heusser, Caspar
	 * @param nPosX
	 * @param nPosY
	 * @param character
	 * @param characterId
	 * @param clientID
	 */
	 public MoveMsg (int nPosX,int nPosY, Character character, int characterId, int clientID){	//rausnehmen
		 super(clientID);
		 this.nPosX= nPosX;
		 this.nPosY= nPosY;
		 this.character = character;
		 this.characterId= characterId;
	 }
	 public MoveMsg (int nPosX,int nPosY, Character character){
		 
		 this.nPosX= nPosX;
		 this.nPosY= nPosY;
		 this.character = character;
		 
	 }
	 public MoveMsg (int nPosX,int nPosY){
		 
		 this.nPosX= nPosX;
		 this.nPosY= nPosY;
		 
	 }
	public void setCharacter(Character character) {
		this.character = character;
	}
	/**
	 * @author Heusser, Caspar
	 * @return the nPosX
	 */
	public int getnPosX() {
		return nPosX;
	}
	/**
	 * @author Heusser, Caspar
	 * @return the nPosY
	 */
	public int getnPosY() {
		return nPosY;
	}
	/**
	 * @author Heusser, Caspar
	 * @return the character
	 */
	public Character getCharacter() {
		return character;
	}
	/**
	 * @author Heusser, Caspar
	 * @return the characterId
	 */
	public int getCharacterId() {
		return characterId;
	}
	 

}

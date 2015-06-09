package pp2015.team12.shared.message;


import pp2015.team12.shared.character.PlayerCharacter;


/**
 * 
 * @author Heusser,Caspar
 *
 */

@SuppressWarnings("serial")
public class CharacterListMsg extends Message{
		PlayerCharacter[]characterList;
		/**
		 * @author Heusser, Caspar
		 * @param clientID
		 * @param characterList
		 */
		public CharacterListMsg (int clientID, PlayerCharacter[] characterList){
			super(clientID);
			this.characterList=characterList;
			
		}

		/**
		 * @author Heusser, Caspar
		 * @return the characterList
		 */
		public PlayerCharacter[] getCharacterList() {
			return characterList;
		}
		
}

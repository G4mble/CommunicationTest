package pp2015.team12.shared.message;

import pp2015.team12.shared.map.Tile;
/**
 * 
 * @author Heusser, Caspar
 *
 */
@SuppressWarnings("serial")
public class MapMsg extends Message {
	Tile[][] map;
	/**
	 * @author Heusser, Caspar
	 * @param map
	 * @param clientID
	 */
	public MapMsg(Tile[][] map, int clientID){
		super(clientID);
		this.map=map;
		
	}

	/**
	 * @author Heusser, Caspar
	 * @return the map
	 */
	public Tile[][] getMap() {
		return map;
	}

	
}

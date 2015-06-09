package pp2015.team12.shared.message;

import pp2015.team12.shared.map.Tile;

@SuppressWarnings("serial")
public class MiniMapMsg extends Message{
	private Tile[][] map;
	private boolean movePlayer;
	
	public MiniMapMsg (Tile[][] map, boolean movePlayer){
		this.map= map;
		this.movePlayer = movePlayer;
	}

	public Tile[][] getMap() {
		return map;
	}

	public boolean isMovePlayer() {
		return movePlayer;
	}
	
}

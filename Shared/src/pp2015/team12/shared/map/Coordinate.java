package pp2015.team12.shared.map;

public class Coordinate {
	/**
	 * The class contains 2 coordinates for placing of monsters and items in a two-dimensional system
	 * @author Ulko, Michael
	 * @author Heusser, Caspar
	 */
	
	private int monsterNr;
	private int posX;
	private int posY;
	
	/**
	 * Constructor for initialization of x and y coordinates
	 * @author Ulko, Michael
	 * @param posX
	 * @param posY
	 */
	public Coordinate(int monsterNr, int posX, int posY) {
		this.monsterNr = monsterNr;
		this.posX = posX;
		this.posY = posY;
	}
	/**
	 * alternative Constructor for initialization of x and y coordinates
	 * @author Heusser, Caspar
	 * @param posX
	 * @param posY
	 */
	public Coordinate(int posX, int posY){
		this.posX= posX;
		this.posY=posY;
	}
	public int getMonsterNr() {
		return monsterNr;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}

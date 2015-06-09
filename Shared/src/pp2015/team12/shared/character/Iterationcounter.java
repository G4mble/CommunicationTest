package pp2015.team12.shared.character;
/**
 * 
 * @author Balduin,Andreas,5800366
 *
 */
public class Iterationcounter {
	
	private int posX;
	private int posY;
	private int iteration;
	/**
	 * Constructer
	 * @author Balduin,Andreas,5800366
	 * @param player
	 * @param iteration
	 */
	public Iterationcounter(int posX, int posY, int iteration){
		this.posX = posX;
		this.posY = posY;
		this.iteration = iteration;
	}



	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}



	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}



	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}



	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}



	/**
	 * @return the iteration
	 */
	public int getIteration() {
		return iteration;
	}

	/**
	 * @param iteration the iteration to set
	 */
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}
}
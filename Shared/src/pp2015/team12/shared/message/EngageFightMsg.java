package pp2015.team12.shared.message;

import pp2015.team12.shared.map.Coordinate;

/**
 * @author Heusser, Caspar
 * 
 *
 */
@SuppressWarnings("serial")
public class EngageFightMsg extends Message{
	private int direction;	//1-up 2-right 3-down 4-left
	private Coordinate monsterPos;
	public Coordinate getMonsterPos() {
		return monsterPos;
	}
	public void setMonsterPos(Coordinate monsterPos) {
		this.monsterPos = monsterPos;
	}
	/**
	 * @author Heusser, Caspar
	 * @param SubmitterID
	 * @param direction
	 */
	public EngageFightMsg(int SubmitterID, int direction){
		super(SubmitterID);
		this.direction=direction;
	}
	/**
	 * @author Heusser, Caspar
	 * @return
	 */
	public int getDirection() {
		return direction;
	}

}

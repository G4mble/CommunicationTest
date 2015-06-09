package pp2015.team12.shared.message;

import pp2015.team12.shared.map.Coordinate;

/**
 * @author Heusser, Caspar
 * 
 *
 */
@SuppressWarnings("serial")
public class PickUpMsg extends Message{
	
	Coordinate pos;
	/**
	 * @return the pos
	 */
	public Coordinate getPos()
	{
		return pos;
	}
	/**
	 * @param pos the pos to set
	 */
	public void setPos(Coordinate pos)
	{
		this.pos = pos;
	}
	/**
	 * @author Heusser, Caspar
	 * @param SubmitterID
	 */
	public PickUpMsg(){
		
	}
	
	public PickUpMsg(int clientId){
		super(clientId);
	}

}

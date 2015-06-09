package komponente.serverEngineII;


/**
 * Class for the A Star Algorithm
 * @author Balduin,Andreas,5800366
 */
public class Vertices {
	private int pos_x;
	private int pos_y;
	private int distance_to_Start; 
	private int distance_to_End; 
	private int total_distance;
	private Vertices father;
	
	/**
	 * Standard Constructor
	 * @author Balduin,Andreas,5800366
	 * @param pos_x
	 * @param pos_y
	 * @param end
	 */
	public Vertices(int pos_x, int pos_y, Vertices end, Vertices father) {
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		int diff_in_X_Pos = Math.abs(pos_x - end.getPos_x()); // Difference in X-Position
		int diff_in_Y_Pos = Math.abs(pos_y - end.getPos_y()); // Difference in Y-Position
		this.distance_to_End = diff_in_X_Pos + diff_in_Y_Pos; // h(x) = Manhattan distance
		this.father = father;
		this.distance_to_Start = father.distance_to_Start + 1; // g(x)
		this.total_distance = distance_to_End + distance_to_Start; // f(x) = g(x) + h(x)
	}
	/**
	 * Constructor for the Start Vertices
	 * @author Balduin,Andreas,5800366
	 * @param pos_x
	 * @param pos_y
	 * @param end
	 */
	public Vertices (int pos_x,int pos_y,Vertices end){
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		int diff_in_X_Pos = Math.abs(pos_x - end.getPos_x()); // Difference in X-Position
		int diff_in_Y_Pos = Math.abs(pos_y - end.getPos_y()); // Difference in Y-Position
		this.distance_to_End = diff_in_X_Pos + diff_in_Y_Pos; // h(x) = Manhattan distance
		this.distance_to_Start = 0; // g(x) = 0 because its the Start Vertices 
		this.total_distance = distance_to_End; // f(x) = h(x)
	}
	/**
	 * Constructor for the End Vertices
	 * @author Balduin,Andreas,5800366
	 * @param pos_x
	 * @param pos_y
	 */
	public Vertices (int pos_x,int pos_y){
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.distance_to_End = 0; // h(x) = 0 because its the End Vertices
		this.distance_to_Start = 0; // g(x) will be later changed in the A Star Algorithm
		this.total_distance = 0; // f(x) = g(x)
	}
	/**
	 * @return the pos_x
	 */
	public int getPos_x() {
		return pos_x;
	}

	/**
	 * @param pos_x
	 *          	the pos_x to set
	 */
	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}

	/**
	 * @return the pos_y
	 */
	public int getPos_y() {
		return pos_y;
	}

	/**
	 * @param pos_y
	 *            the pos_y to set
	 */
	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}

	/**
	 * @return the distance_to_Start
	 */
	public int getDistance_to_Start() {
		return distance_to_Start;
	}

	/**
	 * @param distance_to_Start
	 *            the distance_to_Start to set
	 */
	public void setDistance_to_Start(int distance_to_Start) {
		this.distance_to_Start = distance_to_Start;
	}

	/**
	 * @return the distance_to_End
	 */
	public double getDistance_to_End() {
		return distance_to_End;
	}

	/**
	 * @param distance_to_End
	 *            the distance_to_End to set
	 */
	public void setDistance_to_End(int distance_to_End) {
		this.distance_to_End = distance_to_End;
	}

	/**
	 * @return the father
	 */
	public Vertices getFather() {
		return father;
	}

	/**
	 * @param father the father to set
	 */
	public void setFather(Vertices father) {
		this.father = father;
	}
	/**
	 * @return the total_distance
	 */
	public double getTotal_distance() {
		return total_distance;
	}
	/**
	 * @param total_distance the total_distance to set
	 */
	public void setTotal_distance(int total_distance) {
		this.total_distance = total_distance;
	}

}

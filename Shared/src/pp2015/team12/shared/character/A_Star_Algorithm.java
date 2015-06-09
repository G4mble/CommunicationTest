package pp2015.team12.shared.character;
import java.util.LinkedList;
/**
 * Implementation of A Star Algorithm
 * which use the Manhattan Distance for the Heuristic
 * @author Balduin,Andreas,5800366
 *
 */
public class A_Star_Algorithm {

	boolean[][] Map;
	/**
	 * Constructor
	 * Balduin,Andreas,5800366
	 * @param Map
	 */
	public A_Star_Algorithm (boolean[][] Map){
		this.Map = Map;
	}
	/**
	 * Main Implemenation of A Star Algorithm
	 * Balduin,Andreas,5800366
	 * @param pos_x_Start
	 * @param pos_y_Start
	 * @param pos_x_End
	 * @param pos_y_End
	 * @return
	 */
	public Vertices[] A_Star (int pos_x_Start,int pos_y_Start,int pos_x_End, int pos_y_End){
		// Initialize Start  Condition
		Vertices End = new Vertices(pos_x_End, pos_y_End); 
		Vertices Start = new Vertices(pos_x_Start, pos_y_Start, End); 
		LinkedList<Vertices> Open_List = new LinkedList<Vertices>();
		LinkedList<Vertices> Closed_List = new LinkedList<Vertices>();
		LinkedList<Vertices> Path_List = new LinkedList<Vertices>();
		Open_List.add(Start);
		boolean end_found = false;
		
		//  Start of the Algorithm
		while (!end_found) {
			if (!Open_List.isEmpty()) {
				Vertices z = cheapest_Vertices(Open_List); // Search for the minimal f(x) in the Open List
				Open_List.remove(z);
				Closed_List.add(z);
				boolean[] neighbour = new boolean[4]; 
				neighbour = check_Neighbours(z.getPos_x(), z.getPos_y()); // Check the neighbours of the Minimum
				
				if ((neighbour[0])) { // checking the right neighbour
					Vertices v = new Vertices(z.getPos_x() + 1, z.getPos_y(),End, z);
					if (check_Vertices_List(v, Closed_List) < 0) {  // check if it is not  in the Closed list
						if (check_Vertices_List(v, Open_List) < 0) { // check if it is not in the Open list
							Open_List.add(v);
						} else {
							Vertices w = Open_List.get(check_Vertices_List(v,Open_List));
							if (v.getDistance_to_Start() < w.getDistance_to_Start()) { // update f(x) if it is in the Open List  
																					   // and has lower g(x)	
								w.setFather(z);
								w.setDistance_to_Start(v.getDistance_to_Start());
							}
						}
					}
					if (check_Vertices(v, End)) { // check if End is reached
						Path_List.add(v);
						end_found = true;
					}
				}
				if ((neighbour[1])) { // checking the left neighbour nearly the same Code as right neighbour 
					Vertices v = new Vertices(z.getPos_x() - 1, z.getPos_y(),End, z);
					if (check_Vertices_List(v, Closed_List) < 0) {
						if (check_Vertices_List(v, Open_List) < 0) {
							Open_List.add(v);
						} else {
							Vertices w = Open_List.get(check_Vertices_List(v,Open_List));
							if (v.getDistance_to_Start() < w.getDistance_to_Start()) {
								w.setFather(z);
								w.setDistance_to_Start(v.getDistance_to_Start());
							}
						}
					}
					if (check_Vertices(v, End)) {
						Path_List.add(v);
						end_found = true;
					}
				}
				if ((neighbour[2])) { // checking the up neighbour nearly the same Code as right neighbour 
					Vertices v = new Vertices(z.getPos_x(), z.getPos_y() + 1,End, z);
					if (check_Vertices_List(v, Closed_List) < 0) {
						if (check_Vertices_List(v, Open_List) < 0) {
							Open_List.add(v);
						} else {
							Vertices w = Open_List.get(check_Vertices_List(v,Open_List));
							if (v.getDistance_to_Start() < w.getDistance_to_Start()) {
								w.setFather(z);
								w.setDistance_to_Start(v.getDistance_to_Start());
							}
						}
					}
					if (check_Vertices(v, End)) {
						Path_List.add(v);
						end_found = true;
					}
				}
				if ((neighbour[3])) { // checking the down neighbour nearly the same Code as right neighbour 
					Vertices v = new Vertices(z.getPos_x(), z.getPos_y() - 1,End, z);
					if (check_Vertices_List(v, Closed_List) < 0) {
						if (check_Vertices_List(v, Open_List) < 0) {
							Open_List.add(v);
						} else {
							Vertices w = Open_List.get(check_Vertices_List(v,Open_List));
							if (v.getDistance_to_Start() < w.getDistance_to_Start()) {
								w.setFather(z);
								w.setDistance_to_Start(v.getDistance_to_Start());
							}
						}
					}
					if (check_Vertices(v, End)) {
						Path_List.add(v);
						end_found = true;
					}
				}
			}
			else { // Open_List has no Entry return 8 Start Vertices
				Vertices[] No_Path_Found = { Start,Start,Start,Start,Start,Start,Start,Start };
				return No_Path_Found;
			}
		}
		// Construct the Path from Start to End 
		while(!(Path_List.getLast().getFather()==null)){
			Path_List.add(Path_List.getLast().getFather());
		}
		Vertices [] Path_Array = List_to_Array(Path_List);
		return Path_Array;
	}
	
	
	/**
	 * Converts a List into an Array 
	 * but the first Entry in the List is the last Entry in the Array
	 * Balduin,Andreas,5800366
	 * @param list
	 * @return
	 */
	public Vertices[] List_to_Array (LinkedList<Vertices> list){
		Vertices[] Path = new Vertices[list.size()];
		int i = 0;
		while(!list.isEmpty()){
			Path[i] = list.removeLast();
			i ++;
		}
		return Path;
		
	}
	/**
	 * Checks the Position of a Vertices V with a List of Vertices
	 * if a Vertices in the List has the same Position with V it returns the position in the list
	 * else -1
	 * Balduin,Andreas,5800366	 
	 * @param a
	 * @param b
	 * @return
	 */
	public int check_Vertices_List(Vertices v, LinkedList<Vertices> list) {
		int s = list.size();
		for (int i = 0; i < s; i++) {
			if (check_Vertices(v, list.get(i)))
				return i;
		}
		return -1;
	}
	/**
	 * Checks if the Vertices has the same Position
	 * Balduin,Andreas,5800366
	 * @param a
	 * @param b
	 * @return
	 */
	
	public boolean check_Vertices(Vertices a, Vertices b) {
		if (a.getPos_x() == b.getPos_x()) {
			if (a.getPos_y() == b.getPos_y())
				return true;
			else
				return false;
		} else
			return false;
	}
	/**
	 * Searchs for the minimal Total Distance in a Vertices List
	 * Balduin,Andreas,5800366
	 * @param Open_List
	 * @return
	 */
	public Vertices cheapest_Vertices(LinkedList<Vertices> list) {
		
		Vertices min = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTotal_distance() < min.getTotal_distance())
				min = list.get(i);
		}
		return min;
	}
	/**
	 * check if the Neighbours of a Positon is accessible
	 * neighbours[0] down of Start point
	 * neighbours[1] up of Start point
	 * neighbours[2] right of Start point
	 * neighbours[3] left of Start point
	 * Balduin,Andreas,5800366
	 * @param pos_x
	 * @param pos_y
	 * @return
	 */
	public boolean[] check_Neighbours(int pos_x, int pos_y) {
		boolean[] neighbours = new boolean[4];

		if (check(pos_x + 1, pos_y))
			neighbours[0] = true;
		else
			neighbours[0] = false;
		if (check(pos_x - 1, pos_y))
			neighbours[1] = true;
		else
			neighbours[1] = false;
		if (check(pos_x, pos_y + 1))
			neighbours[2] = true;
		else
			neighbours[2] = false;
		if (check(pos_x, pos_y - 1))
			neighbours[3] = true;
		else
			neighbours[3] = false;
		return neighbours;
	}
	/**
	 * check if the Positon is accessible
	 * Balduin,Andreas,5800366
	 * @param pos_x
	 * @param pos_y
	 * @return
	 */
	public boolean check(int pos_x, int pos_y) {
		if (Map[pos_x][pos_y]) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the map
	 */
	public boolean[][] getMap() {
		return Map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(boolean[][] map) {
		Map = map;
	}
}

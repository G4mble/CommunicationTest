package komponente.map;

import pp2015.team12.shared.map.Tile;

/**
 * Contains all necessary methods and attributes for each node. Used structures:
 * Binary tree and tree, where a node has two 'parent' nodes.
 * 
 * @author Ulko, MIchael
 * 
 */
public class Node {

	/* Node ID */
	private int nodeNr;
	/* Double array of type Tile (= Level) */
	private Tile[][] map;
	/* Node on the left side for binary tree */
	private Node leftSon;
	/* Node on the right side for binary tree */
	private Node rightSon;
	/* Node should have two 'parent' nodes */
	private Node son;
	/* Node which is placed above another node */
	private Node father;
	/**/
	private Node leftFather;
	/**/
	private Node rightFather;

	/**
	 * Every node must contain an ID and level.
	 * 
	 * @param nodeNr
	 *            ID
	 * @param map
	 *            Generated level
	 * @author Ulko, Michael
	 */
	public Node(int nodeNr, Tile[][] map) {
		this.nodeNr = nodeNr;
		this.map = map;
	}

	/**
	 * Receive the left bottom node.
	 * 
	 * @return Left bottom node
	 * @author Ulko, Michael
	 */
	public Node getLeftSon() {
		return leftSon;
	}

	/**
	 * Receive the right bottom node.
	 * 
	 * @return Right bottom node
	 * @author Ulko, Michael
	 */
	public Node getRightSon() {
		return rightSon;
	}

	/**
	 * Receive the bottom node.
	 * 
	 * @return Bottom node
	 * @author Ulko, Michael
	 */
	public Node getSon() {
		return son;
	}

	/**
	 * Receive the above node.
	 * 
	 * @return Above node
	 * @author Ulko, Michael
	 */
	public Node getFather() {
		return father;
	}

	/**
	 * Receive left father node.
	 * 
	 * @return Left father node
	 * @author Ulko, Michael
	 */
	public Node getLeftFather() {
		return leftFather;
	}

	/**
	 * Receive right father node.
	 * 
	 * @return Right father node
	 * @author Ulko, Michael
	 */
	public Node getRightFather() {
		return rightFather;
	}

	/**
	 * Set the left bottom node.
	 * 
	 * @param node
	 *            New node which should be initializied
	 * @author Ulko, Michael
	 */
	public void setLeftSon(Node node) {
		this.leftSon = node;
	}

	/**
	 * Set the right bottom node.
	 * 
	 * @param node
	 *            New node which should be initializied
	 * @author Ulko, Michael
	 */
	public void setRightSon(Node node) {
		this.rightSon = node;
	}

	/**
	 * Set the bottom node.
	 * 
	 * @param node
	 *            New node which should be initializied
	 * @author Ulko, Michael
	 */
	public void setSon(Node node) {
		this.son = node;
	}

	/**
	 * Set the above node.
	 * 
	 * @param node
	 *            New node which should be initializied
	 * @author Ulko, Michael
	 */
	public void setFather(Node node) {
		this.father = node;
	}

	/**
	 * Set the left father node.
	 * 
	 * @param node
	 *            New node which should be initializied
	 * @author Ulko, Michael
	 */
	public void setLeftFather(Node node) {
		this.leftFather = node;
	}

	/**
	 * Set the right father node.
	 * 
	 * @param node
	 *            New node which should be initializied
	 * @author Ulko, Michael
	 */
	public void setRightFather(Node node) {
		this.rightFather = node;
	}

	/**
	 * Receive a level.
	 * 
	 * @return Level Current level
	 * @author Ulko, Michael
	 */
	public Tile[][] getLevel() {
		return this.map;
	}

	/**
	 * Receive a node ID.
	 * 
	 * @return ID Current node number
	 * @author Ulko, Michael
	 */
	public int getNodeNr() {
		return this.nodeNr;
	}
}

package komponente.map;

import pp2015.team12.shared.map.Tile;

/**
 * Creates a tree strucutre for the whole game. Every node has an ID, contains a
 * level and is associated with other adjazent nodes: There is father-son
 * connection. Every tree contains two halfs: The first (= above) half is based
 * on binary tree principle. It means every 'father' node has two 'sons'. The
 * second (= below) part is mirror-inverted to the first part: Two adjazent
 * 'father' nodes have one 'son'. There are three of such trees (= sub-trees).
 * 
 * @author Ulko, Michael
 * 
 */
public class LevelTree {

	/* This object is used when a start node should be created */
	private static Node startNode;

	/**
	 * Give back the start node.
	 * 
	 * @return Start node
	 * @author Ulko, Michael
	 */
	public static Node getStartNode() {
		return startNode;
	}

	/**
	 * Initialize the start node.
	 * 
	 * @param startNode
	 * @author Ulko, Michael
	 */
	private static void setStartNode(Node startNode) {
		LevelTree.startNode = startNode;
	}

	/**
	 * Create start room.
	 * 
	 * @author Ulko, Michael
	 */
	private void setStartRoom() {
		setStartNode(new Node(0, ob.createStartLevel()));
	}

	/* This object is used when a new node should be created */
	private Node node;

	/**
	 * Create a new Node with ID and level
	 * 
	 * @param nodeNr
	 *            ID
	 * @param map
	 *            Level
	 * @author Ulko, Michael
	 */
	private void setNode(int nodeNr, Tile[][] map) {
		this.node = new Node(nodeNr, map);
	}

	/**
	 * Connect the start node with the first node of the first sub-tree.
	 * 
	 * @author Ulko, Michael
	 */
	private void connectStartWithRoot() {
		LevelTree.getStartNode().setSon(this.node);
		this.node.setFather(LevelTree.getStartNode());
	}

	/* Necessary to use some functions from 'Level_Ready' */
	private Level_Ready ob = new Level_Ready();

	/* These control variables stay for each act */
	private boolean act1 = false;
	private boolean act2 = false;
	private boolean act3 = false;

	/* These variables should compute the ID for every new node */
	private int counter1 = 1;
	private int counter2 = 1;
	private int counter3 = 1;

	/* Maximal ID counter. Is necessary for nodes in below tree half */
	private int memoryNode = 0;

	/**
	 * This part is based on the binary tree logic. Produce two below nodes
	 * (left and right) and connect them with 'parent' node.
	 * 
	 * @param node
	 *            'Parent' node
	 * @author Ulko, Michael
	 */
	private void tree1Half(Node node) {
		/* It is the first act */
		if (act1 && !act2 && !act3) {
			/*
			 * It's above half of a tree and 'parent' node has not a below left
			 * node
			 */
			if (counter1 * 2 < 16 && node.getLeftSon() == null) {
				/* Decision whether it is a shop level */
				if (counter1 * 2 == 4 || counter1 * 2 == 6) {
					/* Create new left node which is a shop */
					Node leftSon = new Node(counter1 * 2, ob.createShopLevel(1,
							counter1 * 2));
					/* Update the control variable of the 1 act */
					counter1 *= 2;
					/* Connect both nodes with each other */
					node.setLeftSon(leftSon);
					leftSon.setFather(node);
					/* Move left down as long as it is the above half of a tree */
					tree1Half(leftSon);
				} /* Here is a normal level with labyrinth */
				else {
					/* Create new left node */
					Node leftSon = new Node(counter1 * 2, ob.createLevel(1,
							counter1 * 2));
					/* Update the control variable of the 1 act */
					counter1 *= 2;
					/* Connect both nodes with each other */
					node.setLeftSon(leftSon);
					leftSon.setFather(node);
					/* Move left down as long as it is the above half of a tree */
					tree1Half(leftSon);
				}
			}
			/*
			 * It's above half of a tree and 'parent' node has not a below right
			 * node
			 */
			if (counter1 * 2 < 16 && node.getRightSon() == null) {
				/* Create new right node */
				Node rightSon = new Node(counter1 * 2 + 1, ob.createLevel(1,
						counter1 * 2 + 1));
				/* Update the control variable of the 1 act */
				counter1 = counter1 * 2 + 1;
				/* Update control variable */
				memoryNode = counter1;
				/* Connect both nodes with each other */
				node.setRightSon(rightSon);
				rightSon.setFather(node);
				/* Move right down as long as it is the above half of a tree */
				tree1Half(rightSon);
			}
			/* Update control variable */
			counter1 /= 2;
		}
		/* It is the second act */
		if (!act1 && act2 && !act3) {
			/*
			 * It's above half of a tree and 'parent' node has not a below left
			 * node
			 */
			if (counter2 * 2 < 16 && node.getLeftSon() == null) {
				/* Decision whether it is a shop level */
				if (counter2 * 2 + 22 == 26 || counter2 * 2 + 22 == 28) {
					/* Create new left node which is a shop */
					Node leftSon = new Node(counter2 * 2 + 22,
							ob.createShopLevel(2, counter2 * 2 + 22));
					/* Update the control variable of the 2 act */
					counter2 *= 2;
					/* Connect both nodes with each other */
					node.setLeftSon(leftSon);
					leftSon.setFather(node);
					/* Move left down as long as it is the above half of a tree */
					tree1Half(leftSon);
				} /* Here is a normal level with labyrinth */
				else {
					/* Create new left node */
					Node leftSon = new Node(counter2 * 2 + 22, ob.createLevel(
							2, counter2 * 2 + 22));
					/* Update the control variable of the 2 act */
					counter2 *= 2;
					/* Connect both nodes with each other */
					node.setLeftSon(leftSon);
					leftSon.setFather(node);
					/* Move left down as long as it is the above half of a tree */
					tree1Half(leftSon);
				}
			}
			/*
			 * It's above half of a tree and 'parent' node has not a below right
			 * node
			 */
			if (counter2 * 2 < 16 && node.getRightSon() == null) {
				/* Create new right node */
				Node rightSon = new Node(counter2 * 2 + 23, ob.createLevel(2,
						counter2 * 2 + 23));
				/* Update the control variable of the 2 act */
				counter2 = counter2 * 2 + 1;
				/* Update control variable */
				memoryNode = counter2 + 22;
				/* Connect both nodes with each other */
				node.setRightSon(rightSon);
				rightSon.setFather(node);
				/* Move right down as long as it is the above half of a tree */
				tree1Half(rightSon);
			}
			/* Update control variable */
			counter2 /= 2;
		}
		/* It is the third act */
		if (!act1 && !act2 && act3) {
			/*
			 * It's above half of a tree and 'parent' node has not a below left
			 * node
			 */
			if (counter3 * 2 < 16 && node.getLeftSon() == null) {
				/* Decision whether it is a shop level */
				if (counter3 * 2 + 44 == 48 || counter3 * 2 + 44 == 50) {
					/* Create new left node which is a shop */
					Node leftSon = new Node(counter3 * 2 + 44,
							ob.createShopLevel(3, counter3 * 2 + 44));
					/* Update the control variable of the 3 act */
					counter3 *= 2;
					/* Connect both nodes with each other */
					node.setLeftSon(leftSon);
					leftSon.setFather(node);
					/* Move left down as long as it is the above half of a tree */
					tree1Half(leftSon);
				} /* Here is a normal level with labyrinth */
				else {
					/* Create new left node */
					Node leftSon = new Node(counter3 * 2 + 44, ob.createLevel(
							3, counter3 * 2 + 44));
					/* Update the control variable of the 3 act */
					counter3 *= 2;
					/* Connect both nodes with each other */
					node.setLeftSon(leftSon);
					leftSon.setFather(node);
					/* Move left down as long as it is the above half of a tree */
					tree1Half(leftSon);
				}
			}
			if (counter3 * 2 < 16 && node.getRightSon() == null) {
				/* Create new right node */
				Node rightSon = new Node(counter3 * 2 + 45, ob.createLevel(3,
						counter3 * 2 + 45));
				/* Update the control variable of the 3 act */
				counter3 = counter3 * 2 + 1;
				/* Update control variable */
				memoryNode = counter3 + 44;
				/* Connect both nodes with each other */
				node.setRightSon(rightSon);
				rightSon.setFather(node);
				/* Move right down as long as it is the above half of a tree */
				tree1Half(rightSon);
			}
			/* Update control variable */
			counter3 /= 2;
		}
	}

	/* Temporary variables */
	private Node node1;
	private Node node2;

	/**
	 * Search a below left node in the first tree half
	 * 
	 * @param start
	 *            Start node
	 * @param nodeNr
	 *            ID of searched node
	 * @return Searched node
	 * @author Ulko, Michael
	 */
	private Node searchNodeLeftSide(Node start, int nodeNr) {
		/* Control variable */
		boolean setOrNot = false;
		/* If searched node is found */
		if (start.getNodeNr() == nodeNr) {
			setOrNot = true;
		} else {
			/* Move to the left node if it is possible */
			if (start.getLeftSon() != null) {
				searchNodeLeftSide(start.getLeftSon(), nodeNr);
			}
			/* Move to the right node if it is possible */
			if (start.getRightSon() != null) {
				searchNodeLeftSide(start.getRightSon(), nodeNr);
			}
			/* Move to the below node if it is possible */
			if (start.getSon() != null) {
				searchNodeLeftSide(start.getSon(), nodeNr);
			}
		}
		if (setOrNot) {
			return this.node1 = start;
		} else {
			return null;
		}
	}

	/**
	 * Search a below right node in the first tree half
	 * 
	 * @param start
	 *            Start node
	 * @param nodeNr
	 *            ID of searched node
	 * @return Searched node
	 * @author Ulko, Michael
	 */
	private Node searchNodeRightSide(Node start, int nodeNr) {
		/* Control variable */
		boolean setOrNot = false;
		/* If searched node is found */
		if (start.getNodeNr() == nodeNr) {
			setOrNot = true;
		} else {
			/* Move to the left node if it is possible */
			if (start.getLeftSon() != null) {
				searchNodeRightSide(start.getLeftSon(), nodeNr);
			}
			/* Move to the right node if it is possible */
			if (start.getRightSon() != null) {
				searchNodeRightSide(start.getRightSon(), nodeNr);
			}
			/* Move to the below node if it is possible */
			if (start.getSon() != null) {
				searchNodeRightSide(start.getSon(), nodeNr);
			}
		}
		if (setOrNot) {
			return this.node2 = start;
		} else {
			return null;
		}
	}

	/**
	 * This methode produces one below node and connect in with its two up
	 * 'parents' nodes.
	 * 
	 * @param node1
	 *            First 'parent' node
	 * @param node2
	 *            Second 'parent' node
	 * @param actID
	 *            Current act
	 * @author Ulko, Michael
	 */
	private void createBelowNode(Node node1, Node node2, int actID) {
		/* Create new node */
		Node son = new Node(memoryNode += 1, ob.createLevel(actID, memoryNode));
		/* Connect just created node with both above nodes */
		node1.setSon(son);
		node2.setSon(son);
		son.setLeftFather(node1);
		son.setRightFather(node2);
	}

	/**
	 * This methode produces one below node and connect in with its two up
	 * 'parents' nodes.
	 * 
	 * @param node1
	 *            First 'parent' node
	 * @param node2
	 *            Second 'parent' node
	 * @param actID
	 *            Current act
	 * @author Ulko, Michael
	 */
	private void createBelowNodeBoss(Node node1, Node node2, int actID) {
		/* Create new node for boss level */
		Node son = new Node(memoryNode += 1, ob.createBossLevel(actID,
				memoryNode));
		/* Connect just created node with both above nodes */
		node1.setSon(son);
		node2.setSon(son);
		son.setLeftFather(node1);
		son.setRightFather(node2);
	}

	/**
	 * This methode produces one below node and connect in with its two up
	 * 'parents' nodes.
	 * 
	 * @param node1
	 *            First 'parent' node
	 * @param node2
	 *            Second 'parent' node
	 * @param actID
	 *            Current act
	 * @author Ulko, Michael
	 */
	private void createBelowNodesTrader(Node node1, Node node2, int actID) {
		Node son = new Node(memoryNode += 1, ob.createShopLevel(actID,
				memoryNode));
		node1.setSon(son);
		node2.setSon(son);
		son.setLeftFather(node1);
		son.setRightFather(node2);
	}

	/**
	 * This part is based on the mirror-inverted principle to the binary tree
	 * logic. It connects two above nodes with one below node.
	 * 
	 * @param countAct
	 *            ID of searched node in every act
	 * @param actID
	 *            Current act
	 * @author Ulko, Michael
	 */
	private void tree2Half(int countAct, int actID) {
		/*
		 * Slip until a tree has only one below node without adjacent nodes in
		 * its second half
		 */
		for (int i = 1; i <= 7; i++) {
			/* Find the first 'parent' node */
			searchNodeLeftSide(this.node, countAct);
			/* Find the second 'parent' node */
			searchNodeRightSide(this.node, countAct += 1);
			/* If here should be placed a shop level */
			if (i == 2 || i == 4) {
				/* Create new below node for a shop level */
				createBelowNodesTrader(node1, node2, actID);
			} /* If here should be placed a boss level */
			else if (i == 7) {
				/* Create new below node for boss level */
				createBelowNodeBoss(this.node1, this.node2, actID);
			} /* Here is placed a normal level with labyrinth */
			else {
				/* Create new below node and connect it with its two 'parents' */
				createBelowNode(this.node1, this.node2, actID);
			}
			// createBelowNode(this.node1, this.node2, actID);
			/* Update the control variable */
			countAct++;
		}
	}

	/**
	 * Connect the last node from above tree with the first node of below tree
	 * 
	 * @param last
	 *            Last node from above tree
	 * @param first
	 *            First node of below tree
	 * @author Ulko, Michael
	 */
	private void connectActTrees(Node last, Node first) {
		last.setSon(first);
		first.setFather(last);
	}

	/* Stay for the first node of every sub-tree */
	private int counterAct1 = 1;
	private int counterAct2 = 23;
	private int counterAct3 = 45;

	/* First nodes in every sub-tree */
	private static Node nodeAct1 = null;
	private static Node nodeAct2 = null;
	private static Node nodeAct3 = null;

	/**
	 * Give back the fisrt node in the first sub-tree.
	 * 
	 * @return First node in the first sub-tree
	 * @author Ulko, Michael
	 */
	public static Node getNodeAct1() {
		return nodeAct1;
	}

	/**
	 * Give back the first node in the second sub-tree.
	 * 
	 * @return First node in the second sub-tree
	 * @author Ulko, Michael
	 */
	public static Node getNodeAct2() {
		return nodeAct2;
	}

	/**
	 * Give back the fisrt node in the third sub-tree.
	 * 
	 * @return First node in the third sub-tree
	 * @author Ulko, Michael
	 */
	public static Node getNodeAct3() {
		return nodeAct3;
	}

	/**
	 * Initialize the first node in the first sub-tree
	 * 
	 * @param nodeAct1
	 * @author Ulko, Michael
	 */
	public static void setNodeAct1(Node nodeAct1) {
		LevelTree.nodeAct1 = nodeAct1;
	}

	/**
	 * Initialize the first node in the second sub-tree
	 * 
	 * @param nodeAct2
	 * @author Ulko, Michael
	 */
	public static void setNodeAct2(Node nodeAct2) {
		LevelTree.nodeAct2 = nodeAct2;
	}

	/**
	 * Initialize the first node in the third sub-tree
	 * 
	 * @param nodeAct1
	 * @author Ulko, Michael
	 */
	public static void setNodeAct3(Node nodeAct3) {
		LevelTree.nodeAct3 = nodeAct3;
	}

	/* Represent the below left node in 1.half of 1.sub-tree */
	private int countAct1 = 8;
	/* Represent the below left node in 1.half of 2.sub-tree */
	private int countAct2 = 30;
	/* Represent the below left node in 1.half of 3.sub-tree */
	private int countAct3 = 52;

	/* Secure variable which allows the access to monsterList and itemList */
	private boolean levelIsGenerated = false;

	/**
	 * Receive the permission for an acces to monsterList and itemList
	 * 
	 * @return Permission
	 * @author Ulko, Michael
	 */
	public boolean getLevelIsGenerated() {
		return levelIsGenerated;
	}

	/**
	 * Create the whole game tree which consists of three sub-trees each with 22
	 * nodes
	 */

	public void createTreeCompletely() {
		/* First act */
		act1 = true;
		/* Create the start room */
		setStartRoom();
		/* Set the first node of the first sub-tree */
		setNode(counterAct1, ob.createLevel(1, counterAct1));
		/* Connect start room with the first room of the first sub-tree */
		connectStartWithRoot();
		/* Update the root of new sub-tree */
		LevelTree.setNodeAct1(this.node);

		/* Build the first half of the first sub-tree */
		tree1Half(this.node);
		/* Build the second half of the first sub-tree */
		tree2Half(this.countAct1, 1);

		/* Second act */
		act1 = false;
		act2 = true;
		/* Set the first node of the second sub-tree */
		setNode(counterAct2, ob.createLevel(2, counterAct2));
		/* Update the root of new sub-tree */
		LevelTree.setNodeAct2(this.node);
		/* Connect the first and second sub-trees */
		connectActTrees(this.node2.getSon(), this.node);
		/* Build the first half of the second sub-tree */
		tree1Half(this.node);
		/* Build the second half of the second sub-tree */
		tree2Half(this.countAct2, 2);

		/* Third act */
		act2 = false;
		act3 = true;
		/* Set the first node of the third sub-tree */
		setNode(counterAct3, ob.createLevel(3, counterAct3));
		LevelTree.setNodeAct3(this.node);
		/* Connect the second and third sub-trees */
		connectActTrees(this.node2.getSon(), this.node);
		/* Build the first half of the third sub-tree */
		tree1Half(this.node);
		/* Build the second half of the third sub-tree */
		tree2Half(this.countAct3, 3);
		/* Update secure variable */
		this.levelIsGenerated = true;

		if (this.levelIsGenerated) {
			System.out.println("Die Baumstruktur wurde erzeugt. "
					+ "Jeder Knoten enthaelt ein fertiges Level.");
			System.out.println();
		}

	}

}
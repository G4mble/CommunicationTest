package komponente.map;

import java.util.Vector;

/**
 * Create the tree, MonsterList and ItemList completely
 * 
 * @author Ulko, Michael
 */
public class LevelGenerator {

	/* Objects */
	private static LevelTree lt = new LevelTree();
	private Level_Basic lb = new Level_Basic();

	/**
	 * Generate a whole tree for the game
	 * 
	 * @author Ulko, Michael
	 */
	public void createTree() {
		lt.createTreeCompletely();
	}

	/**
	 * This function gives a list with all monster positions for all levels
	 * 
	 * @author Ulko, Michael
	 */
	public Vector<Integer>[] getMonsterList() {
		/* If a level tree was build and every node has ID and level */
		if (lt.getLevelIsGenerated()) {
			return Level_Ready.getMonsterList();
		} else {
			return null;
		}
	}

	/**
	 * This function gives a list with all item positions for all levels
	 * 
	 * @author Ulko, Michael
	 */
	public Vector<Integer>[] getItemList() {
		/* If a level tree was build and every node has ID and level */
		if (lt.getLevelIsGenerated()) {
			return Level_Ready.getItemList();
		} else {
			return null;
		}
	}

	/**
	 * Print map, monster and items positions of every node for tree.
	 * 
	 * @author Ulko, Michael
	 */
	public void printAllInfoAboutAllLevels() {
		/* If the tree is created */
		if (lt.getLevelIsGenerated()) {
			/* Print the start level */
			System.out.println("Level 0 (Startlevel)");
			System.out.println();
			lb.printArray(LevelTree.getStartNode().getLevel());
			for (int i = 1; i <= 66; i++) {
				/* Print map */
				System.out.println("Level " + i);
				System.out.println();
				lb.printArray(getSearchedNode(i).getLevel());
				/* Print amount and positions of monsters in the selected map */
				printMonsterOneElement(Level_Ready.getMonsterList(), i);
				System.out.println();
				/* Print amount and positions of items in the selected map */
				printItemOneElement(Level_Ready.getItemList(), i);
				System.out.println();
			}
		}
	}

	/**
	 * Print map, monster and item positions of one special node.
	 * 
	 * @param levelID
	 *            Wished level (= node number from 1 to 66)
	 * @author Ulko, Michael
	 */
	public void printAllInfoAboutOneLevel(int levelID) {
		/* If the tree is created */
		if (lt.getLevelIsGenerated()) {
			if (levelID == 0) {
				lb.printArray(LevelTree.getStartNode().getLevel());
			} else {
				/* Print map */
				lb.printArray(getSearchedNode(levelID).getLevel());
				/* Print amount and positions of monsters in the selected map */
				printMonsterOneElement(Level_Ready.getMonsterList(), levelID);
				System.out.println();
				/* Print amount and positions of items in the selected map */
				printItemOneElement(Level_Ready.getItemList(), levelID);
				System.out.println();
			}
		}
	}

	/**
	 * Find one special node.
	 * 
	 * @param nodeID
	 *            Number of searched node
	 * @return Searched node
	 * @author Ulko, Michael
	 */
	public Node getSearchedNode(int nodeID) {
		if (lt.getLevelIsGenerated()) {
			decideActNode(nodeID);
			return this.searchedNode;
		} else {
			return null;
		}
	}

	/* Helping methods */

	/* Control variable */
	private Node searchedNode;

	/**
	 * Decide which act should be chosen.
	 * 
	 * @param nodeID
	 *            Number of searched node
	 * @author Ulko, Michael
	 */
	private void decideActNode(int nodeID) {
		int border;
		if (nodeID >= 1 && nodeID <= 22) {
			border = LevelTree.getNodeAct1().getNodeNr() + 21;
			searchNode(LevelTree.getNodeAct1(), nodeID, border);
		}
		if (nodeID >= 23 && nodeID <= 44) {
			border = LevelTree.getNodeAct2().getNodeNr() + 21;
			searchNode(LevelTree.getNodeAct2(), nodeID, border);
		}
		if (nodeID >= 45 && nodeID <= 66) {
			border = LevelTree.getNodeAct3().getNodeNr() + 21;
			searchNode(LevelTree.getNodeAct3(), nodeID, border);
		}
	}

	/**
	 * Find the searched node.
	 * 
	 * @param nodeAct
	 *            First node of every sub-tree
	 * @param nodeID
	 *            Number of searched node
	 * @param border
	 *            Number of last node in the sub-tree, where should be searched
	 * @author Ulko, Michael
	 */
	private void searchNode(Node nodeAct, int nodeID, int border) {
		boolean setOrNot = false;
		if (nodeAct.getNodeNr() == nodeID) {
			setOrNot = true;
		} else {
			if (nodeAct.getLeftSon() != null
					&& nodeAct.getLeftSon().getNodeNr() <= border) {
				searchNode(nodeAct.getLeftSon(), nodeID, border);
			}
			if (nodeAct.getRightSon() != null
					&& nodeAct.getRightSon().getNodeNr() <= border) {
				searchNode(nodeAct.getRightSon(), nodeID, border);
			}
			if (nodeAct.getSon() != null
					&& nodeAct.getSon().getNodeNr() <= border) {
				searchNode(nodeAct.getSon(), nodeID, border);
			}
		}
		if (setOrNot) {
			this.searchedNode = nodeAct;
		}
	}

	/**
	 * Traverse created tree and show the map placed in each node.
	 * 
	 * @author Ulko, Michael
	 */
	public void traverseTreePrintLevel() {
		if (lt.getLevelIsGenerated()) {
			for (int i = 1; i <= 66; i++) {
				System.out.println("Level: " + i);
				lb.printArray(getSearchedNode(i).getLevel());
			}
		}
	}

	/**
	 * Give back the amount of monsters in the array of Vector and positions of
	 * every monster in the level.
	 * 
	 * @param list
	 *            Should contain positions of monsters
	 * @param actID
	 *            Current act
	 * @param levelID
	 *            Current level
	 * @author Ulko, Michael
	 */
	private void printMonsterOneElement(Vector<Integer>[] list, int levelID) {
		if (lt.getLevelIsGenerated()) {
			int counter = 0;
			int monsterCounter = 1;
			System.out.println("Level: " + levelID);
			System.out.println("Art des Charakters: "
					+ list[levelID - 1].get(counter));
			System.out.println("Anzahl Monster im Level: "
					+ list[levelID - 1].get(counter += 1));
			while (counter < list[levelID - 1].size() - 1) {
				System.out.print("Monster " + monsterCounter
						+ " hat folgende Positionen: ");
				System.out.print("posX = "
						+ list[levelID - 1].get(counter += 1));
				System.out.println("\tposY = "
						+ list[levelID - 1].get(counter += 1));
				monsterCounter++;
			}
		}
	}

	/* Print the whole MonsterList */
	public void printMonsterList() {
		if (lt.getLevelIsGenerated()) {
			for (int i = 1; i <= 66; i++) {
				printMonsterOneElement(getMonsterList(), i);
				System.out.println();
			}
		}
	}

	/**
	 * Give back the amount of items in the array of Vector and positions of
	 * every item in the level.
	 * 
	 * @param list
	 *            Should contain positions of items
	 * @param actID
	 *            Current act
	 * @param levelID
	 *            Current level
	 * @author Ulko, Michael
	 */
	private void printItemOneElement(Vector<Integer>[] list, int levelID) {
		if (lt.getLevelIsGenerated()) {
			int counter = 0;
			int itemCounter = 1;
			System.out.println("Level: " + levelID);
			System.out.println("Anzahl Items im Level: "
					+ list[levelID - 1].get(counter));
			while (counter < list[levelID - 1].size() - 1) {
				System.out.print("Item " + itemCounter
						+ " hat folgende Positionen: ");
				System.out.print("posX = "
						+ list[levelID - 1].get(counter += 1));
				System.out.println("\tposY = "
						+ list[levelID - 1].get(counter += 1));
				itemCounter++;
			}
		}
	}

	/**
	 * Print the whole ItemList with all vectors.
	 * 
	 * @author Ulko, Michael
	 */
	public void printItemList() {
		if (lt.getLevelIsGenerated()) {
			for (int i = 1; i <= 66; i++) {
				printItemOneElement(getItemList(), i);
				System.out.println();
			}
		}
	}

	/**
	 * Print all connections of selected node to other nodes.
	 * 
	 * @param nodeID
	 *            Number of node
	 * @author Ulko, Michael
	 */
	public void checkConnection(int nodeID) {
		Node searchedNode;
		if (nodeID == 0) {
			searchedNode = LevelTree.getStartNode();
		} else {
			searchedNode = getSearchedNode(nodeID);
		}
		System.out.println("Aktueller Knoten: " + searchedNode.getNodeNr());
		if (searchedNode.getFather() != null) {
			System.out.println("Direkter Vater vom Knoten: "
					+ searchedNode.getFather().getNodeNr());
		} else {
			System.out.println("Knoten hat keinen direkten Vater!");
		}
		if (searchedNode.getLeftFather() != null) {
			System.out.println("Linker Vater vom Knoten: "
					+ searchedNode.getLeftFather().getNodeNr());
		} else {
			System.out.println("Knoten hat keinen linken Vater!");
		}
		if (searchedNode.getRightFather() != null) {
			System.out.println("Rechter Vater vom Knoten: "
					+ searchedNode.getRightFather().getNodeNr());
		} else {
			System.out.println("Knoten hat keinen rechten Vater!");
		}
		if (searchedNode.getLeftSon() != null) {
			System.out.println("Linker Sohn vom Knoten: "
					+ searchedNode.getLeftSon().getNodeNr());
		} else {
			System.out.println("Knoten hat keinen linken Sohn!");
		}
		if (searchedNode.getRightSon() != null) {
			System.out.println("Rechter Sohn vom Knoten: "
					+ searchedNode.getRightSon().getNodeNr());
		} else {
			System.out.println("Knoten hat keinen rechten Sohn!");
		}
		if (searchedNode.getSon() != null) {
			System.out.println("Direkter Sohn vom Knoten: "
					+ searchedNode.getSon().getNodeNr());
		} else {
			System.out.println("Knoten hat keinen direkten Sohn!");
		}
		System.out.println();
	}

	// /**
	// * (Muss nach der Implementierung geloescht werden)
	// *
	// * @param levelID
	// * Nummer des Levels, welches uebergeben werden soll (= Nummer
	// * des Knotens)
	// * @return Doppeltes Array vom Typ Tile (= Karte)
	// */
	// public Tile[][] getMap(int levelID) {
	// /* Startlevel (= Nummer 0) */
	// if (levelID == 0) {
	// /*
	// * Dieser Befehl dient nur der Pruefung, ob richtige Karte
	// * uebergeben wird. Die soll nicht implementiert werden.
	// */
	//
	// lb.printArray(LevelTree.getStartNode().getLevel());
	// /*
	// * Das ist die Funktion, die dir eine Map aus dem Startlevel
	// * zurueckgibt. Die ist SEHR wichtig!!!
	// */
	// return LevelTree.getStartNode().getLevel();
	// } else {
	// /*
	// * Dieser Befehl dient nur der Pruefung, ob richtige Karte
	// * uebergeben wird. Die soll nicht implementiert werden.
	// */
	// lb.printArray(getSearchedNode(levelID).getLevel());
	//
	// /*
	// * Das ist die Funktion, die dir eine Map aus einem bestimmten
	// * Knoten zurueckgibt. Die ist SEHR wichtig!!!
	// */
	// return getSearchedNode(levelID).getLevel();
	// }
	// }
}
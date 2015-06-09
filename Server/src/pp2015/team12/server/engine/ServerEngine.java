package pp2015.team12.server.engine;

import java.util.ArrayList;
import java.util.Vector;

import pp2015.team12.server.map.LevelTree;
import pp2015.team12.server.map.Level_Basic;
import pp2015.team12.server.map.Level_Ready;
import pp2015.team12.server.map.Node;
import pp2015.team12.shared.character.DummyCharacter;
import pp2015.team12.shared.character.Monster;
import pp2015.team12.shared.character.Monster_Tank;
import pp2015.team12.shared.character.PlayerCharacter;
import pp2015.team12.shared.character.Warrior;
import pp2015.team12.shared.item.ItemModel;
import pp2015.team12.shared.map.Tile;
import pp2015.team12.shared.map.textures.RW_Border_1;
import pp2015.team12.shared.map.textures.UW_Floor_1;
import pp2015.team12.shared.message.ChatMsg;
import pp2015.team12.shared.message.Message;
import pp2015.team12.shared.message.MoveMsg;

/**
 * Saves and Update the Level, Item and Player data
 * 
 * @author Friedrich Murillo, Simon, 5802318
 */
public class ServerEngine
{

	private static LevelTree lt = new LevelTree();
	private Level_Basic lb = new Level_Basic();

	private Monster[] monsterList = new Monster[5];
	// private monsterList[] monsterLvlList = new monsterList[67];
	private Vector<Monster> monsterArray = new Vector<Monster>();

	// SE.getMonsterList()[17];

	// Monster[] monsterList = {new Monster_Tank( 0,0, 0, "Werner", 64,
	// 96,"Monster1")};

	private PlayerCharacter[] playerList = new PlayerCharacter[10];
	private int clientCount = 0;

	private MessageHandler messageHandler;
	private EventServer eventServer;

	/**
	 * ServerEngine
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public ServerEngine()
	{
		this.outgoingMessages = new ArrayList<ChatMsg>();
		this.messageHandler = new MessageHandler(this);
		this.messageHandler.start();

	}

	/**
	 * Create the whole level Tree
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public void createTree()
	{
		lt.createTreeCompletely();
	}

	Node currentNode;

	/**
	 * @return the currentNode
	 */
	public Node getCurrentNode()
	{
		return currentNode;
	}

	/**
	 * @param currentNode
	 *            the currentNode to set
	 */
	public void setCurrentNode(Node currentNode)
	{
		this.currentNode = currentNode;
	}

	/**
	 * return the levelId for the next map that must send to client and get the
	 * right vektor for Monster and Item list (-1)
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 * @param currentNode
	 * @param doorId
	 * @return nextLevelId for get right map
	 */
	public int getNextLevelId(Node currentNode, int doorId)
	{
		if (doorId == 1)
		{

			return currentNode.getFather().getNodeNr();

		} else if (doorId == 2)
		{
			return currentNode.getLeftFather().getNodeNr();
		} else if (doorId == 3)
		{
			return currentNode.getRightFather().getNodeNr();
		} else if (doorId == 4)
		{
			return currentNode.getSon().getNodeNr();
		} else if (doorId == 5)
		{
			return currentNode.getLeftSon().getNodeNr();
		} else
		{
			return currentNode.getRightSon().getNodeNr();
		}
	}

	/**
	 * update the current node wird wahrscheinlich nicht genutzt
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 * @param currentNode
	 * @param doorId
	 * @return Node
	 */
	public Node getNextNode(Node currentNode, int doorId)
	{
		if (doorId == 1)
		{
			return currentNode.getFather();
		} else if (doorId == 2)
		{
			return currentNode.getLeftFather();
		} else if (doorId == 3)
		{
			return currentNode.getRightFather();
		} else if (doorId == 4)
		{
			return currentNode.getSon();
		} else if (doorId == 5)
		{
			return currentNode.getLeftSon();
		} else
		{
			return currentNode.getRightSon();
		}
	}

	/**
	 * This function gives a list with all monster positions for all levels
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public Vector<Integer>[] getMonsterList()
	{
		/* If a level tree was build and every node has ID and level */
		if (lt.getLevelIsGenerated())
		{
			return Level_Ready.getMonsterList();
		} else
		{
			return null;
		}
	}

	/**
	 * This function gives a list with all item positions for all levels
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public Vector<Integer>[] getItemList()
	{
		/* If a level tree was build and every node has ID and level */
		if (lt.getLevelIsGenerated())
		{
			return Level_Ready.getItemList();
		} else
		{
			return null;
		}
	}

	/**
	 * Print map, monster and item positions of one special node.
	 * 
	 * @param levelID
	 *            Wished level (= node number from 1 to 66)
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public void printAllInfoAboutOneLevel(int levelID)
	{
		/* If the tree is created */
		if (lt.getLevelIsGenerated())
		{
			if (levelID == 0)
			{
				lb.printArray(LevelTree.getStartNode().getLevel());
			} else
			{
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
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public Node getSearchedNode(int nodeID)
	{
		if (lt.getLevelIsGenerated())
		{
			decideActNode(nodeID);
			return this.searchedNode;
		} else
		{
			return null;
		}
	}

	private Node searchedNode;

	/**
	 * Decide which act should be chosen
	 * 
	 * @param nodeID
	 *            Number of searched node
	 * @return Searched node
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	private void decideActNode(int nodeID)
	{
		int border;
		if (nodeID >= 1 && nodeID <= 22)
		{
			border = LevelTree.getNodeAct1().getNodeNr() + 21;
			searchNode(LevelTree.getNodeAct1(), nodeID, border);
		}
		if (nodeID >= 23 && nodeID <= 44)
		{
			border = LevelTree.getNodeAct2().getNodeNr() + 21;
			searchNode(LevelTree.getNodeAct2(), nodeID, border);
		}
		if (nodeID >= 45 && nodeID <= 66)
		{
			border = LevelTree.getNodeAct3().getNodeNr() + 21;
			searchNode(LevelTree.getNodeAct3(), nodeID, border);
		}
	}

	/**
	 * Find the searched node
	 * 
	 * @param nodeAct
	 * @param nodeID
	 *            Number of searched node
	 * @param border
	 * 
	 * @return Searched node
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	private void searchNode(Node nodeAct, int nodeID, int border)
	{
		boolean setOrNot = false;
		if (nodeAct.getNodeNr() == nodeID)
		{
			setOrNot = true;
		} else
		{
			if (nodeAct.getLeftSon() != null && nodeAct.getLeftSon().getNodeNr() <= border)
			{
				searchNode(nodeAct.getLeftSon(), nodeID, border);
			}
			if (nodeAct.getRightSon() != null && nodeAct.getRightSon().getNodeNr() <= border)
			{
				searchNode(nodeAct.getRightSon(), nodeID, border);
			}
			if (nodeAct.getSon() != null && nodeAct.getSon().getNodeNr() <= border)
			{
				searchNode(nodeAct.getSon(), nodeID, border);
			}
		}
		if (setOrNot)
		{
			this.searchedNode = nodeAct;
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
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	private void printMonsterOneElement(Vector<Integer>[] list, int levelID)
	{
		if (lt.getLevelIsGenerated())
		{
			int counter = 0;
			int monsterCounter = 1;
			System.out.println("Level: " + levelID);
			System.out.println("Art des Charakters: " + list[levelID - 1].get(counter));
			System.out.println("Anzahl Monster im Level: " + list[levelID - 1].get(counter += 1));
			while (counter < list[levelID - 1].size() - 1)
			{
				System.out.print("Monster " + monsterCounter + " hat folgende Positionen: ");
				System.out.print("posX = " + list[levelID - 1].get(counter += 1));
				System.out.println("\tposY = " + list[levelID - 1].get(counter += 1));
				monsterCounter++;
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
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	private void printItemOneElement(Vector<Integer>[] list, int levelID)
	{
		if (lt.getLevelIsGenerated())
		{
			int counter = 0;
			int itemCounter = 1;
			System.out.println("Level: " + levelID);
			System.out.println("Anzahl Items im Level: " + list[levelID - 1].get(counter));
			while (counter < list[levelID - 1].size() - 1)
			{
				System.out.print("Item " + itemCounter + " hat folgende Positionen: ");
				System.out.print("posX = " + list[levelID - 1].get(counter += 1));
				System.out.println("\tposY = " + list[levelID - 1].get(counter += 1));
				itemCounter++;
			}
		}
	}

	int textureWidth = 40;

	/**
	 * consistency check for the MoveMsg checks if the player walk in a wall, in
	 * a Monster or in an other Player
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 * @param message
	 */
	public void consistencyCheck(MoveMsg message)
	{
		int levelId = message.getCharacter().getLevelId();
		Tile[][] map = getMap(levelId);
		int clientId = message.getClientId();

		if (map != null)
		{
			// Bewegung nach rechts pruefen
			if (playerList[clientId].getPosX() < message.getnPosX())
			{
				// gucken ob keine wand rechts ist
				if (map[((message.getnPosX() + (this.textureWidth - 1)) / this.textureWidth)][message.getnPosY() / this.textureWidth].getAccessible() && map[((message.getnPosX() + (this.textureWidth - 1)) / this.textureWidth)][((message.getnPosY() + (this.textureWidth - 1)) / this.textureWidth)].getAccessible())
				{
					// gucken ob kein monster und kein anderer spieler rechts
					// steht
					if (this.checkMonster(message) && this.checkPlayer(message))
					{
						playerList[clientId].setPosX(message.getnPosX());
						playerList[clientId].setPosY(message.getnPosY());
						// TODO geupdatete playerlist rausschicken
					} else
					{
						// TODO Move message fehlgeschlagen
					}
				}
			}
			// Bewegung nach Links pruefen
			else if (playerList[clientId].getPosX() > message.getnPosX())
			{
				// gucken ob keine Wand links ist
				if (map[(message.getnPosX() / this.textureWidth)][(message.getnPosY() / this.textureWidth)].getAccessible() && map[(message.getnPosX() / this.textureWidth)][((message.getnPosY() + (this.textureWidth - 1)) / this.textureWidth)].getAccessible())
				{
					// gucken ob kein monster und kein anderer spieler rechts
					// steht
					if (this.checkMonster(message) && this.checkPlayer(message))
					{
						playerList[clientId].setPosX(message.getnPosX());
						playerList[clientId].setPosY(message.getnPosY());
						// TODO geupdatete playerlist rausschicken
					} else
					{
						// TODO Move message fehlgeschlagen
					}
				}
			}
			// Bewegung nach unten pruefen
			if (playerList[clientId].getPosY() < message.getnPosY())
			{
				// gucken ob keine Wand unten ist
				if (map[(message.getnPosX() / this.textureWidth)][((message.getnPosY() + (this.textureWidth - 1)) / this.textureWidth)].getAccessible() && map[((message.getnPosX() + (this.textureWidth - 1)) / this.textureWidth)][((message.getnPosY() + (this.textureWidth - 1)) / this.textureWidth)].getAccessible())
				{
					// gucken ob kein monster und kein anderer spieler rechts
					// steht
					if (this.checkMonster(message) && this.checkPlayer(message))
					{
						playerList[clientId].setPosX(message.getnPosX());
						playerList[clientId].setPosY(message.getnPosY());
						// TODO geupdatete playerlist rausschicken
					} else
					{
						// TODO Move message fehlgeschlagen
					}
				}
			}
			// Bewegung nach oben pruefen
			else if (playerList[clientId].getPosY() > message.getnPosY())
			{
				// gucken ob keine Wand oben ist
				if (map[(message.getnPosX() / this.textureWidth)][(message.getnPosY() / this.textureWidth)].getAccessible() && map[((message.getnPosX() + (this.textureWidth - 1)) / this.textureWidth)][(message.getnPosY() / this.textureWidth)].getAccessible())
				{
					// gucken ob kein monster und kein anderer spieler rechts
					// steht
					if (this.checkMonster(message) && this.checkPlayer(message))
					{
						playerList[clientId].setPosX(message.getnPosX());
						playerList[clientId].setPosY(message.getnPosY());
						// TODO geupdatete playerlist rausschicken
					} else
					{
						// TODO Move message fehlgeschlagen
					}
				}
			}
		}

	}

	private boolean checkPlayer(MoveMsg message)
	{
		// TODO Auto-generated method stub
		return false;
	}

	private boolean checkMonster(MoveMsg message)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the messageHandler
	 */
	public MessageHandler getMessageHandler()
	{
		return messageHandler;
	}

	/**
	 * @param messageHandler
	 *            the messageHandler to set
	 */
	public void setMessageHandler(MessageHandler messageHandler)
	{
		this.messageHandler = messageHandler;
	}

	/**
	 * If a Player Login a Dummy Character lock a free place in playerList
	 * (>=10) or send an "server full" msg
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public void addClient()
	{ // wird aufgerufen wenn ein nutzer sich einloggt
		if (this.clientCount == 10)
		{ // playerList.size()==10
			System.out.println("Der Server ist voll");
		} else
		{
			for (int i = 0; i < 10; i++)
			{
				if (playerList[i] == null)
				{
					playerList[i] = new DummyCharacter();
					// TODO diese clientId an thomas
					clientCount++;
					break;
				}
			}
		}
	}

	/**
	 * add a new Player to the playerList
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 * @param player
	 */
	public void addPlayer(PlayerCharacter player)
	{
		playerList[player.getClientId()] = player;
	}

	public int getclientId(int clientId)
	{
		int Id;
		Id = playerList[clientId].getClientId();
		return Id;
	}

	/**
	 * return the item list
	 * 
	 * @return itemList
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	// public Vector<Integer>[] getItemList(){
	// return itemList;
	// }

	/**
	 * add all Monsters to monsterList
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public void addMonsters()
	{

	}

	/**
	 * remove a player from playerList
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public void removePlayer(int clientId)
	{
		PlayerCharacter player = playerList[clientId];
		playerList[clientId] = null;
		// TODO send safe player message mit SE_III_Controller 
		clientCount--;
	}

	// Die test outgoingmsg
	ArrayList<ChatMsg> outgoingMessages;

	public void addOutgoingChatMsg(ChatMsg message)
	{
		this.outgoingMessages.add(message);

	}

	public ArrayList<ChatMsg> getAlloutgoingMessages()
	{
		return outgoingMessages;
	}

	public EventServer getEventServer()
	{
		return eventServer;
	}

	public void setEventServer(EventServer eventServer)
	{
		this.eventServer = eventServer;
	}

	/**
	 * Get the map of the Level levelID
	 * 
	 * @param levelID
	 *            Number of the wanted level
	 * @return Tile [][] Array
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public Tile[][] getMap(int levelID)
	{
		/* Startlevel (= Nummer 0) */
		if (levelID == 0)
		{
			/*
			 * Dieser Befehl dient nur der Pruefung, ob richtige Karte
			 * uebergeben wird. Die soll nicht implementiert werden.
			 */

			lb.printArray(LevelTree.getStartNode().getLevel());
			/*
			 * Das ist die Funktion, die eine Map aus dem Startlevel
			 * zurueckgibt.
			 */
			return LevelTree.getStartNode().getLevel();
		} else
		{
			/*
			 * Dieser Befehl dient nur der Pruefung, ob richtige Karte
			 * uebergeben wird. Die soll nicht implementiert werden.
			 */
			lb.printArray(getSearchedNode(levelID).getLevel());

			/*
			 * Das ist die Funktion, die eine Map aus einem bestimmten Knoten
			 * zurueckgibt.
			 */
			return getSearchedNode(levelID).getLevel();
		}
	}
}

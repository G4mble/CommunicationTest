package komponente.serverEngineI;

import java.util.ArrayList;
import java.util.Vector;

import komponente.map.LevelTree;
import komponente.map.Level_Basic;
import komponente.map.Level_Ready;
import komponente.map.Node;
import pp2015.team12.shared.character.DummyCharacter;
import pp2015.team12.shared.character.PlayerCharacter;
import pp2015.team12.shared.map.Tile;
import pp2015.team12.shared.message.ChatMsg;

/**
 * Saves and Update the Level, Item and Player data
 * 
 * @author Friedrich Murillo, Simon, 5802318
 */
public class ServerEngine
{

	private static LevelTree lt = new LevelTree();
	private Level_Basic lb = new Level_Basic();

	// private Monster[] monsterList = new Monster[5];
	// Monster[] monsterList = {new Monster_Tank( 0,0, 0, "Werner", 64,
	// 96,"Monster1")};

	private PlayerCharacter[] playerList = new PlayerCharacter[10];
	private int clientCount = 0;

	private MessageHandler messageHandler;
	private EventServer eventServer;

	/**
	 * Create the whole level Tree
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public void createTree()
	{
		lt.createTreeCompletely();
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

	public ServerEngine()
	{
		this.outgoingMessages = new ArrayList<ChatMsg>();
		this.messageHandler = new MessageHandler(this);
		this.messageHandler.start();
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
//		PlayerCharacter player = playerList[clientId];
		playerList[clientId] = null;
		// TODO send safe player message
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
			 * Das ist die Funktion, die eine Map aus einem bestimmten
			 * Knoten zurueckgibt.
			 */
			return getSearchedNode(levelID).getLevel();
		}
	}
}

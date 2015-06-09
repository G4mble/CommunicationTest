package pp2015.team12.server.engine;

import pp2015.team12.server.map.LevelTree;
import pp2015.team12.server.map.Level_Basic;
import pp2015.team12.server.map.Node;
import pp2015.team12.shared.InventoryModel;
import pp2015.team12.shared.character.Mage;
import pp2015.team12.shared.character.PlayerCharacter;
import pp2015.team12.shared.character.Warrior;
import pp2015.team12.shared.message.ChatMsg;
import pp2015.team12.shared.message.LoginRequestMsg;
import pp2015.team12.shared.statistics.StatisticsModel;

/**
 * Just for tests
 * 
 * @author Simon Friedrich Murillo
 */
public class TestServerMain
{

	public static void main(String[] args)
	{
		ServerEngine SE = new ServerEngine();
		
		//erstellen des Levelbaumes
		SE.createTree();  	
		

		//test-ChatMsg dem MessageHandler uebergeben
		SE.getMessageHandler().addNewMsg(new ChatMsg("Hallo", 1)); 
		
		//kleiner sleeptimer damit die nachricht zeit hat abzuspeichern
		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Node currentNode;
		// Der spieler steht nichtauf der Liste
		currentNode = LevelTree.getStartNode();
		System.out.println(SE.getNextLevelId(currentNode, 4));
		
		
		
		// Spieler ist in der Liste
//		int levelId = 27;
//		currentNode = SE.getSearchedNode(levelId);
		
//		
//		System.out.println(SE.getNextLevelId(currentNode, 5));
//		
//		currentNode = SE.getNextNode(currentNode, 5);
//		
//		
//		System.out.println(SE.getNextLevelId(currentNode, 4));

		// simuliert die ausgabe aller chat msg
		//System.out.println(SE.getAlloutgoingMessages().get(0).getContent());
		
		//wiedergabe des Startlevels
//		SE.getMap(0);	
		//wiedergabe eines Bosslevels Akt1
//		SE.getMap(22);
		//wiedergabe eines normalen levels Akt 2
//		SE.getMap(32);					
		
		
		// alle leveldaten eines lvl abfragen (map, level, akt, monster, items) (22, 44, 66 sind Boss-Level)
//		SE.printAllInfoAboutOneLevel(1); 	
//		SE.printAllInfoAboutOneLevel(22);
//		SE.printAllInfoAboutOneLevel(44);
//		SE.printAllInfoAboutOneLevel(66);
//		SE.printAllInfoAboutOneLevel(35);

		
		// Clients hinzufuegen
//		SE.addClient();
//		SE.addClient();
//		SE.addClient();
//		SE.addClient();
//		SE.addClient();
//		SE.addClient();
//		SE.addClient();
//		SE.addClient();
//		SE.addClient();
//		SE.addClient();
		//Server erkennt das sich schon 10 spieler eingeloggt haben und gibt eine 
		//"Server ist voll" Nachricht wieder. Wenn jedoch ein spieler Ausgeloggt
		//wird (removePlayer) koennen sich wieder neue clients anmelden
//		SE.removePlayer(2);
//		SE.removePlayer(3);
//		SE.addClient();
//		SE.addClient();

		// Simuliert ein Event was Monster 1 nach einer zeit wiederbeleben soll (hier ca.3 sekunden)
//		SE.getEventServer().startrespawnMonsterEvent(1);
		
		// Simuliert die einnahme eines Heiltrankes von spieler 3
//		SE.getEventServer().useHealthpotion(3);

		System.out.println(SE.getMonsterList()[17]);
		
		
	}

}

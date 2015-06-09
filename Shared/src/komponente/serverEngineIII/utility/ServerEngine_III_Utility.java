package komponente.serverEngineIII.utility;

import java.util.ArrayList;

import pp2015.team12.shared.InventoryModel;
import pp2015.team12.shared.character.PlayerCharacter;
import pp2015.team12.shared.item.ConsumableModel;
import pp2015.team12.shared.item.EquipmentModel;
import pp2015.team12.shared.item.ItemModel;
import pp2015.team12.shared.statistics.StatisticsModel;

/**
 * utility class used for console print operation
 * @author Staufenberg, Thomas, 5820359
 * */
public class ServerEngine_III_Utility
{
	/**
	 * prints all player information of the given player in the console</br>
	 * calls printStatisticsInformation() and printInventoryInformation()
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public static void printPlayerInformation(String paramDispatcher, PlayerCharacter paramPlayer)
	{
		System.out.println(paramDispatcher + ": Charakterinformation--------------------");
		System.out.println("Benutzername:	 " + paramPlayer.getUsername());
		System.out.println("Klasse:   	 " + paramPlayer.getCharacterName());
		System.out.println("Level: 	 	 " + paramPlayer.getLevel());
		System.out.println("Maximales Leben: " + paramPlayer.getMaximumLife());
		System.out.println("Aktuelles Leben: " + paramPlayer.getCurrentLife());
		System.out.println("Angriff: 	 " + paramPlayer.getAttack());
		System.out.println("Verteidigung:	 " + paramPlayer.getDefense());
		System.out.println("--------------------------------------------");
		ServerEngine_III_Utility.printStatisticsInformation(paramDispatcher, paramPlayer);
		ServerEngine_III_Utility.printInventoryInformation(paramDispatcher, paramPlayer);
	}
	
	/**
	 * prints all statistics information of the given player in the console
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private static void printStatisticsInformation(String paramDispatcher, PlayerCharacter paramPlayer)
	{
		StatisticsModel currentStatistics = paramPlayer.getStatistics();
		System.out.println(paramDispatcher + ": Statistikinformation--------------------");
		System.out.println("Benutzername: 	  " + paramPlayer.getUsername());
		System.out.println("Spielzeit:	  " + currentStatistics.getTimePlayed());
		System.out.println("Anzahl Kills:	  " + currentStatistics.getMonsterKillCount());
		System.out.println("Anzahl Tode:	  " + currentStatistics.getDeathCount());
		System.out.println("Gesammeltes Gold: " + currentStatistics.getGoldEarned());
		System.out.println("--------------------------------------------");
	}
	
	/**
	 * prints all inventory information of the given player in the console
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private static void printInventoryInformation(String paramDispatcher, PlayerCharacter paramPlayer)
	{
		InventoryModel currentInventory = paramPlayer.getInventory();
		EquipmentModel[] currentEquip = currentInventory.getEquipmentList();
		ItemModel[] currentInventoryContentList = currentInventory.getInventoryContentList();
		System.out.println(paramDispatcher + ": Inventarinformation--------------------");
		System.out.println("Benutzername: 	" + paramPlayer.getUsername());
		System.out.println("Gold: 		" + currentInventory.getGoldCount());
		System.out.println("Ruestungsteile: " + currentInventory.getArmorPartsCount());
		System.out.println("--------------------------------------------");
		System.out.println(paramDispatcher + ": Equipment--------------------");
		for(int i = 0; i < 5; i++)
		{
			if(currentEquip[i] != null)
			{
				EquipmentModel currentItem = currentEquip[i];
				System.out.println("Ausruestungplatz " + (i + 1) + ": " + currentItem.getItemName() + " Level: " + currentItem.getLevelRestriction() + " Angriff: " + currentItem.getAttackValue() + " Verteidigung: " + currentItem.getDefenseValue() + " Lebensbonus: " + currentItem.getHpValue() + " Verkaufswert: " + currentItem.getItemGoldValue() + " Ruestungsteile beim Zerlegen: " + currentItem.getArmorPartsRevenue());
			}
			else
				System.out.println("Ausruestungplatz " + (i + 1) + ": leer");
		}
		
		System.out.println(paramDispatcher + ": Inventar--------------------");
		for(int i = 0; i < 10; i++)
		{
			try
			{
				ItemModel currentItem = currentInventoryContentList[i];
				if(currentItem instanceof EquipmentModel)
				{
					EquipmentModel currentTmpItem = (EquipmentModel) currentItem;
					System.out.println("Inventarplatz " + (i + 1) + ": " + currentTmpItem.getItemName() + " Level: " + currentTmpItem.getLevelRestriction() + " Angriff: " + currentTmpItem.getAttackValue() + " Verteidigung: " + currentTmpItem.getDefenseValue() + " Lebensbonus: " + currentTmpItem.getHpValue() + " Verkaufswert: " + currentTmpItem.getItemGoldValue() + " Ruestungsteile beim Zerlegen: " + currentTmpItem.getArmorPartsRevenue());
				}
				else
				{
					ConsumableModel currentTmpItem = (ConsumableModel) currentItem;
					System.out.println("Inventarplatz " + (i + 1) + ": " + currentTmpItem.getItemName() + " Anzahl: " + currentTmpItem.getStackSize() + " Verkaufswert: " + currentTmpItem.getItemGoldValue());
				}
			}
			catch(IndexOutOfBoundsException iOoBE)
			{
				for(int j = i; j < 10; j++)
					System.out.println("Inventarplatz " + (j + 1) + ": leer");
				break;
			}
		}
		System.out.println("--------------------------------------------");
	}
	
	/**
	 * prints the given globalInventoryList in the console
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public static void printGlobalInventory(ArrayList<ItemModel> paramGlobalInventory)
	{
		System.out.println("--------------------Globales Inventar--------------------");
		for(int i = 0; i < paramGlobalInventory.size(); i++)
			System.out.println("Globales Inventar Platz " + (i + 1) + ": " + paramGlobalInventory.get(i).getItemName());
		System.out.println("--------------------------------------------");
	}
	
	/**
	 * prints the given highscore data in the console
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public static void printHighscoreData(Object[][] paramHighscoreData)
	{
		if(paramHighscoreData != null)
		{
			for(int i = 0; i < paramHighscoreData.length; i++)
				System.out.println("Name: " + paramHighscoreData[i][0] + " Kills: " + paramHighscoreData[i][1] + " Tode: " + paramHighscoreData[i][2] + " Gold: " + paramHighscoreData[i][3] + " Spielzeit: " + paramHighscoreData[i][4]);
		}
		else
			System.err.println("Highscore konnte nicht geladen werden!");
	}
}
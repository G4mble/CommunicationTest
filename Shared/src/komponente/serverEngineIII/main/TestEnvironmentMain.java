package komponente.serverEngineIII.main;

import java.util.Scanner;

import komponente.serverEngineIII.platform.ProgramController;
import komponente.serverEngineIII.utility.ServerEngine_III_Utility;

/**
 * main class of the test environment
 * @author Staufenberg, Thomas, 5820359
 * */
public class TestEnvironmentMain
{
	private static boolean inspectIncremental = false;
	private static Scanner scan = new Scanner(System.in);
	/**
	 * main method, starts the program by creating new ProgramController
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public static void main(String[] args)
	{
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------specify desired values for the testrun---------------------------------------------------------------*/
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		
/*username and password	*/
		
		String username = "Thomas";
		String password = "Staufenberg";
		
/*character selection
 * 1: Warrior
 * 2: Mage */
		
		int charID = 1;
		
/*statistics and player modification*/
		
		int addKills = 25;
		int addDeaths = 5;
		int addTimePlayed = 100;
		int increaseLevelBy = 4;
		int decreaseCurrentLifeBy = 80;
		
/*number of calls to the generateRandomItem() method
 * each call can create up to 2 items*/
		
		int generateItemCount = 20;
		
/*number of items the user tries to pickup in the first pickup sequence
 * NOTE: inventorySize = 10*/
		
		int pickupItemCount_seqOne = 11;
		
/*number of items the user tries to pickup in the second pickup sequence
 * NOTE: inventorySize = 10*/
				
		int pickupItemCount_seqTwo = 10;
		
/*number of items the user tries to sell
 * NOTE: values > 10 will lead to an error*/
		
		int itemSellCount = 5;
		
/*number of items the user tries to drop
 * NOTE: values > 10 will lead to an error*/
				
		int itemDropCount = 5;
		
/*gold and armorParts modification
 * this modification will be executed between crafting process 2 and 3*/
		
		int addGold = 100000;
		int addArmorParts = 5000;
		
/*specify itemIndex for crafting purpose
 *  itemIndex:
 *  0: Einhandschwert
 *  1: Zweihandschwert
 *  2: Schild
 *  3: Helm
 *  4: Brustschutz
 *  5: Stiefel
 *  crafting process will be executed 4 times
 * */
		int itemIndex_one = 2;
		int itemIndex_two = 0;
		int itemIndex_three = 5;
		int itemIndex_four = 3;
		
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------*/
/*------------------------------fixed value changes below this point are not provided and may lead to unhandled exceptions-------------------------------------*/
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------*/		
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("----------------------------Beginn des Testdurchlaufs-----------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		
		ProgramController programController = new ProgramController();
		
		System.out.println("Registriere neuen Benutzer. --> Username: " + username + ", Passwort: " + password);
		System.out.println("Waehle Charakter aus, charID: " + charID);
		TestEnvironmentMain.waitForUserReady();
		programController.initiateRegistrationProcess(username, password, charID);
		System.out.println("----------------------------------------------------------------------------------");
		if(programController.isLoggedIn())
		{
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Benutzer loggt sich aus.");
			TestEnvironmentMain.waitForUserReady();
			programController.logoutUser();
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Ein weiterer Benutzer versucht sich mit dem gleichen Benutzernamen zu registrieren.");
			TestEnvironmentMain.waitForUserReady();
			programController.initiateRegistrationProcess(username, password, charID);
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Benutzer loggt sich mit falschem Passwort ein.");
			TestEnvironmentMain.waitForUserReady();
			programController.initiateLoginProcess(username, (password + "x"));
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Benutzer loggt sich mit richtigem Passwort ein.");
			TestEnvironmentMain.waitForUserReady();
			programController.initiateLoginProcess(username, password);
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("Modifiziere Kills...");
			TestEnvironmentMain.waitForUserReady();
			programController.modifyPlayerValues("killCount", addKills);
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Modifiziere Tode....");
			TestEnvironmentMain.waitForUserReady();
			programController.modifyPlayerValues("deathCount", addDeaths);
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Modifiziere Spielzeit....");
			TestEnvironmentMain.waitForUserReady();
			programController.modifyPlayerValues("timePlayed", addTimePlayed);
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Modifiziere Level....");
			TestEnvironmentMain.waitForUserReady();
			programController.modifyPlayerValues("level", increaseLevelBy);
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Modifiziere aktuelles Leben....");
			TestEnvironmentMain.waitForUserReady();
			programController.modifyPlayerValues("currentLife", decreaseCurrentLifeBy);
			
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Benutzer toetet mehrere Monster oder oeffnet einige Schatztruhen --> " + generateItemCount + " Items werden generiert.");
			TestEnvironmentMain.decideOnStepSize("Generieren der Items");
			for(int i = 0; i < generateItemCount; i++)
			{
				programController.createNewItem();
				System.out.println("----------------------------------------------------------------------------------");
				if(TestEnvironmentMain.inspectIncremental)
					TestEnvironmentMain.waitForUserReady();
			}
			
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Benutzer versucht die ersten " + pickupItemCount_seqOne + " Items aus dem globalen Invetar aufzunehmen.");
			TestEnvironmentMain.decideOnStepSize("Aufheben der Items");
			for(int i = 0; i < pickupItemCount_seqOne; i++)
			{
				programController.pickupItem();
				System.out.println("----------------------------------------------------------------------------------");
				if(TestEnvironmentMain.inspectIncremental)
					TestEnvironmentMain.waitForUserReady();
			}
			
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Benutzer versucht der Reihe nach die Items in den Inventarplaetzen 1 - 10 auszuruesten.");
			TestEnvironmentMain.decideOnStepSize("Ausruesten der Items");
			for(int i = 0; i < 10; i++)
			{
				programController.equipItem(i);
				System.out.println("----------------------------------------------------------------------------------");
				if(TestEnvironmentMain.inspectIncremental)
					TestEnvironmentMain.waitForUserReady();
			}
			
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Benutzer versucht der Reihe nach die Items in dem Inventarplaetzen 1 - 10 zu benutzen(konsumieren).");
			TestEnvironmentMain.decideOnStepSize("Benutzen der Items");
			for(int i = 0; i < 10; i++)
			{
				programController.consumeItem(i);
				System.out.println("----------------------------------------------------------------------------------");
				if(TestEnvironmentMain.inspectIncremental)
					TestEnvironmentMain.waitForUserReady();
			}
			
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Benutzer versucht der Reihe nach die ersten " + itemSellCount + " Items in seinem Inventar zu verkaufen.");
			TestEnvironmentMain.decideOnStepSize("Verkaufen der Items");
			for(int i = 0; i < itemSellCount; i++)
			{
				programController.sellItem();
				System.out.println("----------------------------------------------------------------------------------");
				if(TestEnvironmentMain.inspectIncremental)
					TestEnvironmentMain.waitForUserReady();
			}
			
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Benutzer versucht der Reihe nach die ersten " + itemDropCount + " Items in seinem Inventar abzulegen.");
			TestEnvironmentMain.decideOnStepSize("Ablegen der Items");
			for(int i = 0; i < itemDropCount; i++)
			{
				programController.dropItem();
				System.out.println("----------------------------------------------------------------------------------");
				if(TestEnvironmentMain.inspectIncremental)
					TestEnvironmentMain.waitForUserReady();
			}
			
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Benutzer versucht erneut " + pickupItemCount_seqTwo + " Items aus dem globalen Invetar aufzunehmen.");
			TestEnvironmentMain.decideOnStepSize("Aufnehmen der Items");
			for(int i = 0; i < pickupItemCount_seqTwo; i++)
			{
				programController.pickupItem();
				System.out.println("----------------------------------------------------------------------------------");
				if(TestEnvironmentMain.inspectIncremental)
					TestEnvironmentMain.waitForUserReady();
			}
			
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Benutzer versucht der Reihe nach die Items in den Inventarplaetzen 1 - 10 zu zerlegen.");
			TestEnvironmentMain.decideOnStepSize("Zerlegen der Items");
			for(int i = 0; i < 10; i++)
			{
				programController.salvageItem(i);
				System.out.println("----------------------------------------------------------------------------------");
				if(TestEnvironmentMain.inspectIncremental)
					TestEnvironmentMain.waitForUserReady();
			}
			
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Benutzer versucht einige Items zu craften.");
			TestEnvironmentMain.waitForUserReady();

			programController.craftItem(itemIndex_one);
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			
			programController.craftItem(itemIndex_two);
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			
			System.out.println("Modifieziere Ruestungsteile.");
			TestEnvironmentMain.waitForUserReady();
			programController.modifyPlayerValues("armorParts", addArmorParts);
			TestEnvironmentMain.waitForUserReady();
			System.out.println("Modifieziere Gold.");
			TestEnvironmentMain.waitForUserReady();
			programController.modifyPlayerValues("gold", addGold);
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			
			System.out.println("Benutzer versucht erneut einige Items zu craften.");
			TestEnvironmentMain.waitForUserReady();
			
			programController.craftItem(itemIndex_three);
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			
			programController.craftItem(itemIndex_four);
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			
			System.out.println("Zeige Highscore an. Sortiert nach: Benutzername (absteigened)");
			TestEnvironmentMain.waitForUserReady();
			ServerEngine_III_Utility.printHighscoreData(programController.updateHighscore("username"));
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			
			System.out.println("Zeige Highscore an. Sortiert nach: Anzahl Kills (absteigened)");
			TestEnvironmentMain.waitForUserReady();
			ServerEngine_III_Utility.printHighscoreData(programController.updateHighscore("monsterKillCount"));
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			
			System.out.println("Zeige Highscore an. Sortiert nach: Anzahl Tode (absteigened)");
			TestEnvironmentMain.waitForUserReady();
			ServerEngine_III_Utility.printHighscoreData(programController.updateHighscore("numberOfDeaths"));
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			
			System.out.println("Zeige Highscore an. Sortiert nach: gesammeltem Gold (absteigened)");
			TestEnvironmentMain.waitForUserReady();
			ServerEngine_III_Utility.printHighscoreData(programController.updateHighscore("goldEarned"));
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
			
			System.out.println("Zeige Highscore an. Sortiert nach: Spielzeit (absteigened)");
			TestEnvironmentMain.waitForUserReady();
			ServerEngine_III_Utility.printHighscoreData(programController.updateHighscore("timePlayed"));
			System.out.println("----------------------------------------------------------------------------------");
			TestEnvironmentMain.waitForUserReady();
		}
		else
		{
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------------------------");
			System.err.println("\n\nOffensichtlich haben sie die Testumgebung bereits zuvor ausgefuehrt.\n"
					+ "Da die Daten noch immer in der Datenbank stehen, muss die Datenbank vor erneuter Nutzung bereinigt werden.\n"
					+ "Moechten sie diesen Vorgang jetzt ausfuehren?\nJa: y || Nein: n");
			String input = TestEnvironmentMain.scan.next();
			if(input.equals("y"))
				programController.initiateDBCleanUp();
		}
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("------------------------------Ende des Testdurchlaufs-----------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		
		TestEnvironmentMain.scan.close();
	}
	
	private static void decideOnStepSize(String paramAction)
	{
		System.out.println("Das " + paramAction +" der Items Schrittweise betrachten?\nJa: y || Nein: beliebige Taste");
		TestEnvironmentMain.inspectIncremental = false;
		String input = TestEnvironmentMain.scan.next();
		if(input.equals("y"))
			TestEnvironmentMain.inspectIncremental = true;
	}
	
	private static void waitForUserReady()
	{
		System.out.println("Beliebige Eingabe + Enter zum Fortfahren.");
		TestEnvironmentMain.scan.next();
	}
}
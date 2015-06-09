package komponente.serverEngineIII.engine;

import java.util.ArrayList;
import java.util.Random;

import pp2015.team12.shared.InventoryModel;
import pp2015.team12.shared.character.PlayerCharacter;
import pp2015.team12.shared.item.Boots;
import pp2015.team12.shared.item.ChestArmor;
import pp2015.team12.shared.item.ConsumableModel;
import pp2015.team12.shared.item.EquipmentModel;
import pp2015.team12.shared.item.GoldStack;
import pp2015.team12.shared.item.HealthPotion;
import pp2015.team12.shared.item.Helmet;
import pp2015.team12.shared.item.ItemModel;
import pp2015.team12.shared.item.ManaPotion;
import pp2015.team12.shared.item.OneHandedWeapon;
import pp2015.team12.shared.item.Shield;
import pp2015.team12.shared.item.TwoHandedWeapon;

/**
 * contains all logic for item crafting and random generation
 * @author Staufenberg, Thomas, 5820359
 * */
public class ItemManager
{
	private PlayerCharacter activePlayer;
	private int currentPlayerLevel;
	
	/**
	 * reads the playerLevel from the given player and stores them both in gloabl variables
	 * in global variables
	 * @param paramActivePlayer the player that tries to craft an item or for whom the item is to be generated
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public ItemManager(PlayerCharacter paramActivePlayer)
	{
		this.activePlayer = paramActivePlayer;
		this.currentPlayerLevel = this.activePlayer.getLevel();
	}
	
	/**
	 * generates new equipment according to given selectionID</br>is used by 'random world drops' and the crafting system</br>
	 * adds the generated item to the players inventory (if isCrafted)
	 * @param paramSelectionID equipSlotID of the item to be generated
	 * @param paramIsCrafted wether the item is generated in a crafting process(true) or 'randomly dropped'
	 * @return null: if isCrafted</br>the generated equipment if its a random drop
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private EquipmentModel generateNewEquipment(int paramSelectionID, boolean paramIsCrafted)
	{
		System.out.println("ItemManager: Erzeuge neues Equipment. isCrafted = " + paramIsCrafted);
		Random randomGenerator = new Random();
		//calculate range used to generate some random values
		int range = (int) ((5 / (double) 7) + ( this.currentPlayerLevel * (2 / (double) 7)));
		int currentID = -1;
		//calculate levelRestriction depending on playerLevel and if the item is not crafted add a random value (0;1)
		int currentLevelRestriction = this.currentPlayerLevel;
		if(!paramIsCrafted)
			currentLevelRestriction += randomGenerator.nextInt(2);
		int currentAtkValue = 0;
		int currentDefValue = 0;
		int currentHpValue = 0;
		
		//calculate values for weapons
		if(paramSelectionID < 2)
		{
			//calculate base values
			currentAtkValue = ((currentLevelRestriction * 4) / 9) + 4 + randomGenerator.nextInt(range);
			currentDefValue = (int)((currentLevelRestriction - 1) * (4 / (double)9) + 2 + randomGenerator.nextInt(range));
			currentHpValue = (int)(((currentLevelRestriction - 4) * (4 / (double)10)) + 2 + randomGenerator.nextInt(range));
			//add bonus/malus to base values depending on probability
			if(randomGenerator.nextInt(100) >= 80)
				currentDefValue *= randomGenerator.nextInt(2);
			if(randomGenerator.nextInt(100) >= 90)
				currentHpValue *= randomGenerator.nextInt(2);
			if(randomGenerator.nextInt(100) >= 90)
				currentAtkValue -= randomGenerator.nextInt(((int) Math.round(range/(double)2)));
			//add random bonus values for two hand weapons
			if(paramSelectionID == 1)
			{
				currentAtkValue *= (Math.round(((double)2 - (double)randomGenerator.nextDouble())));
				currentDefValue *= (Math.round(((double)2 - (double)randomGenerator.nextDouble())));
				currentHpValue *= (Math.round(((double)2 - (double)randomGenerator.nextDouble())));
			}
		}
		//calculate values for equipment that is not a weapon
		else
		{
			//calculate base values
			currentAtkValue = (int)((currentLevelRestriction - 1) * (4 / (double)9) + 2 + randomGenerator.nextInt(range));
			currentDefValue = ((currentLevelRestriction * 4) / 9) + 4 + randomGenerator.nextInt(range);
			currentHpValue = (int)(((currentLevelRestriction - 3) * (4 / (double)10)) + 1 + randomGenerator.nextInt(range));
			//add bonus/malus to base values depending on probability
			if(randomGenerator.nextInt(100) >= 90)
				currentDefValue -= randomGenerator.nextInt(((int) Math.round(range/(double)2)));
			if(randomGenerator.nextInt(100) >= 90)
				currentHpValue *= randomGenerator.nextInt(2);
			if(randomGenerator.nextInt(100) >= 80)
				currentAtkValue *= randomGenerator.nextInt((2));
		}
		
		//calculate gold value
		int currentGoldValue = (int)((currentAtkValue + currentDefValue + currentHpValue) * (currentLevelRestriction / (double)5) + 1);
		
		//modify item values even more if the item got crafted
		if(paramIsCrafted)
		{
			//level 1 P(0,61 <= X <= 0,64)
			if(randomGenerator.nextInt(100) >= 40)
				currentAtkValue += randomGenerator.nextInt(range);
			if(randomGenerator.nextInt(100) >= 38)
				currentDefValue += randomGenerator.nextInt(range);
			if(randomGenerator.nextInt(100) >= 36)
				currentHpValue += randomGenerator.nextInt(range);
			
			//level 2 P(0,09 <= X <= 0,18)
			if(randomGenerator.nextInt(100) >= 90)
				currentAtkValue += range;
			if(randomGenerator.nextInt(100) >= 87)
				currentDefValue += range;
			if(randomGenerator.nextInt(100) >= 83)
				currentHpValue += range;
			
			//level 3 P(0,02 <= X <= 0,04)
			if(randomGenerator.nextInt(100) >= 99)
				currentAtkValue *= ((double)2 - (double)randomGenerator.nextDouble());
			if(randomGenerator.nextInt(100) >= 98)
				currentDefValue *= ((double)2 - (double)randomGenerator.nextDouble());
			if(randomGenerator.nextInt(100) >= 97)
				currentHpValue *= ((double)2 - (double)randomGenerator.nextDouble());
			
			currentGoldValue = (int)((currentAtkValue + currentDefValue + currentHpValue) * (currentLevelRestriction / (double)2) + 1);
		}
		
		//create the actual item
		EquipmentModel currentItem = null;
		
		switch(paramSelectionID)
		{
			case 0:
				currentItem = new OneHandedWeapon(currentID, currentGoldValue, currentLevelRestriction, currentAtkValue, currentDefValue, currentHpValue);
				break;
			case 1:
				currentItem = new TwoHandedWeapon(currentID, currentGoldValue, currentLevelRestriction, currentAtkValue, currentDefValue, currentHpValue);
				break;
			case 2:
				currentItem = new Shield(currentID, currentGoldValue, currentLevelRestriction, currentAtkValue, currentDefValue, currentHpValue);
				break;
			case 3:
				currentItem = new Helmet(currentID, currentGoldValue, currentLevelRestriction, currentAtkValue, currentDefValue, currentHpValue);
				break;
			case 4:
				currentItem = new ChestArmor(currentID, currentGoldValue, currentLevelRestriction, currentAtkValue, currentDefValue, currentHpValue);
				break;
			case 5:
				currentItem = new Boots(currentID, currentGoldValue, currentLevelRestriction, currentAtkValue, currentDefValue, currentHpValue);
				break;
		}
		
		System.out.println(currentItem.getItemName() + " erzeugt.");
		
		if(paramIsCrafted)
		{
			//if the item is crafted add it to the players inventory
			currentItem.setArmorPartsRevenue((Math.max(1, ((currentItem.getArmorPartsRevenue()) / 2))));
			currentItem.pickup(this.activePlayer);
			return null;
		}
		else
		{
			//if the item is a 'world drop', set the x and y position according the the players current position
			currentItem.setXPos(this.activePlayer.getPosX());
			currentItem.setYPos(this.activePlayer.getPosY());
			return currentItem;
		}
	}
	
	/**
	 * invokes crafting process</br>calculates crafting costs and perfoms a consistency check on these costs and on the players inventory size</br>
	 * calls this.generateNewEquipment() if the process is good to go
	 * @param paramSelectionID equipSlotID of the item to be generated
	 * @return int value indicating process state:</br> 0 -> process finished without errors</br> -1 -> insufficient resources (gold AND/OR armorParts);</br> -2 -> inventory full
	 * @author Staufenberg, Thomas, 5820359
	 * */
	protected int craftEquipment(int paramSelectionID)
	{
		System.out.println("ItemManager: Starte crafting Prozess.");
		InventoryModel currentInventory = this.activePlayer.getInventory();
		int armorPartsCosts = ((Math.max(1, (this.currentPlayerLevel / 5))) * 6);
		int goldCosts = (int)((((this.currentPlayerLevel / (double)15) * 900) * (this.currentPlayerLevel / (double)36)) + 20);
		if((currentInventory.getArmorPartsCount() >= armorPartsCosts) && (currentInventory.getGoldCount() >= goldCosts))
		{
			if((currentInventory.getCurrentItemsInInventory()) < (currentInventory.getInventorySize()))
			{
				this.generateNewEquipment(paramSelectionID, true);
				currentInventory.modifyArmorPartsCount(-armorPartsCosts);
				currentInventory.modifyGoldCount(-goldCosts);
			}
			else
				return -2;
		}
		else
			return -1;
		return 0;
	}
	
	/**
	 * creates a new consumable depending on the selectionID
	 * @param paramSelectionID ID of the consumable to be generated
	 * @return the generated consumable
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private ConsumableModel generateNewConsumable(int paramSelectionID)
	{
		System.out.println("ItemManager: Erzeuge neues Consumable.");
		Random randomGenerator = new Random();
		int currentStackSize = Math.max(1, (randomGenerator.nextInt(3)));
		ConsumableModel currentItem = null; 
		
		switch(paramSelectionID)
		{
			case 6:
				currentItem = new HealthPotion(currentStackSize);
				break;
			case 7:
				currentItem = new ManaPotion(currentStackSize);
				break;
		}
		return currentItem;
	}
	
	/**
	 * generates a new GoldStack with itemGoldValue depending on the playerLevel 
	 * @return the generated goldStack
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private GoldStack generateNewGoldStack()
	{
		System.out.println("ItemManager: Erzeuge neuen GoldStack.");
		int range = (int) ((5 / (double) 7) + ( this.currentPlayerLevel * (2 / (double) 7)));
		Random randomGenerator = new Random();
		int currentGoldValue = (int)(((this.currentPlayerLevel / (double)18) * 700) * (this.currentPlayerLevel / (double)48) + 1 + randomGenerator.nextInt(range));
		return new GoldStack(currentGoldValue);
	}
	
	/**
	 * decides on the type of the item(Consumable, GoldStack, Equipment)</br>
	 * calls the appropriate method to generate a new item of the corresponding type
	 * @return list of items that have been generated
	 * @author Staufenberg, Thomas, 5820359
	 * */
	protected ArrayList<ItemModel> generateRandomItem()
	{
		Random randomGenerator = new Random();
		int currentItemAmount = Math.max(1, randomGenerator.nextInt(3));
		int currentItemIndex = -1;
		ArrayList<ItemModel> generatedItemList = new ArrayList<>();
		
		System.out.println("ItemManager: Erzeuge " + currentItemAmount + " neue(s) Item(s).");
		for(int i = 0; i < currentItemAmount; i++)
		{
			currentItemIndex = randomGenerator.nextInt(9);
			ItemModel currentItem = null;
			if(currentItemIndex < 6)
				currentItem = this.generateNewEquipment(currentItemIndex, false);
			else if(currentItemIndex < 8)
				currentItem = this.generateNewConsumable(currentItemIndex);
			else
				currentItem = this.generateNewGoldStack();
			generatedItemList.add(currentItem);
		}
		return generatedItemList;
	}
}
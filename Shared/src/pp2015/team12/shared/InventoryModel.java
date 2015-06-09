package pp2015.team12.shared;

import java.io.Serializable;

import pp2015.team12.shared.character.PlayerCharacter;
import pp2015.team12.shared.item.ConsumableModel;
import pp2015.team12.shared.item.EquipmentModel;
import pp2015.team12.shared.item.GoldStack;
import pp2015.team12.shared.item.ItemModel;
import pp2015.team12.shared.item.TwoHandedWeapon;

/**
 * model class for player inventory, stores all inventory related data
 * @author Staufenberg, Thomas, 5820359
 * */
@SuppressWarnings("serial")
public class InventoryModel implements Serializable
{
	private int goldCount, armorPartsCount, currentItemsInInventory;
	private static final int INVENTORY_SIZE = 21;
	private boolean isTwoHandEquipped;
	private ItemModel[] inventoryContentList;
	private ConsumableModel[] quickSlotList;
	private EquipmentModel[] equipmentList;							//equipSlotIDs: weaponHand: 0 ; shieldHand: 1 ; helmet: 2 ; chest: 3 ; boots: 4
	private PlayerCharacter owningCharacter;
	
	/**
	 * stores given parameters in global variables
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public InventoryModel(int paramGoldCount, int paramArmorPartsCount, ItemModel[] paramInventoryContentList, EquipmentModel[] paramEquipmentList, ConsumableModel[] paramQuickSlotList)
	{
		this.currentItemsInInventory = 0;
		this.goldCount = paramGoldCount;
		this.armorPartsCount = paramArmorPartsCount;
		this.inventoryContentList = paramInventoryContentList;
		this.equipmentList = paramEquipmentList;
		this.quickSlotList = paramQuickSlotList;
		if(this.equipmentList[0] instanceof TwoHandedWeapon)
			this.isTwoHandEquipped = true;
		else
			this.isTwoHandEquipped = false;
		this.initializeInventoryContentList();
	}
	
	/**
	 * sets default values and calls second constructor
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public InventoryModel()
	{
		//TODO set final values: gold		
		this(50, 0, new ItemModel[InventoryModel.INVENTORY_SIZE], new EquipmentModel[5], new ConsumableModel[6]);
	}

	/**
	 * moves the current item to the given position in the inventoryContentList
	 * @param paramItem current item
	 * @param paramInventoryPosition the position the item is to be moved to
	 * @param paramPreviousInventoryPosition the position where the item was previously located
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void moveItemInInventory(ItemModel paramItem, int paramInventoryPosition, int paramPreviousInventoryPosition)
	{
		ItemModel previousItem = this.inventoryContentList[paramInventoryPosition];
		this.inventoryContentList[paramInventoryPosition] = paramItem;
		this.inventoryContentList[paramPreviousInventoryPosition] = previousItem;
	}
	
	/**
	 * moves the current consumable to the given position in the quickSlotList
	 * @param paramItem currentItem
	 * @param paramQuickSlotPosition the position the item is to be moved to
	 * @param paramPreviousQuickSlotPosition the position where the item was previously located
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void moveItemInQuickSlotList(ConsumableModel paramItem, int paramQuickSlotPosition, int paramPreviousQuickSlotPosition)
	{
		ConsumableModel previousItem = this.quickSlotList[paramQuickSlotPosition];
		this.quickSlotList[paramQuickSlotPosition] = paramItem;
		this.quickSlotList[paramPreviousQuickSlotPosition] = previousItem;
	}
	
	/**
	 * initializes the inventory by counting all elements != null and setting currentItemsInInventory</br>
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private void initializeInventoryContentList()
	{
		for(int j = 0; j < this.inventoryContentList.length; j++)
			if(this.inventoryContentList[j] != null)
				this.currentItemsInInventory++;
	}
	
	/**
	 * recalculates the players attributes everytime an equipment piece changes
	 * @param paramEquipment the equipment to be considered
	 * @param paramModifyPositive whethere the equipment is being equipped(true) or removed from equipment(false)
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private void modifyPlayerAttributes(EquipmentModel paramEquipment, boolean paramModifyPositive)
	{
		int currentMaxLife = this.owningCharacter.getMaximumLife();
		int currentAtk = this.owningCharacter.getAttack();
		int currentDef = this.owningCharacter.getDefense();
		
		if(paramModifyPositive)
		{
			currentMaxLife += paramEquipment.getHpValue();
			currentAtk += paramEquipment.getAttackValue();
			currentDef += paramEquipment.getDefenseValue();
		}
		else
		{
			currentMaxLife -= paramEquipment.getHpValue();
			currentAtk -= paramEquipment.getAttackValue();
			currentDef -= paramEquipment.getDefenseValue();
		}
		
		this.owningCharacter.setMaximumLife(currentMaxLife);
		this.owningCharacter.setAttack(currentAtk);
		this.owningCharacter.setDefense(currentDef);
		
		if(this.owningCharacter.getCurrentLife() > currentMaxLife)
			this.owningCharacter.setCurrentLife(currentMaxLife);
	}

	/**
	 * iterates over the equipment list and updates the players attributes for each item equipped
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void initializePlayerAttributes()
	{
		for(int i = 0; i < this.equipmentList.length; i++)
		{
			EquipmentModel currentEquipment = this.equipmentList[i];
			if(!(currentEquipment == null))
				this.modifyPlayerAttributes(currentEquipment, true);
		}
		if(this.owningCharacter.getCurrentLife() < this.owningCharacter.getMaximumLife())
			this.owningCharacter.setCurrentLife(this.owningCharacter.getMaximumLife());
	}
	
	/**
	 * finds the first free slot in the players inventoryContentList</br>
	 * is only called if there is at least one free slot left
	 * @return the first free slot
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private int findFreeInventorySlot()
	{
		int freeSlot = 0;
		while(freeSlot < InventoryModel.INVENTORY_SIZE)
		{
			if(this.inventoryContentList[freeSlot] != null)
				break;
			freeSlot++;
		}
		return freeSlot;
	}
	
	/**
	 * tries to add given item to the inventoryContentList
	 * @param paramItem item to be added to the inventory
	 * @param paramInventoryPosition the slot where the item is to be added; set to -1 to select first free position
	 * @return true: item successfully added</br>false: inventory full
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean addItemToInventory(ItemModel paramItem, int paramInventoryPosition)
	{
		if(paramItem instanceof ConsumableModel)
		{
			for(int i = 0; i < this.inventoryContentList.length; i++)
			{
				ItemModel currentItem = this.inventoryContentList[i];
				if(currentItem.getItemID() == paramItem.getItemID())
				{
					((ConsumableModel)currentItem).modifyStackSize(((ConsumableModel) paramItem).getStackSize());
					return true;
				}
			}
		}
		if(paramItem instanceof GoldStack)
		{
			this.modifyGoldCount(paramItem.getItemGoldValue());
			this.owningCharacter.getStatistics().updateGoldEarned(paramItem.getItemGoldValue());
			return true;
		}
		if(this.currentItemsInInventory < InventoryModel.INVENTORY_SIZE)
		{
			int inventorySlot = paramInventoryPosition;
			if(inventorySlot == -1)
				inventorySlot = this.findFreeInventorySlot();
			this.inventoryContentList[inventorySlot] = paramItem;
			this.currentItemsInInventory++;
			return true;
		}
		return false;
	}
	
	/**
	 * overloaded method</br>tries to add given item to the inventoryContentList</br>
	 * calls this.addItemToInventory with paramInventoryPosition = -1
	 * @param paramItem item to be added to the inventory
	 * @return true: item successfully added</br>false: inventory full
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean addItemToInventory(ItemModel paramItem)
	{
		return this.addItemToInventory(paramItem, -1);
	}
	
	
	/**
	 * removes given item from the inventory if existing, and adds a DummyItem at its previous position
	 * @param paramItem the item to be removed
	 * @return true: item removed from the inventory</br>false: item not in inventory
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean removeItemFromInventory(ItemModel paramItem)
	{
		int itemPosition = -1;
		for(int i = 0; i < this.inventoryContentList.length; i++)
		{
			ItemModel currentItem = this.inventoryContentList[i];
			if(currentItem.getItemID() == paramItem.getItemID())
			{
				itemPosition = i;
				break;
			}
		}
		if(itemPosition != -1)
		{
			this.inventoryContentList[itemPosition] = null;
			this.currentItemsInInventory--;
			return true;
		}
		return false;
	}
	
	/**
	 * tries to add the given Item to the inventory</br>
	 * removes the Item from the equipment if the previous operation returned true or paramAddToInventory is false</br>
	 * @param paramItem the Item to be removed
	 * @param paramInventoryPosition the slot where the item that is getting removed is to be added to the inventory; set to -1 to select first free position
	 * @param paramAddToInventory wheter the item should be added to the inventory (true) or not (false)
	 * @return true: Item successfully removed (and added to the inventory[optional])</br>false: inventory full OR item at paramInventoryPosition cannot be equipped (various reasons possible)
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean removeItemFromEquip(EquipmentModel paramItem, boolean paramAddToInventory, int paramInventoryPosition)
	{
		if(paramAddToInventory)
		{
			if(paramInventoryPosition != -1)
			{
				ItemModel previousItemAtInventorySlot = this.inventoryContentList[paramInventoryPosition];
				if((previousItemAtInventorySlot instanceof EquipmentModel) && (((EquipmentModel) previousItemAtInventorySlot).getEquipSlotID() == paramItem.getEquipSlotID()))
					return this.equipItem((EquipmentModel) previousItemAtInventorySlot, paramInventoryPosition);
				else if(previousItemAtInventorySlot != null)
					return false;
			}
			this.addItemToInventory(paramItem, paramInventoryPosition);
		}
		this.equipmentList[paramItem.getEquipSlotID()] = null;
		this.modifyPlayerAttributes(paramItem, false);

		if(paramItem instanceof TwoHandedWeapon)
			this.isTwoHandEquipped = false;
		return true;
	}
	
	/**
	 * tries to add the given Item to the inventory</br>
	 * removes the Item from the equipment if the previous operation returned true or paramAddToInventory is false</br>
	 * calls this.removeItemFromEquipment with paramInventoryPosition = -1
	 * @param paramItem the Item to be removed
	 * @param paramAddToInventory wheter the item should be added to the inventory (true) or not (false)
	 * @return true: Item successfully removed (and added to the inventory[optional])</br>false: inventory full OR item at paramInventoryPosition cannot be equipped (various reasons possible)
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean removeItemFromEquip(EquipmentModel paramItem, boolean paramAddToInventory)
	{
		return this.removeItemFromEquip(paramItem, paramAddToInventory, -1);
	}
	
	/**
	 * equips the given item to the player charakter, removes the equipped item from the inventory</br>
	 * adds the previously equipped item to the inventory at the position paramInventoryPosition if not null
	 * @param paramItem the EquipmentModel to be equipped
	 * @param paramInventoryPosition the slot where the item is to be added to the inventory
	 * @return true: item successfully equipped</br>false: inventory full or characterLevel too low
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean equipItem(EquipmentModel paramItem, int paramInventoryPosition)
	{
		if((paramItem instanceof TwoHandedWeapon) && (this.currentItemsInInventory > (InventoryModel.INVENTORY_SIZE - 1) && (this.equipmentList[0] != null) && (this.equipmentList[1] != null)))
			System.out.println("Ihr Inventar ist voll!");
		else if(paramItem.getLevelRestriction() <= this.owningCharacter.getLevel())
		{
			EquipmentModel previousItem = this.equipmentList[paramItem.getEquipSlotID()];
			this.equipmentList[paramItem.getEquipSlotID()] = paramItem;
			this.removeItemFromInventory(paramItem);
			this.modifyPlayerAttributes(paramItem, true);
			
			if(this.isTwoHandEquipped && (paramItem.getEquipSlotID() == 1))
				this.removeItemFromEquip(this.equipmentList[0], true, -1);
			
			if(previousItem != null)
			{
				this.addItemToInventory(previousItem, paramInventoryPosition);
				this.modifyPlayerAttributes(previousItem, false);
				if(previousItem instanceof TwoHandedWeapon)
					this.isTwoHandEquipped = false;
			}
			
			if(paramItem instanceof TwoHandedWeapon)
			{
				this.isTwoHandEquipped = true;
				if(this.equipmentList[1] != null)
					this.removeItemFromEquip(this.equipmentList[1], true, -1);
			}
			return true;
		}
		else
			System.out.println("Ihr Level ist zu niedrig um dieses Item auszuruesten!");
		return false;
	}
	
	/**
	 * equips the given item to the player charakter, removes the equipped item from the inventory</br>
	 * adds the previously equipped item to the inventory at the first free slot if not null
	 * calls this.equipItem with paramInventoryPosition = -1
	 * @param paramItem the EquipmentModel to be equipped
	 * @return true: item successfully equipped</br>false: inventory full or characterLevel too low
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean equipItem(EquipmentModel paramItem)
	{
		return this.equipItem(paramItem, -1);
	}

	/**
	 * removes the given consumable from the quickSlotList
	 * @param paramItem the ConsumableModel to be removed
	 * @param paramPreviousQuickSlotPosition the position of the ConsumableModel to be removed in the quickSlotList; call with -1 if the quickSlotPosition is unknown
	 * @param paramInventoryPosition the position where the item is to be added to the inventory; call with -1 if the item is not to be added to the inventory
	 * @return true: item successfully removed</br>false: the item that is to be switched into the quickSlotList is not a ConsumableModel
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean removeItemFromQuickSlotList(ConsumableModel paramItem, int paramPreviousQuickSlotPosition, int paramInventoryPosition)
	{
		if(paramInventoryPosition != -1)
		{
			ItemModel itemAtInventorySlot = this.inventoryContentList[paramInventoryPosition];
			if(itemAtInventorySlot instanceof ConsumableModel)
			{
				this.removeItemFromInventory(itemAtInventorySlot);
				this.quickSlotList[paramPreviousQuickSlotPosition] = (ConsumableModel) itemAtInventorySlot;
				this.addItemToInventory(paramItem);
			}
			else
				return false;
		}
		else if(paramPreviousQuickSlotPosition != -1)
			this.quickSlotList[paramPreviousQuickSlotPosition] = null;
		else
		{
			for(int i = 0; i < this.quickSlotList.length; i++)
			{
				if(this.quickSlotList[i].getItemID() == paramItem.getItemID())
				{
					this.quickSlotList[i] = null;
					break;
				}
			}
		}
		return true;
	}
	
	/**
	 * removes the given consumable from the quickSlotList</br>calls this.removeItemFromQuickSlotList with paramInventoryPosition = -1
	 * @param paramItem the ConsumableModel to be removed
	 * @param paramPreviousQuickSlotPosition the position of the ConsumableModel to be removed in the quickSlotList
	 * @return true: item successfully removed</br>false: the item that is to be switched into the quickSlotList is not a ConsumableModel
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean removeItemFromQuickSlotList(ConsumableModel paramItem, int paramPreviousQuickSlotPosition)
	{
		return this.removeItemFromQuickSlotList(paramItem, paramPreviousQuickSlotPosition, -1);
	}
	
	/**
	 * removes the given consumable from the quickSlotList</br>calls this.removeItemFromQuickSlotList with</br>
	 * paramInventoryPosition = -1 AND paramPreviousQuickSlotPosition = -1
	 * @param paramItem the ConsumableModel to be removed
	 * @return true: item successfully removed</br>false: the item that is to be switched into the quickSlotList is not a ConsumableModel
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean removeItemFromQuickSlotList(ConsumableModel paramItem)
	{
		return this.removeItemFromQuickSlotList(paramItem, -1);
	}
	
	/**
	 * adds the given consumable to the quickSlotList at paramQuickSlotPosition</br>
	 * @param paramQuickSlotPosition the position in the quickSlotList where the item is to be added; set to -1 if the method is called during "pickup"
	 * @param paramPreviousInventoryPosition the position where a possible switch partner from the inventory was previously located; set to -1 if the method is called during "pickup"
	 * @return true: item successfully added</br>false: 
	 * */
	public boolean addItemToQuickSlotList(ConsumableModel paramItem, int paramQuickSlotPosition, int paramPreviousInventoryPosition)
	{
		if(paramQuickSlotPosition == -1)
		{
			for(int i = 0; i < this.quickSlotList.length; i++)
			{
				ConsumableModel currentItem = this.quickSlotList[i];
				if(currentItem.getItemID() == paramItem.getItemID())
				{
					currentItem.modifyStackSize(paramItem.getStackSize());
					return true;
				}
			}
		}
		else
		{
			ConsumableModel previousItem = this.quickSlotList[paramQuickSlotPosition];
			this.quickSlotList[paramQuickSlotPosition] = paramItem;
			this.removeItemFromInventory(paramItem);
			if(previousItem != null)
				this.addItemToInventory(previousItem, paramPreviousInventoryPosition);
			return true;
			
		}
		return false;
	}
	
	/**
	 * salvages the given Item, this results in the Item being destroyed</br>
	 * adds the armorPartsRevenue of the salvaged Item to the players armorPartsCount
	 * @param paramItem the Item to be salvaged
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void salvageEquipment(EquipmentModel paramItem)
	{
		if(!(this.removeItemFromInventory(paramItem)))
			this.removeItemFromEquip(paramItem, false);
		this.modifyArmorPartsCount(paramItem.getArmorPartsRevenue());
	}
	
	/**
	 * sells the given Item, this results in the Item being destroyed</br>
	 * adds the itemGoldValue of the given Item to the players goldCount
	 * @param paramItem the Item to be sold
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void sellItem(ItemModel paramItem)
	{
		if(!(this.removeItemFromInventory(paramItem)))
		{
			if(!((paramItem instanceof EquipmentModel) && (this.removeItemFromEquip((EquipmentModel)paramItem, false))))
				this.removeItemFromQuickSlotList((ConsumableModel)paramItem);
		}
		this.modifyGoldCount(paramItem.getItemGoldValue());
		this.owningCharacter.getStatistics().updateGoldEarned(paramItem.getItemGoldValue());
	}
		/**
	 * increases/decreases the goldCound by the given value
	 * @param paramModificator gold amount to be added/subtracted
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void modifyGoldCount(int paramModificator)
	{
		this.goldCount += paramModificator;
	}
	
	/**
	 * increases/decreases the armorPartsCount by the given value
	 * @param paramModificator amount of armorParts to be added/subtracted
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void modifyArmorPartsCount(int paramModificator)
	{
		this.armorPartsCount += paramModificator;
	}
	
	/**
	 * @return current goldCount
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public int getGoldCount()
	{
		return this.goldCount;
	}
	
	/**
	 * @return current armorPartsCount
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public int getArmorPartsCount()
	{
		return this.armorPartsCount;
	}
	
	/**
	 * @return current inventoryContentList
	 * @author Staufenberg, Thomas, 5820359 
	 * */
	public ItemModel[] getInventoryContentList()
	{
		return this.inventoryContentList;
	}
	
	/**
	 * @return current equipmentList
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public EquipmentModel[] getEquipmentList()
	{
		return this.equipmentList;
	}
	
	/**
	 * @return maximum amount of inventory slots available
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public int getInventorySize()
	{
		return InventoryModel.INVENTORY_SIZE;
	}
	
	/**
	 * @return the current quickSlotList
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public ConsumableModel[] getQuickSlotList()
	{
		return this.quickSlotList;
	}
	
	/**
	 * @return the number of items that are currently stored in the inventory
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public int getCurrentItemsInInventory()
	{
		return this.currentItemsInInventory;
	}
	
	/**
	 * ovewrites the current equipmentList with the given one
	 * @param paramEquipmentList the equipmentList to be set
	 * @author Staufenberg, Thomas 5820359
	 * */
	public void setEquipmentList(EquipmentModel[] paramEquipmentList)
	{
		this.equipmentList = paramEquipmentList;
	}

	/**
	 * sets the owner attribute of the current inventory
	 * @param paramOwner the PlayerCharacter the current inventory belongs to
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void setOwner(PlayerCharacter paramOwner)
	{
		this.owningCharacter = paramOwner;
	}
}
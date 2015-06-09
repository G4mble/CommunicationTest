package pp2015.team12.shared.item;

import pp2015.team12.shared.character.PlayerCharacter;

/**
 * abstract superclass of all consumables</br>extends ItemModel
 * @author Staufenberg, Thomas, 5820359
 * */
@SuppressWarnings("serial")
public abstract class ConsumableModel extends ItemModel
{
	protected int stackSize, valueModificator;
	
	/**
	 * forwards paramID, paramGoldValue, paramName, paramImagePath to super constructor</br>
	 * stores remaining parameters in global variables
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public ConsumableModel(int paramID, int paramGoldValue, String paramName, String paramImagePath, int paramValueMod, int paramStackSize)
	{
		super(paramID, (paramGoldValue * paramStackSize), paramName, paramImagePath);
		
		this.valueModificator = paramValueMod;
		this.stackSize = paramStackSize;
	}
	
	/**
	 * abstract method to consume the current item
	 * @param paramPlayer PlayerCharakter model of the player consuming the item
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public abstract void consume(PlayerCharacter paramPlayer);
	
	/**
	 * moves the current consumable to the given position in the quickSlotList
	 * @param paramPlayer the player the item belongs to
	 * @param paramQuickSlotPosition the position the item is to be moved to
	 * @param paramPreviousQuickSlotPosition the position where the item was previously located
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void moveInQuickSlotList(PlayerCharacter paramPlayer, int paramQuickSlotPosition, int paramPreviousQuickSlotPosition)
	{
		paramPlayer.getInventory().moveItemInQuickSlotList(this, paramQuickSlotPosition, paramPreviousQuickSlotPosition);
	}
	
	/**
	 * increases the stackSize of the current consumable</br>recalculates the itemGoldValue depending on the new stackSize
	 * @param paramModificator amount by which the stackSize is to be modified (+ / -)
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public int modifyStackSize(int paramModificator)
	{
		int itemGoldValuePerUnit = (super.itemGoldValue / this.stackSize);
		this.stackSize += paramModificator;
		super.itemGoldValue = (itemGoldValuePerUnit * this.stackSize);
		return this.stackSize;
	}
	
	/**
	 * @return stackSize of the current consumable
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public int getStackSize()
	{
		return this.stackSize;
	}
}
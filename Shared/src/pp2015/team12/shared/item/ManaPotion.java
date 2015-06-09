package pp2015.team12.shared.item;

import pp2015.team12.shared.character.Mage;
import pp2015.team12.shared.character.PlayerCharacter;

/**
 * implementation of a ManaPotion</br>extends ConsumableModel
 * @author Staufenberg, Thomas, 5820359
 * */
@SuppressWarnings("serial")
public class ManaPotion extends ConsumableModel
{
	/**
	 * primary constructor</br>
	 * sets itemID, itemGoldValue, itemName, itemImagePath, valueModificator and stackSize</br>
	 * forwards these values and stackSize to super constructor
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public ManaPotion(int paramStackSize)
	{
		super(3, 5, "Manatrank", "manaTrank.png", 40, paramStackSize);
	}
	
	/**
	 * overrides abstract method from superclass</br>decreases stackSize by 1, increases the players mana by super.valueModificator percent
	 * @param paramPlayer PlayerCharakter model of the player consuming the item
	 * @author Staufenberg, Thomas, 5820359
	 * */
	@Override
	public void consume(PlayerCharacter paramPlayer)
	{
		if(paramPlayer instanceof Mage)
		{
			Mage currentPlayer = (Mage) paramPlayer;
			if(currentPlayer.setCurrentMana((currentPlayer.getCurrentMana() + (int)((double)(currentPlayer.getMaximumMana()) * (double)((double)super.valueModificator / (double)100)))))
				if((--super.stackSize) == 0)
				{
					if(!(paramPlayer.getInventory().removeItemFromInventory(this)))
						paramPlayer.getInventory().removeItemFromQuickSlotList(this);
				}
		}
		else
			System.out.println("Ihr Charakter kann diesen Gegenstand nicht benutzen!");
	}
}
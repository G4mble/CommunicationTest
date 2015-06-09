package pp2015.team12.shared.character;

import pp2015.team12.shared.InventoryModel;

/**
 * @author Balduin,Andreas,5800366
 */
@SuppressWarnings("serial")
public class Trader extends NPC {
	InventoryModel inventory;
	
	/**
	 * @author Balduin,Andreas,5800366
	 * @param posX
	 * @param posY
	 * @param inventory
	 */
	public Trader(int posX, int posY,InventoryModel inventory,int levelId) {
		super("Haendler", posX, posY,"Haendler.jpg",levelId);
		this.inventory = inventory;
	}

	/**
	 * @return the inventory
	 */
	public InventoryModel getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(InventoryModel inventory) {
		this.inventory = inventory;
	}
}

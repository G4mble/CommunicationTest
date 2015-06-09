package komponente.guiII;
/**
 * temporary class for the inventory
 * @author Vinzenz Liem Bui
 */
public class InventoryTestumgebung {

	private int itemID;
	private String imageName;
	private String type;
	private int amount = 0;
	/**
	 * initializes a consumable
	 * @author Vinzenz Liem Bui
	 */
	public InventoryTestumgebung(int itemID, String imageName, String type, int amount){
		this.itemID = itemID;
		this.imageName = imageName;
		this.type = type;
		this.amount = amount;
	}
	/**
	 * initializes a non-consumable aka sword, armour, boots...
	 * @author Vinzenz Liem Bui
	 */
	public InventoryTestumgebung(int itemID, String imageName, String type){
		this.itemID = itemID;
		this.imageName = imageName;
		this.type = type;
	}
	/**
	 * returns the itemID
	 * @author Vinzenz Liem Bui
	 */
	public int getItemID(){
		return itemID;
	}
	/**
	 * returns image
	 * @author Vinzenz Liem Bui
	 */
	public String getImageName(){
		return imageName;
	}
	/**
	 * returns type of item (consumable, sword, boots ,...)
	 * @author Vinzenz Liem Bui
	 */
	public String getType(){
		return type;
	}
	/**
	 * returns the amount of the item
	 * @author Vinzenz Liem Bui
	 */
	public int getAmount(){
		return amount;
	}
	
}

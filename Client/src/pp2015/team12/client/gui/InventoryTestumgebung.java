package pp2015.team12.client.gui;

public class InventoryTestumgebung {

	private int itemID;
	private String imageName;
	private String type;
	private int amount = 0;
	
	public InventoryTestumgebung(int itemID, String imageName, String type, int amount){
		this.itemID = itemID;
		this.imageName = imageName;
		this.type = type;
		this.amount = amount;
	}
	
	public InventoryTestumgebung(int itemID, String imageName, String type){
		this.itemID = itemID;
		this.imageName = imageName;
		this.type = type;
	}
	
	public int getItemID(){
		return itemID;
	}
	
	public String getImageName(){
		return imageName;
	}
	
	public String getType(){
		return type;
	}
	
	public int getAmount(){
		return amount;
	}
	
}

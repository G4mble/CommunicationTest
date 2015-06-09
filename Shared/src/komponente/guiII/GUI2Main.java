package komponente.guiII;

public class GUI2Main {
	/**
	 * initializes the GUI2 and starts it
	 * @author Vinzenz Liem Bui
	 */
	public static void main(String[]args){
		
		Frame frame = new Frame();
		
		// set map
		int [][] map = new int [][] {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1},
				{1,0,1,1,0,0,1,1,0,0,1,1,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,1,1,1,0,1,0,0,0,1,0,0,1,1,0,1},
				{1,1,0,1,1,1,0,0,0,1,0,1,0,1,0,1,1,1,0,0},
				{1,1,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,1},
				{1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,1,0,1,1,1},
				{1,1,0,0,0,0,0,1,0,1,1,1,0,0,0,1,0,0,1,1},
				{1,1,1,1,0,1,1,1,0,1,1,0,0,1,0,0,0,1,1,1},
				{1,1,0,0,0,0,0,1,1,0,0,0,0,1,1,1,1,1,1,1},
				{1,1,0,1,1,1,0,1,1,0,1,1,0,1,0,0,0,1,0,1},
				{1,1,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,1,0,1},
				{1,1,0,0,1,0,0,1,1,0,1,0,0,1,1,1,0,1,0,1},
				{1,1,1,0,1,0,1,1,1,0,1,1,1,1,0,0,0,0,0,1},
				{1,0,1,0,1,0,1,0,0,0,1,1,1,1,1,1,1,1,0,1},
				{1,0,1,0,1,0,1,1,0,1,1,0,0,0,1,1,1,1,0,1},
				{1,0,0,0,1,0,0,1,0,0,0,0,0,0,1,1,1,1,0,1},
				{1,0,1,0,1,1,0,0,0,1,1,0,0,0,1,0,0,0,0,1},
				{0,0,1,0,1,1,1,0,1,0,1,1,1,0,1,0,0,1,0,1},
				{1,1,1,0,1,1,1,0,0,0,1,1,1,0,0,0,0,1,0,1},
				{1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1}
    			};
		frame.forwardMessageGUI2(new MessageTestumgebung(map));
		
		// set Status
		frame.forwardMessageGUI2(new MessageTestumgebung(90,80,34,39,1587416));
		
		//set Inventory
		InventoryTestumgebung[] itemBar = {new InventoryTestumgebung(2,"I_Bottle03.png","consumable",9),
										   null,
										   new InventoryTestumgebung(2,"I_C_Bread.png","consumable",2)
											};
		InventoryTestumgebung[] inventar = {new InventoryTestumgebung(0,"A_Armour01.png","armor"),
											new InventoryTestumgebung(1,"P_Blue01.png","consumable",4),
											null,
											new InventoryTestumgebung(2,"A_Shoes05.png","boots"),
											new InventoryTestumgebung(2,"I_Antidote.png","consumable",12),
											new InventoryTestumgebung(2,"S_Sword01.png","weapon"),
											new InventoryTestumgebung(2,"S_Sword02.png","weapon")
										    };
		InventoryTestumgebung[] equipment = {new InventoryTestumgebung(2,"S_Sword01.png","weapon"),
											 new InventoryTestumgebung(2,"C_Elm03.png","helmet"),
											 new InventoryTestumgebung(2,"A_Armour02.png","armor")
											};
		frame.forwardMessageGUI2(new MessageTestumgebung(equipment, itemBar,inventar));
		
		//set charStats (attack,defence...)
		frame.forwardMessageGUI2(new MessageTestumgebung(90,100,120,132,34,41));
		
		//set statistic
		frame.forwardMessageGUI2(new MessageTestumgebung(95, 31, 12, "8.25", "Langschwert", "80%", "33h 42min"));

	}
}

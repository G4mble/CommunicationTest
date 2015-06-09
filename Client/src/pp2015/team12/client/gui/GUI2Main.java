package pp2015.team12.client.gui;

import pp2015.team12.client.ClientCommunication;
import pp2015.team12.shared.InventoryModel;
import pp2015.team12.shared.item.*;
import pp2015.team12.shared.map.Tile;
import pp2015.team12.shared.map.textures.*;
import pp2015.team12.shared.message.*;

public class GUI2Main {

	public static void main(String[]args){
		
		Frame frame = new Frame(new ClientCommunication(null));
		
		Tile testTrue = new SW_Floor_1();
		testTrue.readTexture();
		Tile testFalse = new SW_Wall_1();
		testFalse.readTexture();
		Tile[][] map = new Tile[][]{{testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testTrue,testFalse,testFalse,testFalse,testFalse,testFalse},
				{testFalse,testTrue,testFalse,testFalse,testTrue,testTrue,testFalse,testFalse,testTrue,testTrue,testFalse,testFalse,testTrue,testTrue,testTrue,testTrue,testTrue,testTrue,testTrue,testFalse},
				{testFalse,testTrue,testTrue,testTrue,testTrue,testFalse,testFalse,testFalse,testTrue,testFalse,testTrue,testTrue,testTrue,testFalse,testTrue,testTrue,testFalse,testFalse,testTrue,testFalse},
				{testFalse,testFalse,testTrue,testFalse,testFalse,testFalse,testTrue,testTrue,testTrue,testFalse,testTrue,testFalse,testTrue,testFalse,testTrue,testFalse,testFalse,testFalse,testTrue,testTrue},
				{testFalse,testFalse,testTrue,testTrue,testTrue,testTrue,testTrue,testFalse,testFalse,testTrue,testTrue,testTrue,testTrue,testFalse,testTrue,testTrue,testTrue,testTrue,testTrue,testFalse},
				{testFalse,testTrue,testTrue,testFalse,testFalse,testFalse,testFalse,testFalse,testTrue,testTrue,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testTrue,testFalse,testFalse,testFalse},
				{testFalse,testFalse,testTrue,testTrue,testTrue,testTrue,testTrue,testFalse,testTrue,testFalse,testFalse,testFalse,testTrue,testTrue,testTrue,testFalse,testTrue,testTrue,testFalse,testFalse},
				{testFalse,testFalse,testFalse,testFalse,testTrue,testFalse,testFalse,testFalse,testTrue,testFalse,testFalse,testTrue,testTrue,testFalse,testTrue,testTrue,testTrue,testFalse,testFalse,testFalse},
				{testFalse,testFalse,testTrue,testTrue,testTrue,testTrue,testTrue,testFalse,testFalse,testTrue,testTrue,testTrue,testTrue,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse},
				{testFalse,testFalse,testTrue,testFalse,testFalse,testFalse,testTrue,testFalse,testFalse,testTrue,testFalse,testFalse,testTrue,testFalse,testTrue,testTrue,testTrue,testFalse,testTrue,testFalse},
				{testFalse,testFalse,testTrue,testFalse,testFalse,testFalse,testTrue,testTrue,testTrue,testTrue,testTrue,testFalse,testTrue,testTrue,testTrue,testFalse,testTrue,testFalse,testTrue,testFalse},
				{testFalse,testFalse,testTrue,testTrue,testFalse,testTrue,testTrue,testFalse,testFalse,testTrue,testFalse,testTrue,testTrue,testFalse,testFalse,testFalse,testTrue,testFalse,testTrue,testFalse},
				{testFalse,testFalse,testFalse,testTrue,testFalse,testTrue,testFalse,testFalse,testFalse,testTrue,testFalse,testFalse,testFalse,testFalse,testTrue,testTrue,testTrue,testTrue,testTrue,testFalse},
				{testFalse,testTrue,testFalse,testTrue,testFalse,testTrue,testFalse,testTrue,testTrue,testTrue,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testTrue,testFalse},
				{testFalse,testTrue,testFalse,testTrue,testFalse,testTrue,testFalse,testFalse,testTrue,testFalse,testFalse,testTrue,testTrue,testTrue,testFalse,testFalse,testFalse,testFalse,testTrue,testFalse},
				{testFalse,testTrue,testTrue,testTrue,testFalse,testTrue,testTrue,testFalse,testTrue,testTrue,testTrue,testTrue,testTrue,testTrue,testFalse,testFalse,testFalse,testFalse,testTrue,testFalse},
				{testFalse,testTrue,testFalse,testTrue,testFalse,testFalse,testTrue,testTrue,testTrue,testFalse,testFalse,testTrue,testTrue,testTrue,testFalse,testTrue,testTrue,testTrue,testTrue,testFalse},
				{testTrue,testTrue,testFalse,testTrue,testFalse,testFalse,testFalse,testTrue,testFalse,testTrue,testFalse,testFalse,testFalse,testTrue,testFalse,testTrue,testTrue,testFalse,testTrue,testFalse},
				{testFalse,testFalse,testFalse,testTrue,testFalse,testFalse,testFalse,testTrue,testTrue,testTrue,testFalse,testFalse,testFalse,testTrue,testTrue,testTrue,testTrue,testFalse,testTrue,testFalse},
				{testFalse,testFalse,testFalse,testTrue,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testFalse,testTrue,testFalse}
    			};
		//frame.forwardMessageGUI(new MessageTestumgebung(map));
		frame.forwardMessage(new MapMsg(map,2));
	
		
		//set Inventory
		InventoryModel invMod = new InventoryModel();
		ConsumableModel[] itembar = invMod.getQuickSlotList();
		itembar[1] = new HealthPotion(1);
		
		for(ItemModel item: itembar){
			if(item!=null)
			item.readItemTexture();
		}
		
		ItemModel[] inventory = invMod.getInventoryContentList();
		inventory[1] = new HealthPotion(1);
		
		
		for(ItemModel item: inventory){
			if(item!=null){
				System.out.println();
				item.readItemTexture();
			}
		}
		
		frame.forwardMessage(new LocInvMsg(2, invMod));
		
		//set charStats (attack,defence...)
		frame.forwardMessageGUI(new MessageTestumgebung(90,100,120,132,34,41));
		
		//set statistic
		frame.forwardMessageGUI(new MessageTestumgebung(95, 31, 12, "8.25", "Langschwert", "80%", "33h 42min"));
		
		// set Status
		frame.forwardMessageGUI(new MessageTestumgebung(90,80,34,39,1587416));
	}
		
	
}

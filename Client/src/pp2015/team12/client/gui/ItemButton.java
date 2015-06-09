package pp2015.team12.client.gui;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import pp2015.team12.shared.item.*;

public class ItemButton extends JButton{
	
	private Image img;
	private String imageName;
	private String type;
	private Boolean empty = true;
	private int amount = 0;
	private ItemModel item;
	private int[] index = {0,0}; // 0 = equip, 1 = itembar , 2 = inv, zweite zahl entspricht equip / itembar oder inv!
	private JLabel amountCounter = new JLabel("0");
	
	/*
	public ItemButton(int itemID, String imageName, String type, String info, ItemMouseListener ml){
		this.itemID = itemID;
		this.type = type;
		empty = false;
		this.imageName = imageName;
		//setText(String.valueOf(itemID));
		setBackground(Color.BLACK);
		//setBorder(null);
		try {
			img = ImageIO.read(this.getClass().getResource("ItemImages/"+imageName));
			setIcon(new ImageIcon(img));
		} catch (IOException e) {
			
		}
		
		if(ml != null)
			addMouseMotionListener(ml);
	}*/
	
	public ItemButton(int[] index){
		setLayout(null);
		setEnabled(false);
		this.index = index;
	}
	
	public ItemButton(ItemMouseListener ml,int[] index){
		setLayout(null);
		if(ml != null)
		addMouseMotionListener(ml);
		setEnabled(false);
		this.index = index;
	}

	public Boolean isEmpty(){
		return empty;
	}
	
	public void setItem(ItemModel item){
		
		if(item != null){
			this.item = item;

			setEnabled(true);
			
			this.img = item.getItemImage();
			setIcon(new ImageIcon(img));
			
			if(item instanceof ConsumableModel){
				this.type = "consumable";
				this.amount = ((ConsumableModel)item).getStackSize();
				amountCounter.setBounds(1, 1, 20, 10);
				amountCounter.setText(String.valueOf(amount));
				add(amountCounter);
			} else if(item instanceof EquipmentModel){
				if(item instanceof Weapon)
					this.type = "weapon";
				if(item instanceof Shield)
					this.type = "shield";
				if(item instanceof Helmet)
					this.type = "helmet";
				if(item instanceof Boots)
					this.type = "boots";
				if(item instanceof Armament)
					this.type = "armor";
			}
				
			empty = false;
		
		} else {
			
			this.imageName = null;
			this.type = null;
			this.amount = 0;
			remove(amountCounter);
			setIcon(null);
			setEnabled(false);
			empty = true;
		}
	}
	
	public void setItem(InventoryTestumgebung item){
		
		if(item != null){
			setEnabled(true);
			this.imageName = item.getImageName();
			this.type = item.getType();
			try {
				img = ImageIO.read(this.getClass().getResource("ItemImages/"+imageName));
				setIcon(new ImageIcon(img));
			} catch (IOException e) {
			
			}
			empty = false;
			if(type.equals("consumable")){
				this.amount = item.getAmount();
				amountCounter.setBounds(1, 1, 20, 10);
				amountCounter.setText(String.valueOf(amount));
				add(amountCounter);
			}
		} else {

			this.imageName = null;
			this.type = null;
			this.amount = 0;
			remove(amountCounter);
			setIcon(null);
			setEnabled(false);
			empty = true;
		}
	}
	
	public int[] getIndex(){
		return index;
	}
	
	public ItemModel getItem(){
		return item;
		/*
		if(imageName != null)
			
			//return item;
			return new InventoryTestumgebung(itemID, imageName, type, amount);
		else 
			return null;
			*/
	}
	
	public String getType(){
		return type;
	}
	
	public Image getImage(){
		return img;
	}
	
	
}

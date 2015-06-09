package pp2015.team12.client.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import pp2015.team12.shared.*;
import pp2015.team12.shared.item.*;


public class InventoryPanel extends JLabel implements ActionListener{

	private JLayeredPane layeredPanel = new JLayeredPane();
	
	private JLabel itemLabel = new JLabel();
	private IngamePanel controller;
	private ItemMouseListener ml;
	private Boolean itemSelected = false;
	
	private JPopupMenu popupMenu = new JPopupMenu();
	private JMenuItem useItem = new JMenuItem("Use");
	private JMenuItem infoItem = new JMenuItem("Info");
	private JMenuItem dropItem = new JMenuItem("Drop");
	
	private ItemModel copiedItem;
	private ItemButton selectedBtn;
	private ItemButton oldBtn;
	private ItemButton itemBarBtnArray[] = new ItemButton[6];
	private ItemButton inventoryBtnArray[] = new ItemButton[21];
	
	private int[] oldItemIndex = {0,0};  
	private int[] newItemIndex = {0,0};
	
	private JLabel goldLabel = new JLabel();
	
	private JTextArea charStats = new JTextArea();
	
	private ItemButton helmetSlot;
	private ItemButton armorSlot;
	private ItemButton bootsSlot;
	private ItemButton weaponSlot;
	private ItemButton shieldSlot;
		
	private JTextArea infoPanel = new JTextArea("Lorem ipsum");
	
	public InventoryPanel(IngamePanel controller){
		setLayout(null);
		this.controller = controller;
		ml = new ItemMouseListener(this);
		setVisible(false);
		
		add(layeredPanel);
		
		charStats.setBounds(170, 70, 150, 160);
		charStats.setOpaque(false);
		charStats.setEditable(false);
		charStats.addMouseMotionListener(ml);
		charStats.setForeground(Color.decode("0x911b1b"));
		charStats.setText("Attack: 0\nAttackspeed: 0\nAgility: 0\nIntelligence: 0\nArmor: 0\nSpeed: 0");
		layeredPanel.add(charStats);
		
		
		
		useItem.addActionListener(this);
		useItem.setName("use");
		popupMenu.add(useItem);
		
		infoItem.addActionListener(this);
		infoItem.setName("info");
		popupMenu.add(infoItem);
		popupMenu.addSeparator();
		
		dropItem.addActionListener(this);
		dropItem.setName("drop");
		popupMenu.add(dropItem);
		
		
		
		
		Image silhouetteImage = null;
		JLabel goldImage = null;
		JButton close = null;
		try {
			close = new JButton(new ImageIcon(ImageIO.read(this.getClass().getResource("gui2images/closeFrameButton.png"))));
			goldImage = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("gui2images/coins.png"))));
			silhouetteImage = ImageIO.read(this.getClass().getResource("gui2images/silhouette.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		int[] weaponSlotIndex = {1,0};
		weaponSlot = new ItemButton(ml, weaponSlotIndex);
		weaponSlot.setName("weapon");
		weaponSlot.setContentAreaFilled(false);
		weaponSlot.setBounds(20,140,30,30);
		weaponSlot.addActionListener(this);
		layeredPanel.add(weaponSlot);
		
		int[] shieldSlotIndex = {1,0};
		shieldSlot = new ItemButton(ml,shieldSlotIndex);
		shieldSlot.setName("shield");
		shieldSlot.setContentAreaFilled(false);
		shieldSlot.setBounds(120,140,30,30);
		shieldSlot.addActionListener(this);
		layeredPanel.add(shieldSlot);
		
		int[] helmetSlotIndex = {2,0};
		helmetSlot = new ItemButton(ml,helmetSlotIndex);
		helmetSlot.setName("helmet");
		helmetSlot.setContentAreaFilled(false);
		helmetSlot.setBounds(70,70,30,30);
		helmetSlot.addActionListener(this);
		layeredPanel.add(helmetSlot);
		
		int[] armorSlotIndex = {3,0};
		armorSlot = new ItemButton(ml,armorSlotIndex);
		armorSlot.setName("armor");
		armorSlot.setContentAreaFilled(false);
		armorSlot.setBounds(70,110,30,30);
		armorSlot.addActionListener(this);
		layeredPanel.add(armorSlot);
		
		int[] bootSlotIndex = {4,0};
		bootsSlot = new ItemButton(ml,bootSlotIndex);
		bootsSlot.setName("boots");
		bootsSlot.setContentAreaFilled(false);
		bootsSlot.setBounds(70, 220, 30, 30);
		bootsSlot.addActionListener(this);
		layeredPanel.add(bootsSlot);
		
		Image resizedSilhouette = silhouetteImage.getScaledInstance(70, 180, java.awt.Image.SCALE_SMOOTH);
		JLabel silhouette = new JLabel(new ImageIcon(resizedSilhouette));
		silhouette.setBounds(50, 70, 70, 180);
		layeredPanel.add(silhouette);
		
		goldLabel.setText("1000");
		goldLabel.setHorizontalAlignment(RIGHT);
		goldLabel.setForeground(Color.decode("0x911b1b"));
		goldLabel.setBounds(150, 452, 100, 20);
		layeredPanel.add(goldLabel);
		
		goldImage.setBounds(255, 452, 41, 20);
		layeredPanel.add(goldImage);
		
		close.setName("close");
		close.addMouseMotionListener(ml);
		close.addActionListener(this);
		close.setBorder(null);
		close.setContentAreaFilled(false);
		close.setBounds(272, -10, 50, 50);
		layeredPanel.add(close);
		
		JLabel statsLabel = new JLabel ("Inventory");
		statsLabel.setForeground(Color.WHITE);
		statsLabel.setBounds(110,13,100,20);
		statsLabel.setHorizontalAlignment(CENTER);
		layeredPanel.add(statsLabel);
		
		itemLabel.setOpaque(true);
		itemLabel.setBackground(Color.BLACK);
		itemLabel.setHorizontalAlignment(CENTER);
		itemLabel.setVisible(false);
		controller.add(itemLabel, 5, 0);
		
		JPanel inventoryHotkeyPanel = new JPanel (new GridLayout(0,6));
		inventoryHotkeyPanel.setBackground(Color.RED);
		inventoryHotkeyPanel.setVisible(true);
		inventoryHotkeyPanel.setBounds(10,270,300,50);
		layeredPanel.add(inventoryHotkeyPanel);
		
		for(int i = 0; i< 6; i++){
			int[] index = {i,1};
			ItemButton button = new ItemButton(ml,index);
			button.setName("itembar");
			button.addActionListener(this);
			button.addMouseListener(new MouseAdapter() { 
			    public void mouseClicked(MouseEvent e) {
			    	if(((ItemButton)e.getSource()).isEnabled() == true)
			        if (e.getButton() == 3) { 
			        	selectedBtn = (ItemButton)e.getSource();
			        	itemLabel.setVisible(false);
			        	popupMenu.show(e.getComponent(), e.getX(), e.getY());   	
			        }
			    }
			});
			itemBarBtnArray[i] = button;
			inventoryHotkeyPanel.add(button);
		}
		
		JPanel gridPanel = new JPanel(new GridLayout(0,7));
		gridPanel.setOpaque(false);
		gridPanel.setVisible(true);
		gridPanel.setBounds(10,325,300,120);
		layeredPanel.add(gridPanel);
		
		for(int i = 0; i< 21; i++){
			int[] index = {i,2};
			ItemButton button = new ItemButton(ml, index);
			//button.setName(String.valueOf(i+6));
			button.setName("inventory");
			button.addActionListener(this);
			button.addMouseListener(new MouseAdapter() { 
			    public void mouseClicked(MouseEvent e) {
			    	if(((ItemButton)e.getSource()).isEnabled() == true)
			        if (e.getButton() == 3) { 
			        	selectedBtn = (ItemButton)e.getSource();
			        	itemLabel.setVisible(false);
			        	
			        	popupMenu.show(e.getComponent(), e.getX(), e.getY());
			        	//popupMenu.add(useItem);
			        }
			    }
			});
			inventoryBtnArray[i] = button;
			gridPanel.add(button);
		}

		infoPanel.setOpaque(true);
		infoPanel.setEditable(false);
		infoPanel.setMargin(new Insets(30,10,10,10));
		infoPanel.setForeground(Color.decode("0x911b1b"));
		infoPanel.setBackground(Color.BLACK);
		infoPanel.setBounds(60, 147, 200, 200);
		infoPanel.setVisible(false);
		layeredPanel.add(infoPanel, 3, 0);
		
		JButton closeInfoPanel = new JButton("x");
		closeInfoPanel.setBounds(175,0,25,25);
		closeInfoPanel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				infoPanel.setVisible(false);
				for(int i = 0; i<itemBarBtnArray.length;i++){
					if(!itemBarBtnArray[i].isEmpty())
						itemBarBtnArray[i].setEnabled(true);
					else
						itemBarBtnArray[i].setEnabled(false);
				}
				for(int i = 0; i<inventoryBtnArray.length;i++){
					if(!inventoryBtnArray[i].isEmpty())
						inventoryBtnArray[i].setEnabled(true);
					else
						inventoryBtnArray[i].setEnabled(false);
				}
				if(!helmetSlot.isEmpty())
					helmetSlot.setEnabled(true);
				if(!bootsSlot.isEmpty())
					bootsSlot.setEnabled(true);
				if(!armorSlot.isEmpty())
					armorSlot.setEnabled(true);
				if(!weaponSlot.isEmpty())
					weaponSlot.setEnabled(true);
			}
		});
		infoPanel.add(closeInfoPanel);
		
	}
	
	public void setCharStats(int attack, int attackSpeed, int agility, int intelligence, int armor, int speed){
		charStats.setText("Attack: " + attack + "\n"
				+ "Attackspeed: " + attackSpeed + "\n"
				+ "Agility: " + agility + "\n"
				+ "Intelligence: "+ intelligence + "\n"
				+ "Armor: "+ armor + "\n"
				+ "Speed: "+ speed);
	}
	
	public void setGold(int goldAmount){
		goldLabel.setText(String.valueOf(goldAmount));
	}
	
	public void setSizes(){
		Image img = null;
		try {
			img = ImageIO.read(this.getClass().getResource("gui2images/menuFrame.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		Image resizedImg = img.getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(resizedImg));
		layeredPanel.setBounds(0, 0, getWidth(), getHeight());
	}
	
	public void setNewItemLabelPosition(int X, int Y){
		itemLabel.setBounds(X, Y, 50, 50);
	}
	
	private void closeInventory(){
		setVisible(false);
	}
	
	public void setInventory(InventoryTestumgebung[] itemBar, InventoryTestumgebung[] inventory, InventoryTestumgebung[]equipment){
		if(itemBar != null){
		for(int i = 0; i<itemBar.length; i++){
			itemBarBtnArray[i].setItem(itemBar[i]);
		}
			controller.reorderItemBar(itemBarBtnArray);
		}
		if(inventory != null)
		for(int i = 0; i<inventory.length; i++){
			inventoryBtnArray[i].setItem(inventory[i]);
		}
		if(equipment != null)
		for(int i = 0; i<equipment.length; i++){
			switch(equipment[i].getType()){
				case "weapon":
					weaponSlot.setItem(equipment[i]);
					break;
				case "helmet":
					helmetSlot.setItem(equipment[i]);
					break;
				case "armor":
					armorSlot.setItem(equipment[i]);
					break;
				case "boots":
					bootsSlot.setItem(equipment[i]);
					break;
			}
		}
	}
	
	public void setInventory(InventoryModel inventory){
		if(inventory.getQuickSlotList() != null){
			for(int i = 0; i<inventory.getQuickSlotList().length; i++){
				itemBarBtnArray[i].setItem(inventory.getQuickSlotList()[i]);
			}
				controller.reorderItemBar(itemBarBtnArray);
		}
		if(inventory.getInventoryContentList() != null){
			System.out.println(inventory.getInventoryContentList().length);
			for(int i = 0; i<inventory.getInventoryContentList().length;i++){
				
				inventoryBtnArray[i].setItem(inventory.getInventoryContentList()[i]);
			}
		}
		/*
		if(inventory.getEquipmentList()!=null){
			for(int i = 0; i<inventory.getEquipmentList().length();i++){
				
			}
		}*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().getClass().getSimpleName().equals("JButton")){
			if(((JButton)e.getSource()).getName() == "close"){
				closeInventory();
				itemSelected = false;
				itemLabel.setVisible(false);
				infoPanel.setVisible(false);
				for(int i = 0; i<itemBarBtnArray.length;i++){
					if(!itemBarBtnArray[i].isEmpty())
						itemBarBtnArray[i].setEnabled(true);
					else
						itemBarBtnArray[i].setEnabled(false);
				}
				for(int i = 0; i<inventoryBtnArray.length;i++){
					if(!inventoryBtnArray[i].isEmpty())
						inventoryBtnArray[i].setEnabled(true);
					else
						inventoryBtnArray[i].setEnabled(false);
				}
				if(!helmetSlot.isEmpty())
					helmetSlot.setEnabled(true);
				if(!bootsSlot.isEmpty())
					bootsSlot.setEnabled(true);
				if(!armorSlot.isEmpty())
					armorSlot.setEnabled(true);
				if(!weaponSlot.isEmpty())
					weaponSlot.setEnabled(true);
				if(!shieldSlot.isEmpty())
					shieldSlot.setEnabled(true);
			}
		} else if(e.getSource().getClass().getSimpleName().equals("ItemButton")){
			/*if(((JButton)e.getSource()).getName() == "inventory"||((JButton)e.getSource()).getName() == "itembar"||
					((JButton)e.getSource()).getName() == "weapon"||((JButton)e.getSource()).getName() == "shield"||
					((JButton)e.getSource()).getName() == "armor"||((JButton)e.getSource()).getName() == "helmet"||
					((JButton)e.getSource()).getName() == "boots"){
			*/	
				if(itemSelected){
					//item wird eingesetzt
					itemSelected = false;
					ItemButton temp = (ItemButton) e.getSource();
					oldBtn.setItem(temp.getItem());
					temp.setItem(copiedItem);
					removeMouseMotionListener(ml);
					itemLabel.setVisible(false);
					
					//neue Position des Items
					newItemIndex = temp.getIndex();
					
					for(int i = 0; i<itemBarBtnArray.length;i++){
						if(!itemBarBtnArray[i].isEmpty())
							itemBarBtnArray[i].setEnabled(true);
						else
							itemBarBtnArray[i].setEnabled(false);
					}
					for(int i = 0; i<inventoryBtnArray.length;i++){
						if(!inventoryBtnArray[i].isEmpty())
							inventoryBtnArray[i].setEnabled(true);
						else
							inventoryBtnArray[i].setEnabled(false);
					}
					
					if(!helmetSlot.isEmpty())
						helmetSlot.setEnabled(true);
					else 
						helmetSlot.setEnabled(false);
					
					if(!bootsSlot.isEmpty())
						bootsSlot.setEnabled(true);
					else
						bootsSlot.setEnabled(false);
					
					if(!armorSlot.isEmpty())
						armorSlot.setEnabled(true);
					else
						armorSlot.setEnabled(false);
					
					if(!weaponSlot.isEmpty())
						weaponSlot.setEnabled(true);
					else
						weaponSlot.setEnabled(false);
					
					if(!shieldSlot.isEmpty())
						shieldSlot.setEnabled(true);
					else
						shieldSlot.setEnabled(false);
					
				} else {
				//Item wird makiert
					itemSelected = true;
					controller.addMouseMotionListener(ml);
					addMouseMotionListener(ml);
				
					
					
					oldBtn = (ItemButton) e.getSource();
					copiedItem = oldBtn.getItem();
					
					//alte position des items
					oldItemIndex = oldBtn.getIndex();
				
					itemLabel.setIcon(new ImageIcon(oldBtn.getImage()));
					itemLabel.setVisible(true);
				
					//Items koennen auf beliebigen Slot im 21er Inventar abgelegt werden
					for(int i = 0; i<inventoryBtnArray.length;i++){
						inventoryBtnArray[i].setEnabled(true);
					}
					
					//wenn item kein consumable ist, kann es nicht in die itembar und nur in entsprechenden equipslot abgelegt werden
					if(!((ItemButton)e.getSource()).getType().equals("consumable")){
						for(int i = 0; i<itemBarBtnArray.length;i++){
							itemBarBtnArray[i].setEnabled(false);
						}
						
						// wenn item aus equip kommt, kann es nur durch gleichartrige items getauscht werden
						if(!((ItemButton)e.getSource()).getName().equals("inventory"))
							for(int i = 0; i<inventoryBtnArray.length;i++){
								if(inventoryBtnArray[i].getType() != ((ItemButton)e.getSource()).getType()){
									if(!inventoryBtnArray[i].isEmpty())
										inventoryBtnArray[i].setEnabled(false);
								}
							}
						
						// nur richtige slots werden freigeschaltet
						switch(((ItemButton)e.getSource()).getType()){
							case "weapon":
								weaponSlot.setEnabled(true);
								shieldSlot.setEnabled(false);
								helmetSlot.setEnabled(false);
								bootsSlot.setEnabled(false);
								armorSlot.setEnabled(false);
								break;
							case "shield":
								weaponSlot.setEnabled(false);
								shieldSlot.setEnabled(true);
								helmetSlot.setEnabled(false);
								bootsSlot.setEnabled(false);
								armorSlot.setEnabled(false);
								break;
							case "armor":
								weaponSlot.setEnabled(false);
								shieldSlot.setEnabled(false);
								helmetSlot.setEnabled(false);
								bootsSlot.setEnabled(false);
								armorSlot.setEnabled(true);
								break;
							case "boots":
								weaponSlot.setEnabled(false);
								shieldSlot.setEnabled(false);
								helmetSlot.setEnabled(false);
								bootsSlot.setEnabled(true);
								armorSlot.setEnabled(false);
								break;
							case "helmet":
								weaponSlot.setEnabled(false);
								shieldSlot.setEnabled(false);
								helmetSlot.setEnabled(true);
								bootsSlot.setEnabled(false);
								armorSlot.setEnabled(false);
								break;
						}
					} else {
						//consumable
						//alle itembarslots sind fuer consumables verfuegbar
						for(int i = 0; i<itemBarBtnArray.length;i++){
							itemBarBtnArray[i].setEnabled(true);
						}
						
						for(int i = 0; i<inventoryBtnArray.length;i++){
							if(inventoryBtnArray[i].isEmpty() == false)
								if(!inventoryBtnArray[i].getType().equals("consumable")){
									inventoryBtnArray[i].setEnabled(false);
								}
						}
						weaponSlot.setEnabled(false);
						shieldSlot.setEnabled(false);
						helmetSlot.setEnabled(false);
						bootsSlot.setEnabled(false);
						armorSlot.setEnabled(false);
					}
				}
			//}
		} /*else if(e.getSource().getClass().getSimpleName().equals("JMenuItem")){
			if(((JMenuItem) e.getSource()).getName() == "use"){
				System.out.println("use item " + selectedBtn.getItem().getImageName());
				if(!selectedBtn.getType().equals("consumable")){
					switch(selectedBtn.getType()){
					case "weapon":

						copiedItem = selectedBtn.getItem();
						selectedBtn.setItem(weaponSlot.getItem());
						weaponSlot.setItem(copiedItem);
												
						break;
					case "armor":
						copiedItem = selectedBtn.getItem();
						selectedBtn.setItem(armorSlot.getItem());
						armorSlot.setItem(copiedItem);
						
						break;
					case "boots":
						copiedItem = selectedBtn.getItem();
						selectedBtn.setItem(bootsSlot.getItem());
						bootsSlot.setItem(copiedItem);
						
						break;
					case "helmet":
						copiedItem = selectedBtn.getItem();
						selectedBtn.setItem(helmetSlot.getItem());
						helmetSlot.setItem(copiedItem);
						
						break;
					}
				}
			} else if(((JMenuItem) e.getSource()).getName() == "info"){
				System.out.println("show info");
				
				//infoPanel.setText(selectedBtn.getItem().getImageName());
				infoPanel.setVisible(true);
				
				for(int i=0; i<itemBarBtnArray.length;i++){
					itemBarBtnArray[i].setEnabled(false);
				}
				for(int i=0; i<inventoryBtnArray.length;i++){
					inventoryBtnArray[i].setEnabled(false);
				}
				weaponSlot.setEnabled(false);
				helmetSlot.setEnabled(false);
				bootsSlot.setEnabled(false);
				armorSlot.setEnabled(false);
				
			} else if (((JMenuItem) e.getSource()).getName() == "drop"){
				//System.out.println("drop item " + selectedBtn.getItem().getImageName());
				//selectedBtn.setItem(null);
			}
			
		}*/
		controller.reorderItemBar(itemBarBtnArray);
	}
	
}
package komponente.guiII;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Class for the InventoryPanel
 * @author Vinzenz Liem Bui
 */
public class InventoryPanel extends JLabel implements ActionListener{

	private JLayeredPane layeredPanel = new JLayeredPane();
	
	private JLabel itemLabel = new JLabel();
	private IngamePanel controller;
	private ItemMouseListener ml;
	private Boolean itemSelected = false;
	
	private JPopupMenu popupMenu = new JPopupMenu();
	
	private InventoryTestumgebung copiedItem;
	private ItemButton selectedBtn;
	private ItemButton oldBtn;
	private ItemButton itemBarBtnArray[] = new ItemButton[6];
	private ItemButton inventoryBtnArray[] = new ItemButton[21];
	
	private JLabel goldLabel = new JLabel();
	
	private JTextArea charStats = new JTextArea();
	
	private ItemButton helmetSlot;
	private ItemButton armorSlot;
	private ItemButton bootsSlot;
	private ItemButton weaponSlot;
		
	private JTextArea infoPanel = new JTextArea("Lorem ipsum");
	/**
	 * Constructor, requires the IngamePanel instance
	 * @author Vinzenz Liem Bui
	 */
	public InventoryPanel(IngamePanel controller){
		setLayout(null);
		this.controller = controller;
		ml = new ItemMouseListener(this);
		setVisible(false);
		
		add(layeredPanel);
		
		charStats.setBounds(150, 70, 150, 180);
		charStats.setOpaque(false);
		charStats.setEditable(false);
		charStats.addMouseMotionListener(ml);
		charStats.setForeground(Color.decode("0x911b1b"));
		charStats.setText("Attack: 0\nAttackspeed: 0\nAgility: 0\nIntelligence: 0\nArmor: 0\nSpeed: 0");
		layeredPanel.add(charStats);
		
		JMenuItem useItem = new JMenuItem("Use");
		useItem.addActionListener(this);
		useItem.setName("use");
		popupMenu.add(useItem);
		JMenuItem infoItem = new JMenuItem("Info");
		infoItem.addActionListener(this);
		infoItem.setName("info");
		popupMenu.add(infoItem);
		popupMenu.addSeparator();
		JMenuItem dropItem = new JMenuItem("Drop");
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
		weaponSlot = new ItemButton(ml);
		weaponSlot.setName("weapon");
		weaponSlot.setContentAreaFilled(false);
		weaponSlot.setBounds(20,140,30,30);
		weaponSlot.addActionListener(this);
		layeredPanel.add(weaponSlot);
		helmetSlot = new ItemButton(ml);
		helmetSlot.setName("helmet");
		helmetSlot.setContentAreaFilled(false);
		helmetSlot.setBounds(70,70,30,30);
		helmetSlot.addActionListener(this);
		layeredPanel.add(helmetSlot);
		armorSlot = new ItemButton(ml);
		armorSlot.setName("armor");
		armorSlot.setContentAreaFilled(false);
		armorSlot.setBounds(70,110,30,30);
		armorSlot.addActionListener(this);
		layeredPanel.add(armorSlot);
		bootsSlot = new ItemButton(ml);
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
			ItemButton button = new ItemButton(ml);
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
			ItemButton button = new ItemButton(ml);
			button.setName(String.valueOf(i+6));
			button.setName("inventory");
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
	/**
	 * sets the current Character stats, if you put on new items like swords or boots
	 * @author Vinzenz Liem Bui
	 */
	public void setCharStats(int attack, int attackSpeed, int agility, int intelligence, int armor, int speed){
		charStats.setText("Attack: " + attack + "\n"
				+ "Attackspeed: " + attackSpeed + "\n"
				+ "Agility: " + agility + "\n"
				+ "Intelligence: "+ intelligence + "\n"
				+ "Armor: "+ armor + "\n"
				+ "Speed: "+ speed);
	}
	/**
	 * sets the current gold
	 * @author Vinzenz Liem Bui
	 */
	public void setGold(int goldAmount){
		goldLabel.setText(String.valueOf(goldAmount));
	}
	/**
	 * sets all the positions (necessary, because of absolute positioning -> while the panel is not visible, 
	 * the getWidth / getHeight method returns 0, so we have to call this function, while the panel is visible)
	 * @author Vinzenz Liem Bui
	 */
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
	/**
	 * method to refresh the position of the ItemLabel, which is shown next to the pointer, while moving an item
	 * @author Vinzenz Liem Bui
	 */
	public void setNewItemLabelPosition(int X, int Y){
		itemLabel.setBounds(X, Y, 50, 50);
	}
	/**
	 * closes the inventory
	 * @author Vinzenz Liem Bui
	 */
	private void closeInventory(){
		setVisible(false);
	}
	/**
	 * sets the current inventory, requires 3 arrays for the itembar(up to 6 items), equipment (up to 4 items) and inventory(up to 21 items)
	 * @author Vinzenz Liem Bui
	 */
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
	/**
	 * the actionlistener is of paramount importance for moving the items.
	 * @author Vinzenz Liem Bui
	 */
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
			}
		} else if(e.getSource().getClass().getSimpleName().equals("ItemButton")){
			if(((JButton)e.getSource()).getName() == "inventory"||((JButton)e.getSource()).getName() == "itembar"||
					((JButton)e.getSource()).getName() == "weapon"||((JButton)e.getSource()).getName() == "armor"||
					((JButton)e.getSource()).getName() == "helmet"||((JButton)e.getSource()).getName() == "boots"){
				
				if(itemSelected){
					//item wird eingesetzt
					itemSelected = false;
					ItemButton temp = (ItemButton) e.getSource();
					oldBtn.setItem(temp.getItem());
					temp.setItem(copiedItem);
					removeMouseMotionListener(ml);
					itemLabel.setVisible(false);
					
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
					
				} else {
				//Item wird makiert
					itemSelected = true;
					controller.addMouseMotionListener(ml);
					addMouseMotionListener(ml);
				
					oldBtn = (ItemButton) e.getSource();
					copiedItem = oldBtn.getItem();
				
					itemLabel.setIcon(new ImageIcon(oldBtn.getImage()));
					itemLabel.setVisible(true);
				
					
					for(int i = 0; i<inventoryBtnArray.length;i++){
						inventoryBtnArray[i].setEnabled(true);
					}
					
					if(!((ItemButton)e.getSource()).getType().equals("consumable")){
						for(int i = 0; i<itemBarBtnArray.length;i++){
							itemBarBtnArray[i].setEnabled(false);
						}
						
						if(!((ItemButton)e.getSource()).getName().equals("inventory"))
						for(int i = 0; i<inventoryBtnArray.length;i++){
							if(inventoryBtnArray[i].getType() != ((ItemButton)e.getSource()).getType()){
								if(!inventoryBtnArray[i].isEmpty())
									inventoryBtnArray[i].setEnabled(false);
							}
						}
						
						switch(((ItemButton)e.getSource()).getType()){
							case "weapon":
								weaponSlot.setEnabled(true);
								helmetSlot.setEnabled(false);
								bootsSlot.setEnabled(false);
								armorSlot.setEnabled(false);
								break;
							case "armor":
								weaponSlot.setEnabled(false);
								helmetSlot.setEnabled(false);
								bootsSlot.setEnabled(false);
								armorSlot.setEnabled(true);
								break;
							case "boots":
								weaponSlot.setEnabled(false);
								helmetSlot.setEnabled(false);
								bootsSlot.setEnabled(true);
								armorSlot.setEnabled(false);
								break;
							case "helmet":
								weaponSlot.setEnabled(false);
								helmetSlot.setEnabled(true);
								bootsSlot.setEnabled(false);
								armorSlot.setEnabled(false);
								break;
						}
					} else {
						
						for(int i = 0; i<itemBarBtnArray.length;i++){
							itemBarBtnArray[i].setEnabled(true);
						}
						
						weaponSlot.setEnabled(false);
						helmetSlot.setEnabled(false);
						bootsSlot.setEnabled(false);
						armorSlot.setEnabled(false);
					}
				}
			}
		} else if(e.getSource().getClass().getSimpleName().equals("JMenuItem")){
			if(((JMenuItem) e.getSource()).getName() == "use"){
				System.out.println("use item " + selectedBtn.getItem().getImageName());
			} else if(((JMenuItem) e.getSource()).getName() == "info"){
				System.out.println("show info");
				
				infoPanel.setText(selectedBtn.getItem().getImageName());
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
				System.out.println("drop item " + selectedBtn.getItem().getImageName());
				selectedBtn.setItem(null);
			}
			
		}
		controller.reorderItemBar(itemBarBtnArray);
	}
	
}
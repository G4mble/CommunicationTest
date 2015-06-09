package komponente.guiII;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
/**
 * class for itembutton
 * @author Vinzenz Liem Bui
 */
public class ItemButton extends JButton{
	
	private int itemID = 0;
	private Image img;
	private String imageName;
	private String type;
	private Boolean empty = true;
	private int amount = 0;
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
	/**
	 * constructor for a button if no MouseMotionListener is needed (itembar)
	 * @author Vinzenz Liem Bui
	 */
	public ItemButton(){
		setLayout(null);
		setEnabled(false);
	}
	/**
	 * constructor for itembuttons in the inventoy, the ItemMouseListener is important, so that
	 * the itemlabel's position is also refreshed, while the cursor is above an itembutton.
	 * @author Vinzenz Liem Bui
	 */
	public ItemButton(ItemMouseListener ml){
		setLayout(null);
		if(ml != null)
		addMouseMotionListener(ml);
		setEnabled(false);
	}
	
	/**
	 * returns if the button is empty, meaning, that it holds no item
	 * @author Vinzenz Liem Bui
	 */
	public Boolean isEmpty(){
		return empty;
	}
	/**
	 * sets an item to the button
	 * @author Vinzenz Liem Bui
	 */
	public void setItem(InventoryTestumgebung item){
		
		if(item != null){
			setEnabled(true);
			
		
			
			this.imageName = item.getImageName();
			this.itemID = item.getItemID();
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
			this.itemID = -1;
			this.imageName = null;
			this.type = null;
			this.amount = 0;
			remove(amountCounter);
			setIcon(null);
			setEnabled(false);
			empty = true;
		}
	}
	/**
	 * returns the item assigned to the button
	 * @author Vinzenz Liem Bui
	 */
	public InventoryTestumgebung getItem(){
		if(imageName != null)
			return new InventoryTestumgebung(itemID, imageName, type, amount);
		else 
			return null;
	}
	/**
	 * returns the type of the item
	 * @author Vinzenz Liem Bui
	 */
	public String getType(){
		return type;
	}
	/**
	 * returns the image
	 * @author Vinzenz Liem Bui
	 */
	public Image getImage(){
		return img;
	}
	
	
}

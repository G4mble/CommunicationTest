package komponente.guiII;
/**
 * @author Vinzenz Liem Bui
 */
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * itembar class
 * @author Vinzenz Liem Bui
 */
public class ItemBar extends JLabel implements ActionListener{

	private IngamePanel ip;
	private ItemButton[] buttonArray = new ItemButton[6];
	/**
	 * constructor
	 * @author Vinzenz Liem Bui
	 */
	public ItemBar(IngamePanel ip){
		this.ip = ip;
		setLayout(null);
		//setBackground(Color.decode("0x8b4513"));
		try {
			setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("gui2images/Bar.png"))));
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		}
		
		setBackground(Color.BLACK);
		for(int i = 0; i<6;i++){
			ItemButton itemButton = new ItemButton(null);
			itemButton.setFocusable(false);
			itemButton.setName(String.valueOf(i));
			itemButton.setBounds(5 + i*41,8,34,34);
			add(itemButton);
			
			buttonArray[i] = itemButton;
			
			itemButton.addActionListener(this);
		}
	}
	/**
	 * gets the item at button number i
	 * @author Vinzenz Liem Bui
	 */
	public InventoryTestumgebung getItemOfButton(int i){
		return buttonArray[i].getItem();
	}
	/**
	 * returns if button i is empty or not
	 * @author Vinzenz Liem Bui
	 */
	public Boolean isEmpty(int i){
		return buttonArray[i].isEmpty();
	}
	/**
	 * sets the current itembar
	 * @author Vinzenz Liem Bui
	 */
	public void setNewBar(ItemButton[] btnArray){

		for(int i = 0; i<btnArray.length; i++){
			ItemButton oldBtn = buttonArray[i];
			ItemButton newBtn = btnArray[i];
			oldBtn.setItem(newBtn.getItem());
		}
	}
	/**
	 * uses item at position i
	 * @author Vinzenz Liem Bui
	 */
	private void useItem(int i){
		ip.useItem(i);
	}
	/**
	 * actionlistener, to recognize when a button is clicked
	 * @author Vinzenz Liem Bui
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton btn = (JButton)e.getSource();
		useItem(Integer.parseInt(btn.getName()));
		
	}
}

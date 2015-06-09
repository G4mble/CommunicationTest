package pp2015.team12.client.gui;
/**
 * @author Vinzenz Liem Bui
 */
import javax.imageio.ImageIO;
import javax.swing.*;

import pp2015.team12.shared.item.ItemModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ItemBar extends JLabel implements ActionListener{

	private IngamePanel ip;
	private ItemButton[] buttonArray = new ItemButton[6];
	
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
			int[] index = {i,1};
			ItemButton itemButton = new ItemButton(index);
			itemButton.setFocusable(false);
			itemButton.setName(String.valueOf(i));
			itemButton.setBounds(5 + i*41,8,34,34);
			add(itemButton);
			
			buttonArray[i] = itemButton;
			
			itemButton.addActionListener(this);
		}
	}
	
	public ItemModel getItemOfButton(int i){
		return buttonArray[i].getItem();
	}
	
	public Boolean isEmpty(int i){
		return buttonArray[i].isEmpty();
	}
	
	public void setNewBar(ItemButton[] btnArray){

		for(int i = 0; i<btnArray.length; i++){
			ItemButton oldBtn = buttonArray[i];
			ItemButton newBtn = btnArray[i];
			oldBtn.setItem(newBtn.getItem());
		}
	}
	
	private void useItem(int itemPos){
		ip.useItem(itemPos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton btn = (JButton)e.getSource();
		useItem(Integer.parseInt(btn.getName()));
		
	}
}

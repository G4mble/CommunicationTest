package pp2015.team12.client.gui;

import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;


public class ItemMouseListener implements MouseMotionListener{

	private InventoryPanel inventoryPanel;
	private ItemButton itemButton;
	
	public ItemMouseListener(InventoryPanel inventoryPanel){
		this.inventoryPanel = inventoryPanel;
	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Point pt = SwingUtilities.convertPoint((Component) e.getSource(), e.getX(), e.getY(), inventoryPanel.getParent());
		inventoryPanel.setNewItemLabelPosition(pt.x, pt.y);

	}

}

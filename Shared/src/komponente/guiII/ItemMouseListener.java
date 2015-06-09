package komponente.guiII;

import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

/**
 * class for the MouseMotionListener, needed to refresh the itemlabel position
 * @author Vinzenz Liem Bui
 */
public class ItemMouseListener implements MouseMotionListener{

	private InventoryPanel inventoryPanel;
	private ItemButton itemButton;
	/**
	 * constructor, requires the inventoryPanel as input, so that the correct position can be calculated
	 * @author Vinzenz Liem Bui
	 */
	public ItemMouseListener(InventoryPanel inventoryPanel){
		this.inventoryPanel = inventoryPanel;
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * calculates and sets the coordinates of the cursor for the itemlabel
	 * @author Vinzenz Liem Bui
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Point pt = SwingUtilities.convertPoint((Component) e.getSource(), e.getX(), e.getY(), inventoryPanel.getParent());
		inventoryPanel.setNewItemLabelPosition(pt.x, pt.y);

	}

}

package pp2015.team12.shared.item;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pp2015.team12.shared.character.PlayerCharacter;

/**
 * abstract superclass for ingame items: equipment and consumables
 * @author Staufenberg, Thomas, 5820359
 * */
@SuppressWarnings("serial")
public abstract class ItemModel implements Serializable
{
	protected int itemID, itemGoldValue;			//itemID is required to be -1 if the item is newly created (DB indicator)
	private String itemName, itemImagePath;
	private int xPos, yPos;							//only required when put into globalInventory
	private Image itemImage;
	
	/**
	 * constructor used for creating items read from the DB and as internal constructor
	 * stores parameter in global variables; reads image from imagePath
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public ItemModel(int paramID, int paramGoldValue, String paramName, String paramImagePath)
	{
		this.itemID = paramID;
		this.itemGoldValue = paramGoldValue;
		this.itemName = paramName;
		this.itemImagePath = paramImagePath;
	}
	
	/**
	 * constructor used when creating a NEW item -> ensures itemID = -1</br>
	 * forwards all values to second constructor
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public ItemModel(int paramGoldValue, String paramName, String paramImagePath)
	{
		this(-1, paramGoldValue, paramName, paramImagePath);
	}
	
	/**
	 * moves the current item to the given position in the inventoryContentList
	 * @param paramPlayer the player the item belongs to
	 * @param paramInventoryPosition the position the item is to be moved to
	 * @param paramPreviousInventoryPosition the position where the item was previously located
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void moveInInventory(PlayerCharacter paramPlayer, int paramInventoryPosition, int paramPreviousInventoryPosition)
	{
		paramPlayer.getInventory().moveItemInInventory(this, paramInventoryPosition, paramPreviousInventoryPosition);
	}
	
	/**
	 * moves the current item to the given player inventory
	 * @param paramPlayer the PlayerCharacter model of the player that wants to pick up the item
	 * @return true: item successfully added</br>false: inventory full
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean pickup(PlayerCharacter paramPlayer)
	{
		if(!(paramPlayer.getInventory().addItemToInventory(this)))
			if(!((this instanceof ConsumableModel) && (paramPlayer.getInventory().addItemToQuickSlotList((ConsumableModel)this, -1, -1))))
				return false;
		return true;
	}
	
	/**
	 * drops the current item to the globalInventory
	 * @param paramPlayer PlayerCharacter model of the player that wants to drop the item
	 * @param paramGlobalInventory globalInventory of the level in which player is currently located
	 * @return true: item successfully dropped</br>false: item not in inventory OR error during InventoryModel.removeFromEquip()
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean drop(PlayerCharacter paramPlayer, ArrayList<ItemModel> paramGlobalInventory)
	{
		boolean isRemoved = false;
		
		if(paramPlayer.getInventory().removeItemFromInventory(this))
			isRemoved = true;
		else if((this instanceof EquipmentModel) && (((EquipmentModel) this).removeFromEquip(paramPlayer, false, -1)))
			isRemoved = true;
		else if((this instanceof ConsumableModel) && (paramPlayer.getInventory().removeItemFromQuickSlotList((ConsumableModel)this)))
			isRemoved = true;
		
		if(isRemoved)
		{
			if(this instanceof EquipmentModel)
				((EquipmentModel) this).setItemID(-1);
			this.setXPos(paramPlayer.getPosX());
			this.setYPos(paramPlayer.getPosY());
			paramGlobalInventory.add(this);
			return true;
		}
		return false;
	}
	
	/**
	 * sells the current Item if it's not a GoldStack
	 * @param paramPlayer PlayerCharacter model of the player selling the item
	 * @return true: item successfully sold, and gold added to players goldCount</br>false: item cannot be sold
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean sell(PlayerCharacter paramPlayer)
	{
		if(!(this instanceof GoldStack))
		{
			paramPlayer.getInventory().sellItem(this);
			return true;
		}
		return false;
	}
	
	/**
	 * reads the itemImage depending on the current itemImagePath
	 * @author Staufenberg, Thomas, 5820359 
	 * */
	public void readItemTexture()
	{
		try
		{
			this.itemImage = ImageIO.read(new File(this.itemImagePath));
		}
		catch(IOException ioE)
		{
			//TODO handle exception
		}
	}
	
	/**
	 * sets the xPos of the item to the given value
	 * @param paramXPos xPosition to be set
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void setXPos(int paramXPos)
	{
		this.xPos = paramXPos;
	}

	/**
	 * sets the yPos of the item to the given value
	 * @param paramYPos yPosition to be set
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void setYPos(int paramYPos)
	{
		this.yPos = paramYPos;
	}
	
	/**
	 * @return ID of the current item
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public int getItemID()
	{
		return this.itemID;
	}
	
	/**
	 * @return gold value of the current item
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public int getItemGoldValue()
	{
		return this.itemGoldValue;
	}
	
	/**
	 * @return name of the current item
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public String getItemName()
	{
		return this.itemName;
	}
	
	/**
	 * @return absolute path of the image of the current item
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public String getItemImagePath()
	{
		return this.itemImagePath;
	}
	
	/**
	 * @return the xPosition where the item is positioned on the map
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public int getXPos()
	{
		return this.xPos;
	}
	
	/**
	 * @return the yPosition where the item is positioned on the map
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public int getYPos()
	{
		return this.yPos;
	}
	
	/**
	 * @return image of the current item
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public Image getItemImage()
	{
		return this.itemImage;
	}
}
package pp2015.team12.shared.character;

import pp2015.team12.shared.InventoryModel;
import pp2015.team12.shared.item.Boots;
import pp2015.team12.shared.item.ChestArmor;
import pp2015.team12.shared.item.EquipmentModel;
import pp2015.team12.shared.item.Helmet;
import pp2015.team12.shared.item.OneHandedWeapon;
import pp2015.team12.shared.item.Shield;
import pp2015.team12.shared.statistics.StatisticsModel;

/**
 * implementation of the mage class(playable character)
 * @author Staufenberg, Thomas, 5820359
 * */
@SuppressWarnings("serial")
public class Mage extends PlayerCharacter
{
	private int currentMana, maximumMana;
	
	/**
	 * secondary constructor, calls primary constructor</br>
	 * sets all default values and generates default equipment</br>
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public Mage(int clientId)
	{
		this(clientId, 1, 0, 70, 10, 1,new InventoryModel(), new StatisticsModel());
		this.generateDefaultEquipment();
	}
	
	/**
	 * primary constructor, calls super constructor</br>
	 * creates new Mage and forwards all given values to the superclass</br>sets the mages maximum and current mana
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public Mage(int clientId, int level, int experiencePoints, int life, int attack, int defense,InventoryModel inventory, StatisticsModel statistics)
	{
		super(clientId, level, experiencePoints, life, attack, defense,"Magier", -1, -1, "mage.png", inventory, statistics,0);
		this.maximumMana = 100;
		this.currentMana = this.maximumMana;
	}

	/**
	 * generates default equipment for the mage
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private void generateDefaultEquipment()
	{
		EquipmentModel[] defaultEquip = new EquipmentModel[5];
		defaultEquip[0] = new OneHandedWeapon(-1, 1, 1, 1, 0, 0);
		defaultEquip[1] = new Shield(-1, 1, 1, 0, 1, 1);
		defaultEquip[2] = new Helmet(-1, 1, 1, 0, 1, 1);
		defaultEquip[3] = new ChestArmor(-1, 1, 1, 0, 1, 1);
		defaultEquip[4] = new Boots(-1, 1, 1, 0, 1, 1);
		this.getInventory().setEquipmentList(defaultEquip);
	}

	/**
	 * tries to set the currentMana to the given value
	 * @param paramMana the mana to be set
	 * @return true: mana successfully set</br>false: mana already at cap
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public boolean setCurrentMana(int paramMana)
	{
		if(paramMana < this.currentMana)
		{
			if(paramMana < 0)
				this.currentMana = 0;
			else
				this.currentMana = paramMana;
			return true;
		}
		if(this.currentMana < this.maximumMana)
		{
			if(paramMana <= this.maximumMana)
				this.currentMana = paramMana;
			else
				this.currentMana = this.maximumMana;
			return true;
		}
		else
		{
//			JOptionPane.showMessageDialog(null, "Sie haben bereits volles Mana!", "Achtung!", JOptionPane.WARNING_MESSAGE);
			System.out.println("Sie haben bereits volles Mana!");
			return false;
		}
	}
	
	/**
	 * @return the currentMana
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public int getCurrentMana()
	{
		return this.currentMana;
	}
	
	/**
	 * @return the maximumMana
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public int getMaximumMana()
	{
		return this.maximumMana;
	}
}

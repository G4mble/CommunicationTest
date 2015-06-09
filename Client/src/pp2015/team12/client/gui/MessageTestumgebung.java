package pp2015.team12.client.gui;

public class MessageTestumgebung {

	private String type;
	
	//chatnachricht
	public String submitter;
	public String chatMessage;
	
	//update Inventory
	public InventoryTestumgebung[] equipment;
	public InventoryTestumgebung[] itemBar;
	public InventoryTestumgebung[] inventory;
	
	//update Status
	public int newHealth;
	public int newMana;
	public int newExperience;
	public int newLevel;
	public int newGold;
	
	//update Map
	public int[][] newMap;
	
	//update character status
	public int attack;
	public int attackSpeed;
	public int agility;
	public int intelligence;
	public int armor;
	public int speed;
	
	//update statistic
	int anz;
	int serie;
	int tode;
	String kd;
	String waffe;
	String forts;
	String zeit;
	
	//systemnachricht
	
	public MessageTestumgebung(int anz, int serie, int tode, String kd, String waffe, String forts, String zeit){
		type = "statistic";
		this.anz = anz;
		this.serie = serie;
		this.tode = tode;
		this.kd = kd;
		this.waffe = waffe;
		this.forts = forts;
		this.zeit = zeit;
	}
	
	public MessageTestumgebung(String submitter,String chatMessage){
		this.type = "chat";
		this.submitter = submitter;
		this.chatMessage = chatMessage;
	}
	
	public MessageTestumgebung(int attack, int attackSpeed, int agility, int intelligence, int armor, int speed){
		this.type = "charStats";
		this.attack = attack;
		this.attackSpeed = attackSpeed;
		this.agility = agility;
		this.intelligence = intelligence;
		this.armor = armor;
		this.speed = speed;
	}
	
	public MessageTestumgebung(InventoryTestumgebung[] equipment,InventoryTestumgebung[] itemBar,InventoryTestumgebung[] inventory){
		this.type = "inventory";
		this.equipment = equipment;
		this.itemBar = itemBar;
		this.inventory = inventory;
	}
	
	public MessageTestumgebung(int newHealth, int newMana, int newExperience, int newLevel, int newGold){
		this.type = "status";
		this.newHealth = newHealth;
		this.newMana = newMana;
		this.newExperience = newExperience;
		this.newLevel = newLevel;
		this.newGold = newGold;
	}
	
	public MessageTestumgebung(int[][]newMap){
		this.type = "map";
		this.newMap = newMap;
	}
	
	public String getType(){
		return type;
	}
	
	public MessageTestumgebung getMessage(){
		return this;
	}
	
	
	
}

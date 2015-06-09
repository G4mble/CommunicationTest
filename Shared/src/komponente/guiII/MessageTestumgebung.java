package komponente.guiII;
/**
 * temporary class for the messages, which the client engine would pass to the gui
 * @author Vinzenz Liem Bui
 */
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
	
	/**
	 * constructor for a statistic message
	 * @author Vinzenz Liem Bui
	 */
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
	/**
	 * constructor for chat message
	 * @author Vinzenz Liem Bui
	 */
	public MessageTestumgebung(String submitter,String chatMessage){
		this.type = "chat";
		this.submitter = submitter;
		this.chatMessage = chatMessage;
	}
	/**
	 * constructor for charstats message
	 * @author Vinzenz Liem Bui
	 */
	public MessageTestumgebung(int attack, int attackSpeed, int agility, int intelligence, int armor, int speed){
		this.type = "charStats";
		this.attack = attack;
		this.attackSpeed = attackSpeed;
		this.agility = agility;
		this.intelligence = intelligence;
		this.armor = armor;
		this.speed = speed;
	}
	/**
	 * constructor for an inventory message
	 * @author Vinzenz Liem Bui
	 */
	public MessageTestumgebung(InventoryTestumgebung[] equipment,InventoryTestumgebung[] itemBar,InventoryTestumgebung[] inventory){
		this.type = "inventory";
		this.equipment = equipment;
		this.itemBar = itemBar;
		this.inventory = inventory;
	}
	/**
	 * constructor for the status message
	 * @author Vinzenz Liem Bui
	 */
	public MessageTestumgebung(int newHealth, int newMana, int newExperience, int newLevel, int newGold){
		this.type = "status";
		this.newHealth = newHealth;
		this.newMana = newMana;
		this.newExperience = newExperience;
		this.newLevel = newLevel;
		this.newGold = newGold;
	}
	/**
	 * constructor for a new map
	 * @author Vinzenz Liem Bui
	 */
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

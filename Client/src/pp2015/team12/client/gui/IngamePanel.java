package pp2015.team12.client.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import pp2015.team12.shared.character.PlayerCharacter;
import pp2015.team12.shared.message.*;

/**
 * @author Vinzenz Liem Bui
 */

public class IngamePanel extends JLayeredPane implements KeyListener{
	
	GamePanel gp;
	
	public ChatBox chatBox = new ChatBox();
	private Frame controller;
	private JTextField messageField;
	private ItemBar itemBar = new ItemBar(this);
	private MiniMap miniMap = new MiniMap();
	
	private JScrollPane scrollPane = new JScrollPane (chatBox);
	private JButton logoutButton = new JButton();
	private JButton statsButton = new JButton();
	private JButton inventoryButton = new JButton();
	private JButton privateMessage = new JButton("PM");
	private JButton publicMessage = new JButton("PublicM");
	
	private JLabel portraitPanel = new JLabel();
	private JProgressBar experience = new JProgressBar();
	private JProgressBar health = new JProgressBar();
	private JProgressBar mana = new JProgressBar();
	private JLabel levelLabel = new JLabel("0");
	
	private InventoryPanel inventoryPanel;
	private StatisticsPanel statisticsPanel;
	
	private JLabel systemBar;
	
	private String username;
	
	private PlayerCharacter myCharacter;
		
	public IngamePanel(Frame controller){
		//super(null);
		setLayout(null);
		setBackground(Color.WHITE);
		
		setFocusable(true);
		this.controller = controller;
		
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
	    scrollPane.setBorder(null);
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
		add(scrollPane,2,0);
		
		messageField = new JTextField();
		add(messageField,2,0);
		messageField.setVisible(false);
		messageField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					sendMessage();
					scrollPane.validate();
					scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
			}
		});

		add(itemBar,2,0);

		Image img;
		try {
			URL urlToImage = this.getClass().getResource("gui2images/portrait.png");
			img = ImageIO.read(urlToImage);
			portraitPanel.setIcon(new ImageIcon(img));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		}
		
		portraitPanel.setBounds(50, 30, 222, 84);
		add(portraitPanel,2,0);
		
		add(miniMap,2,0);	

		try {
			logoutButton = new JButton(new ImageIcon(ImageIO.read(this.getClass().getResource("gui2images/logoutButton.png"))));
			statsButton = new JButton(new ImageIcon(ImageIO.read(this.getClass().getResource("gui2images/statsButton.png"))));
			inventoryButton = new JButton(new ImageIcon(ImageIO.read(this.getClass().getResource("gui2images/inventoryButton.png"))));
			systemBar = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("gui2images/systemBar.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		}
		
		logoutButton.setBorder(null);
		logoutButton.setContentAreaFilled(false);
		add(logoutButton,3,0);
		logoutButton.setFocusable(false);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Do Logout");
				controller.showLogin();
				inventoryPanel.setVisible(false);
				statisticsPanel.setVisible(false);
				// requestlogout message
			}
		});
		statsButton.setBorder(null);
		statsButton.setContentAreaFilled(false);
		add(statsButton,3,0);
		statsButton.setFocusable(false);
		statsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openStatistics();
			}
		});
		inventoryButton.setBorder(null);
		inventoryButton.setContentAreaFilled(false);
		add(inventoryButton,3,0);
		inventoryButton.setFocusable(false);
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInventory();
			}
		});
		add(systemBar,2,0);
		/*
		add(privateMessage);
		privateMessage.setFocusable(false);
		privateMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("privateMessage");
			}
		});

		add(publicMessage);
		publicMessage.setFocusable(false);
		publicMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("publicMessage");
				openPublicChat();
			}
		});
		*/
		
		experience.setForeground(Color.YELLOW);
		experience.setValue(100);
		add(experience,2,0);
		
		health.setBounds(85, 10, 118, 12);
		health.setForeground(Color.RED);
		health.setBorder(null);
		health.setValue(100);
		portraitPanel.add(health);
		
		mana.setBounds(85, 25, 118, 12);
		mana.setForeground(Color.BLUE);
		mana.setBorder(null);
		mana.setValue(100);
		portraitPanel.add(mana);
		
		levelLabel.setBounds(29, 65, 25, 10);
		levelLabel.setHorizontalAlignment(JLabel.CENTER);
		levelLabel.setForeground(Color.WHITE);
		portraitPanel.add(levelLabel);
		
		inventoryPanel = new InventoryPanel(this);
		add(inventoryPanel,2,0);
		
		statisticsPanel = new StatisticsPanel();
		add(statisticsPanel,2,0);
		
		
		List<Monster> mon = new LinkedList<Monster>();
//		mon.add(new Monster(100, 100));
		
		List<Player> pl = new LinkedList<Player>();
		pl.add(new Player (1200/2 -48 , 720/2 -48));
		
		gp = new GamePanel(new LooksAndMoving(300, 300, 640, 400), mon, pl);
		gp.setBounds(0, 0, 1200, 720);
		add(gp);
		
		addKeyListener(this);
	}
	
	public void handleMessage(Message message){
		if(message instanceof ChatMsg){
			chatBox.appendText(((ChatMsg) message).getSubmitter(),((ChatMsg) message).getContent());
			} 
		else if(message instanceof MoveMsg){
			
		}
		else if(message instanceof MapMsg){    //Map wird einmal geschickt von Caspar
			gp.setMap(((MapMsg)message).getMap());
			miniMap.setMap(((MapMsg)message).getMap());
		} 
		else if(message instanceof GlobInvMsg){
			gp.setItem(((GlobInvMsg)message).getGlobInv());
		}
		else if(message instanceof MonsterListMsg){
//			gp.setMonster(((MonsterListMsg)message).getMonsterList());
		}
		else if(message instanceof CharacterListMsg){
//			gp.setCharacter((CharacterListMsg)message).getCharacterList());	
		}
		else if (message instanceof LocInvMsg){
			inventoryPanel.setInventory(((LocInvMsg)message).getLocInv());
		}
		else if (message instanceof CharacterUpdateMsg){
			myCharacter = ((CharacterUpdateMsg) message).getPlayer();
			setHealth(myCharacter.getCurrentLife());
			setExperience(myCharacter.getExperiencePoints());
			setLevel(myCharacter.getLevel());
		} 
		
		//getCurrentLife -> Lebensbalken Monster
		
//		else if(message instanceof MonsterUpdateMsg){
//			
//		}
		
		/*
		 * Was muss ich an Caspar schicken? (Anna) 
		 * Move Msg
		 * ItemPickUp Msg
		 * MapChange  Msg
		 * engageFight Msg
		 */
		
		
	}
	
	public void handleMessageOld(MessageTestumgebung message){
		switch(message.getType()){
		/*
			case "map": miniMap.setMap(message.newMap);
				break;*/
		
			case "chat": chatBox.appendText(message.submitter, message.chatMessage);
						 scrollPane.validate();
						 scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
				break;
			case "inventory": //inventoryPanel.setInventory(message.itemBar, message.inventory, message.equipment);
				break;
			case "status": setHealth(message.newHealth);setMana(message.newMana);setExperience(message.newExperience);setLevel(message.newLevel);
							inventoryPanel.setGold(message.newGold);
				break;
			case "charStats": inventoryPanel.setCharStats(message.attack, message.attackSpeed, message.agility, message.intelligence, message.armor, message.speed);
				break;
			case "statistic": statisticsPanel.setStats(message.anz, message.serie, message.tode, message.kd, message.waffe, message.forts, message.zeit);
				break;
		}
		
	}
	
	public void reorderItemBar(ItemButton[] btnArray){
		System.out.println("reorder");
		itemBar.setNewBar(btnArray);
	}
	
	public void setMana(int newValue){
		mana.setValue(newValue);
	}
	
	public void setHealth(int newValue){
		health.setValue(newValue);
	}
	
	public void setExperience(int newValue){
		experience.setValue(newValue);
	}
	
	public void setLevel(int level){
		levelLabel.setText(String.valueOf(level));
	}
	
	public void useItem(int itemPos){
		if(!itemBar.isEmpty(itemPos))
			//System.out.println("use item " + itemBar.getItemOfButton(itemPos).getImageName());
		controller.sendMessage(new UseItemMsg(2, itemPos));
	}
	
	private void sendMessage(){
		messageField.setVisible(false);
		if(!messageField.getText().isEmpty()){
			chatBox.appendText("admin", messageField.getText());
			messageField.setText("");
			ChatMsg chatMessage = new ChatMsg(messageField.getText(), 2, "","");
			controller.sendMessage(chatMessage);
		}
	}
	
	private void openInventory(){
		inventoryPanel.setVisible(true);
		inventoryPanel.setSizes();
		statisticsPanel.setVisible(false);
	}
	
	private void openStatistics(){
		statisticsPanel.setVisible(true);
		statisticsPanel.setSizes();
		inventoryPanel.setVisible(false);
		
		//send a requeststatisticsmessage to ce
	}
	
	/*
	private void openPublicChat(){
		publicChatPanel.setChatMessages(chatBox.getText());
		publicChatPanel.setVisible(true);
	}
	*/
	
	public void setPositions(){
		chatBox.setBounds(20, getSize().height - 50 - 30 - 200, 200,192);
		scrollPane.setBounds(chatBox.getBounds());
		messageField.setBounds(chatBox.getBounds().x,chatBox.getBounds().y + 5 + 200, 200, 25);
		
		experience.setBounds(getSize().width / 2 - (250 / 2), getSize().height - 50 - 8, 250, 8);		
		itemBar.setBounds(getSize().width / 2 - (250 / 2),getSize().height - 50, 250, 50);
		
		miniMap.setBounds(getSize().width - 20 - 200, 20 , 200, 200);
		miniMap.setSize();
		
		logoutButton.setBounds(getSize().width - 42, getSize().height - 35 ,25,25);
		statsButton.setBounds(getSize().width - 36 - 42, getSize().height - 35 ,25,25);
		inventoryButton.setBounds(getSize().width - 36 - 36 - 42, getSize().height - 35 ,25,25);
		systemBar.setBounds(getSize().width - 130, getSize().height-22,130,22);
		
		privateMessage.setBounds(20 + 10 + 45, getSize().height - 5 - 45 ,45,45);
		publicMessage.setBounds(20, getSize().height - 5 - 45 ,45,45);
		publicMessage.setBounds(20, getSize().height - 5 - 45 ,45,45);

		
		//inventoryPanel.setBounds(getSize().width / 2 - 160, getSize().height / 2- 200, 320,400);
		inventoryPanel.setBounds(getSize().width / 2 - 160, getSize().height / 2- 250, 320,495);
		//statisticsPanel.setBounds(getSize().width / 2 - 160, getSize().height / 2- 200, 320,400);
		//statisticsPanel.setBounds(getSize().width / 2 - 137, getSize().height / 2 - 200, 274,424);
		statisticsPanel.setBounds(getSize().width / 2 - 160, getSize().height / 2- 250, 320,495);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode());
		//System.out.println(e.getKeyChar());
		if(e.getKeyCode() > 48 && e.getKeyCode() < 55){
			useItem((Character.getNumericValue( e.getKeyChar())) - 1);
		} else if (e.getKeyCode() == 10){
			messageField.setVisible(true);
			messageField.grabFocus();
		} else if (e.getKeyCode() == 73){
			openInventory();
		} else if (e.getKeyCode() == 79){
			openStatistics();
		}
		
		
		//Gui1
		if(e.getKeyCode() == KeyEvent.VK_DOWN){ 
			gp.getDown(); 
			MoveMsg newPosition = new MoveMsg(myCharacter.getPosX(), myCharacter.getPosY()-4);
			controller.sendMessage(newPosition);
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){ 
			gp.getUp(); 
			MoveMsg newPosition = new MoveMsg(myCharacter.getPosX(), myCharacter.getPosY()-4);
			controller.sendMessage(newPosition);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){ 
			gp.getRight(); 
			MoveMsg newPosition = new MoveMsg(myCharacter.getPosX(), myCharacter.getPosY()-4);
			controller.sendMessage(newPosition);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){ 
			gp.getLeft(); 
			MoveMsg newPosition = new MoveMsg(myCharacter.getPosX(), myCharacter.getPosY()-4);
			controller.sendMessage(newPosition);
		}
//		if(e.getKeyCode() == KeyEvent.VK_A) keyAttack = true;
//		if(e.getKeyCode() == KeyEvent.VK_S) keyPick = true;
//		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
		//Gui1
//		if(e.getKeyCode() == KeyEvent.VK_DOWN) gp.getStopDown();
//		if(e.getKeyCode() == KeyEvent.VK_UP) gp.getStopUp();
//		if(e.getKeyCode() == KeyEvent.VK_RIGHT) keyRight = false;
//		if(e.getKeyCode() == KeyEvent.VK_LEFT) keyLeft = false;
//		if(e.getKeyCode() == KeyEvent.VK_A) keyAttack = false;
//		if(e.getKeyCode() == KeyEvent.VK_S) keyPick = false;
		
	}
	
//	//Getter-Methoden fuer keyUp, keyDown, keyRight, keyLeft, keyAttack, keyPick fuer Zugriff auf boolean Wert
//	 public static boolean getUp() {
//	 	return keyUp;
//	 }
//
//	 public static boolean getDown() {
//	 	return keyDown;
//	 }
//
//	 public static boolean getLeft() {
//	 	return keyLeft;
//	 }
//
//	 public static boolean getRight() {
//	 	return keyRight;
//	 }
//
//	 public static boolean getAttack(){
//	 	return keyAttack;
//	 }
//
//	 public static boolean getPick(){
//	 	return keyPick;
//	 }
//	 
	 
	 
	
}

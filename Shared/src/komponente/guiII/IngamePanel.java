package komponente.guiII;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import pp2015.team12.shared.message.*;

/**
 * Class for the IngamePanel
 * @author Vinzenz Liem Bui
 */

public class IngamePanel extends JPanel implements KeyListener{
	
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
	/**
	 * Constructor
	 * @author Vinzenz Liem Bui
	 */
	public IngamePanel(Frame controller){
		super(null);
		setBackground(Color.WHITE);
		
		setFocusable(true);
		this.controller = controller;
		
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
	    scrollPane.setBorder(null);
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
		add(scrollPane);
		
		messageField = new JTextField();
		add(messageField);
		messageField.setVisible(false);
		messageField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					sendMessage();
					scrollPane.validate();
					scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
			}
		});

		add(itemBar);

		Image img;
		try {
			URL urlToImage = this.getClass().getResource("gui2images/portrait.png");
			img = ImageIO.read(urlToImage);
			portraitPanel.setIcon(new ImageIcon(img));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		}
		
		portraitPanel.setBounds(50, 30, 222, 84);
		add(portraitPanel);
		
		add(miniMap);	

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
		add(logoutButton);
		logoutButton.setFocusable(false);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Do Logout");
				controller.showLogin();
				inventoryPanel.setVisible(false);
				statisticsPanel.setVisible(false);
			}
		});
		statsButton.setBorder(null);
		statsButton.setContentAreaFilled(false);
		add(statsButton);
		statsButton.setFocusable(false);
		statsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openStatistics();
			}
		});
		inventoryButton.setBorder(null);
		inventoryButton.setContentAreaFilled(false);
		add(inventoryButton);
		inventoryButton.setFocusable(false);
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInventory();
			}
		});
		add(systemBar);
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
		add(experience);
		
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
		add(inventoryPanel);
		
		statisticsPanel = new StatisticsPanel();
		add(statisticsPanel);
		

		addKeyListener(this);
	}
	/**
	 * receives the message which was forwarded from the Frame and handles them
	 * @author Vinzenz Liem Bui
	 */
	public void handleMessage(MessageTestumgebung message){
		switch(message.getType()){
			case "map": miniMap.setMap(message.newMap);
				break;
			case "chat": chatBox.appendText(message.submitter, message.chatMessage);
						 scrollPane.validate();
						 scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
				break;
			case "inventory": inventoryPanel.setInventory(message.itemBar, message.inventory, message.equipment);
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
	/**
	 * reorders the Items in the Itembar
	 * @author Vinzenz Liem Bui
	 */
	public void reorderItemBar(ItemButton[] btnArray){
		itemBar.setNewBar(btnArray);
	}
	/**
	 * refresh the Mana bar
	 * @author Vinzenz Liem Bui
	 */
	public void setMana(int newValue){
		mana.setValue(newValue);
	}
	/**
	 * sets the current Health
	 * @author Vinzenz Liem Bui
	 */
	public void setHealth(int newValue){
		health.setValue(newValue);
	}
	/**
	 * sets the current Experience
	 * @author Vinzenz Liem Bui
	 */
	public void setExperience(int newValue){
		experience.setValue(newValue);
	}
	/**
	 * sets the current Level
	 * @author Vinzenz Liem Bui
	 */
	public void setLevel(int level){
		levelLabel.setText(String.valueOf(level));
	}
	/**
	 * method to use item in the itembar
	 * @author Vinzenz Liem Bui
	 */
	public void useItem(int itemPos){
		if(!itemBar.isEmpty(itemPos))
			System.out.println("use item " + itemBar.getItemOfButton(itemPos).getImageName());
	}
	/**
	 * method to send new chat messages
	 * @author Vinzenz Liem Bui
	 */
	private void sendMessage(){
		messageField.setVisible(false);
		if(!messageField.getText().isEmpty()){
			chatBox.appendText("admin", messageField.getText());
			messageField.setText("");
			//ChatMsg chatMessage = new ChatMsg(messageField.getText(),2);
			//controller.com.recieveMessage(chatMessage);
		}
	}
	
	/**
	 * shows the inventory
	 * @author Vinzenz Liem Bui
	 */
	private void openInventory(){
		inventoryPanel.setVisible(true);
		inventoryPanel.setSizes();
		statisticsPanel.setVisible(false);
	}
	
	/**
	 * shows the statistics panel
	 * @author Vinzenz Liem Bui
	 */
	private void openStatistics(){
		statisticsPanel.setVisible(true);
		statisticsPanel.setSizes();
		inventoryPanel.setVisible(false);
	}
	
	/*
	private void openPublicChat(){
		publicChatPanel.setChatMessages(chatBox.getText());
		publicChatPanel.setVisible(true);
	}
	*/
	/**
	 * sets all the positions (necessary, because of absolute positioning -> while the panel is not visible, 
	 * the getWidth / getHeight method returns 0, so we have to call this function, while the panel is visible)
	 * @author Vinzenz Liem Bui
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
	/**
	 * keylisteners for the hotkeys
	 * @author Vinzenz Liem Bui
	 */
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}

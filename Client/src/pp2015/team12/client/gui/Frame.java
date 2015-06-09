package pp2015.team12.client.gui;

import javax.swing.*;

import pp2015.team12.client.ClientCommunication;
import pp2015.team12.shared.message.*;

import java.awt.*;


	//Erstelle FensterFrame

	public class Frame extends JFrame {
	 
	private final int BREITE = 1200;
	private final int HOEHE = 720;
	 
	
	private CardLayout cl = new CardLayout();
	private JPanel panel = new JPanel(cl);
	private IngamePanel ip;
	private LoginPanel lp;
	private ClientCommunication com;

	public Frame(ClientCommunication com){
		this.com = com;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(BREITE,HOEHE);
		this.setTitle("Return of the Dead");
		this.setResizable(false);
		
		try {
	        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {}
	    catch (ClassNotFoundException e) {}
	    catch (InstantiationException e) {}
	    catch (IllegalAccessException e) {}
		
		// JPanel mit CardLayout um das umschalten zwischen verschiedenen Panels zu ermoeglichen
		lp = new LoginPanel(this);
		panel.add(lp, "Login");
		//panel.add(new MainMenu(this), "MainMeunu");
		 
		ip = new IngamePanel(this);
		panel.add(ip, "Ingame");
		add(panel);
		 
		 
		this.setVisible(true);
		 
		
	}
	
	
	public Frame(){
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(BREITE,HOEHE);
		this.setTitle("Return of the Dead");
		this.setResizable(false);
		
		try {
	        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {}
	    catch (ClassNotFoundException e) {}
	    catch (InstantiationException e) {}
	    catch (IllegalAccessException e) {}
		
		// JPanel mit CardLayout um das umschalten zwischen verschiedenen Panels zu ermoeglichen
		panel.add(new LoginPanel(this), "Login");
		//panel.add(new MainMenu(this), "MainMeunu");
		 
		ip = new IngamePanel(this);
		panel.add(ip, "Ingame");
		add(panel);
		 
		 
		this.setVisible(true);
		 
		 

		 
		 

	}
	
	/**
	 * @author Vinzenz Liem Bui
	 */
	public void forwardMessage(Message message){
		if(message instanceof LoginReplyMsg)
			lp.checkReponse(message);
		else if(message instanceof RegistrationReplyMsg)	
			System.out.println();
		else
		ip.handleMessage(message);
	}
	public void forwardMessageGUI(MessageTestumgebung message){
		ip.handleMessageOld(message);
	}
	
	public void sendMessage(Message message){
		if(com!=null)
		com.receiveMessage(message);
	}
	
	/**
	 * @author Vinzenz Liem Bui
	 */
	public void showMainMenu(){
		cl.show(panel,"MainMeunu");
	}
	
	/**
	 * @author Vinzenz Liem Bui
	 */
	public void showLogin(){
		cl.show(panel,"Login");
	}
	
	/**
	 * @author Vinzenz Liem Bui
	 */	
	public void startGame(){
		
		cl.show(panel,"Ingame");
		ip.requestFocus();
		ip.setPositions();
		
	}
	
	
	
}


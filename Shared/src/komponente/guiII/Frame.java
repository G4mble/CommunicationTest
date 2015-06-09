package komponente.guiII;

import javax.swing.*;
import java.awt.*;


/**
 * Class to create the JFrame
 * @author Vinzenz Liem Bui
 */
	public class Frame extends JFrame {
	 
	private final int BREITE = 1280;
	private final int HOEHE = 720;
	 
	
	private CardLayout cl = new CardLayout();
	private JPanel panel = new JPanel(cl);
	private IngamePanel ip;
	//private ClientCommunication com;
	/**
	 * Constructor, creates the JFrame, sets the LookAndFeel and adds a JPanel with a CardLayout, 
	 * allowing to switch between LoginScreen and IngamePanel
	 * @author Vinzenz Liem Bui
	 */
	public Frame(){
		//this.com = com;
		
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
	 * forwards a message to the ingamePanel
	 * @author Vinzenz Liem Bui
	 */
	public void forwardMessageGUI2(MessageTestumgebung message){
		ip.handleMessage(message);
	}
	
	/**
	 * shows the MainMenu, currently not used
	 * @author Vinzenz Liem Bui
	 */
	public void showMainMenu(){
		cl.show(panel,"MainMeunu");
	}
	
	/**
	 * shows the LoginScreen
	 * @author Vinzenz Liem Bui
	 */
	public void showLogin(){
		cl.show(panel,"Login");
	}
	
	/**
	 * shows the IngamePanel
	 * @author Vinzenz Liem Bui
	 */	
	public void startGame(){
		
		cl.show(panel,"Ingame");
		ip.requestFocus();
		ip.setPositions();
		
	}
	
	
	
}


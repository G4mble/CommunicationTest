package komponente.guiII;

import java.awt.*;

import javax.swing.*;

/**
 * ChatBox class
 * @author Vinzenz Liem Bui
 */
public class ChatBox extends JTextArea{
	/**
	 * Constructor, creates the ChatBox
	 * @author Vinzenz Liem Bui
	 */
	public ChatBox(){
		setFont(new Font("Serif", Font.PLAIN, 16));
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
		setEditable(false);
		setText("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		setLineWrap(true);
		
	}
	/**
	 * Method to add a new message to the ChatBox
	 * @author Vinzenz Liem Bui
	 */
	public void appendText(String playerName, String message){
		System.out.println("send message");
		append("\n" + playerName + ": " + message);
	}	
}

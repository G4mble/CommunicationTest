package pp2015.team12.client.gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.*;

/**
 * @author Vinzenz Liem Bui
 */
public class ChatBox extends JTextArea{

	public ChatBox(){
		setFont(new Font("Serif", Font.BOLD, 16));
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
		setEditable(false);
		setText("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		setLineWrap(true);
		setForeground(Color.WHITE);
	}
	
	public void appendText(String playerName, String message){
		append("\n" + playerName + ": " + message);
		//appendToPane("\n" + playerName + ": " + message);
		//appendToChatbox("admin",message,Color.RED);
	}
	/*
	public void appendToChatbox(String playerName, String message, Color color){
		StyleContext sc = StyleContext.getDefaultStyleContext();
	    AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
	        StyleConstants.Foreground, color);

	    int len = getDocument().getLength(); // same value as
	                       // getText().length();
	    setCaretPosition(len); // place caret at the end (with no selection)
	    setCharacterAttributes(aset, false);
	    replaceSelection("\n" + playerName + ": " +message);
	}
	*/
	
}

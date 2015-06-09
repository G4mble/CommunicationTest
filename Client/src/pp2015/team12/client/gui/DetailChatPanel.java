package pp2015.team12.client.gui;

import javax.swing.*;
import java.awt.*;

public class DetailChatPanel extends JPanel{
	
	private JTextArea textArea = new JTextArea();
	
	public DetailChatPanel(){
		super(new BorderLayout());
		setVisible(false);
		setBackground(Color.RED);
		
		textArea.setBackground(Color.BLUE);
		add(textArea, BorderLayout.CENTER);
		
		
	}

	public void setChatMessages(String text){
		textArea.setText(text);
	}
	
	public void closePanel(){
		setVisible(false);
	}
}

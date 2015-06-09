package pp2015.team12.client.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * @author Vinzenz Liem Bui
 */
public class MainMenu extends JPanel implements ActionListener{

	private JButton startButton = new JButton("Start Game");
	private JButton settingsButton = new JButton("Settings");
	private JButton logoutButton = new JButton("Logout");
	private JButton exitButton = new JButton("Exit");
	private Frame controller;
	
	public MainMenu(Frame controller){
		super(new BorderLayout());
		this.controller = controller;
		
		JPanel subPanel = new JPanel(new GridBagLayout());
		
		GridBagConstraints gridConstraint = new GridBagConstraints();
		
		
		JLabel titleLabel = new JLabel("Main Menu");
		titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
		gridConstraint.insets = new Insets(0,100,50,0);
		gridConstraint.gridwidth = 5;
		gridConstraint.gridy = 0;
		subPanel.add(titleLabel,gridConstraint);
		
		gridConstraint.gridwidth = 1;
		gridConstraint.insets = new Insets(0,100,0,0);
		gridConstraint.fill = GridBagConstraints.HORIZONTAL;
		gridConstraint.anchor = GridBagConstraints.WEST;

		gridConstraint.gridy = 1;
		subPanel.add(startButton,gridConstraint);
		startButton.addActionListener(this);
		
		gridConstraint.gridy = 2;
		subPanel.add(settingsButton,gridConstraint);
		
		gridConstraint.insets = new Insets(100,100,0,0);
		gridConstraint.gridy = 3;
		subPanel.add(logoutButton, gridConstraint);
		
		gridConstraint.insets = new Insets(0,100,0,0);
		gridConstraint.gridy = 4;
		subPanel.add(exitButton,gridConstraint);
		
		add(subPanel, BorderLayout.WEST);
	}

	//@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == startButton){
			
			//System.out.println("start game");
			controller.startGame();
		}
	}
	
}

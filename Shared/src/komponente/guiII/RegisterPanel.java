package komponente.guiII;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.*;
/**
 * class for the register panel
 * @author Vinzenz Liem Bui
 */
public class RegisterPanel extends JLayeredPane implements ActionListener{

	private JTextField usernameTf = new JTextField(20);
	private JPasswordField passField = new JPasswordField(20);
	private JPasswordField confirmPassField = new JPasswordField(20);
	private JButton confirmButton = new JButton("Confirm");
	private JButton cancelButton = new JButton("Cancel");

	private JButton barbarian = new JButton();
	private JButton tank = new JButton();
	private JButton archer = new JButton();
	private String selectedChar = "";
	
	private JTextArea charDescription = new JTextArea();
	
	private JLabel errorPanel = new JLabel("please retry!");
	/**
	 * constructor
	 * @author Vinzenz Liem Bui
	 */
	public RegisterPanel(){
		setLayout(null);
		
		add(usernameTf);
		add(passField);
		add(confirmPassField);
		
		confirmButton.addActionListener(this);
		add(confirmButton);
		cancelButton.addActionListener(this);
		add(cancelButton);
		
		barbarian.addActionListener(this);
		add(barbarian);
		tank.addActionListener(this);
		add(tank);
		archer.addActionListener(this);
		add(archer);
		
		charDescription.setText("The barbarian is a strong swordsman, he kills his enemy very fast, but therefore lacks on defence.");
		charDescription.setWrapStyleWord(true);
		charDescription.setLineWrap(true);
		charDescription.setEditable(false);
		add(charDescription);
		
		setBackground(Color.DARK_GRAY);
		setOpaque(true);
		
		errorPanel.setLayout(null);
		errorPanel.setHorizontalAlignment(SwingConstants.CENTER);
		errorPanel.setBackground(Color.GRAY);
		errorPanel.setForeground(Color.WHITE);
		errorPanel.setOpaque(true);
		errorPanel.setVisible(false);
		add(errorPanel,2,0);
	}
	/**
	 * sets the sizes
	 * @author Vinzenz Liem Bui
	 */
	public void setSizes(){
		
		errorPanel.setBounds(getWidth() / 2 - 200, getHeight() / 2 - 50, 400,100);
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorPanel.setVisible(false);
			}
		});
		button.setBounds(errorPanel.getWidth() / 2 - 50, errorPanel.getHeight()- 30, 100, 20);
		errorPanel.add(button);
		
		JLabel usernameLabel = new JLabel ("username");
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setForeground(Color.decode("0x911b1b"));
		usernameLabel.setBounds(90,100,100,20);
		add(usernameLabel);

		usernameTf.setBounds(200, 100, 200, 20);
		
		JLabel passLabel = new JLabel ("password");
		passLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passLabel.setForeground(Color.decode("0x911b1b"));
		passLabel.setBounds(90,130,100,20);
		add(passLabel);
		
		passField.setBounds(200, 130, 200, 20);
		
		JLabel repassLabel = new JLabel ("re-enter password");
		repassLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		repassLabel.setForeground(Color.decode("0x911b1b"));
		repassLabel.setBounds(0,160,190,20);
		add(repassLabel);
		
		confirmPassField.setBounds(200, 160, 200, 20);
		confirmButton.setBounds(this.getWidth() / 2 + 25 ,this.getHeight() - 50,100,20);
		cancelButton.setBounds(this.getWidth() / 2 - 125 ,this.getHeight() - 50,100,20);

		barbarian.setBounds(100,240,200,300);
		tank.setBounds(320,240,200,300);
		archer.setBounds(540,240,200,300);
		
		
		charDescription.setBounds(760,240,200,300);
	}
	/**
	 * checks if the input is correct and then performs the register process
	 * @author Vinzenz Liem Bui
	 */
	private void register(){
		if(Arrays.equals(passField.getPassword(), confirmPassField.getPassword()) && passField.getPassword().length > 0 && usernameTf.getText().length() > 0){
			System.out.println(usernameTf.getText() + "successfully registered a(n)" + selectedChar);
			((Frame)this.getParent().getParent().getParent().getParent().getParent().getParent()).startGame();
			((LoginPanel)getParent()).panel.setVisible(true);
			this.setVisible(false);
		} else {
			errorPanel.setVisible(true);
		}
	}
	/**
	 * actionlistener for the buttons
	 * @author Vinzenz Liem Bui
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == confirmButton){
			register();
		} else if(e.getSource() == cancelButton){
			setVisible(false);
			((LoginPanel)getParent()).panel.setVisible(true);
		} else if(e.getSource() == barbarian){
			selectedChar = "barbarian";
			charDescription.setText("The barbarian is a strong swordsman, he kills his enemy very fast, and also has a reasonable amount of heatlh.");
		} else if(e.getSource() == tank){
			selectedChar = "tank";
			charDescription.setText("The tank can take a lot of damage before he dies. Unfortunately he can't kill his enemies that fast.");
		} else if(e.getSource() == archer){
			selectedChar = "archer";
			charDescription.setText("The archer is a highly trained range character. He kills his enemy with ease, but therefore lacks on armour, that's why he prefers to fight from a safe range. ");
		}
	}
	
}

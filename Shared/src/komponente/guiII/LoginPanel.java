package komponente.guiII;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * loginpanel class
 * @author Vinzenz Liem Bui
 */
public class LoginPanel extends JLayeredPane implements ActionListener{

	private JButton loginButton = new JButton("Login");
	private JButton registerButton = new JButton("Register");
	private JTextField usernameTf = new JTextField(20);
	private JPasswordField passwordTf = new JPasswordField(20);
	private Frame controller;
	private BufferedImage background = null;
	private JCheckBox rememberPassword = new JCheckBox();
	
	private RegisterPanel rp = new RegisterPanel();
	public JPanel panel = new JPanel();
	private JLabel errorPanel = new JLabel("Wrong password or username entered, please retry!");
	/**
	 * constructor, requires the Frame instance as input
	 * @author Vinzenz Liem Bui
	 */
	public LoginPanel(Frame controller){
		super();
		this.controller = controller;
		setLayout(null);
		
		try {
			URL urlToImage = this.getClass().getResource("gui2images/loginscreen.png");
			background = ImageIO.read(urlToImage);
		} catch (Exception e) {
			System.out.println("Fehler: Bild konnte nicht geladen werden.");
		}
		
		errorPanel.setBounds(controller.getWidth() / 2 - 200, controller.getHeight() / 2 - 50, 400,100);
		rp.setBounds(100, 50, controller.getWidth() - 200, controller.getHeight() - 100);
		rp.setVisible(false);
		add(rp);
		
		// Add ActionListener to Buttons
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
		
		// Add objects to LoginPanel
		GridBagConstraints gc = new GridBagConstraints();
	

		panel.setLayout(new GridBagLayout());
		panel.setOpaque(false);
		panel.setBounds(controller.getWidth() / 2 - 200, controller.getHeight() / 2 - 100, 400,200);
		add(panel);
		
		gc.gridx = 0;
		gc.gridy = 1;
		JLabel userLabel = new JLabel("Username:");
		userLabel.setForeground(Color.decode("0x911b1b"));
		panel.add(userLabel,gc);
		gc.gridx = 1;
		gc.gridy = 1;
		panel.add(usernameTf,gc);
		
		gc.insets = new Insets(10,0,0,0);
		
		gc.gridx = 0;
		gc.gridy = 2;
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(Color.decode("0x911b1b"));
		panel.add(passwordLabel,gc);
		gc.gridx = 1;
		gc.gridy = 2;
		panel.add(passwordTf,gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		JLabel rememberLabel = new JLabel("Remember me");
		rememberLabel.setForeground(Color.decode("0x911b1b"));
		panel.add(rememberLabel,gc);
		gc.gridx = 1;
		gc.gridy = 3;
		rememberPassword.setBorder(null);
		panel.add(rememberPassword,gc);
		
		gc.insets = new Insets(20,0,0,0);
		
		gc.gridx = 0;
		gc.gridy = 4;
		gc.gridwidth = 2;
		panel.add(loginButton,gc);
		gc.insets = new Insets(10,0,0,0);
		gc.gridx = 0;
		gc.gridy = 5;
		JLabel orLabel = new JLabel("- OR -");
		orLabel.setForeground(Color.decode("0x911b1b"));
		panel.add(orLabel,gc);
		gc.gridx = 0;
		gc.gridy = 6;
		panel.add(registerButton,gc);
		
		BufferedReader reader;
        String line;
        int count = 0;
        try {
        	reader = new BufferedReader(new FileReader("credentials.txt"));
        	while((line = reader.readLine()) != null) {
        		count ++;
        		if(count == 1){
        			usernameTf.setText(line);
        		} else {
        			passwordTf.setText(line);
        		}
        	} 
        	reader.close();
        }
        catch (IOException e) {
        	System.out.println("Error reading credentials.");
        }
		
        errorPanel.setLayout(null);
		errorPanel.setHorizontalAlignment(SwingConstants.CENTER);
		errorPanel.setBackground(Color.GRAY);
		errorPanel.setForeground(Color.WHITE);
		errorPanel.setOpaque(true);
		errorPanel.setVisible(false);
		add(errorPanel,2,0);
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorPanel.setVisible(false);
			}
		});
		button.setBounds(errorPanel.getWidth() / 2 - 50, errorPanel.getHeight()- 30, 100, 20);
		errorPanel.add(button);
	}
	/**
	 * checks the credentials, which where typed in.
	 * @author Vinzenz Liem Bui
	 */
	private boolean checkLogin(String user, String pass){
		
		if(user.equals("admin") && pass.equals("admin")){
			
			if(rememberPassword.isSelected()){
				BufferedWriter writer = null;
				try {
				    writer = new BufferedWriter( new FileWriter("credentials.txt"));
				    writer.write(user);
				    writer.newLine();
				    writer.write(pass);
				    writer.close();
				}
				catch ( IOException e){
					System.out.println("Error saving credentials");
				}
			} else {
				passwordTf.setText("");
				BufferedWriter writer = null;
				try {
				    writer = new BufferedWriter( new FileWriter("credentials.txt"));
				    writer.write(user);
				    writer.newLine();
				    writer.close();
				}
				catch ( IOException e){
					System.out.println("Error saving login name");
				}
			}
			
			return true;
		} else {
			errorPanel.setVisible(true);
			return false;
		}
		
	}
	/**
	 * paints the background
	 * @author Vinzenz Liem Bui
	 */
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);

	}
	
	/**
	 * actionlistener to handle the clicks on the login or register button
	 * @author Vinzenz Liem Bui
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == loginButton) {
			if(checkLogin(usernameTf.getText(), new String(passwordTf.getPassword()))){
				controller.startGame();
			}
			
		} else if(e.getSource() == registerButton) {
			System.out.println("Register!");
			rp.setVisible(true);
			rp.setSizes();
			panel.setVisible(false);
		}
		
	}

}




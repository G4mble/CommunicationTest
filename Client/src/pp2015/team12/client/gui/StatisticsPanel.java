package pp2015.team12.client.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class StatisticsPanel extends JLabel implements ActionListener{

	private JTextArea stats = new JTextArea();
	
	public StatisticsPanel(){
		setLayout(null);
		setVisible(false);
		
		JButton close = null;
		try {
			close = new JButton(new ImageIcon(ImageIO.read(this.getClass().getResource("gui2images/closeFrameButton.png"))));
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		}
		close.setName("close");
		close.addActionListener(this);
		close.setBorder(null);
		close.setContentAreaFilled(false);
		close.setBounds(272, -10, 50, 50);
		add(close);
		
		JLabel statsLabel = new JLabel ("Statistics");
		statsLabel.setForeground(Color.WHITE);
		statsLabel.setBounds(110,13,100,20);
		statsLabel.setHorizontalAlignment(CENTER);
		add(statsLabel);
		
		
		stats.setEditable(false);
		stats.setOpaque(false);
		stats.setForeground(Color.decode("0x911b1b"));
		stats.setBounds(10, 60, 300, 420);
		stats.setMargin(new Insets(10,10,10,10));
		stats.setText("Anzahl getoeter Monster: 0\n"
					+ "Laengste Serie: 0\n"
					+ "Anzahl Tode: 0\n"
					+ "K/D: 0\n"
					+ "Meist genutzte Waffe: 0\n"
					+ "Spielfortschritt: 0%\n"
					+ "Spielzeit: 0min");
		
		add(stats);
	}
	
	public void setSizes(){

		System.out.println(getWidth());
		Image img = null;
		try {
			
			img = ImageIO.read(this.getClass().getResource("gui2images/menuFrame.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		Image dimg = img.getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(dimg));
	}
	
	public void setStats(int anz, int serie, int tode, String kd, String waffe, String forts, String zeit){
		stats.setText("Anzahl getoeter Monster: "+anz+"\n"
				+ "Laengste Serie: "+serie+"\n"
				+ "Anzahl Tode: "+tode+"\n"
				+ "K/D: "+kd+"\n"
				+ "Meist genutzte Waffe: "+waffe+"\n"
				+ "Spielfortschritt: "+forts+"\n"
				+ "Spielzeit: "+zeit);
	}
	
	private void closeStatistics(){
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		closeStatistics();
	}
}

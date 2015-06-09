package pp2015.team12.client.gui2;
import javax.swing.JFrame; 
import java.awt.BorderLayout;
import java.awt.Color; 
import java.awt.Dimension;

public class Frame extends JFrame{
	private final int WIDTH = 4000;
	 private final int HEIGHT = 4000;
	 
	 public Frame(){
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setSize(WIDTH,HEIGHT);
		 this.setTitle("Devil");
		 this.setLayout(new BorderLayout(30,50));

		 
		 PlayingArea pA = new PlayingArea();
		 this.addKeyListener(pA);
		 this.add(pA, BorderLayout.CENTER);
		 
		 
		 this.setVisible(true);
		 
		 
	 }
}

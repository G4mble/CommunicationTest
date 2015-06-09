//package pp2015.team12.client.gui;
//
//
//
//
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.DisplayMode;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.GraphicsDevice;
//import java.awt.GraphicsEnvironment;
//import java.awt.Image;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.util.List;
//
//public class FrameGUI1 extends JFrame {
// 
// LooksAndMoving lm = null;
// private List<Monster> mon;
// private List<Player> pl;
//	
// private final int WIDTH = 800;
// private final int HEIGHT = 600;
//
// //Bewegung
//// private boolean keyUp = false;
//// private boolean keyDown = false;
//// private boolean keyLeft = false;
//// private boolean keyRight = false;
// 
// //Tiles
// private int xTiles = 640/160;
// private int yTiles = 400/160;
// private int[][] tileArray = new int [xTiles][yTiles];
//
//// static int movingArrayX = 0;
//// static int movingArrayY = 0;
//// 
// 
// private JFrame screen;
// Image img = null;
// 
// 
// 
// 
//// public FrameGUI1(LooksAndMoving lm, List<Monster> mon, List<Player> pl){ 
////	 
////	 screen = new JFrame();
////	 screen.setBounds(0, 0, 640, 400);
////	 add(screen);
////	 
////	 //addKeyListener(new KeyHandler());
////	 
////	 this.lm = lm;
////	 this.mon = mon;
////	 this.pl = pl;
////	 //this.background = background;	 
//// }	 
//	 
//
// 
//
// 
//
// 
//
//
// //KeyHandler fuer down, up, left, right und escape (schliessen des Frames)
//// private class KeyHandler implements KeyListener{
////
////	public void keyPressed(KeyEvent e) {
////		if(e.getKeyCode() == KeyEvent.VK_DOWN) keyDown = true;
////		if(e.getKeyCode() == KeyEvent.VK_UP) keyUp = true;
////		if(e.getKeyCode() == KeyEvent.VK_RIGHT) keyRight = true;
////		if(e.getKeyCode() == KeyEvent.VK_LEFT) keyLeft = true;	
////		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
////	}
////
////	public void keyReleased(KeyEvent e) {
////		if(e.getKeyCode() == KeyEvent.VK_DOWN) keyDown = false;
////		if(e.getKeyCode() == KeyEvent.VK_UP) keyUp = false;
////		if(e.getKeyCode() == KeyEvent.VK_RIGHT) keyRight = false;
////		if(e.getKeyCode() == KeyEvent.VK_LEFT) keyLeft = false;
////	}
////
////	//Wird zwar ausgefuehrt, aber nicht genutzt
////	public void keyTyped(KeyEvent e) {	
////	} 
//// 
//// }
//
//
//
//////Getter-Methoden fuer keyUp, keyDown, keyRight, keyLeft fuer Zugriff auf boolean Wert
////public boolean getUp() {
////	return keyUp;
////}
////
////public boolean getDown() {
////	return keyDown;
////}
////
////public boolean getLeft() {
////	return keyLeft;
////}
////
////public boolean getRight() {
////	return keyRight;
////}
//
//
//
//
//public int[][] getTileArray(){
//	
//	int [][] tileArray2 = new int [tileArray.length][tileArray.length];
//	
//	for(int i = 0; i<tileArray.length; i++){
//		for(int j = 0; j<tileArray[i].length; j++){
//			tileArray[i][j] = tileArray2 [i][j];
//		}
//	}
//	
//	return tileArray2;	
//}
//
//
////Screen soll nicht nur einmal gezeichnet werden sondern nach jeder KeyHandler Abfrage neu
//public void repaintScreen(){
//	 screen.repaint();
//}
//
//
//
//
//
////}
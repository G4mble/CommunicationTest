package komponente.clientEngine;
import javax.swing.JOptionPane;

import pp2015.team12.shared.character.Warrior;
import pp2015.team12.shared.map.*;
import pp2015.team12.shared.map.textures.*;
import pp2015.team12.shared.message.*;

/**
 * a few methods to test the elementary function of the ClientEngine
 * @author Heusser, Caspar
 *
 */
public class TestMain {
	public static void main (String[] args){
		boolean ende = false;
		ClientEngine test = new ClientEngine();
		/*	JOptionPane.showMessageDialog(null,
                "Empfangen einer MapMsg",
                "Naechster Schritt",					      
                JOptionPane.WARNING_MESSAGE);	*/
		do{
		String n = JOptionPane.showInputDialog("Bitte waehlen \n 1 -  neue Map \n 2 - Chat Nachricht an Server \n 3 - Chat Nachricht an Gui \n 4 - Leben reduzieren \n 5 - Beenden ");
			
			if(n.equals("1")){
			Tile[][] map = { 	{new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1()},
								{new RW_Border_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new RW_Border_1()},
								{new RW_Border_1(),new UW_Floor_1(),new SW_Door_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new RW_Border_1()},
								{new RW_Border_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new UW_Floor_1(),new RW_Border_1()},
								{new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1(),new RW_Border_1()}};
			test.Com.recieveMessage(new MapMsg(map,1));
			}if(n.equals("2")){
				String m = JOptionPane.showInputDialog("Bitte Nachricht eingeben");
				test.Com.recieveMessage(new ChatMsg(m,1));
			}
			if(n.equals("3")){
				String m = JOptionPane.showInputDialog("Bitte Nachricht eingeben");
				test.Com.recieveMessage(new ChatMsg(m,2));
			}
			if(n.equals("4")){
				System.out.println(test.player.getCurrentLife());
				System.out.println("Update Wert");
				Warrior a = new Warrior(1);
				String m =  JOptionPane.showInputDialog("Bitte Schaden bestimmen - aktuelles Leben 100 ");
				int t = Integer.parseInt(m);
				a.setCurrentLife(100-t);
				test.Com.recieveMessage(new CharacterUpdateMsg(1, a));
				System.out.println(test.player.getCurrentLife());
			
			}
			if(n.equals("5")){
				ende= true;
			}
			

		}while(ende== false);
	}
	
}

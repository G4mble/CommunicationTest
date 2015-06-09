package komponente.clientEngine;

import javax.swing.JFrame;

import pp2015.team12.shared.character.PlayerCharacter;
import pp2015.team12.shared.map.Tile;

/**
 * Creates a gui to test function of the client engine
 * @author Heusser, Caspar
 *
 *
 */
public class TestGui extends JFrame {
	Tile[][] map;
	PlayerCharacter player;
	
	ClientEngine cE;
	TestSpielfeld feld;
	final int hoehe = 600;//600
	final int breite = 600;//600
	
	public TestGui(Tile[][] map, PlayerCharacter player, ClientCommunication Com,ClientEngine cE){
		this.cE=cE;
		this.map =  map;
		this.player = player;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(this.breite, this.hoehe);
		this.setTitle("Testumgebung ClientEngine");
		this.setVisible(true);
		feld = new TestSpielfeld(map,player,Com,cE);
		this.addKeyListener(feld);
		this.add(feld);
		
	}
		

	
	
}
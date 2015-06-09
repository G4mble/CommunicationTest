package pp2015.team12.shared.map;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import java.awt.Image;

@SuppressWarnings("serial")
public abstract class Tile implements Serializable {
	/**
	 * The class presents the basis structure for all various extended classes
	 * 
	 * @author Ulko, Michael
	 */

	private String pfad;
	private Image texture;
	private int imageID;
	private boolean accessible;

	/**
	 * Constructor for initializing of every parameter for Tile element
	 * 
	 * @author Ulko, Michael
	 * @param pfad
	 * @param imageID
	 * @param accessible
	 */
	public Tile(String pfad, int imageID, boolean accessible) {
		this.pfad = pfad;
		this.imageID = imageID;
		this.accessible = accessible;
	}

	/**
	 * Read a Tile Image
	 * 
	 * @author Ulko, Michael
	 */
	public void readTexture() {
		try {
			this.texture = ImageIO.read(new File(this.pfad));
		} catch (IOException e) {

		}
	}

	/**
	 * Return a Tile object
	 * 
	 * @return
	 */
	public Image getTexture() {
		return this.texture;
	}

	/**
	 * Return the number of a Tile object
	 * 
	 * @author Ulko, Michael
	 * @return imageID
	 */
	public int getImageID() {
		return this.imageID;
	}

	/**
	 * Return the property whether a Tile object can be accessed
	 * 
	 * @author Ulko, Michael
	 * @return accessible
	 */
	public boolean getAccessible() {
		return accessible;
	}

}

package pp2015.team12.server.map;

import java.util.Random;

import pp2015.team12.shared.map.Tile;
import pp2015.team12.shared.map.textures.RW_Border_1;
import pp2015.team12.shared.map.textures.RW_Floor_1;
import pp2015.team12.shared.map.textures.RW_Wall_1;
import pp2015.team12.shared.map.textures.SW_Border_1;
import pp2015.team12.shared.map.textures.SW_Floor_1;
import pp2015.team12.shared.map.textures.SW_Wall_1;
import pp2015.team12.shared.map.textures.UW_Border_1;
import pp2015.team12.shared.map.textures.UW_Floor_1;
import pp2015.team12.shared.map.textures.UW_Wall_1;

/**
 * At first this class creates a basis for a level - border and stones. Then a
 * labyrinth is created using FloodFill algorithm.
 * 
 * @author Ulko, Michael
 * 
 */
public class Level_Basic {

	private Tile[][] map;

	/**
	 * Give a border to the double array of Tile and then fill it with stone
	 * everywhere
	 * 
	 * @author Ulko, Michael
	 */
	private void fillMapArray(int actID) {
		this.map = new Tile[32][62];
		/* Fill the whole level with boundary elements */
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				/* Create a Tile object depends on current act */
				if (actID == 1) {
					map[i][j] = new SW_Border_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Border_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Border_1();
				}
			}
		}
		for (int i = 1; i < map.length - 1; i++) {
			/*
			 * The frame of the level has boundary type. Now fill the inside
			 * part with stones
			 */
			for (int j = 1; j < map[i].length - 1; j++) {
				/* Create a Tile object depends on current act */
				if (actID == 1) {
					map[i][j] = new SW_Wall_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Wall_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Wall_1();
				}
			}
		}
	}

	/**
	 * Print the generated level in the console
	 * 
	 * @param map
	 * @author Ulko, Michael
	 */
	public void printArray() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				/* The symbols are printed depends on the current act */
				/* Stand for the first act */
				if (map[i][j].getImageID() == 1010) {
					System.out.print(" 111 ");
				} else if (map[i][j].getImageID() == 1020) {
					System.out.print("11111");
				} else if (map[i][j].getImageID() == 1030) {
					System.out.print("  .  ");
				} else if (map[i][j].getImageID() == 1041) {
					System.out.print("'E1D'");
				} else if (map[i][j].getImageID() == 1042) {
					System.out.print("'E1L'");
				} else if (map[i][j].getImageID() == 1043) {
					System.out.print("'E1R'");
				} else if (map[i][j].getImageID() == 1044) {
					System.out.print("'O1D'");
				} else if (map[i][j].getImageID() == 1045) {
					System.out.print("'O1L'");
				} else if (map[i][j].getImageID() == 1046) {
					System.out.print("'O1R'");
				}
				/* Stand for the second act */
				if (map[i][j].getImageID() == 2010) {
					System.out.print(" 222 ");
				} else if (map[i][j].getImageID() == 2020) {
					System.out.print("22222");
				} else if (map[i][j].getImageID() == 2030) {
					System.out.print(" . . ");
				} else if (map[i][j].getImageID() == 2041) {
					System.out.print("'E2D'");
				} else if (map[i][j].getImageID() == 2042) {
					System.out.print("'E2L'");
				} else if (map[i][j].getImageID() == 2043) {
					System.out.print("'E2R'");
				} else if (map[i][j].getImageID() == 2044) {
					System.out.print("'O2D'");
				} else if (map[i][j].getImageID() == 2045) {
					System.out.print("'O2L'");
				} else if (map[i][j].getImageID() == 2046) {
					System.out.print("'O2R'");
				}
				/* Stand for the third act */
				if (map[i][j].getImageID() == 3010) {
					System.out.print(" 333 ");
				} else if (map[i][j].getImageID() == 3020) {
					System.out.print("33333");
				} else if (map[i][j].getImageID() == 3030) {
					System.out.print(" ... ");
				} else if (map[i][j].getImageID() == 3041) {
					System.out.print("'E3D'");
				} else if (map[i][j].getImageID() == 3042) {
					System.out.print("'E3L'");
				} else if (map[i][j].getImageID() == 3043) {
					System.out.print("'E3R'");
				} else if (map[i][j].getImageID() == 3044) {
					System.out.print("'O3D'");
				} else if (map[i][j].getImageID() == 3045) {
					System.out.print("'O3L'");
				} else if (map[i][j].getImageID() == 3046) {
					System.out.print("'O3R'");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Print the generated level in the console. This method serves the same
	 * porpose like above method. The sole differnce consists in the parameter.
	 * 
	 * @param map
	 *            Generated level structure
	 * @author Ulko, Michael
	 */
	public void printArray(Tile[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				/* The symbols are printed depends on the current act */
				/* Stand for the first act */
				if (map[i][j].getImageID() == 1010) {
					System.out.print(" 111 ");
				} else if (map[i][j].getImageID() == 1020) {
					System.out.print("11111");
				} else if (map[i][j].getImageID() == 1030) {
					System.out.print("  .  ");
				} else if (map[i][j].getImageID() == 1041) {
					System.out.print("'E1D'");
				} else if (map[i][j].getImageID() == 1042) {
					System.out.print("'E1L'");
				} else if (map[i][j].getImageID() == 1043) {
					System.out.print("'E1R'");
				} else if (map[i][j].getImageID() == 1044) {
					System.out.print("'O1D'");
				} else if (map[i][j].getImageID() == 1045) {
					System.out.print("'O1L'");
				} else if (map[i][j].getImageID() == 1046) {
					System.out.print("'O1R'");
				}
				/* Stand for the second act */
				if (map[i][j].getImageID() == 2010) {
					System.out.print(" 222 ");
				} else if (map[i][j].getImageID() == 2020) {
					System.out.print("22222");
				} else if (map[i][j].getImageID() == 2030) {
					System.out.print(" . . ");
				} else if (map[i][j].getImageID() == 2041) {
					System.out.print("'E2D'");
				} else if (map[i][j].getImageID() == 2042) {
					System.out.print("'E2L'");
				} else if (map[i][j].getImageID() == 2043) {
					System.out.print("'E2R'");
				} else if (map[i][j].getImageID() == 2044) {
					System.out.print("'O2D'");
				} else if (map[i][j].getImageID() == 2045) {
					System.out.print("'O2L'");
				} else if (map[i][j].getImageID() == 2046) {
					System.out.print("'O2R'");
				}
				/* Stand for the third act */
				if (map[i][j].getImageID() == 3010) {
					System.out.print(" 333 ");
				} else if (map[i][j].getImageID() == 3020) {
					System.out.print("33333");
				} else if (map[i][j].getImageID() == 3030) {
					System.out.print(" ... ");
				} else if (map[i][j].getImageID() == 3041) {
					System.out.print("'E3D'");
				} else if (map[i][j].getImageID() == 3042) {
					System.out.print("'E3L'");
				} else if (map[i][j].getImageID() == 3043) {
					System.out.print("'E3R'");
				} else if (map[i][j].getImageID() == 3044) {
					System.out.print("'O3D'");
				} else if (map[i][j].getImageID() == 3045) {
					System.out.print("'O3L'");
				} else if (map[i][j].getImageID() == 3046) {
					System.out.print("'O3R'");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * @author Ulko, Michael
	 * @return map Give back the double array of Tile
	 */
	public Tile[][] getLevel() {
		return this.map;
	}

	/**
	 * Computation of a random variable, which decides the direction of RFF
	 * 
	 * @return One of four possible values: 1 or 4 for up, 2 or 5 for right, 3
	 *         or 6 for down and 4 or 7 for left
	 * @author Ulko, Michael
	 */
	private int randomMethod() {
		/* Create a new Random object */
		Random zahl = new Random();
		/* Decide the possible value and initialize the variable */
		int zahlRandom = Math.abs(zahl.nextInt(8));
		return zahlRandom;
	}

	/**
	 * Randomized Flood Fill for building a labyrinth
	 * 
	 * @param map
	 *            Double array of type Tile is used here
	 * @param stone
	 *            Presents stone in labyrinth
	 * @param floor
	 *            Presents floor or way though the stone walls
	 * @param x
	 *            Height of the double Array of type Tile
	 * @param y
	 *            Width of the double array of type Tile
	 * @author Ulko, Michael
	 */
	private void floodFill(Tile[][] map, int x, int y, int actID) {
		int randomZahl = randomMethod();
		/* Create an object for current Tile array field depends on act */
		if (actID == 1) {
			map[x][y] = new SW_Floor_1();
		} else if (actID == 2) {
			map[x][y] = new RW_Floor_1();
		} else if (actID == 3) {
			map[x][y] = new UW_Floor_1();
		}

		/* Decides which way the RFF should go the next step */
		switch (randomZahl) {
		case 0: {
			/** RFF goes up if possible depends on current act */
			if (x - 2 >= 0 && map[x - 2][y].getImageID() == 1020) {
				map[x - 1][y] = new SW_Floor_1();
				floodFill(map, x - 2, y, actID);
			}
			if (x - 2 >= 0 && map[x - 2][y].getImageID() == 2020) {
				map[x - 1][y] = new RW_Floor_1();
				floodFill(map, x - 2, y, actID);
			}
			if (x - 2 >= 0 && map[x - 2][y].getImageID() == 3020) {
				map[x - 1][y] = new UW_Floor_1();
				floodFill(map, x - 2, y, actID);
			}
		}
		case 1: {
			/* RFF goes right if possible depends on current act */
			if (y + 2 < map[x].length && map[x][y + 2].getImageID() == 1020) {
				map[x][y + 1] = new SW_Floor_1();
				floodFill(map, x, y + 2, actID);
			}
			if (y + 2 < map[x].length && map[x][y + 2].getImageID() == 2020) {
				map[x][y + 1] = new RW_Floor_1();
				floodFill(map, x, y + 2, actID);
			}
			if (y + 2 < map[x].length && map[x][y + 2].getImageID() == 3020) {
				map[x][y + 1] = new UW_Floor_1();
				floodFill(map, x, y + 2, actID);
			}
		}
		case 2: {
			/* RFF goes down if possible depends on current act */
			if (x + 2 < map.length && map[x + 2][y].getImageID() == 1020) {
				map[x + 1][y] = new SW_Floor_1();
				floodFill(map, x + 2, y, actID);
			}
			if (x + 2 < map.length && map[x + 2][y].getImageID() == 2020) {
				map[x + 1][y] = new RW_Floor_1();
				floodFill(map, x + 2, y, actID);
			}
			if (x + 2 < map.length && map[x + 2][y].getImageID() == 3020) {
				map[x + 1][y] = new UW_Floor_1();
				floodFill(map, x + 2, y, actID);
			}
		}
		case 3: {
			/* RFF goes left if possible depends on current act */
			if (y - 2 >= 0 && map[x][y - 2].getImageID() == 1020) {
				map[x][y - 1] = new SW_Floor_1();
				floodFill(map, x, y - 2, actID);
			}
			if (y - 2 >= 0 && map[x][y - 2].getImageID() == 2020) {
				map[x][y - 1] = new RW_Floor_1();
				floodFill(map, x, y - 2, actID);
			}
			if (y - 2 >= 0 && map[x][y - 2].getImageID() == 3020) {
				map[x][y - 1] = new UW_Floor_1();
				floodFill(map, x, y - 2, actID);
			}
		}
		case 4: {
			/** RFF goes up if possible depends on current act */
			if (x - 2 >= 0 && map[x - 2][y].getImageID() == 1020) {
				map[x - 1][y] = new SW_Floor_1();
				floodFill(map, x - 2, y, actID);
			}
			if (x - 2 >= 0 && map[x - 2][y].getImageID() == 2020) {
				map[x - 1][y] = new RW_Floor_1();
				floodFill(map, x - 2, y, actID);
			}
			if (x - 2 >= 0 && map[x - 2][y].getImageID() == 3020) {
				map[x - 1][y] = new UW_Floor_1();
				floodFill(map, x - 2, y, actID);
			}
		}
		case 5: {
			/* RFF goes right if possible depends on current act */
			if (y + 2 < map[x].length && map[x][y + 2].getImageID() == 1020) {
				map[x][y + 1] = new SW_Floor_1();
				floodFill(map, x, y + 2, actID);
			}
			if (y + 2 < map[x].length && map[x][y + 2].getImageID() == 2020) {
				map[x][y + 1] = new RW_Floor_1();
				floodFill(map, x, y + 2, actID);
			}
			if (y + 2 < map[x].length && map[x][y + 2].getImageID() == 3020) {
				map[x][y + 1] = new UW_Floor_1();
				floodFill(map, x, y + 2, actID);
			}
		}
		case 6: {
			/* RFF goes down if possible depends on current act */
			if (x + 2 < map.length && map[x + 2][y].getImageID() == 1020) {
				map[x + 1][y] = new SW_Floor_1();
				floodFill(map, x + 2, y, actID);
			}
			if (x + 2 < map.length && map[x + 2][y].getImageID() == 2020) {
				map[x + 1][y] = new RW_Floor_1();
				floodFill(map, x + 2, y, actID);
			}
			if (x + 2 < map.length && map[x + 2][y].getImageID() == 3020) {
				map[x + 1][y] = new UW_Floor_1();
				floodFill(map, x + 2, y, actID);
			}
		}
		case 7: {
			/* RFF goes left if possible depends on current act */
			if (y - 2 >= 0 && map[x][y - 2].getImageID() == 1020) {
				map[x][y - 1] = new SW_Floor_1();
				floodFill(map, x, y - 2, actID);
			}
			if (y - 2 >= 0 && map[x][y - 2].getImageID() == 2020) {
				map[x][y - 1] = new RW_Floor_1();
				floodFill(map, x, y - 2, actID);
			}
			if (y - 2 >= 0 && map[x][y - 2].getImageID() == 3020) {
				map[x][y - 1] = new UW_Floor_1();
				floodFill(map, x, y - 2, actID);
			}
		}
		}
	}

	/**
	 * Produce the basic structure for every level: global border, stones and
	 * labyrinth.
	 * 
	 * @param actID
	 *            Current act number
	 * 
	 * @author Ulko, Michael
	 */
	public void generateLevel(int actID) {
		/* Fill a level with global border and stones */
		fillMapArray(actID);
		/* Produce labyrinth through the stones */
		floodFill(this.map, 1, 60, actID);
	}

	/**
	 * Produce start level.
	 * 
	 * @author Ulko, Michael
	 */
	public void generateStartRoom() {
		this.map = new Tile[18][30];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new SW_Border_1();
			}
		}
		for (int i = 1; i < map.length - 1; i++) {
			for (int j = 1; j < map[i].length - 1; j++) {
				map[i][j] = new SW_Wall_1();
			}
		}
		for (int i = 2; i < map.length - 2; i++) {
			for (int j = 2; j <= 8; j++) {
				map[i][j] = new SW_Floor_1();
			}
		}
		for (int i = 2; i < map.length - 2; i++) {
			for (int j = 10; j <= 12; j++) {
				map[i][j] = new SW_Floor_1();
			}
		}
		for (int i = 2; i < map.length - 2; i++) {
			for (int j = 13; j <= 19; j++) {
				map[i][j] = new SW_Floor_1();
			}
		}
		for (int i = 2; i < map.length - 2; i++) {
			for (int j = 21; j <= 27; j++) {
				map[i][j] = new SW_Floor_1();
			}
		}
	}

	/**
	 * Produce boss level.
	 * 
	 * @param actID
	 *            Current act
	 * @author Ulko, Michael
	 */
	public void generateBossRoom(int actID) {
		this.map = new Tile[18][30];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (actID == 1) {
					map[i][j] = new SW_Border_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Border_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Border_1();
				}
			}
		}
		for (int i = 1; i < map.length - 1; i++) {
			for (int j = 1; j < map[i].length - 1; j++) {
				if (actID == 1) {
					map[i][j] = new SW_Wall_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Wall_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Wall_1();
				}
			}
		}
		
		
		for (int i = 2; i <= 2; i++) {
			for (int j = 8; j <= 21; j++) {
				if (actID == 1) {
					map[i][j] = new SW_Floor_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Floor_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Floor_1();
				}
			}
		}
		for (int i = 3; i <= 3; i++) {
			for (int j = 4; j <= 25; j++) {
				if (actID == 1) {
					map[i][j] = new SW_Floor_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Floor_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Floor_1();
				}
			}
		}
		for (int i = 4; i <= 5; i++) {
			for (int j = 3; j <= 26; j++) {
				if (actID == 1) {
					map[i][j] = new SW_Floor_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Floor_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Floor_1();
				}
			}
		}
		for (int i = 6; i <= 11; i++) {
			for (int j = 2; j <= 27; j++) {
				if (actID == 1) {
					map[i][j] = new SW_Floor_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Floor_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Floor_1();
				}
			}
		}
		for (int i = 12; i <= 13; i++) {
			for (int j = 3; j <= 26; j++) {
				if (actID == 1) {
					map[i][j] = new SW_Floor_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Floor_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Floor_1();
				}
			}
		}
		for (int i = 14; i <= 14; i++) {
			for (int j = 4; j <= 25; j++) {
				if (actID == 1) {
					map[i][j] = new SW_Floor_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Floor_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Floor_1();
				}
			}
		}
		for (int i = 15; i <= 15; i++) {
			for (int j = 8; j <= 21; j++) {
				if (actID == 1) {
					map[i][j] = new SW_Floor_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Floor_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Floor_1();
				}
			}
		}
	}

	/**
	 * Produce shop level.
	 * 
	 * @param actID
	 *            Current act
	 * @author Ulko, Michael
	 */
	public void generateShopRoom(int actID) {
//		this.map = new Tile[12][13];
		this.map = new Tile[18][30];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (actID == 1) {
					map[i][j] = new SW_Border_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Border_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Border_1();
				}
			}
		}
		for (int i = 1; i < map.length - 1; i++) {
			for (int j = 1; j < map[i].length - 1; j++) {
				if (actID == 1) {
					map[i][j] = new SW_Wall_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Wall_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Wall_1();
				}
			}
		}
		for (int i = 2; i < map.length - 2; i++) {
			for (int j = 2; j < map[i].length - 2; j++) {
				if (actID == 1) {
					map[i][j] = new SW_Floor_1();
				} else if (actID == 2) {
					map[i][j] = new RW_Floor_1();
				} else if (actID == 3) {
					map[i][j] = new UW_Floor_1();
				}
			}
		}
		
		for (int i = 4; i <= 13; i++) {
			for (int j = 6; j <= 22; j++) {
				if ((i == 4 && (j >= 6 && j <= 11)) || (i == 4 && (j >= 17 && j <=22))) {
					if (actID == 1) {
						map[i][j] = new SW_Wall_1();
					} else if (actID == 2) {
						map[i][j] = new RW_Wall_1();
					} else if (actID == 3) {
						map[i][j] = new UW_Wall_1();
					}
				} else if (i == 13 && (j >= 11 && j <= 17)) {
					if (actID == 1) {
						map[i][j] = new SW_Wall_1();
					} else if (actID == 2) {
						map[i][j] = new RW_Wall_1();
					} else if (actID == 3) {
						map[i][j] = new UW_Wall_1();
					}
				} else if ((j == 6 || j == 11 || j == 17 || j == 22)){
					if (actID == 1) {
						map[i][j] = new SW_Wall_1();
					} else if (actID == 2) {
						map[i][j] = new RW_Wall_1();
					} else if (actID == 3) {
						map[i][j] = new UW_Wall_1();
					}
				}
			}
		}
		
		
		
//		for (int i = 4; i <= 7; i++) {
//			for (int j = 4; j <= 8; j++) {
//				if ((i >= 4 && i <= 6) && (j == 4 || j == 8)) {
//					if (actID == 1) {
//						map[i][j] = new SW_Wall_1();
//					} else if (actID == 2) {
//						map[i][j] = new RW_Wall_1();
//					} else if (actID == 3) {
//						map[i][j] = new UW_Wall_1();
//					}
//				}
//				if ((i == 7) && (j >= 4 && j <= 8)) {
//					if (actID == 1) {
//						map[i][j] = new SW_Wall_1();
//					} else if (actID == 2) {
//						map[i][j] = new RW_Wall_1();
//					} else if (actID == 3) {
//						map[i][j] = new UW_Wall_1();
//					}
//				}
//			}
//		}
	}

}

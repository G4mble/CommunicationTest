package pp2015.team12.server.map;

import java.util.Random;
import java.util.Vector;

import pp2015.team12.shared.map.Tile;
import pp2015.team12.shared.map.textures.RW_Door_1;
import pp2015.team12.shared.map.textures.RW_Door_2;
import pp2015.team12.shared.map.textures.RW_Door_3;
import pp2015.team12.shared.map.textures.RW_Door_4;
import pp2015.team12.shared.map.textures.RW_Door_5;
import pp2015.team12.shared.map.textures.RW_Door_6;
import pp2015.team12.shared.map.textures.RW_Floor_1;
import pp2015.team12.shared.map.textures.SW_Door_1;
import pp2015.team12.shared.map.textures.SW_Door_2;
import pp2015.team12.shared.map.textures.SW_Door_3;
import pp2015.team12.shared.map.textures.SW_Door_4;
import pp2015.team12.shared.map.textures.SW_Door_5;
import pp2015.team12.shared.map.textures.SW_Door_6;
import pp2015.team12.shared.map.textures.SW_Floor_1;
import pp2015.team12.shared.map.textures.UW_Door_1;
import pp2015.team12.shared.map.textures.UW_Door_2;
import pp2015.team12.shared.map.textures.UW_Door_3;
import pp2015.team12.shared.map.textures.UW_Door_4;
import pp2015.team12.shared.map.textures.UW_Door_5;
import pp2015.team12.shared.map.textures.UW_Door_6;
import pp2015.team12.shared.map.textures.UW_Floor_1;

/**
 * This class generates rooms with various size and positions and places them in
 * a level. It places special number of doors and computes the number of
 * monsters and items for every level and builds two Vector[] arrays which
 * contain positions of monsters or items in every level.
 * 
 * @author Ulko, Michael
 * 
 */
public class Level_Ready {

	/**
	 * 
	 * @return An array of Integer which contains two coordinates for placing a
	 *         room: pos1 stands for the x and pos2 for y coordinate
	 * @author Ulko, Michael
	 */
	private int[] randomRoomPos() {
		Random zahl = new Random();
		int[] pos = new int[2];
		/*
		 * "3" in brackets stands for the maximal deviation down from the upper
		 * left corner of every level quadrant
		 */
		int pos1 = Math.abs(zahl.nextInt(3));
		/*
		 * "5" in brackets stands for the maximal deviation right from the upper
		 * left corner of every level quadrant
		 */
		int pos2 = Math.abs(zahl.nextInt(5));
		pos[0] = pos1;
		pos[1] = pos2;
		return pos;
	}

	/**
	 * Decide how many units can be added maximal to the height of the
	 * generating room
	 * 
	 * @return Maximal units added to the height
	 * 
	 * @author Ulko, Michael
	 */
	private int randomRoomHeight() {
		Random zahl = new Random();
		/*
		 * Maximal "4" units can be added to the height of generating room
		 */
		int zahlRandom = 1 + Math.abs(zahl.nextInt(4));
		return zahlRandom;
	}

	/**
	 * Decide how many units can be added maximal to the length of the
	 * generating room
	 * 
	 * @return Maximal units added to the length
	 * 
	 * @author Ulko, Michael
	 */
	private int randomRoomLength() {
		Random zahl = new Random();
		/*
		 * Maximal "11" units can be added to the height of generating room
		 */
		int zahlRandom = 1 + Math.abs(zahl.nextInt(11));
		return zahlRandom;
	}

	/* This array should contain final characteristics of every generated room */
	private int[] room = new int[4];

	/**
	 * Create single room
	 * 
	 * @param levelPart1
	 *            Stands for the number of quadrant in the double array in
	 *            vertical alignment
	 * 
	 * @param levelPart2
	 *            Stands for the number of quadrant in the double array in
	 *            horizontal alignment
	 * 
	 * @author Ulko, Michael
	 */
	private void createRoom(int levelPart1, int levelPart2) {
		/* Final height of generated room is defined */
		int x = 3 + randomRoomHeight();
		/* Final height of generated room is defined */
		int y = 4 + randomRoomLength();
		/* Final positions of generated room is defined */
		int pos1 = 1 + levelPart1 + randomRoomPos()[0];
		int pos2 = 1 + levelPart2 + randomRoomPos()[1];
		/* Final attitudes of the generated room are passed to the array */
		room[0] = pos1;
		room[1] = pos2;
		room[2] = x;
		room[3] = y;
	}

	/**
	 * 
	 * @return Decision whether a room should be created and placed in the
	 *         double array of type Tile
	 * @author Ulko, Michael
	 */
	private boolean roomAppearence() {
		Random zahl = new Random();
		/* This function was selected randomly */
		int zahlRandom = 1 + Math.abs(zahl.nextInt(55)) % 2;
		boolean appearence = true;
		if (zahlRandom % 2 == 0) {
			appearence = false;
		}
		return appearence;
	}

	/**
	 * Decide whether a room should be created and placed in an array or not and
	 * fulfill the consequence of this decision.
	 * 
	 * @param map
	 *            Double array of type Tile
	 * @param floor
	 *            Way though the labyrinth
	 * @author Ulko, Michael
	 */
	private void placeRoom(Tile[][] map, int actID) {
		/*
		 * Gives the maximal number of rooms which can be not placed in map
		 * array
		 */
		int appearenceZaehler = 3;
		/*
		 * Stands for the number of quadrant in the double array in vertical
		 * alignment
		 */
		int levelPart1 = 0;
		/*
		 * Stands for the number of quadrant in the double array in horizontal
		 * alignment
		 */
		int levelPart2 = 0;
		/*
		 * Double array of Tile consists of fixed number of quadrants. Variables
		 * i and j count until maximal number of quadrants of the array
		 * (vertical and horizontal alignment)
		 */
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				/*
				 * If a room shouldn't be placed in the double array and it's
				 * possible to do it then don't place the room
				 */
				if (appearenceZaehler > 0 && !roomAppearence()) {
					appearenceZaehler--;
				} else {
					createRoom(levelPart1, levelPart2);
					for (int ii = room[0]; ii < room[0] + room[2]; ii++) {
						for (int jj = room[1]; jj < room[1] + room[3]; jj++) {
							/* Create a Tile object depends on current act */
							if (actID == 1) {
								map[ii][jj] = new SW_Floor_1();
							} else if (actID == 2) {
								map[ii][jj] = new RW_Floor_1();
							} else if (actID == 3) {
								map[ii][jj] = new UW_Floor_1();
							}
						}
					}
				}
				/* Switch to the next down vertical quadrant */
				levelPart1 += 10;
				// printArray();
			}
			/* Switch to the next right horizontal quadrant */
			levelPart2 += 20;
			/* Switch to the top vertical quadrant in the next "column" */
			levelPart1 = 0;
		}
	}

	/**
	 * Calculate a random coordinate in vertical direction for placing a door
	 * 
	 * @param map
	 *            Necessary for dynamic calculation of modulo variable
	 * @return Value in vertical direction, where a door can be placed probably
	 * @author Ulko, Michael
	 */
	private int countDoorPosX(Tile[][] map) {
		Random zahl = new Random();
		/*
		 * From modulo operator 2 units are subtracted due to 1 border unit of
		 * every level side. 1 is added due to legal access on the array field.
		 */
		int posX = 1 + Math.abs(zahl.nextInt(map.length - 2));
		return posX;
	}

	/**
	 * Calculate a random coordinate in horizontal direction for placing of a
	 * door
	 * 
	 * @param map
	 *            Necessary for dynamic calculation of modulo variable
	 * @return Value in horizontal direction, where a door can be placed
	 *         probably
	 * @author Ulko, Michael
	 */
	private int countDoorPosY(Tile[][] map) {
		Random zahl = new Random();
		/*
		 * From modulo operator 2 units are subtracted due to 1 border unit of
		 * every level side. 1 is added due to legal access on the array field.
		 */
		int posY = 1 + Math.abs(zahl.nextInt(map.length - 2));
		return posY;
	}

	/* This array schould contain legal coordinates for placing a door */
	private int[] doorPos = new int[2];
	/* Control variable */
	private boolean isWall = false;

	/**
	 * Decide, whether a door can be placed in a special level or not. If it is
	 * possible, set 'isWall' on 'true'.
	 * 
	 * @param map
	 *            Is necessary for desicion which objects are adjacent to
	 *            possible door with calculated coordinates.
	 * @author Ulko, Michael
	 */
	private void calculateWallPos(Tile[][] map) {
		/* Calculated position in vertical direction */
		this.doorPos[0] = countDoorPosX(map);
		/* Calculated position in horizontal direction */
		this.doorPos[1] = countDoorPosY(map);
		/* Slip until a valid position is found */
		while (!this.isWall) {
			/*
			 * Is valid either if 1) The array field where the door schould be
			 * placed contains a stone object and 2) The above field object is a
			 * floor element and 3) The lower field object is a border element
			 * OR 1) The array field where the door schould be placed contains a
			 * stone object and 2) The left field object is a border element and
			 * 3) The right field is a floor element.
			 */
			if (((map[this.doorPos[0]][this.doorPos[1] - 1].getImageID() == 1020
					|| map[this.doorPos[0]][this.doorPos[1] - 1].getImageID() == 2020 || map[this.doorPos[0]][this.doorPos[1] - 1]
					.getImageID() == 3020)
					&& (map[this.doorPos[0]][this.doorPos[1]].getImageID() == 1020
							|| map[this.doorPos[0]][this.doorPos[1]]
									.getImageID() == 2020 || map[this.doorPos[0]][this.doorPos[1]]
							.getImageID() == 3020)
					&& (map[this.doorPos[0]][this.doorPos[1] + 1].getImageID() == 1020
							|| map[this.doorPos[0]][this.doorPos[1] + 1]
									.getImageID() == 2020 || map[this.doorPos[0]][this.doorPos[1] + 1]
							.getImageID() == 3020)
					&& (map[this.doorPos[0] - 1][this.doorPos[1]].getImageID() == 1030
							|| map[this.doorPos[0] - 1][this.doorPos[1]]
									.getImageID() == 2030 || map[this.doorPos[0] - 1][this.doorPos[1]]
							.getImageID() == 3030) && (map[this.doorPos[0] + 1][this.doorPos[1]]
					.getImageID() == 1010
					|| map[this.doorPos[0] + 1][this.doorPos[1]].getImageID() == 2010 || map[this.doorPos[0] + 1][this.doorPos[1]]
					.getImageID() == 3010))
					||

					((map[this.doorPos[0]][this.doorPos[1]].getImageID() == 1020
							|| map[this.doorPos[0]][this.doorPos[1]]
									.getImageID() == 2020 || map[this.doorPos[0]][this.doorPos[1]]
							.getImageID() == 3020)
							&& (map[this.doorPos[0]][this.doorPos[1] - 1]
									.getImageID() == 1010
									|| map[this.doorPos[0]][this.doorPos[1] - 1]
											.getImageID() == 2010 || map[this.doorPos[0]][this.doorPos[1] - 1]
									.getImageID() == 3010)
							&& (map[this.doorPos[0]][this.doorPos[1] + 1]
									.getImageID() == 1030
									|| map[this.doorPos[0]][this.doorPos[1] + 1]
											.getImageID() == 2030 || map[this.doorPos[0]][this.doorPos[1] + 1]
									.getImageID() == 3030)
							&& (map[this.doorPos[0] + 1][this.doorPos[1]]
									.getImageID() == 1020
									|| map[this.doorPos[0]][this.doorPos[1] + 1]
											.getImageID() == 2020 || map[this.doorPos[0]][this.doorPos[1] + 1]
									.getImageID() == 3020) && (map[this.doorPos[0] - 1][this.doorPos[1]]
							.getImageID() == 1020
							|| map[this.doorPos[0] - 1][this.doorPos[1]]
									.getImageID() == 2020 || map[this.doorPos[0] - 1][this.doorPos[1]]
							.getImageID() == 3020))) {
				this.isWall = true;
			} else {
				/* Find another coordinates */
				calculateWallPos(map);
			}
		}
	}

	/**
	 * Place the matching door in a level.
	 * 
	 * @param map
	 *            Double array of type Tile for direct access on every array
	 *            field
	 * @param actID
	 *            Representes current act
	 * @param doorType
	 *            Stands for every possible door type: 1. door directing to
	 *            parent node; 2. door directing to left son and 3. door
	 *            direting to right son
	 * @author Ulko, Michael
	 */
	private void setDoor(Tile[][] map, int actID, int doorType) {
		/* If it is allowed to place a door on special position */
		if (this.isWall) {
			/* Doors for the first act */
			if (actID == 1) {
				/* Door directing to direct parent node */
				if (doorType == 1) {
					map[this.doorPos[0]][this.doorPos[1]] = new SW_Door_1();
				} /* Door directing to left parent node */
				else if (doorType == 2) {
					map[this.doorPos[0]][this.doorPos[1]] = new SW_Door_2();
				} /* Door directing to right parent node */
				else if (doorType == 3) {
					map[this.doorPos[0]][this.doorPos[1]] = new SW_Door_3();
				} /* Door directing to direct son */
				else if (doorType == 4) {
					map[this.doorPos[0]][this.doorPos[1]] = new SW_Door_4();
				} /* Door directing to left son */
				else if (doorType == 5) {
					map[this.doorPos[0]][this.doorPos[1]] = new SW_Door_5();
				} /* Door directing to right son */
				else if (doorType == 6) {
					map[this.doorPos[0]][this.doorPos[1]] = new SW_Door_6();
				}
			}
			/* Doors for the second act */
			if (actID == 2) {
				/* Door directing to direct parent node */
				if (doorType == 1) {
					map[this.doorPos[0]][this.doorPos[1]] = new RW_Door_1();
				} /* Door directing to left parent node */
				else if (doorType == 2) {
					map[this.doorPos[0]][this.doorPos[1]] = new RW_Door_2();
				} /* Door directing to right parent node */
				else if (doorType == 3) {
					map[this.doorPos[0]][this.doorPos[1]] = new RW_Door_3();
				} /* Door directing to direct son */
				else if (doorType == 4) {
					map[this.doorPos[0]][this.doorPos[1]] = new RW_Door_4();
				} /* Door directing to left son */
				else if (doorType == 5) {
					map[this.doorPos[0]][this.doorPos[1]] = new RW_Door_5();
				} /* Door directing to right son */
				else if (doorType == 6) {
					map[this.doorPos[0]][this.doorPos[1]] = new RW_Door_6();
				}
			}
			/* Doors for the third act */
			if (actID == 3) {
				/* Door directing to direct parent node */
				if (doorType == 1) {
					map[this.doorPos[0]][this.doorPos[1]] = new UW_Door_1();
				} /* Door directing to left parent node */
				else if (doorType == 2) {
					map[this.doorPos[0]][this.doorPos[1]] = new UW_Door_2();
				} /* Door directing to right parent node */
				else if (doorType == 3) {
					map[this.doorPos[0]][this.doorPos[1]] = new UW_Door_3();
				} /* Door directing to direct son */
				else if (doorType == 4) {
					map[this.doorPos[0]][this.doorPos[1]] = new UW_Door_4();
				} /* Door directing to left son */
				else if (doorType == 5) {
					map[this.doorPos[0]][this.doorPos[1]] = new UW_Door_5();
				} /* Door directing to right son */
				else if (doorType == 6) {
					map[this.doorPos[0]][this.doorPos[1]] = new UW_Door_6();
				}
			}
		}
	}

	/**
	 * Place doors due to the act and level number in a level.
	 * 
	 * @param map
	 *            Double array of type Tile for direct access on every array
	 *            field
	 * @param actID
	 *            Representes current act
	 * @param levelID
	 *            Represents current level number
	 * @author Ulko, Michael
	 */
	private void placeDoors(Tile[][] map, int actID, int levelID) {
		/* Each first 7 nodes of every sub-tree */
		if ((levelID >= 1 && levelID <= 7) || (levelID >= 23 && levelID <= 29)
				|| (levelID >= 45 && levelID <= 51)) {

			/* Whether the door directing to direct father node can be placed */
			calculateWallPos(map);
			/* Place the first door in level */
			setDoor(map, actID, 1);
			/* Update the variable */
			this.isWall = false;

			/* Decide whether the door directing to the left node can be placed */
			calculateWallPos(map);
			/* Place the second door in level */
			setDoor(map, actID, 5);
			/* Update the variable */
			this.isWall = false;

			/* Decide whether the door directing to the right node can be placed */
			calculateWallPos(map);
			/* Place the third door in level */
			setDoor(map, actID, 6);
			/* Update the variable */
			this.isWall = false;
		}
		/* Each middle 8 nodes of every sub-tree */
		if ((levelID >= 8 && levelID <= 15) || (levelID >= 30 && levelID <= 37)
				|| (levelID >= 52 && levelID <= 59)) {

			/* Whether the door directing to direct father node can be placed */
			calculateWallPos(map);
			/* Place the first door in level */
			setDoor(map, actID, 1);
			/* Update the variable */
			this.isWall = false;

			/* Whether the door directing to direct son node can be placed */
			calculateWallPos(map);
			/* Place the second door in level */
			setDoor(map, actID, 4);
			/* Update the variable */
			this.isWall = false;
		}
		if ((levelID >= 16 && levelID <= 22)
				|| (levelID >= 38 && levelID <= 44)
				|| (levelID >= 60 && levelID <= 66)) {

			/* Whether the door directing to left father node can be placed */
			calculateWallPos(map);
			/* Place the first door in level */
			setDoor(map, actID, 2);
			/* Update the variable */
			this.isWall = false;

			/* Whether the door directing to right father node can be placed */
			calculateWallPos(map);
			/* Place the second door in level */
			setDoor(map, actID, 3);
			/* Update the variable */
			this.isWall = false;

			/* Whether the door directing to direct son node can be placed */
			calculateWallPos(map);
			/* Place the third door in level */
			setDoor(map, actID, 4);
			/* Update the variable */
			this.isWall = false;
		}
	}

	/**
	 * Place doors due to the current act and level number in the boss level.
	 * 
	 * @param actID
	 *            Current act number
	 * @param levelID
	 *            Current level number
	 * @param map
	 *            Level where the doors should be placed
	 * @author Ulko, Michael
	 */
	private void placeDoorsBoss(int actID, int levelID, Tile[][] map) {
		if (actID == 1) {
			map[8][1] = new SW_Door_2();
			map[8][28] = new SW_Door_3();
			map[16][15] = new SW_Door_4();
		}
		if (actID == 2) {
			map[8][1] = new RW_Door_2();
			map[8][28] = new RW_Door_3();
			map[16][15] = new RW_Door_4();
		}
		if (actID == 3) {
			map[8][1] = new UW_Door_2();
			map[8][28] = new UW_Door_3();
			map[16][15] = new UW_Door_4();
		}
	}

	/**
	 * Place doors due to the current act and level number in the shop level.
	 * 
	 * @param actID
	 *            Current act number
	 * @param levelID
	 *            Current level number
	 * @param map
	 *            Level where the doors should be placed
	 * @author Ulko, Michael
	 */
	private void placeDoorsShop(int actID, int levelID, Tile[][] map) {
		if (actID == 1) {
			if (levelID == 4 || levelID == 6) {
				map[1][14] = new SW_Door_1();
				map[16][8] = new SW_Door_5();
				map[16][20] = new SW_Door_6();
			}
			if (levelID == 17 || levelID == 19) {
				map[1][8] = new SW_Door_2();
				map[1][20] = new SW_Door_3();
				map[16][14] = new SW_Door_4();
			}
		}
		if (actID == 2) {
			if (levelID % 22 == 4 || levelID % 22 == 6) {
				map[1][14] = new RW_Door_1();
				map[16][8] = new RW_Door_5();
				map[16][20] = new RW_Door_6();
			}
			if (levelID % 22 == 17 || levelID % 22 == 19) {
				map[1][8] = new RW_Door_2();
				map[1][20] = new RW_Door_3();
				map[16][14] = new RW_Door_4();
			}
		}
		if (actID == 3) {
			if (levelID % 44 == 4 || levelID % 44 == 6) {
				map[1][14] = new UW_Door_1();
				map[16][8] = new UW_Door_5();
				map[16][20] = new UW_Door_6();
			}
			if (levelID % 44 == 17 || levelID % 44 == 19) {
				map[1][8] = new UW_Door_2();
				map[1][20] = new UW_Door_3();
				map[16][14] = new UW_Door_4();
			}
		}
	}

	/**
	 * Calculate coordinates for placing a monster or item.
	 * 
	 * @param range
	 *            Length of double array in one direction: vertical or
	 *            horizontal
	 * @return Coordinate in vertical or horizontal direction
	 * @author Ulko, Michael
	 */
	private int calcPos(int range) {
		Random random = new Random();
		/* Position whithin the array is guaranted */
		int randZahl = 1 + Math.abs(random.nextInt(range - 2));
		return randZahl;
	}

	/*
	 * Protection variable to avoid of double placing (items or monsters) on the
	 * same field
	 */
	private int[][] tempMap;
	/* Control variable */
	private boolean canPlace = false;

	/**
	 * Find a valid position for placing of a monster or item.
	 * 
	 * @param map
	 *            Double array of type Tile for direct access on every array
	 *            field
	 * @param pos
	 *            Array for saving two coordinats for every monster or item
	 *            element
	 * @author Ulko, Michael
	 */
	private void countPos(Tile[][] map, int[] pos) {
		/* Calculate possible position in vertical alignment */
		pos[0] = calcPos(map.length);
		/* Calculate possible position in horizontal alignment */
		pos[1] = calcPos(map[pos[0]].length);
		/* Slip until valid coordinates for placing are found */
		while (!canPlace) {
			/* Set on 'true' if the selected array field is a floor object */
			if ((map[pos[0]][pos[1]].getImageID() == 1030
					|| map[pos[0]][pos[1]].getImageID() == 2030 || map[pos[0]][pos[1]]
					.getImageID() == 3030)
			/* Protection filed allows placing, too */
			&& (this.tempMap[pos[0]][pos[1]] != 1)) {
				this.canPlace = true;
			} /* Calculate new position */
			else {
				countPos(map, pos);
			}
		}
	}

	/**
	 * Compute the amount of placed monsters or items.
	 * 
	 * @param minNr
	 *            Minimal value for objects which must be placed
	 * @return Amount for objects must be placed
	 * @author Ulko, Michael
	 */
	private int calcElNr(int minNr) {
		Random random = new Random();
		/* 3 other objects can be added to 'minNr', too */
		int nr = minNr + Math.abs(random.nextInt(3));
		return nr;
	}

	/* Saves the minimal amount of monsters or items */
	private int elAmount = 0;
	/* Should contain coordinates for vertical and horizontal direction */
	private int[] possPos = new int[2];

	/**
	 * Save the amount and positions of elements (monster or items) in special
	 * field: Vector[levelID]: levelID stands for current level. All calculated
	 * coordinates for all elements (='minNr') are saved as a vector in the
	 * Vector[] filed according to the level.
	 * 
	 * @param minNr
	 *            Minimal value for objects which must be placed
	 * @param list
	 *            Contains all positions of all elements shuold be placed
	 * @param levelID
	 *            Current level
	 * @param map
	 *            Current level structure
	 * @author Ulko, Michael
	 */
	private void setPosItems(int minNr, Vector<Integer>[] list, int levelID,
			Tile[][] map) {
		/* Calculated amount of monsters or items in level */
		this.elAmount = calcElNr(minNr);
		/* Create a Vector object for the array field */
		list[levelID - 1] = new Vector<Integer>();
		/* Save the calculated amount as first Vector element */
		list[levelID - 1].addElement(this.elAmount);
		/* Slip until there is no further elements should be placed */
		while (this.elAmount > 0) {
			/* Find a valid position for placing */
			countPos(map, this.possPos);
			/* If the computed position is valid */
			if (canPlace) {
				/* Add valid position of element in vertical alignment to Vector */
				list[levelID - 1].addElement(this.possPos[0]);
				/* Add valid position in horizontal alignment to Vector */
				list[levelID - 1].addElement(this.possPos[1]);
				/* Register monster or item in protection variable */
				this.tempMap[possPos[0]][possPos[1]] = 1;
				this.elAmount--;
			}
			/* Update the control variable */
			this.canPlace = false;
		}
	}

	/**
	 * Save the amount and positions of elements (monster or items) in special
	 * field: Vector[levelID]: levelID stands for current level. All calculated
	 * coordinates for all elements (='minNr') are saved as a vector in the
	 * Vector[] filed according to the level.
	 * 
	 * @param minNr
	 *            Minimal value for objects which must be placed
	 * @param list
	 *            Contains all positions of all elements shuold be placed
	 * @param levelID
	 *            Current level
	 * @param map
	 *            Current level structure
	 * @author Ulko, Michael
	 */
	private void setPosItemsShop(int minNr, Vector<Integer>[] list,
			int levelID, Tile[][] map) {
		/* Create a Vector object for the array field */
		list[levelID - 1] = new Vector<Integer>();
		/* Save the calculated amount as first Vector element */
		list[levelID - 1].addElement(0);
	}

	/**
	 * Save the amount and positions of elements (monster or items) in special
	 * field: Vector[levelID]: levelID stands for current level. All calculated
	 * coordinates for all elements (='minNr') are saved as a vector in the
	 * Vector[] filed according to the level.
	 * 
	 * @param minNr
	 *            Minimal value for objects which must be placed
	 * @param list
	 *            Contains all positions of all elements shuold be placed
	 * @param levelID
	 *            Current level
	 * @param map
	 *            Current level structure
	 * @author Ulko, Michael
	 */
	private void setPosMonsters(int minNr, Vector<Integer>[] list, int levelID,
			Tile[][] map) {
		/* Calculated amount of monsters or items in level */
		this.elAmount = calcElNr(minNr);
		/* Create a Vector object for the array field */
		list[levelID - 1] = new Vector<Integer>();
		/* Kind of character: 1 = normal, 2 = boss, 3 = trader */
		list[levelID - 1].addElement(1);
		/* Save the calculated amount as first Vector element */
		list[levelID - 1].addElement(this.elAmount);
		/* Slip until there is no further elements should be placed */
		while (this.elAmount > 0) {
			/* Find a valid position for placing */
			countPos(map, this.possPos);
			/* If the computed position is valid */
			if (canPlace) {
				/* Add valid position of element in vertical alignment to Vector */
				list[levelID - 1].addElement(this.possPos[0]);
				/* Add valid position in horizontal alignment to Vector */
				list[levelID - 1].addElement(this.possPos[1]);
				/* Register monster or item in protection variable */
				this.tempMap[possPos[0]][possPos[1]] = 1;
				this.elAmount--;
			}
			/* Update the control variable */
			this.canPlace = false;
		}
	}

	/**
	 * Save positions of boss monster in special field: Vector[levelID]: levelID
	 * stands for current level.
	 * 
	 * @author Ulko, Michael
	 */
	private void setPosBoss(Vector<Integer>[] list, int levelID, Tile[][] map) {
		/* Calculated amount of monsters in level */
		this.elAmount = 1;
		/* Create a Vector object for the array field */
		list[levelID - 1] = new Vector<Integer>();
		/* Kind of character: 1 = normal, 2 = boss, 3 = trader */
		list[levelID - 1].addElement(2);
		/* Save the calculated amount as first Vector element */
		list[levelID - 1].addElement(this.elAmount);
		/* Every trader has constant positions */
		list[levelID - 1].addElement(1);
		list[levelID - 1].addElement(15);
	}

	/**
	 * Save positions of trader in the special field.
	 * 
	 * @param list
	 *            MonsterList
	 * @param levelID
	 *            Current level number
	 * @param map
	 *            Level where a trader should be placed
	 * @author Ulko, Michael
	 */
	private void setPosTrader(Vector<Integer>[] list, int levelID, Tile[][] map) {
		/* Calculated amount of monsters in level */
		this.elAmount = 1;
		/* Create a Vector object for the array field */
		list[levelID - 1] = new Vector<Integer>();
		/* Kind of character: 1 = normal, 2 = boss, 3 = trader */
		list[levelID - 1].addElement(3);
		/* Save the calculated amount as first Vector element */
		list[levelID - 1].addElement(this.elAmount);
		/* Every trader has constant positions */
		list[levelID - 1].addElement(14);
		list[levelID - 1].addElement(11);
	}

	/* Object for using methods from 'Level_Basic' */
	private Level_Basic ob = new Level_Basic();

	/* List which contains amounts and positions of monsters */
	@SuppressWarnings("unchecked")
	private static Vector<Integer>[] monsterList = new Vector[66];

	/**
	 * Give back the whole MonsterList.
	 * 
	 * @return MonsterList
	 * @author Ulko, Michael
	 */
	public static Vector<Integer>[] getMonsterList() {
		return monsterList;
	}

	/**
	 * Set the MonsterList.
	 * 
	 * @param monsterList
	 * @author Ulko, Michael
	 */
	public static void setMonsterList(Vector<Integer>[] monsterList) {
		Level_Ready.monsterList = monsterList;
	}

	/* List which contains amounts and positions of items */
	@SuppressWarnings("unchecked")
	private static Vector<Integer>[] itemList = new Vector[66];

	/**
	 * Give back the whole ItemsList.
	 * 
	 * @return ItemsList
	 * @author Ulko, Michael
	 */
	public static Vector<Integer>[] getItemList() {
		return itemList;
	}

	/**
	 * Set the MonsterList.
	 * 
	 * @param monsterList
	 * @author Ulko, Michael
	 */
	public static void setItemList(Vector<Integer>[] itemList) {
		Level_Ready.itemList = itemList;
	}

	/**
	 * Create a level completely and make it ready for further using.
	 * 
	 * @param actID
	 *            Current act
	 * @param levelID
	 *            Current level
	 * @return Finished level with labyrinth, doors, monsters and items
	 * @author Ulko, Michael
	 */
	public Tile[][] createLevel(int actID, int levelID) {
		/* Generate basic structure of level (border, stones and labyrinth) */
		ob.generateLevel(actID);

		/* Set rooms in the level */
		placeRoom(ob.getLevel(), actID);

		/* Set doors in the level */
		placeDoors(ob.getLevel(), actID, levelID);

		/* Set size of protection variable */
		this.tempMap = new int[32][62];

		/* Compute amount and positions of monsters in level */
		setPosMonsters(5, Level_Ready.getMonsterList(), levelID, ob.getLevel());

		/* Compute amount and positions of items in level */
		setPosItems(3, Level_Ready.getItemList(), levelID, ob.getLevel());

		return ob.getLevel();
	}

	/**
	 * Create the start level and placing two doors there.
	 * 
	 * @return Finished start level
	 * @author Ulko, Michael
	 */
	public Tile[][] createStartLevel() {
		/* Generate basic structure of the start level */
		ob.generateStartRoom();
		/* Place the entrance door */
		ob.getLevel()[1][15] = new SW_Door_1();
		/* Place the exit door */
		ob.getLevel()[16][15] = new SW_Door_4();

		return ob.getLevel();
	}

	/**
	 * Create a level with boss monster completely and make it ready for further
	 * using.
	 * 
	 * @param actID
	 *            Current act number
	 * @param levelID
	 *            Current level number
	 * @return Finished boss level
	 * @author Ulko, Michael
	 */
	public Tile[][] createBossLevel(int actID, int levelID) {
		/* Generate basic structure of the boss level */
		ob.generateBossRoom(actID);

		/* Set doors in the level */
		placeDoorsBoss(actID, levelID, ob.getLevel());

		/* Set size of protection variable */
		this.tempMap = new int[18][30];

		/* Compute positions of boss monster in level */

		setPosBoss(Level_Ready.getMonsterList(), levelID, ob.getLevel());

		/* Compute amount and positions of items in level */
		setPosItems(10, Level_Ready.getItemList(), levelID, ob.getLevel());

		return ob.getLevel();
	}

	/**
	 * Create a level with trader character completely and make it ready for
	 * further using.
	 * 
	 * @param actID
	 *            Current act number
	 * @param levelID
	 *            Current level number
	 * @return Finished shop level
	 * @author Ulko, Michael
	 */
	public Tile[][] createShopLevel(int actID, int levelID) {
		/* Generate basic structure of the boss level */
		ob.generateShopRoom(actID);

		/* Set doors in the level */
		placeDoorsShop(actID, levelID, ob.getLevel());

		/* Compute positions of trader character in level */
		setPosTrader(Level_Ready.getMonsterList(), levelID, ob.getLevel());

		/* Compute amount and positions of items in level */
		setPosItemsShop(0, Level_Ready.getItemList(), levelID, ob.getLevel());

		return ob.getLevel();
	}
}

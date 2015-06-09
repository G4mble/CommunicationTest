package komponente.serverEngineII;

public class Main_Monster_Testumgebung {

	public static void ausgabe(char[][] map) {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();

		}
	}
	
	public static char[][] map_aktualisieren (char[][] map,int pos_X,int pos_Y){
		for (int i=0; i < map.length;i++){
			for(int j=0;j < map[0].length;j++){
				if (map[i][j]=='M'){
					map[i][j]='.';
				}			
			}
		}
		map[pos_X][pos_Y] = 'M';
		return map;
	}
	
	 
	public static void main(String[] args) {
		
		
		// Fight
		
		char[][] mapA1 = {{'#','#','#','#','#','#','#'},
						 {'#','.','.','.','.','.','#'},
						 {'#','.','.','.','.','.','#'},
						 {'#','.','.','.','.','.','#'},
						 {'#','#','#','#','#','#','#'}};
		boolean[][] mapA2 = new boolean[mapA1.length][mapA1[0].length];
		for (int i = 0; i < mapA2.length; i++) {
			for (int j = 0; j < mapA2[0].length; j++) {
				if (mapA1[i][j] == '.') {
					mapA2[i][j] = true;
				} else {
					mapA2[i][j] = false;
				}
			}
		}
		Monster_Berserker monsterA = new Monster_Berserker(3, 1, 1, "Monster", 2, 1, "");
		Monster_Berserker playerA = new Monster_Berserker(3, 1, 1, "Player", 2, 5, "");
		mapA1[monsterA.getPosX()][monsterA.getPosY()] = 'M';
		mapA1[playerA.getPosX()][playerA.getPosY()] = 'P';
		ausgabe(mapA1);
		System.out.println("State des Monster " + monsterA.getState());		
		System.out.println("Life: "+monsterA.getCurrentLife()+"   "+playerA.getCurrentLife());
		
		
		
		
		for (int i = 1; i < 8; i++) {
			Vertices[] Path2 = playerA.path_to_Player(mapA2, monsterA);
			if (Path2.length == 2) {
				playerA.attack(monsterA);
			}
			if (monsterA.getCurrentLife() < (monsterA.getMaximumLife()/10)){
				monsterA.setState(-1);	
			}
			Vertices[] Path1 = monsterA.path_to_Player(mapA2, playerA);
			switch(monsterA.getState()){
				case 0:
					if (Path1.length != 2) {
					monsterA.setState(1);
					Vertices next_Step = Path1[1];
					monsterA.setPosX(next_Step.getPos_x());
					monsterA.setPosY(next_Step.getPos_y());
					}
					break;
				case 1:
					if (Path1.length != 2) {
					Vertices next_Step = Path1[1];
					monsterA.setPosX(next_Step.getPos_x());
					monsterA.setPosY(next_Step.getPos_y());
					}
					else {
						monsterA.attack(playerA);
					}
					break;
				case -1:
					int pos_X_Monster = monsterA.getPosX();
					int pos_Y_Monster = monsterA.getPosY();
					boolean next_step_found = false;
					while (!next_step_found) {
						double random = Math.random();
						if (random < 0.25) {
							if (mapA2[pos_X_Monster + 1][pos_Y_Monster]) {
								if(!((pos_X_Monster + 1) == playerA.getPosX() && (pos_Y_Monster == playerA.getPosY()))){
									next_step_found = true;
									monsterA.setPosX(pos_X_Monster + 1);
								}
							}
						}
						if ((0.25 <= random) && (random < 0.5)) {
							if (mapA2[pos_X_Monster - 1][pos_Y_Monster]) {
								if(!((pos_X_Monster -1) == playerA.getPosX() && (pos_Y_Monster == playerA.getPosY()))){
									next_step_found = true;
									monsterA.setPosX(pos_X_Monster -1);
								}							}
						}
						if ((0.5 <= random) && (random < 0.75)) {
							if (mapA2[pos_X_Monster][pos_Y_Monster + 1]) {
								if(!(pos_X_Monster == playerA.getPosX() && ((pos_Y_Monster + 1) == playerA.getPosY()))){
									next_step_found = true;
									monsterA.setPosX(pos_Y_Monster + 1);
								}
							}
						}
						if (0.75 <= random) {
							if (mapA2[pos_X_Monster][pos_Y_Monster - 1]) {
								if(!(pos_X_Monster == playerA.getPosX() && ((pos_Y_Monster - 1) == playerA.getPosY()))){
									next_step_found = true;
									monsterA.setPosX(pos_Y_Monster - 1);
								}
							}
						}
					
					
			}
			
			
		}	map_aktualisieren(mapA1, monsterA.getPosX(), monsterA.getPosY());
			ausgabe(mapA1);
			System.out.println("State des Monster " + monsterA.getState());
			System.out.println("Life: " + monsterA.getCurrentLife() + "   "+ playerA.getCurrentLife());
	}
		// Finite State Machine
		char[][] mapB1 = {{'#','#','#','#','#','#','#'},
				 		  {'#','.','.','.','.','.','#'},
				 		  {'#','.','.','.','.','.','#'},
				 		  {'#','.','.','.','.','.','#'},
				 		  {'#','.','.','.','.','.','#'},
				 		  {'#','.','.','.','.','.','#'},
				 		  {'#','.','.','.','.','.','#'},
				 		  {'#','#','#','#','#','#','#'}};
				
		boolean[][] mapB2 = new boolean[mapB1.length][mapB1[0].length];
		for (int i = 0; i < mapB2.length; i++) {
			for (int j = 0; j < mapB2[0].length; j++) {
				if (mapB1[i][j] == '.') {
					mapB2[i][j] = true;
				} else {
					mapB2[i][j] = false;
				}
			}
		}
		Monster_Berserker monster = new Monster_Berserker(1, 1, 1, "Monster", 1, 1, "");
		Monster_Berserker player = new Monster_Berserker(3, 1, 1, "Player", 6, 5, "");
		mapB1[monster.getPosX()][monster.getPosY()] = 'M';
		mapB1[player.getPosX()][player.getPosY()] = 'P';
		ausgabe(mapB1);
		System.out.println("State des Monster " + monster.getState());

		for (int i = 0; i < 20; i++) {
			Vertices[] Path = monster.path_to_Player(mapB2, player);
			if (Path.length != 2) {
				if ((Path.length) <= (monster.getMovementSpeed() + 2)) {
					monster.setState(1);
					Vertices next_Step = Path[1];
					monster.setPosX(next_Step.getPos_x());
					monster.setPosY(next_Step.getPos_y());
				} else {
					monster.setState(0);
					int pos_X_Monster = monster.getPosX();
					int pos_Y_Monster = monster.getPosY();
					boolean next_step_found = false;
					while (!next_step_found) {
						double random = Math.random();
						if (random < 0.25) {
							if (mapB2[pos_X_Monster + 1][pos_Y_Monster]) {
								next_step_found = true;
								monster.setPosX(pos_X_Monster + 1);
							}
						}
						if ((0.25 <= random) && (random < 0.5)) {
							if (mapB2[pos_X_Monster - 1][pos_Y_Monster]) {
								next_step_found = true;
								monster.setPosX(pos_X_Monster - 1);
							}
						}
						if ((0.5 <= random) && (random < 0.75)) {
							if (mapB2[pos_X_Monster][pos_Y_Monster + 1]) {
								next_step_found = true;
								monster.setPosY(pos_Y_Monster + 1);
							}
						}
						if (0.75 <= random) {
							if (mapB2[pos_X_Monster][pos_Y_Monster - 1]) {
								next_step_found = true;
								monster.setPosY(pos_Y_Monster - 1);
							}
						}
					}
				}
				map_aktualisieren(mapB1, monster.getPosX(), monster.getPosY());
				ausgabe(mapB1);
				System.out.println("State des Monster " + monster.getState());
			}
		}
		// A Stern Algorithmus 
		char[][] Map1 = {{'#','#','#','#','#','#','#','#','#'},
						 {'#','.','.','.','.','.','.','.','#'},
						 {'#','#','#','#','#','#','#','.','#'},
						 {'#','.','#','.','#','.','#','.','#'},
						 {'#','.','#','.','#','.','#','.','#'},
						 {'#','.','#','.','#','.','#','E','#'},
						 {'#','.','.','.','.','.','#','.','#'},
						 {'#','.','#','.','#','.','#','.','#'},
						 {'#','S','#','.','#','.','#','.','#'},
						 {'#','#','#','#','#','#','#','#','#'}};
						
		int SX = 0;
		int SY = 0;
		int EX = 0;
		int EY = 0;
		for (int i=0; i < Map1.length;i++){
			for(int j=0;j < Map1[0].length;j++){
				if (Map1[i][j]=='S'){
					SX = i;
					SY = j;
					Map1[i][j]='.';
				}
				if (Map1[i][j]=='E'){
					EX = i;
					EY = j;
					Map1[i][j]='.';
				}
				
			}
		}
		boolean [][] Map2 = new boolean[Map1.length][Map1[0].length];
		for (int i=0; i < Map2.length;i++){
			for(int j=0;j < Map2[0].length;j++){
				if(Map1[i][j]=='.'){
					Map2[i][j] = true;
				}
				else {
					Map2[i][j] = false;
				}
			}
		}
		
		long time = System.currentTimeMillis();
		A_Star_Algorithm A_Star = new A_Star_Algorithm(Map2);
		System.out.println(System.currentTimeMillis() - time);
		Vertices[] Path = A_Star.A_Star(SX, SY, EX, EY);
		int s = Path.length;
		Vertices c = Path[0];
		int x = c.getPos_x();
		int y = c.getPos_y();
		Map1[x][y] = 'S';	
		for (int i = 1; i < s-1; i++) {
			c = Path[i];
			x = c.getPos_x();
			y = c.getPos_y();
			Map1[x][y] = '1';		
		}
		c = Path[s-1];
		x = c.getPos_x();
		y = c.getPos_y();
		Map1[x][y] = 'E';	
		
		for (int i=0; i < Map1.length;i++){
			for(int j=0;j < Map1[0].length;j++){
				System.out.print(Map1[i][j] +" ");
			}
			System.out.println();
		}
		
	}	
}
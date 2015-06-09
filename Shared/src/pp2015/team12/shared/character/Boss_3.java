package pp2015.team12. shared.character;

@SuppressWarnings("serial")
public class Boss_3 extends Monster {

	public Boss_3() {
		super(1,1000, 1000, 1000, 5, "Boss_3", 2, 10,"Boss_3.jpg",66,1,15000);
	}
	 
	public void telport() {
		boolean next_step_found = false;
		while (!next_step_found) {
			double random = Math.random();
			if (random < 0.25) {
				if (!((this.getPosX() == 2) && (this.getPosY() == 10))) {
					next_step_found = true;
					this.setPosX(2);
					this.setPosY(10);
				}
			}
			if ((0.25 <= random) && (random < 0.5)) {
				if (!((this.getPosX() == 7) && (this.getPosY() == 2))) {
					next_step_found = true;
					this.setPosX(7);
					this.setPosY(2);
				}
			}
			if ((0.5 <= random) && (random < 0.75)) {
				if (!((this.getPosX() == 7) && (this.getPosY() == 17))) {
					next_step_found = true;
					this.setPosX(7);
					this.setPosY(17);
				}
			}
			if (0.75 <= random) {
				if (!((this.getPosX() == 13) && (this.getPosY() == 10))) {
					next_step_found = true;
					this.setPosX(13);
					this.setPosY(10);
				}
			}
		}
	}
}
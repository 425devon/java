
public class Ninja extends Human {
	protected int stealth = 10;
	
	public void steal(Human h) {
		h.health -= this.stealth;
		this.health += this.stealth;
	}
	public void runAway() {
		this.health -= 10;
	}
}


public class Wizard extends Human {
	protected int health = 50;
	protected int intelligence = 8;
	
	public void heal(Human h) {
		h.health += this.intelligence;
	}
	
	public void fireball(Human h) {
		h.health -= this.intelligence*3;
	}

}

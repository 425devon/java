
public class Human {
	private int strength = 3;
	private int stealth = 3;
	private int intelligence = 3;
	public int health = 100;
	
	public void setStrength(int number) {
        this.strength = number;
    }
	public void setStealth(int number) {
        this.stealth = number;
    }
	public void setIntelligence(int number) {
        this.intelligence = number;
    }

	public void attack(Human h) {
		h.health -= this.strength;
		System.out.println("attacking!" +" "+ h);
	}
}

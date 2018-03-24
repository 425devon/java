
public class Samurai extends Human{
	protected int health = 200;
	static int count = 0;
	
	Samurai(){
		count++;
	}
	
	public void deathBlow(Human h) {
		h.health = 0;
		this.health = this.health/2;
	}
	public void meditate() {
		this.health += this.health/2;
	}
	public int howMany() {
		System.out.println(String.format("There are %d samaruai!", count));
		return count;
	}

}

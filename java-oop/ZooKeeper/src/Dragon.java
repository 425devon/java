
public class Dragon extends Mammal {
	int energyLevel = 300;
	
	public void fly() {
		this.energyLevel -= 50;
		System.out.println("Wooooosh"+" "+this.energyLevel);
	}
	
	public void eatHumans() {
		this.energyLevel += 25;
		System.out.println("That person tasted like mutton and socks!"+" "+this.energyLevel);
	}
	
	public void attackTown() {
		this.energyLevel -= 100;
		System.out.println("The roof, the roof, the roof is on fire!"+" "+this.energyLevel);
	}
	
}

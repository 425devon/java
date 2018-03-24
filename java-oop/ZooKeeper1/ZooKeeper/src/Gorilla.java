
public class Gorilla extends Mammal {
	
	public void throwSomething() {
		this.energyLevel -= 5;
		System.out.println("Gorilla throws banana"+" "+this.energyLevel);
	}
	public void eatBananas() {
		this.energyLevel += 10;
		System.out.println("awwwYeah banana time!"+" "+this.energyLevel);
	}
	public void climb() {
		this.energyLevel -= 10;
		System.out.println("Enough monkey business time to climb"+" "+this.energyLevel);
	}

}

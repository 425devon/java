
public class HumanTest {

	public static void main(String[] args) {
		/*
		Wizard bob = new Wizard();
		Human ted = new Human();
		
		bob.fireball(ted);
		System.out.println(ted.health);
		bob.heal(ted);
		System.out.println(ted.health);
	    ------
		Ninja bob = new Ninja();
		Human ted = new Human();
		
		bob.steal(ted);
		System.out.println(ted.health);
		bob.runAway();
		System.out.println(bob.health);
		*/
		Samurai bob = new Samurai();
		Human ted = new Human();
		Samurai jim = new Samurai();
		
		
		System.out.println(bob.health);
		bob.deathBlow(ted);
		System.out.println(ted.health);
		System.out.println(bob.health);
		bob.meditate();
		System.out.println(bob.health);
		jim.howMany();

	}

}

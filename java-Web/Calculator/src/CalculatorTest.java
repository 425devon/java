
public class CalculatorTest {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.setOperandOne(10);
		c.setOperation('-');
		c.setOperandTwo(33);
		c.perfromOperation();
		
		System.out.println(c.getResults());

	}

}

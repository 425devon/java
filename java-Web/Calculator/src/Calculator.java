
public class Calculator {
	private double operandOne;
	private char operation;
	private double operandTwo;
	private double results;
	
	public double getOperandOne() {
		return this.operandOne;
	}
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operation) {
		this.operation = operation;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public double getResults() {
		return results;
	}
	public void setResults(double results) {
		this.results = results;
	}
	public void perfromOperation() {
		if(this.operation == '+') {
			setResults(this.operandOne + this.operandTwo);
		}
		if(this.operation == '-') {
			setResults(this.operandOne - this.operandTwo);
		}
	}
	
	public Calculator() {
	}
}

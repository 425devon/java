package com.devon.web;

public class Calc {
	private Integer result;
	
	
	public void addition(String op) {
		String array1[] = op.split("\\+");
		Integer res = Integer.parseInt(array1[0])+Integer.parseInt(array1[1]);
		this.setResult(res);
	}
	public void subtraction(String op) {
		String array1[] = op.split("-");
		Integer res = Integer.parseInt(array1[0])-Integer.parseInt(array1[1]);
		this.setResult(res);
	}
	public void multiplication(String op) {
		String array1[] = op.split("x");
		Integer res = Integer.parseInt(array1[0])*Integer.parseInt(array1[1]);
		this.setResult(res);
	}
	public void division(String op) {
		String array1[] = op.split("/");
		Integer res = Integer.parseInt(array1[0])/Integer.parseInt(array1[1]);
		this.setResult(res);
	}
	
	
	
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	
	public Calc() {
		
	};
}

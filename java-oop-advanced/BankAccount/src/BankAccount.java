import java.util.Random;

class BankAccount {
	private int accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	static int numaccounts = 0;
	static double cashstored;
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	private int generator() {
		Random rnd = new Random();
		int newAccount = 1000000000 + rnd.nextInt(900000000);
		return newAccount;
	}
	
	BankAccount(){
		setAccountNumber(generator());
		numaccounts++;
		
	}
	public double checkBalance() {
		return this.checkingBalance;
	}
	public double saveBalance() {
		return this.savingsBalance;
	}
	public void deposit(double amount, String accountType) {
		if(accountType == "checking") {
			this.checkingBalance += amount;
		}
		if(accountType == "savings") {
			this.savingsBalance += amount;
		}
		cashstored += amount;
	}
	public void withdraw(double amount, String accountType) {
		if(accountType == "checking") {
			if(this.checkingBalance > amount) {
				this.checkingBalance -= amount;
				cashstored -= amount;
			}
		}
		if(accountType == "savings") {
			if(this.savingsBalance > amount) {
				this.savingsBalance -= amount;
				cashstored -= amount;
			}
		}
	}
	public String myBalance() {
		return(String.format("Your checking account balance is: $ %.2f ,Your savings account balance is: $ %.2f", this.checkingBalance, this.savingsBalance));
	}

}

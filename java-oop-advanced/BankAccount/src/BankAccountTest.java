
public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount bmoney = new BankAccount();
		
		System.out.println(bmoney.getAccountNumber());
		bmoney.deposit(100.50, "checking");
		bmoney.deposit(500.50, "savings");
		bmoney.withdraw(60, "checking");
		System.out.println(bmoney.myBalance());
		
		System.out.println(BankAccount.cashstored);

	}

}

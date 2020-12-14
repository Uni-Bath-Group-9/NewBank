package server;

public class Account {
	
	private String accountName;
	private double openingBalance;

	public Account(String accountName, double openingBalance) {
		this.accountName = accountName;
		this.openingBalance = openingBalance;
	}
	
	public String toString() {
		return (accountName + ": " + openingBalance);
	}

	public String getAccountName(){
		return accountName;
	}

	public double getBalance(){
		return openingBalance;
	}

	public void updateBalance(double newBal){
		openingBalance = newBal;
	}

}

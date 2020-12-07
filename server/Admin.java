package server;

import java.util.ArrayList;

public class Admin {
	
	private ArrayList<Account> accounts;
	private String customerID;
	private String password;
	
	public Admin(String adminID, String password) {
		accounts = new ArrayList<>();
		this.customerID = adminID.toLowerCase();
		this.password = password;
	}
	
	public String accountsToString() {
		String s = "";
		for(Account a : accounts) {
			s += a.toString()+"\n";
		}
		return s;
	}

	public void addAccount(Account account) {
		accounts.add(account);		
	}

	// Check if the password is correct
	public boolean isPasswordCorrect(String password){
		return this.password.equals(password);
	}

	// Get customerID
	public String getAdminID(){
		return this.adminID;
	}

	// Get accounts
	public ArrayList<Account> getAccounts(){
		return accounts;
	}

	// Get account balance
	public double getBal(String name){
		double balance = 0.0;
		for (Account a:accounts){
			if (a.getAccountName().equals(name)){
				balance = a.getBalance();
			}
		}		
		return balance;						
	}

	public void withdrawAmt(String name, double amt){
		for (Account a: accounts){
			if (a.getAccountName().equals(name)){
				double current = a.getBalance();
				double result = current - amt;
				if (result < 0){
					result = 0;
				}
				a.updateBalance(result);
			}
		}
	}

	public void creditAmt(String name, double amt){
		for (Account a: accounts){
			if (a.getAccountName().equals(name)){
				double current = a.getBalance();
				double result = current + amt;
				a.updateBalance(result);
			}
		}
	}




}

package server;

import java.util.ArrayList;

public class Customer {
	
	private ArrayList<Account> accounts;
	private String customerID;
	private String password;
	
	public Customer(String customerID, String password) {
		accounts = new ArrayList<>();
		this.customerID = customerID.toLowerCase();
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

	public boolean isPasswordCorrect(String password){
		return this.password.equals(password);
	}

	public String getCustomerID(){
		return this.customerID;
	}


}

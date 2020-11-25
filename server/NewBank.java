package server;

import java.util.HashMap;

public class NewBank {
	
	private static final NewBank bank = new NewBank();
	private customerDatabase customers;
	
	private NewBank() {
		customers = new customerDatabase();
		// addTestData();
	}
	
	// private void addTestData() {
	// 	Customer bhagy = new Customer();
	// 	bhagy.addAccount(new Account("Main", 1000.0));
	// 	customers.put("Bhagy", bhagy);
		
	// 	Customer christina = new Customer();
	// 	christina.addAccount(new Account("Savings", 1500.0));
	// 	customers.put("Christina", christina);
		
	// 	Customer john = new Customer();
	// 	john.addAccount(new Account("Checking", 250.0));
	// 	customers.put("John", john);
	// }
	
	public static NewBank getBank() {
		return bank;
	}
	
	public synchronized Customer checkLogInDetails(String customerID, String password) {
		Customer customer = customers.getCustomer(customerID);
		if(customer == null){
			return null;
		}else if (customer.isPasswordCorrect(password)){
			return customer;
		}
		else{
			return null;
		}
	}

	// commands from the NewBank customer are processed in this method
	public synchronized String processRequest(String customerID, String request) {
		Customer customer = customers.getCustomer(customerID);
		if( customer !=null){
			switch(request) {
			case "SHOWMYACCOUNTS" : return showMyAccounts(customer);
			default : return "FAIL";
			}
		}
		return "FAIL";
	}
	
	private String showMyAccounts(Customer customer) {
		return customer.accountsToString();
	}

}

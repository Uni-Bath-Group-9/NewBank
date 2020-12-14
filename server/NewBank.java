package server;

// import java.util.HashMap;

public class NewBank {
	
	private static final NewBank bank = new NewBank();
	private customerDatabase customers;
	private adminDatabase admins;

	private NewBank() {
		customers = new customerDatabase();
		admins = new adminDatabase();
	}
	
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

	public synchronized Admin checkLogInDetailsAdmin(String adminID, String password) {
		Admin admin = admins.getAdmin(adminID);
		if(admin == null){
			return null;
		}else if (admin.isPasswordCorrect(password)){
			return admin;
		}
		else{
			return null;
		}
	}

	// commands from the NewBank customer are processed in this method
	public synchronized String processRequest(String customerID, String request) {
		Customer customer = customers.getCustomer(customerID);
		String[] inputRequest = request.split(" ");
		
		if( customer !=null){
			switch(inputRequest[0]) {
			case "SHOWMYACCOUNTS" : return showMyAccounts(customer);
			case "NEWACCOUNT" : return createNewAccount(customer, inputRequest[1]);
			case "BALANCE" : return balance(customer, inputRequest[1]);
			case "WITHDRAW" : return withdraw(customer,inputRequest[1], inputRequest[2]);
			case "TRANSFER" : return transfer(customer, customers.getCustomer(inputRequest[3]), inputRequest[1], inputRequest[4], inputRequest[2]);
			default : return "FAIL";
			}
		}
		return "FAIL";
	}

	// commands from the NewBank customer are processed in this method
	public synchronized String processRequestAdmin(String adminID, String request) {
		Admin admin = admins.getAdmin(adminID);
		String[] inputRequest = request.split(" ");

		if( admin !=null){
			Customer customer = customers.getCustomer(inputRequest[1]);
			switch(inputRequest[0]) {
				case "SHOWCUSTOMERACCOUNTS" : return showMyAccounts(customer);
				case "TRANSFERCUSTOMER" : return transfer(customer, customers.getCustomer(inputRequest[4]), inputRequest[2], inputRequest[5], inputRequest[3]);
				default : return "FAIL";
			}
		}
		return "FAIL";
	}


	private String transfer(Customer customer, Customer recipient, String c_acc, String r_acc, String amt){
		double amount = Double.parseDouble(amt);
		customer.withdrawAmt(c_acc, amount);
		recipient.creditAmt(r_acc, amount);
		return "SUCCESS";
	}
	
	
	private String withdraw(Customer customer, String acc, String amt){
		double amount = Double.parseDouble(amt);
		customer.withdrawAmt(acc, amount);
		return "SUCCESS";
	}
	
	private String balance(Customer customer, String acc){
		return String.valueOf(customer.getBal(acc));
	}
	
	private String showMyAccounts(Customer customer) {
		return customer.accountsToString();
	}


	// Create a new new account

	private String createNewAccount(Customer customer, String accountName){
		customer.addAccount(new Account(accountName, 0.0));
		customers.updateCustomerAccount(customer);
		return "SUCCESS";
	}

}

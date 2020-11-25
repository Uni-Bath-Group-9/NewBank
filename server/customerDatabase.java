
/*
 * Customers database to hold customers information 
 */

package server;

import java.util.HashMap;


public class customerDatabase {

    private HashMap<String, Customer> customers;

    public customerDatabase(){
        customers = new HashMap<>();
        addTestData();
    }
    //  Test data into the database
    private void addTestData(){
        Customer bhagy = new Customer("bhagy", "bhagy1");
		bhagy.addAccount(new Account("Main", 1000.0));
        // customers.put("Bhagy", bhagy);
        addCustomers(bhagy);
		
		Customer christina = new Customer("Christina", "Christina1");
		christina.addAccount(new Account("Savings", 1500.0));
        // customers.put("Christina", christina);
        addCustomers(christina);
		
		Customer john = new Customer("John", "John1");
		john.addAccount(new Account("Checking", 250.0));
        // customers.put("John", john);
        addCustomers(john);

        Customer kd = new Customer("KD", "kd1");
        kd.addAccount(new Account("Checking", 300.00));
        // customers.put("KD", kd);
        addCustomers(kd);
       

    }
    // Method to add customers to the HashMap
    public void addCustomers(Customer customer){
        String customerID = customer.getCustomerID();
        customers.put(customerID,customer);
    }

    // Get a customers ID from the customers database.
    public Customer getCustomer(String customerID){
        customerID = customerID.toLowerCase();
        return customers.get(customerID);
    }

    // Update customer accounts

    public void updateCustomerAccount(Customer customer){
        String customerID = customer.getCustomerID();
        customers.replace(customerID, customer);
    }
}

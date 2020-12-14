package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NewBankClientHandler extends Thread{
	
	private NewBank bank;
	private BufferedReader in;
	private PrintWriter out;
	
	public NewBankClientHandler(Socket s) throws IOException {
		bank = NewBank.getBank();
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = new PrintWriter(s.getOutputStream(), true);
	}
	
	public void run() {
		// keep getting requests from the client and processing them
		boolean sendRequest = false;
		try {
			while(true){
				// ask for user name
				out.println("Enter Username");
				String userName = in.readLine();
				// ask for password
				out.println("Enter Password");				
				String password = in.readLine();
				out.println("Checking Details...");
				// authenticate user and get customer ID token from bank for use in subsequent requests
				Customer customer = bank.checkLogInDetails(userName, password);
				Admin admin = bank.checkLogInDetailsAdmin(userName, password);
				// if the user is authenticated then get requests from the user and process them 
				if(customer != null) {
					out.println("Log In Successful");
					out.println("Here are your options:");
					out.println("Option 1: BALANCE [accountName] - Show balance");
					out.println("Option 2: NEWACCOUNT [accountName] - Create account");
					out.println("Option 3: SHOWMYACCOUNTS - Show all accounts and balances");
					out.println("Option 4: WITHDRAW [account] [amount] - Withdraw funds");
					out.println("Option 5: TRANSFER [account] [amount] [recipient] [account] - Transfer funds");
					
					while(sendRequest == false) {
						out.println("Please enter your option:");
						String request = in.readLine();
						sendRequest = checkRequestError (request);
						if (sendRequest ==true) {
							out.println("Request from " + customer.getCustomerID());
							String responce = bank.processRequest(customer.getCustomerID(), request);
							out.println(responce);
						}
						sendRequest = false;
					}
				}
				else if(admin != null) {
						out.println("Admin Log In Successful");
						out.println("Here are your options:");
						out.println("Option 1: SHOWCUSTOMERACCOUNTS [accountName] - Show balance");
						out.println("Option 2: TRANSFER [payer] [account] [amount] [recipient] [account] - Transfer funds");

						while(sendRequest == false) {
							out.println("Please enter your option:");
							String request = in.readLine();
							sendRequest = checkRequestError (request);
							if (sendRequest ==true) {
								out.println("Request from " + customer.getCustomerID());
								String responce = bank.processRequest(customer.getCustomerID(), request);
								out.println(responce);
							}
							sendRequest = false;
						}
				}

				else {
					out.println("Log In Failed");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}
	private boolean checkRequestError(String request) {
		String[] inputRequest = request.split(" ");

			switch(inputRequest[0]) {
				case "SHOWMYACCOUNTS" : return true;
				case "NEWACCOUNT" :
					if (inputRequest.length<2){
						out.println("Please enter account type");
						out.println("Try again.");
						return false;
					}
					else {return true ;}
				case "BALANCE" :
					if (inputRequest.length<2){
						out.println("Please enter account type after BALANCE");
						out.println("Try again.");
						return false;
					}
					else {return true ;}
				case "WITHDRAW" :
					if (inputRequest.length<3){
						out.println("Please enter account and amount");
						out.println("Try again.");
						return false;
					}
					else {return true ;}
				case "TRANSFER" :
					if (inputRequest.length<5){
						out.println("Please enter account, amount, recipient and account");
						out.println("Try again.");
						return false;
					}
					else {return true ;}
					default : return false;

		}
	}
}

# NewBank

## Getting Started

## Setup/Requirements

## Prerequisites

* Java 

## Cloning

* In your terminal:
        
        $ git clone https://github.com/Uni-Bath-Group-9/NewBank.git
        $ cd NewBank
        $ While in the NewBank folder, if you are using VS Code type code . and the editor should start. \nOtherwise you are free to use your favourite IDE to open the project. 


## Running Newbank

* Run the server by running the file .//server/NewBankServer.java
* Run the client by running the file .//client/ExampleClient.java

## Customer Commands

Login using your username and password. Assumption is that there is a user account already created.
To do.... Add instruction for creating a new account as an admin.

## Customer Commands

Guide to the protocol for interacting with the NewBank application. After logging in, a customer enters one of the commands below depending on what activity they would like to perform:

## Customer Commands

| Command | Description | Example
| --- | --- | --- |
| `BALANCE [accountName]` | Returns balance of an account. Returns `SUCCESS` or `FAIL`.| Example:`BALANCE Savings`|
| `NEWACCOUNT [accountName]` | Creates a new account. Returns `SUCCESS` or `FAIL` | Example: `NEWACCOUNT Checking`|
| `SHOWMYACCOUNTS` | Returns a list of all the customer's accounts with their balances.|Example: `SHOWMYACCOUNTS`|
| `WITHDRAW [account] [amount]` | Withdraws money from the current logged in users account.Returns `SUCCESS` or `FAIL` | Example: `WITHDRAW Savings 100`| 
| `TRANSFER [account] [amount] [recipient] [account]` | Transfers money from a logged in user account to another existing account. Returns `SUCCESS` or `FAIL`| Example: `TRANSFER Savings 200 John Checking`|


## Customer Commands


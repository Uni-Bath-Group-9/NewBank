# NewBank

Guide to the protocol for interacting with the NewBank application. A customer enters one of the commands below dependnging on what activity they woil like to perform:

## Customer Commands

| Command | Description | Example
| --- | --- | --- |
| `BALANCE [accountName]` | Description: Returns balance of an account. Returns `SUCCESS` or `FAIL`.| Example:`Balance Savings`.|
| `NEWACCOUNT [accountName] ` | Description: Creates a new account. Returns `SUCCESS` or `FAIL` | Example: `NEWACCOUNT Savings`.|
| `SHOWMYACCOUNTS` | Description: Returns a list of all the customers accounts with the balances. Returns list of accounts for the currently logged in user.|Example: `NEWACCOUNT Savings`.|
| `WITHDRAW [account] [amount]` | Description: Withdraws monet from the current logged in users account.Returns `SUCCESS` or `FAIL` | Example: `MOVE 100 Main Savings`.| 
| `TRANSFER [account] [amount] [recipient] [account]` | Description: Transfers money from a logged in user account to another existing account. Returns `SUCCESS` or `FAIL`| Example: `TRANSFER Savings 200 John Checking`.|


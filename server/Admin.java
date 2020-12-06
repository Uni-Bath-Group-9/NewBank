package server;

import java.util.ArrayList;

public class Admin {

    private ArrayList<Account> accounts;
    private String adminID;
    private String password;

    public Admin(String adminID, String password) {
        accounts = new ArrayList<>();
        this.adminID = adminID.toLowerCase();
        this.password = password;
    }

    // Check if the password is correct
    public boolean isPasswordCorrect(String password){
        return this.password.equals(password);
    }

    // Get adminID
    public String getAdminID(){
        return this.adminID;
    }


}

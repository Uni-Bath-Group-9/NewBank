
/*
 * Admin database to hold admin information
 */

package server;

import java.util.HashMap;


public class adminDatabase {

    private HashMap<String, Admin> admins;

    public adminDatabase() {
        admins = new HashMap<>();
        addTestData();
    }

    //  Test data into the database
    private void addTestData() {
        Admin ben = new Admin("ben", "ben1");
        // customers.put("Ben", ben);
        addAdmin(ben);


    }

    // Method to add admin to the HashMap
    public void addAdmin(Admin admin) {
        String adminID = admin.getAdminID();
        admins.put(adminID, admin);
    }

    // Get a admin ID from the customers database.
    public Admin getAdmin(String adminID) {
        adminID = adminID.toLowerCase();
        return admins.get(adminID);
    }

}
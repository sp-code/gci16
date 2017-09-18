package gci.app.model;

import gci.app.controller.Controller;
import java.sql.SQLException;

public final class OperatorModel implements Model{
    private final Controller controller;
    private String username = "";
    private String password = "";

    public String getUsernameToSearch() {
        return username;
    }

    public void setUsernameToSearch(String username) {
        this.username = username;
    }

    public String getPasswordToUpdate() {
        return password;
    }

    public void setPasswordToUpdate(String password) {
        this.password = password;
    }
  
    public OperatorModel(Controller controller) throws SQLException{
        this.controller = controller;
    }
        
    public void setUsernameToDelete(String username) {
        this.username = username;
        controller.setUsernameToDelete(username);
    }
    
    public String getUsernameToDelete() {
        return this.username;
    }
}


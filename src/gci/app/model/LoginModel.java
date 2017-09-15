package gci.app.model;

import gci.app.controller.Controller;
import java.sql.SQLException;

public final class LoginModel implements Model{
    private final Controller controller;
    private String id = "";
    private String username = "";
    private String password = "";
    private String userType = "";

    public LoginModel(Controller controller) throws SQLException{
        this.controller = controller;
    }
        
    public void setID(String id) {
        this.id = id;
        controller.setID(id);
    }
    
    public void setUsername(String username) {
        this.username = username;
        controller.setUsername(username);
    }
    
    public void setPassword(String password) {
        this.password = password;
        controller.setPassword(password);
    }
    
    public void setUserType(String type) {
        this.userType = type;
        controller.setUserType(type);
    }
    
    public String getID() {
        return this.id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getUserType(){
        return this.userType;
    }
}

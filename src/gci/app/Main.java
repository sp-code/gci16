package gci.app;

import gci.app.controller.Controller;
import java.sql.SQLException;

public class Main {
    public static void main(String [] args){
        Controller controller = new Controller();
        try{
            controller.controller();
        }
        catch (SQLException ex){}
    }
}

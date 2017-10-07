package gci.app.model;

import gci.app.controller.Controller;

public class ErrorModel implements Model{
    private final Controller controller;
    private String errorMessage = "";
    
    public ErrorModel(Controller controller){
        this.controller = controller;
    }
    
    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
        controller.setErrorMessage(errorMessage);
    }

    public String getErrorMessage() {
        return (errorMessage.compareTo("") != 0) ? errorMessage : "ERROR : String not initialized.";
    }
   
}

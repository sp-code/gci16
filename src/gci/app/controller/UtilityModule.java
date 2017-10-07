package gci.app.controller;

public class UtilityModule {
    protected static String convertToMultiline(String orig){
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
    
    protected static Double convertStringInDouble(String myString){
        return Double.valueOf(myString);
    }
}

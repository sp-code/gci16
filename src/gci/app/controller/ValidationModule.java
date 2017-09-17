package gci.app.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationModule {
    
    protected static boolean isValidString(String s){
        return s != null && !s.isEmpty();
    }
    
    protected static boolean isStringADouble(String myString){
        if(!isValidString(myString)) return false;
        final String Digits     = "(\\p{Digit}+)";
        final String HexDigits  = "(\\p{XDigit}+)";
        final String Exp        = "[eE][+-]?"+Digits;
        final String fpRegex    = ("[\\x00-\\x20]*"+
                                    "[+-]?(" +         
                                    "NaN|" +           
                                    "Infinity|" +   
        "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+
        "(\\.("+Digits+")("+Exp+")?)|"+
        "((" +
        "(0[xX]" + HexDigits + "(\\.)?)|" +
        "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +
        ")[pP][+-]?" + Digits + "))" +
        "[fFdD]?))" +
        "[\\x00-\\x20]*");
        return Pattern.matches(fpRegex, myString);
    }
    
    protected static boolean validateUsername(String username){
        if(username == null || username.length() < 4 || username.length() > 15) return false;
        String control = "^[a-zA-Z][a-zA-Z0-9]*$";
        Pattern p = Pattern.compile(control);
        Matcher m = p.matcher(username);
        return m.matches();
    }
    
    protected static boolean validatePassword(String password){
        if(password == null || password.length() < 6 || password.length() > 15) return false;
        String control = "^[a-zA-Z][a-zA-Z0-9]*$"; 
        Pattern p = Pattern.compile(control);
        Matcher m = p.matcher(password);
        return m.matches();
    }
}

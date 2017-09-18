package gci.app.controller;

import gci.app.model.CostModel;
import gci.app.model.CustomerModel;
import gci.app.model.LoginModel;
import gci.app.views.ProduceBillsView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QueryModule {
    private static Connection connection;
    private static LoginModel loginModel;
    private static CostModel costModel;
    private static ProduceBillsView produceBillsView;
    private static CustomerModel customerModel;

    
    protected static void setConnection(Connection conn){
        connection = conn;
    } 
    
    protected static void setLoginModel(LoginModel lm){
        loginModel = lm;
    }
    
    protected static void setCostModel(CostModel cm){
        costModel = cm;
    }
    
    protected static void setProduceBillsView(ProduceBillsView pbv){
        produceBillsView = pbv;
    }
    
    protected static void setCustomerModel(CustomerModel customerModel) {
        QueryModule.customerModel = customerModel;
    }
    
    protected static boolean queryOpAdminLogin(String username, String password){
        ResultSet rs;
        Statement s;
        String query =  "SELECT * from "+DatabaseModule.DB+
                        ".LOGIN WHERE USERNAME=\""+
                        username+"\" AND PASSWD=\""+password+"\";";
        try{
            s = connection.createStatement();
            rs = s.executeQuery(query);
            if(rs.next()){
               loginModel.setID(rs.getString(1));
               loginModel.setUsername(rs.getString(2));
               loginModel.setPassword(rs.getString(3));
               loginModel.setUserType(rs.getString(4));
               return true;
            }
        }
        catch (SQLException e) {
            DatabaseModule.showSQLError(e);
        }
        return false;
    }
    
    protected static boolean queryCreationOperator(String username, String password){
        ResultSet rs;
        Statement s;
        final String userType = "O";
        String query = "INSERT INTO "+DatabaseModule.DB+
                       ".LOGIN(USERNAME, PASSWD, USERTYPE) VALUES"+"('"+username+"','"+password+"','"+userType+"');";
        try{
            s = connection.createStatement();
            s.execute(query);
        }
        catch(SQLException e){
            DatabaseModule.showSQLError(e);
        }
        return false;
        
    }
    
    protected static boolean queryDeleteOperator(String username) {
        final int result;
        Statement s;
        final String userType = "O";
        String query =  "DELETE FROM "+DatabaseModule.DB+
                        ".LOGIN WHERE USERNAME='"+
                        username+"' AND USERTYPE='"+userType+"';";
        try{
            s = connection.createStatement();
            result = s.executeUpdate(query);
            if(result != 0)
                return true;
        }
        catch (SQLException e) {
            DatabaseModule.showSQLError(e);
        }
        return false;
    }
    
    protected static boolean queryUpdateCostInfo(double shippingFees, double waterRate, double vat) {
        final int result;
        Statement s;
        final String userType = "O";
        
        String query =  "UPDATE "+DatabaseModule.DB+
                        ".FEES SET SHIPPINGFEES = "+String.valueOf(shippingFees)+
                        ", WATERRATE = "+String.valueOf(waterRate)+
                        ", VAT = "+String.valueOf(vat)+
                        " WHERE IDFEES = 1;";
        try{
            s = connection.createStatement();
            result = s.executeUpdate(query);
            if(result != 0)
                return true;
        }
        catch (SQLException e) {
            DatabaseModule.showSQLError(e);
        }
        return false;
    }
    
    protected static void queryRetrieveCostInfo() {
        ResultSet rs;
        Statement s;
        String query =  "SELECT * from "+DatabaseModule.DB+
                        ".FEES WHERE IDFEES = 1;";
        try{
            s = connection.createStatement();
            rs = s.executeQuery(query);
            if(rs.next()){
               costModel.setShippingFees(UtilityModule.convertStringInDouble(rs.getString(2)));
               costModel.setWaterRate(UtilityModule.convertStringInDouble(rs.getString(3)));
               costModel.setVAT(UtilityModule.convertStringInDouble(rs.getString(4)));
            }
        }
        catch (SQLException e) {
            DatabaseModule.showSQLError(e);
        }
    }
    
    protected static void queryRetrieveBillsInfo(){
        ResultSet rs;
        Statement s;
        JTable table = produceBillsView.getBillsTable();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        Object[] row = new Object[2];
        
        String query =  "SELECT * from "+DatabaseModule.DB+
                        ".BILLS ORDER BY EXPIRATION ASC LIMIT 5;";
        try{
            s = connection.createStatement();
            rs = s.executeQuery(query);
            while(rs.next()){
                row[0] = rs.getString("TAXCODE");
                row[1] = rs.getDate("EXPIRATION");
                dtm.addRow(row);
            }
        }
        catch (SQLException e) {
            DatabaseModule.showSQLError(e);
        }
    }
    
    protected static void queryRetrieveCustomerInfo(String customerTaxCode) {
        ResultSet rs;
        Statement s;
        final String queryArguments = "C.NAME, C.SURNAME, C.TAXCODE, "
                                        + "C.DATEOFBIRTH, C.HOMEADDRESS,"
                                        + " C.HOMENUMBER, C.EMAIL";
        final String query =  "SELECT "+queryArguments+" FROM "+DatabaseModule.DB+
                        ".CUSTOMERS AS C WHERE C.TAXCODE = '"+customerTaxCode+"';";
        try{
            s = connection.createStatement();
            rs = s.executeQuery(query);
            if(rs.next()){
                customerModel.setName(rs.getString("NAME"));
                customerModel.setSurname(rs.getString("SURNAME"));
                customerModel.setTaxCode(rs.getString("TAXCODE"));
                customerModel.setDateOfBirth(rs.getDate("DATEOFBIRTH"));
                customerModel.setHomeAddress(rs.getString("HOMEADDRESS"));
                customerModel.setPhone(rs.getString("HOMENUMBER"));
                customerModel.setEmail(rs.getString("EMAIL"));
            }
        }
        catch (SQLException e) {
            DatabaseModule.showSQLError(e);
        }
    }
    
    protected static boolean queryDeleteGeneratedBill(String taxCode) {
        final int result;
        Statement s;
        String query =  "DELETE FROM "+DatabaseModule.DB+
                        ".BILLS WHERE TAXCODE='"+
                        taxCode+"';";
        System.out.println(query);
        try{
            s = connection.createStatement();
            result = s.executeUpdate(query);
            if(result != 0)
                return true;
        }
        catch (SQLException e) {
            DatabaseModule.showSQLError(e);
        }
        return false;
    }

    protected static boolean queryUsernameExists(String username) {
        ResultSet rs;
        Statement s;
        String query =  "SELECT * from "+DatabaseModule.DB+
                        ".LOGIN WHERE USERNAME = '"+username+"';";
        try{
            s = connection.createStatement();
            rs = s.executeQuery(query);
            if(rs.next())
                return true;
        }
        catch (SQLException e) {
            DatabaseModule.showSQLError(e);
        }
        return false;
    }

    protected static boolean queryUpdatePassword(String usernameToSearch, String newPassword) {
        final int result;
        Statement s;
        
        String query =  "UPDATE "+DatabaseModule.DB+
                        ".LOGIN SET PASSWD = '"+newPassword+
                        "' WHERE USERNAME = '"+usernameToSearch+"';";
        try{
            s = connection.createStatement();
            result = s.executeUpdate(query);
            if(result != 0)
                return true;
        }
        catch (SQLException e) {
            DatabaseModule.showSQLError(e);
        }
        return false;
    }
}

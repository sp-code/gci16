package gci.app.controller;

import gci.app.model.CustomerModel;
import gci.app.model.CostModel;
import gci.app.model.ErrorModel;
import gci.app.model.LoginModel;
import gci.app.model.OperatorModel;
import gci.app.views.AdministratorDesktopView;
import gci.app.views.BillCreatedView;
import gci.app.views.ChangePasswordOperatorView;
import gci.app.views.ChoosePasswordView;
import gci.app.views.ConfirmDeleteView;
import gci.app.views.CostChangedView;
import gci.app.views.CreateOperatorView;
import gci.app.views.DataSummaryView;
import gci.app.views.DeleteOperatorView;
import gci.app.views.ErrorView;
import gci.app.views.LoginView;
import gci.app.views.LoginOKView;
import static gci.app.views.LoginView.PREMUTO_LOGIN;
import static gci.app.views.LoginView.premuto;
import gci.app.views.ManageCostView;
import gci.app.views.MenuView;
import gci.app.views.OperatorDesktopView;
import gci.app.views.OperatorCreatedView;
import gci.app.views.OperatorDeletedView;
import gci.app.views.PasswordChangedView;
import gci.app.views.ProduceBillsView;
import gci.app.views.View;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JTable;

public class Controller{
    
    private final static String USERNAME_NOT_VALID = "Username is not correct.\n"
                     + "It should be >= 4 and <= 15 character length and alphanumeric.\n";
    private final static String PASSWORD_NOT_VALID = "Password is not correct.\n"
                     + "It should be >= 6 and <= 15 character length and alphanumeric.";
    private final static String FEES_NOT_NUMBER = "The shipping fees is not a number.";
    private final static String WATER_NOT_NUMBER = "The water rate is not a number.";
    private final static String VAT_NOT_NUMBER = "The VAT is not a number.";
    private final static String USER_NOT_EXISTS_DB = "Not exists such username in the db.";
    
    private Connection connection = null;
    
    private LoginModel loginModel = null;
    private OperatorModel operatorModel = null;
    private ErrorModel errorModel = null;
    private CostModel costModel = null;
    private CustomerModel customerModel = null;
    
    private LoginView loginView = null;
    private LoginOKView loginOKView = null;
    private ErrorView errorView = null;
    private CreateOperatorView createOpView = null;
    private AdministratorDesktopView adminView = null;
    private OperatorDesktopView operatorView = null;
    private OperatorCreatedView operatorCreatedView = null;
    private DeleteOperatorView deleteOpView = null;
    private ConfirmDeleteView confirmDeleteView = null;
    private OperatorDeletedView operatorDeletedView = null;
    private ManageCostView manageCostView = null;
    private CostChangedView costChangedView = null;
    private ProduceBillsView produceBillsView = null;
    private DataSummaryView dataSummaryView = null;
    private BillCreatedView billsCreatedView = null;
    
    private Date expirationDate = null;
    private ChangePasswordOperatorView changePasswordOperatorView;
    private ChoosePasswordView choosePasswordView;
    private PasswordChangedView passwordChangedView;
    
    public void controller() throws SQLException{
        connection = DatabaseModule.getDefaultConnection();
        QueryModule.setConnection(connection);
        
        loginModel = new LoginModel(this);
        QueryModule.setLoginModel(loginModel);
        loginView = new LoginView(new JDialog(), true, this);
        loginView.setVisible(true);
        
        if(loginView.getPremuto() == LoginView.PREMUTO_ANNULLA)
                 loginView.dispose();
    }
    
    public void doAction(View v) throws SQLException{
        if(v instanceof LoginView){
            final String username = loginView.getUserField().getText();
            final String password = new String(loginView.getPasswordField().getPassword());
            
            loginOKView = new LoginOKView(this);
         
            if(login(username, password))
                loginOKView.setVisible(true);
        
        }
        else if(v instanceof LoginOKView)
            showMenuByUserType();
        else if(v instanceof ErrorView){
            final ErrorView err = (ErrorView) v;
            final View parentView = err.getParentView();
            if(parentView instanceof LoginView)
                loginView.setVisible(true);
            else if(parentView instanceof CreateOperatorView)
                createOpView.setVisible(true);
            else if(parentView instanceof DeleteOperatorView || parentView instanceof ConfirmDeleteView)
                deleteOpView.setVisible(true);
            else if(parentView instanceof ManageCostView)
                manageCostView.setVisible(true);
            else if(parentView instanceof ChangePasswordOperatorView)
                changePasswordOperatorView.setVisible(true);
            else if(parentView instanceof ChoosePasswordView)
                choosePasswordView.setVisible(true);
        }
        else if(v instanceof BillCreatedView){
            if (Desktop.isDesktopSupported()) {
                try{
                    if(ValidationModule.isValidString(PDFModule.getFilename())){
                        File myFile = new File(PDFModule.getFilename());
                        Desktop.getDesktop().open(myFile);
                    }
                }catch(IOException ex){}
            }
        }
    }
    
    public void doAction(View v, String eventName) throws SQLException {
        if(v instanceof MenuView && eventName.equals("Logout"))
                controller();
        else if(v instanceof AdministratorDesktopView){
            if(eventName.equals("Create Operator")){    
                createOpView = new CreateOperatorView(this);
                createOpView.setVisible(true);
            }
            else if(eventName.equals("Delete Operator")){
                deleteOpView = new DeleteOperatorView(this);
                operatorModel = new OperatorModel(this);
                deleteOpView.setVisible(true);
            }
            else if(eventName.equals("Manage Cost")){
                manageCostView = new ManageCostView(this);
                costModel = new CostModel(this);
                QueryModule.setCostModel(costModel);
                QueryModule.queryRetrieveCostInfo();
                manageCostView.setVisible(true);
            }
            else if(eventName.equals("Manage Password Operator")){
                changePasswordOperatorView = new ChangePasswordOperatorView(this);
                operatorModel = new OperatorModel(this);
                changePasswordOperatorView.setVisible(true);
            }
        }
        else if(v instanceof OperatorDesktopView){
            if(eventName.equals("Produce Bills")){
                produceBillsView = new ProduceBillsView(this);
                QueryModule.setProduceBillsView(produceBillsView);
                customerModel = new CustomerModel(this);
                QueryModule.setCustomerModel(customerModel);
                QueryModule.queryRetrieveBillsInfo();
                produceBillsView.setVisible(true);
            }
        }
        else if( (v instanceof CreateOperatorView || 
            v instanceof DeleteOperatorView) && eventName.equals("Back")){
                adminView.setVisible(true);
        }
        else if(v instanceof CreateOperatorView){
            if(eventName.equals("Create")){
                final String username = createOpView.getUsernameTextField().getText();   
                final String password = new String(createOpView.getPasswordField().getPassword());
                final boolean validUser = ValidationModule.validateUsername(username);
                final boolean validPass = ValidationModule.validatePassword(password);
                if(validUser && validPass){
                    createOpView.dispose();
                    QueryModule.queryCreationOperator(username,password);
                    operatorCreatedView = new OperatorCreatedView(this);
                    operatorCreatedView.setVisible(true);
                }
                else{
                    errorModel = new ErrorModel(this);
                    errorView = new ErrorView(this, createOpView);
                    if(!validUser)
                        errorModel.setErrorMessage(
                              UtilityModule.convertToMultiline(USERNAME_NOT_VALID)
                        );
                    else if(!validPass)
                        errorModel.setErrorMessage(
                                UtilityModule.convertToMultiline(PASSWORD_NOT_VALID)
                        );
                    errorView.setVisible(true);
                }
            }
        }
        else if(v instanceof ChangePasswordOperatorView){
            if(eventName.equals("Search")){
                final String username = changePasswordOperatorView.getUsernameTextField().getText();
                operatorModel.setUsernameToSearch(username);
                final boolean validUser = ValidationModule.validateUsername(username);
                if(validUser){
                    final boolean existsUser = QueryModule.queryUsernameExists(username);
                    if(existsUser){
                        choosePasswordView = new ChoosePasswordView(this);
                        choosePasswordView.setVisible(true);
                    }
                    else{
                        errorModel = new ErrorModel(this);
                        errorView = new ErrorView(this, changePasswordOperatorView);
                        errorModel.setErrorMessage(
                              UtilityModule.convertToMultiline(USER_NOT_EXISTS_DB)
                        );
                        errorView.setVisible(true);
                    }
                }
                else{
                    errorModel = new ErrorModel(this);
                    errorView = new ErrorView(this, changePasswordOperatorView);
                    errorModel.setErrorMessage(
                              UtilityModule.convertToMultiline(USERNAME_NOT_VALID)
                    );
                    errorView.setVisible(true);
                }
            }
            else if(eventName.equals("Back"))
                adminView.setVisible(true);
        }
        else if(v instanceof DeleteOperatorView){
            if(eventName.equals("Search")){
                final String username = deleteOpView.getUsernameTextField().getText();
                final boolean validUser = ValidationModule.validateUsername(username);
                deleteOpView.setVisible(false);
                if(validUser){
                    confirmDeleteView = new ConfirmDeleteView(this);
                    operatorModel.setUsernameToDelete(username);
                    confirmDeleteView.setVisible(true);
                }
                else{
                    errorModel = new ErrorModel(this);
                    errorView = new ErrorView(this, deleteOpView);
                    errorModel.setErrorMessage(
                              UtilityModule.convertToMultiline(USERNAME_NOT_VALID)
                    );
                    errorView.setVisible(true);
                }
            }
            
        }
        else if(v instanceof ChoosePasswordView){
            if(eventName.equals("Change")){
                final String password = new String(choosePasswordView.getPasswordField().getPassword());
                final boolean validPass = ValidationModule.validatePassword(password);
                if(validPass){
                    final boolean flag = QueryModule.queryUpdatePassword(operatorModel.getUsernameToSearch(), password);
                    if(flag){
                        passwordChangedView = new PasswordChangedView(this);
                        passwordChangedView.setVisible(true);
                    }
                }
                else{
                    errorModel = new ErrorModel(this);
                    errorView = new ErrorView(this, choosePasswordView);
                    errorModel.setErrorMessage(
                              UtilityModule.convertToMultiline(PASSWORD_NOT_VALID)
                    );
                    errorView.setVisible(true);
                }
            }
        }
        else if(v instanceof ConfirmDeleteView){
            if(eventName.equals("Back"))
                deleteOpView.setVisible(true);
            else if(eventName.equals("DELETE")){
                final boolean deleteOK = QueryModule.queryDeleteOperator(operatorModel.getUsernameToDelete());
                if(deleteOK){
                    operatorDeletedView = new OperatorDeletedView(this);
                    operatorDeletedView.setVisible(true);
                }
                else{ 
                    errorModel = new ErrorModel(this);
                    errorView = new ErrorView(this, deleteOpView); 
                    errorModel.setErrorMessage(USER_NOT_EXISTS_DB);
                    errorView.setVisible(true);
                }
            }
        }
        else if(v instanceof ManageCostView){
            if(eventName.equals("Back"))
                adminView.setVisible(true);
            else if(eventName.equals("Default Value")){
                costModel.setShippingFees(CostModel.DEFAULT_SHIPPING_FEES);
                costModel.setWaterRate(CostModel.DEFAULT_WATER_RATE);
                costModel.setVAT(CostModel.DEFAULT_VAT);
                manageCostView.setVisible(true);
            }
            else if(eventName.equals("Change")){
                manageCostView.setVisible(false);
                String shippingFeesToValidate = manageCostView.getShippingFeesField().getText();
                String waterRateToValidate = manageCostView.getWaterRateField().getText();
                String vatToValidate = manageCostView.getVATField().getText();
                
                if(ValidationModule.isStringADouble(shippingFeesToValidate) && 
                   ValidationModule.isStringADouble(waterRateToValidate) && 
                   ValidationModule.isStringADouble(vatToValidate)){
                    costModel.setShippingFees(UtilityModule.convertStringInDouble(shippingFeesToValidate));
                    costModel.setWaterRate(UtilityModule.convertStringInDouble(waterRateToValidate));
                    costModel.setVAT(UtilityModule.convertStringInDouble(vatToValidate));
                    final boolean queryOK = QueryModule.queryUpdateCostInfo(costModel.getShippingFees(), costModel.getWaterRate(), costModel.getVAT());
                    if(queryOK){
                        costChangedView = new CostChangedView(this);
                        costChangedView.setVisible(true);
                    }
                }
                else{
                    errorModel = new ErrorModel(this);
                    errorView = new ErrorView(this, manageCostView); 
                    if(!ValidationModule.isStringADouble(shippingFeesToValidate))
                        errorModel.setErrorMessage(FEES_NOT_NUMBER);
                    else if(!ValidationModule.isStringADouble(waterRateToValidate))
                        errorModel.setErrorMessage(WATER_NOT_NUMBER);
                    else
                        errorModel.setErrorMessage(VAT_NOT_NUMBER);
                    errorView.setVisible(true);
                }
                
            }
        }
        else if(v instanceof ProduceBillsView){
            if(eventName.equals("Back"))
                operatorView.setVisible(true);
            else{ // Event generated by selecting one of the rows.
                final JTable table = produceBillsView.getBillsTable();
                final int row = table.getSelectedRow();
                final String customerTaxCode = table.getModel().getValueAt(row, 0).toString();
                expirationDate = (Date) table.getModel().getValueAt(row, 1);
                dataSummaryView = new DataSummaryView(this);
                QueryModule.queryRetrieveCustomerInfo(customerTaxCode);
                dataSummaryView.setVisible(true);
            }
        }
        else if(v instanceof DataSummaryView){
            if(eventName.equals("Back"))
                produceBillsView.setVisible(true);
            else{ //GENERATE Event.
                manageCostView = new ManageCostView(this);
                costModel = new CostModel(this);
                QueryModule.setCostModel(costModel);
                QueryModule.queryRetrieveCostInfo();
                QueryModule.queryRetrieveIDAndConsumption(customerModel.getTaxCode());
                PDFModule.setCostModel(costModel);
                PDFModule.setCustomerModel(customerModel);
                QueryModule.createGeneratedBill(customerModel.getWaterMeterID());
                billsCreatedView = new BillCreatedView(this);
                PDFModule.createPDF(expirationDate);
                billsCreatedView.getLinkBillClickableLabel().setText(
                        "<html>"+
                            "<u style=\"color: blue\">"+PDFModule.getFilename()+"</u>"+
                        "</html>"
                );
                billsCreatedView.setVisible(true);
            }
        }
        else if(v instanceof OperatorCreatedView 
           || v instanceof OperatorDeletedView 
           || v instanceof PasswordChangedView
           || v instanceof CostChangedView)
            adminView.setVisible(true);
        else if(v instanceof BillCreatedView)
            operatorView.setVisible(true);
    }
    
    private boolean login(String user, String pass){
        boolean userExists = QueryModule.queryOpAdminLogin(user, pass);
        boolean validUser = ValidationModule.validateUsername(user);
        boolean validPass = ValidationModule.validatePassword(pass);
        if(validUser && validPass){
            if(userExists){
                loginView.dispose();
                premuto = PREMUTO_LOGIN;
                return true;
            }
            else{
                errorModel = new ErrorModel(this);
                errorView = new ErrorView(this, loginView);
                errorModel.setErrorMessage(USER_NOT_EXISTS_DB);
                errorView.setVisible(true);
            }
        }
        else{
            errorModel = new ErrorModel(this);
            errorView = new ErrorView(this, loginView);
            if(!validUser)
                errorModel.setErrorMessage(
                              UtilityModule.convertToMultiline(USERNAME_NOT_VALID)
                );
            else if(!validPass)
                errorModel.setErrorMessage(
                                UtilityModule.convertToMultiline(PASSWORD_NOT_VALID)
                );
            errorView.setVisible(true);
        }
        return false;
    }
    
    private void showMenuByUserType(){
        if(loginModel.getUserType().compareTo("A") == 0){
            adminView = new AdministratorDesktopView(this);
            adminView.setVisible(true);
        }
        else{
            operatorView = new OperatorDesktopView(this);
            operatorView.setVisible(true);
        }
    }
    
    // LoginView
    public void setUsername(String username) {
        loginView.getUserField().setText(username);
    }
    
    public void setPassword(String password) {
        loginView.getPasswordField().setText(password);
    }
    
    // LoginOKView
    public void setID(String id) {
        loginOKView.getIDLabel().setText(id);
    }

    public void setUserType(String userType) {
        if(userType.equals("A"))
            loginOKView.getUserTypeLabel().setText("Administrator");
        else
            loginOKView.getUserTypeLabel().setText("Operator");
    }
    
    // ErrorView
    public void setErrorMessage(String errorMessage) {
        errorView.getErrorLabel().setText(errorMessage);
    }
    
    // ConfirmDeleteView
    public void setUsernameToDelete(String username) {
        confirmDeleteView.getUsernameTextField().setText(username);
    }
    
    // ManageCostView
    public void setShippingFees(Double shippingFees) {
        manageCostView.getShippingFeesField().setText(String.valueOf(shippingFees));
    }

    public void setWaterRate(Double waterRate) {
        manageCostView.getWaterRateField().setText(String.valueOf(waterRate));
    }

    public void setVAT(Double vat) {
        manageCostView.getVATField().setText(String.valueOf(vat));
    }

    // DataSummaryView
    public void setName(String name) {
        dataSummaryView.getNameLabel().setText(name);
    }
    
    public void setSurname(String surname) {
        dataSummaryView.getSurnameLabel().setText(surname);
    }

    public void setTaxCode(String taxCode) {
        dataSummaryView.getTaxCodeLabel().setText(taxCode);
    }
    
    public void setHomeAddress(String homeAddress) {
        dataSummaryView.getHomeAddressLabel().setText(homeAddress);
    }
    
    public void setPhone(String phone) {
        dataSummaryView.getPhoneLabel().setText(phone);
    }
    
}

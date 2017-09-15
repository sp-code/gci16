package gci.app.model;

import gci.app.controller.Controller;
import java.sql.SQLException;
import java.util.Date;

public final class CustomerModel implements Model{
    
    private final Controller controller;
    
    private String name;
    private String surname;
    private String taxCode;
    private Date dateOfBirth;
    private String homeAddress;
    private String phone;
    private String email;
    private String waterMeterID;
    private Date customerSince;
    private Date lastRead;
    private Date lastGenerated;
    private String status;
    
        
    
    public CustomerModel(Controller controller) throws SQLException{
        this.controller = controller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        controller.setName(name);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        controller.setSurname(surname);
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
        controller.setTaxCode(taxCode);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        controller.setDateOfBirth(dateOfBirth);
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
        controller.setHomeAddress(homeAddress);
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        controller.setPhone(phone);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        controller.setEmail(email);
    }

    public String getWaterMeterID() {
        return waterMeterID;
    }

    public void setWaterMeterID(String waterMeterID) {
        this.waterMeterID = waterMeterID;
    }

    public Date getCustomerSince() {
        return customerSince;
    }

    public void setCustomerSince(Date customerSince) {
        this.customerSince = customerSince;
    }

    public Date getLastRead() {
        return lastRead;
    }

    public void setLastRead(Date lastRead) {
        this.lastRead = lastRead;
    }

    public Date getLastGenerated() {
        return lastGenerated;
    }

    public void setLastGenerated(Date lastGenerated) {
        this.lastGenerated = lastGenerated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

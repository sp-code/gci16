package gci.app.model;

import gci.app.controller.Controller;
import java.sql.SQLException;
import java.util.Date;

public final class CustomerModel implements Model{
    
    private final Controller controller;
    
    private String name;
    private String surname;
    private String taxCode;
    private String homeAddress;
    private String phone;
    private Integer waterMeterID;
    private Date customerSince;
    private Date lastRead;
    private Date lastGenerated;
    private String status;
    private double consumption;
    
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

    public Integer getWaterMeterID() {
        return waterMeterID;
    }

    public void setWaterMeterID(Integer waterMeterID) {
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
    
    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }
}

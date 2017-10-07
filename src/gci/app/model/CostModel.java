package gci.app.model;

import gci.app.controller.Controller;
import java.sql.SQLException;

public final class CostModel implements Model{
    
    public final static double DEFAULT_SHIPPING_FEES = 2.50;
    public final static double DEFAULT_WATER_RATE = 1;
    public final static double DEFAULT_VAT = 22; 
    
    private final Controller controller;
    private double shippingFees = 0;
    private double waterRate = 0;
    private double vat = 0;

    public CostModel(Controller controller) throws SQLException{
        this.controller = controller;
    }
        
    public void setShippingFees(Double shippingFees) {
        this.shippingFees = shippingFees;
        controller.setShippingFees(shippingFees);
    }
    
    public void setWaterRate(Double waterRate) {
        this.waterRate = waterRate;
        controller.setWaterRate(waterRate);
    }
    
    public void setVAT(Double vat) {
        this.vat = vat;
        controller.setVAT(vat);
    }
    
    public double getShippingFees() {
        return this.shippingFees;
    }
    public double getWaterRate() {
        return this.waterRate;
    }
    
    public double getVAT() {
        return this.vat;
    }
}

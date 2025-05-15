package com.pluralsight;

class LeaseContract extends Contract {

    private double expectedEndingValue;
    private double leaseFee;


    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold,double expectedEndingValue, double leaseFee) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    // <editor-fold desc="GETTERS/SETTERS">
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
    // </editor-fold>

    @Override
    double getTotalPrice(){
        return 0;
    }

    @Override
    double getMonthlyPayment(){
        return 0;
    }
}

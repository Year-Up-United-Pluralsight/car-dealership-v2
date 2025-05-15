package com.pluralsight;

class SalesContract extends Contract {

    private double salesTaxPercentage;
    private double recordingFee;
    private double processingFee;
    private boolean wantsToFinance;
    private double monthlyPayment;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean wantsToFinance) {

        super(date, customerName, customerEmail, vehicleSold); // Calls super class's (Contract) constructor

        this.salesTaxPercentage = 0.05;
        this.recordingFee = 100.00;
        this.wantsToFinance = wantsToFinance;

        // Processing fee is $295 for vehicles under $10k and $495 for all others
        if (vehicleSold.getPrice() < 10000){
            processingFee = 295;
        }

    }

    // <editor-fold desc="GETTERS/SETTERS">
    public double getSalesTaxPercentage() {
        return salesTaxPercentage;
    }

    public void setSalesTaxPercentage(double salesTaxPercentage) {
        this.salesTaxPercentage = salesTaxPercentage;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isWantsToFinance() {
        return wantsToFinance;
    }

    public void setWantsToFinance(boolean wantsToFinance) {
        this.wantsToFinance = wantsToFinance;
    }
    // </editor-fold>

    @Override
    double getTotalPrice() {
        return 0;
    }

    @Override
    double getMonthlyPayment(){

        // Monthly payment is set if financed
        if (this.wantsToFinance){

            // 4.25% (for 48 months) if the price is $10k or more
            if (super.getVehicleSold().getPrice() >= 10000) {
                this.monthlyPayment = 0.0425;
                return monthlyPayment;
            }

            // 5.25% for 24 month if price is less than $10k
            else {
                this.monthlyPayment = 0.0525; // Monthly payment is 5.25% for 24 months
                return monthlyPayment;
            }
        }

    }

}

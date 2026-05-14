package com.pluralsight;

public class SalesContract extends Contract{

    private double salesTax = 00.05;
    private double recordingFee = 100;
    private boolean financing;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean financing) {
        super(date, customerName, customerEmail, vehicle);
        this.financing = financing;
    }

    @Override
    public double getMonthlyPayment(){
        double monthlyPayment;
        double processingFee = 0;
        if (getVehicle().getPrice() < 10000 ){
            processingFee = 295;
        } else {
            processingFee = 495;
        }
        double salesTaxAmount = getVehicle().getPrice() * salesTax;
        double fees = salesTaxAmount + recordingFee + processingFee;
        double loan = fees + getVehicle().getPrice();

        if (getVehicle().getPrice() >= 10000){
            double upperHalf = 00.0425 * Math.pow((1+00.0425),48);
            double lowerHalf = Math.pow((1+00.0425),(48-1));
            monthlyPayment = loan * (upperHalf/lowerHalf);
            return monthlyPayment;
        } else {
            double upperHalf = 00.0525 * Math.pow((1+00.0525),24);
            double lowerHalf = Math.pow((1+00.0525),(24-1));
            monthlyPayment = loan * (upperHalf/lowerHalf);
            return monthlyPayment;
        }
    }

    @Override
    public double getTotalPrice() {
        double processingFee = 0;
        double totalPrice = 0;
        //calculate processing fee
        if (getVehicle().getPrice() < 10000 ){
            processingFee = 295;
        } else {
            processingFee = 495;
        }
        double salesTaxAmount = getVehicle().getPrice() * salesTax;
        double fees = salesTaxAmount + recordingFee + processingFee;
        double loan = fees + getVehicle().getPrice();
        if (isFinancing()){
            if (getVehicle().getPrice() >= 10000) {
                totalPrice = getMonthlyPayment() * 48;
            } else {
                totalPrice = getMonthlyPayment() * 24;
            }
        } else {
            totalPrice = loan;
        }
        return totalPrice;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public boolean isFinancing() {
        return financing;
    }

    public void setFinancing(boolean financing) {
        this.financing = financing;
    }
}

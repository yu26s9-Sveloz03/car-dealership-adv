package com.pluralsight;

public class LeaseContract extends Contract{

    private double expectedEndingValuePercentageRate = 00.50;
    private double leaseFeePercentageRate = 00.07;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
    }

    @Override
    public double getMonthlyPayment(){
        double monthlyPayment;
        double expectedEndingValue = getVehicle().getPrice() * expectedEndingValuePercentageRate;
        double loan = expectedEndingValue + expectedEndingValue * leaseFeePercentageRate;
        double upperHalf = 00.04 * Math.pow((1+00.04),36);
        double lowerHalf = Math.pow((1+00.04),(36-1));
        monthlyPayment = loan * (upperHalf/lowerHalf);
        return monthlyPayment;
    }

    public double getTotalPrice(){
        double expectedEndingValue = getVehicle().getPrice() * expectedEndingValuePercentageRate;
        double totalPrice = getMonthlyPayment() * 36 + expectedEndingValue;
        return totalPrice;
    }

    public double getExpectedEndingValuePercentageRate() {
        return expectedEndingValuePercentageRate;
    }

    public void setExpectedEndingValuePercentageRate(double expectedEndingValuePercentageRate) {
        this.expectedEndingValuePercentageRate = expectedEndingValuePercentageRate;
    }

    public double getLeaseFeePercentageRate() {
        return leaseFeePercentageRate;
    }

    public void setLeaseFeePercentageRate(double leaseFeePercentageRate) {
        this.leaseFeePercentageRate = leaseFeePercentageRate;
    }
}

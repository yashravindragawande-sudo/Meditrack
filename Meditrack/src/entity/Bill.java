package entity;


import constants.Constants;

public class Bill {

    public void calculate(double billAmount) {

        double taxAmount = billAmount * Constants.TAX_RATE;

        System.out.println("Tax Amount: " + taxAmount);
    }
}
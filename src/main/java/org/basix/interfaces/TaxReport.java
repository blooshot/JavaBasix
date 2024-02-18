package org.basix.interfaces;

public class TaxReport {
    private TaxCalculator calculator;


//    public TaxReport(TaxCalculator calculator) {
//        // Constructor Injection
//        this.calculator = calculator;
//    }

    public void show(TaxCalculator calculator){
        // Method Injection - passing dependecy object directly into the method
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

  /*  public void setCalculator(TaxCalculator calculator) {
        // Setter injection
        this.calculator = calculator;
    }*/
}

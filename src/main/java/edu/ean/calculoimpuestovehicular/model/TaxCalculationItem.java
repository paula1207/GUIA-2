/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ean.calculoimpuestovehicular.model;

/**
 *
 * @author hermannvallejo
 */
public class TaxCalculationItem {
    private double result;
    private String reason;

    public TaxCalculationItem(double result, String reason) {
        this.result = result;
        this.reason = reason;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

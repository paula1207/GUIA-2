/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ean.calculoimpuestovehicular.model;

import java.text.DecimalFormat;
import java.time.Year;

/**
 *
 * @author Paula, Estefania, Hermann
 */
public class TaxCalculator {
    
    private TaxCalculationItem getDepreciationFactor(Vehicle v) {
        int currentYear = Year.now().getValue();
        int age = currentYear - v.getYear();
        double factor;
        if (age <= 3) {
            factor = 1.0;
        } else if (age <= 10) {
            factor = 0.85;
        } else if (age <= 20) {
            factor = 0.7;
        } else {
            factor = 0.5;
        }
        
        return new TaxCalculationItem(factor, "Para una antiguedad de " +
                                        age +
                                        " aplica el factor de depreciacion " + 
                                        factor +
                                        "\n");
    }
    
    private TaxCalculationItem getCylinderCapacityFactor(Vehicle v) {
        int cc = v.getCylinderCapacity();
        double factor;
        
        if (cc <= 1000) {
            factor = 1.0;
        } else if (cc <= 2000) {
            factor = 1.1;
        } else {
            factor = 1.2;
        }
        
        return new TaxCalculationItem(factor, "Para un cilindraje de " +
                                        cc +
                                        " aplica el factor " + 
                                        factor +
                                        "\n");
    }
    
    private TaxCalculationItem getPersonalUseFactor(double adjustedValuation) {
        double factor;
        if (adjustedValuation < 55679000) {
            factor = 1.7;
        } else if (adjustedValuation < 125274000) {
            factor = 2.7;
        } else {
            factor = 3.7;
        }
        
        return new TaxCalculationItem(factor, "Segun avaluo de " +
                                        formatCurrency(adjustedValuation) +
                                        " el factor de impuesto para particular es " +
                                        factor +
                                        "\n");
    }
    
    private String formatCurrency(double value) {
        DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00");
        String formattedValue = df2.format(value);
        return formattedValue;
    }
    
    private String performCalculation(Vehicle v) {
        
        StringBuilder message = new StringBuilder("");
        
        TaxCalculationItem depreciationFactor = getDepreciationFactor(v);
        double adjustedValuation = v.getValuation() * depreciationFactor.getResult();
        message
            .append(depreciationFactor.getReason())
            .append("Valor base con ajuste de depreciacion ")
            .append(formatCurrency(adjustedValuation))
            .append("\n");
        
        TaxCalculationItem cylinderCapacityFactor = getCylinderCapacityFactor(v);
        message.append(cylinderCapacityFactor.getReason());
        
        TaxCalculationItem personalUseFactor = getPersonalUseFactor(adjustedValuation);
        
        double useTypeFactor;
        if (v.isPublic()) {
            useTypeFactor = 0.7;
            message.append("Para vehiculo de transporte publico la tasa es ")
                    .append(useTypeFactor)
                    .append("\n");
        } else {
             useTypeFactor = personalUseFactor.getResult();
             message.append(personalUseFactor.getReason())
                     .append("\n");
        }
        
        double taxes = adjustedValuation * (useTypeFactor / 100.0) * cylinderCapacityFactor.getResult();
        
        String formattedValue = formatCurrency(taxes);
        
        message.append("El impuesto vehicular para el ")
                .append(v.getBrand())
                .append(" ")
                .append(v.getModel())
                .append(" es ")
                .append(formattedValue)
                .append("\n");
        
        return message.toString();
    }
    
    public String calculateTaxes(Vehicle v) throws TaxCalculationException {
        return performCalculation(v);
    }
}
